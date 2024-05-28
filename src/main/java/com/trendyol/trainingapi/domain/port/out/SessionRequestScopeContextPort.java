package com.trendyol.trainingapi.domain.port.out;


import com.trendyol.trainingapi.domain.entity.SessionInfo;

public interface SessionRequestScopeContextPort {

    SessionInfo getSessionInfo();

    void setSessionInfo(SessionInfo sessionInfo);

}
