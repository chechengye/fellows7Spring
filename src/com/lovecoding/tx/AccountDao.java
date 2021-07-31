package com.lovecoding.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    @Autowired
    JdbcTemplate jt;
    public void reducePrice(int id , double price){
        jt.update("update ums_user set amount = amount - ?  where id = ?" , price , id );
    }
    public void addPrice(int id , double price){
        jt.update("update ums_user set amount = amount + ?  where id = ?" , price , id );
    }
}
