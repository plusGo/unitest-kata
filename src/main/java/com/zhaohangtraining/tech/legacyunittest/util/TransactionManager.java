package com.zhaohangtraining.tech.legacyunittest.util;

import com.zhaohangtraining.tech.legacyunittest.infrastructure.Persister;
import org.springframework.stereotype.Component;

import java.io.Reader;

@Component
public class TransactionManager {
    public TransactionManager(Reader reader, Persister persister) {
    }

    public void approve(String taskId, int employeeId, String nodeID) {
        throw new UnsupportedOperationException("TransactionManager.approve() not supported yet.");
    }
}
