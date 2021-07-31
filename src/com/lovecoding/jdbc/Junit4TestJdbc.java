package com.lovecoding.jdbc;


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
@ContextConfiguration("classpath:com/lovecoding/jdbc/jdbc.xml")
public class Junit4TestJdbc {

    @Autowired
    JdbcTemplate jt;

    @Test
    public void testFn(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        JdbcTemplate jt = new JdbcTemplate(dataSource);//与QueryRunner一曲同工
        List<UmsUser> userList = jt.query("select * from ums_user ", new RowMapper<UmsUser>() {

            @Override
            public UmsUser mapRow(ResultSet rs, int i) throws SQLException {
                UmsUser user = new UmsUser();
                user.setName(rs.getString("name"));
                user.setId(rs.getInt("id"));
                return user;
            }
        });

        System.out.println(userList);
    }

    @Test
    public void testFn2(){
        int rows = jt.update("update ums_user set name = ? where id = ? " , "刘备" , 2);
        System.out.println(rows);
    }
}
