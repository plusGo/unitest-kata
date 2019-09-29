package com.zhaohangtraining.tech.legacyunittest.service;

import com.zhaohangtraining.tech.legacyunittest.domain.Employee;
import com.zhaohangtraining.tech.legacyunittest.infrastructure.PayrollDatabase;
import com.zhaohangtraining.tech.legacyunittest.infrastructure.TransactionLog;

import java.sql.Date;
import java.util.Iterator;

public class TransactionServiceEx3 {

    private PayrollDatabase db;

    public TransactionServiceEx3() {
    }

    public TransactionServiceEx3(PayrollDatabase db) {
        this.db = db;
    }
    public void run(Date date) {
        if (db.getEmployees() != null) {
            for (Iterator it = db.getEmployees(); it.hasNext(); ) {
                Employee e = (Employee) it.next();
                if (e.isPayday(date)) {
                    e.pay();
                }
            }
        }
        TransactionLog log = new TransactionLog();
        log.saveTransaction(date);
    }

}


