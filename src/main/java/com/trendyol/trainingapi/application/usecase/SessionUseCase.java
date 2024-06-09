package com.trendyol.trainingapi.application.usecase;

import com.trendyol.trainingapi.domain.valueobject.SessionInfo;
import com.trendyol.trainingapi.domain.model.SessionInfoCreateModel;

public interface SessionUseCase {

    String createSession(SessionInfoCreateModel sessionInfoCreateModel);
    SessionInfo getSessionInfo();
    void extendExistingSession();
    void removeSession();

}
