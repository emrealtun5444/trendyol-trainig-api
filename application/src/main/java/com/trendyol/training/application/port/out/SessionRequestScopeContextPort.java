package com.trendyol.training.application.port.out;


import com.trendyol.training.domain.valueobject.SessionInfo;

public interface SessionRequestScopeContextPort {

    SessionInfo getSessionInfo();

    void setSessionInfo(SessionInfo sessionInfo);

}
