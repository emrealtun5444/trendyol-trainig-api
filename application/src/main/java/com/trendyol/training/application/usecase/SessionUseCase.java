package com.trendyol.training.application.usecase;


import com.trendyol.training.domain.model.SessionInfoCreateModel;
import com.trendyol.training.domain.valueobject.SessionInfo;

public interface SessionUseCase {

    String createSession(SessionInfoCreateModel sessionInfoCreateModel);
    SessionInfo getSessionInfo();
    void extendExistingSession();
    void removeSession();

}
