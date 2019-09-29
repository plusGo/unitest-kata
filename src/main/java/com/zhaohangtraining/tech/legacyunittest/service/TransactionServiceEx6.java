package com.zhaohangtraining.tech.legacyunittest.service;

import com.zhaohangtraining.tech.legacyunittest.configuration.DryConfiguration;
import com.zhaohangtraining.tech.legacyunittest.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceEx6 {

    private DryConfiguration dryConfiguration;
    private TransactionManager tm;

    @Autowired
    public TransactionServiceEx6(DryConfiguration dryConfiguration, TransactionManager tm) {
        this.dryConfiguration = dryConfiguration;
        this.tm = tm;
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


