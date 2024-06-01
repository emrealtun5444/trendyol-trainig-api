package com.trendyol.trainingapi.infrastracture.cache;

import com.trendyol.trainingapi.domain.valueobject.SessionInfo;
import com.trendyol.trainingapi.application.port.out.SessionRequestScopeContextPort;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Setter
@Getter
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionRequestScopeContextAdapter implements SessionRequestScopeContextPort {

    private SessionInfo sessionInfo;

}
