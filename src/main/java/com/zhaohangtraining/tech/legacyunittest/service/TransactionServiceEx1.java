package com.zhaohangtraining.tech.legacyunittest.service;

import ex.domain.Employee;
import ex.infrastructure.PayrollDatabase;
import ex.infrastructure.TransactionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Iterator;

@Service
public class TransactionServiceEx1 {

    private PayrollDatabase db;
    private TransactionLog log;

    @Autowired
    public TransactionServiceEx1(PayrollDatabase db, TransactionLog log) {
        this.db = db;
        this.log = log;
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
        log.saveTransaction(date);
    }
}

