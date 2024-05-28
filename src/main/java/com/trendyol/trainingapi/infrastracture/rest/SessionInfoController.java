package com.trendyol.trainingapi.infrastracture.rest;

import com.trendyol.trainingapi.domain.entity.SessionInfo;
import com.trendyol.trainingapi.domain.model.SessionInfoCreateModel;
import com.trendyol.trainingapi.domain.port.in.SessionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/session")
public class SessionInfoController {

    private final SessionUseCase sessionUseCase;

    @PostMapping("create")
    public ResponseEntity<String> create() {
        return ResponseEntity.ok(sessionUseCase.createSession(
                SessionInfoCreateModel.builder()
                        .name("Emre")
                        .surname("Altun")
                        .userName("ealtun5444")
                        .email("emrealtun5444@gmail.com")
                        .build()

        ));
    }

    @GetMapping("get")
    public SessionInfo get() {
        return sessionUseCase.getSessionInfo();

    }

    @PutMapping("extend")
    public ResponseEntity<Void> extend() {
        sessionUseCase.extendExistingSession();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("remove")
    public ResponseEntity<Void> remove() {
        sessionUseCase.removeSession();
        return ResponseEntity.ok().build();
    }
}
