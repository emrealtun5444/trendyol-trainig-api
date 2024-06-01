package com.trendyol.trainingapi.application.port.out;


import com.trendyol.trainingapi.domain.valueobject.SessionInfo;

public interface SessionRequestScopeContextPort {

    SessionInfo getSessionInfo();

    void setSessionInfo(SessionInfo sessionInfo);

}
