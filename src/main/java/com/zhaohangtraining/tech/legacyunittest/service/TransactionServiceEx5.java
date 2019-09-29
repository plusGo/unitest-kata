package com.zhaohangtraining.tech.legacyunittest.service;

import ex.configuration.AppConfig;
import ex.configuration.AppConfiguration;
import ex.configuration.DryConfiguration;
import ex.infrastructure.ModelReader;
import ex.infrastructure.XMLStore;
import ex.util.TransactionManager;

public class TransactionServiceEx5 {

    private static final DryConfiguration dryConfiguration = AppConfiguration.getDryConfiguration();

    private static ModelReader reader;
    private static TransactionManager tm;

    static {
        reader = new ModelReader(AppConfig.getDryConfiguration());
        XMLStore persister = new XMLStore(dryConfiguration);
        tm = new TransactionManager(reader, persister);
    }

    public void approve(String taskId, int employeeId, String nodeID) {
        if (isApprovalable(employeeId)) {
            tm.approve(taskId, employeeId, nodeID);
        }
    }

    private boolean isApprovalable(int employeeId) {
        if (employeeId < 10) {
            return true;
        }
        return false;
    }
}


