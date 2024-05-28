package com.trendyol.trainingapi.domain.port.in;

import com.trendyol.trainingapi.domain.entity.SessionInfo;
import com.trendyol.trainingapi.domain.model.SessionInfoCreateModel;

public interface SessionUseCase {

    String createSession(SessionInfoCreateModel sessionInfoCreateModel);
    SessionInfo getSessionInfo();
    void extendExistingSession();
    void removeSession();

}
