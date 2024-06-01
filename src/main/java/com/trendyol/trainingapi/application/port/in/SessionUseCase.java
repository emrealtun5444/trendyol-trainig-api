package com.trendyol.trainingapi.application.port.in;

import com.trendyol.trainingapi.domain.valueobject.SessionInfo;
import com.trendyol.trainingapi.domain.model.SessionInfoCreateModel;

public interface SessionUseCase {

    String createSession(SessionInfoCreateModel sessionInfoCreateModel);
    SessionInfo getSessionInfo();
    void extendExistingSession();
    void removeSession();

}
