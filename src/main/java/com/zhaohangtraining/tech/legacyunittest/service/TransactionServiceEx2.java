package com.zhaohangtraining.tech.legacyunittest.service;

import com.zhaohangtraining.tech.legacyunittest.domain.Employee;
import com.zhaohangtraining.tech.legacyunittest.infrastructure.PayrollDatabase;
import com.zhaohangtraining.tech.legacyunittest.infrastructure.TransactionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Iterator;

@Service
public class TransactionServiceEx2 {

    @Autowired
    private PayrollDatabase db;

    @Autowired
    private TransactionLog log;

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

