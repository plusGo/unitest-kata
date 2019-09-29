package com.zhaohangtraining.tech.legacyunittest.service;

import com.zhaohangtraining.tech.legacyunittest.configuration.AppConfig;
import com.zhaohangtraining.tech.legacyunittest.configuration.AppConfiguration;
import com.zhaohangtraining.tech.legacyunittest.configuration.DryConfiguration;
import com.zhaohangtraining.tech.legacyunittest.infrastructure.ModelReader;
import com.zhaohangtraining.tech.legacyunittest.infrastructure.XMLStore;
import com.zhaohangtraining.tech.legacyunittest.util.TransactionManager;

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


