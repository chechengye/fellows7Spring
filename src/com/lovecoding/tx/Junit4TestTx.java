package com.lovecoding.tx;


import com.lovecoding.jdbc.bean.UmsUser;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/lovecoding/tx/tx.xml")
public class Junit4TestTx {

    @Autowired
    AccountService accountService;
    @Test
    public void testFn(){
        accountService.transfer(1 , 2, 100);
    }

}
