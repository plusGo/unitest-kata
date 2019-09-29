package com.zhaohangtraining.tech.legacyunittest.service;

import com.zhaohangtraining.tech.legacyunittest.domain.Employee;
import com.zhaohangtraining.tech.legacyunittest.infrastructure.PayrollDatabase;
import com.zhaohangtraining.tech.legacyunittest.util.SMSUtil;
import java.sql.Date;
import java.util.Iterator;

public class TransactionServiceEx4 {

    private PayrollDatabase db;

    public TransactionServiceEx4(PayrollDatabase db) {
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
        SMSUtil.send(date);
    }

}




