package com.trendyol.trainingapi.domain.service;

import com.trendyol.trainingapi.domain.valueobject.SessionInfo;
import com.trendyol.trainingapi.domain.model.SessionInfoCreateModel;
import com.trendyol.trainingapi.application.port.in.SessionUseCase;
import com.trendyol.trainingapi.application.port.out.HttpServletPort;
import com.trendyol.trainingapi.application.port.out.RedisPropertyPort;
import com.trendyol.trainingapi.application.port.out.SessionPort;
import com.trendyol.trainingapi.application.port.out.SessionRequestScopeContextPort;
import com.trendyol.trainingapi.infrastracture.common.Constants;
import com.trendyol.trainingapi.infrastracture.common.exception.BusinessException;
import com.trendyol.trainingapi.infrastracture.common.exception.NoActiveSessionFoundException;
import com.trendyol.trainingapi.infrastracture.common.exception.SessionIdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SessionInfoService implements SessionUseCase {

    private final SessionPort sessionPort;
    private final RedisPropertyPort redisPropertyPort;
    private final HttpServletPort httpServletPort;
    private final SessionRequestScopeContextPort sessionRequestScopeContextPort;

    public String createSession(SessionInfoCreateModel sessionInfoCreateModel) {

        checkIfSessionAlreadyExists(sessionInfoCreateModel.getUserName());

        final var uid = UUID.randomUUID().toString();

        final var sessionInfo = SessionInfo.builder()
                .id(uid)
                .expiration(redisPropertyPort.getSessionInfoTTL().longValue())
                .build();

        sessionPort.save(sessionInfo);
        sessionRequestScopeContextPort.setSessionInfo(sessionInfo);

        return uid;
    }

    public SessionInfo getSessionInfo() {
        return Optional.ofNullable(sessionRequestScopeContextPort.getSessionInfo())
                .orElseGet(() -> {
                    final var editorSessionId = getSessionIdFromTheHeader();
                    final var sessionInfo = sessionPort.findById(editorSessionId)
                            .orElseThrow(SessionIdNotFoundException::new);
                    sessionRequestScopeContextPort.setSessionInfo(sessionInfo);
                    return sessionInfo;
                });
    }

    public void extendExistingSession() {

        final var sessionId = getSessionIdFromTheHeader();

        var sessionInfo = sessionPort.findById(sessionId)
                .orElseThrow(NoActiveSessionFoundException::new);

        sessionInfo.updateTTL(redisPropertyPort.getSessionInfoTTL().longValue());
        sessionPort.save(sessionInfo);
    }

    public void removeSession() {

        final var sessionId = getSessionIdFromTheHeader();

        var sessionInfoOpt = sessionPort.findById(sessionId);
        sessionInfoOpt.ifPresent(sessionInfo -> sessionPort.deleteById(sessionInfo.getId()));
    }

    private void checkIfSessionAlreadyExists(String userName) {
        final var isUserNameExists = sessionPort.findByUserName(userName);

        if (isUserNameExists.isPresent()) {
            throw new BusinessException("session.already.exists");
        }
    }

    private String getSessionIdFromTheHeader() {
        final var sessionId = httpServletPort.getHeader(Constants.Headers.SESSION_ID);

        if (Objects.isNull(sessionId)) {
            throw new BusinessException("validation.error", Constants.Headers.SESSION_ID);
        }
        return sessionId;
    }
}
