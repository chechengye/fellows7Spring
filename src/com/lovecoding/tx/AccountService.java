package com.lovecoding.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    TransactionTemplate tt;
    /**
     * a 向 b 转款 .此时应该配置事务来管理业务方法
     */
    public void transfer(int a , int b , double price){
        //代码编写事务配置 - execute()中管理的业务代码。就可以保持事务的完整性。
        /*tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.reducePrice(a , price);
                //int i = 10 / 0;
                accountDao.addPrice(b , price);
            }
        });*/
        //配置文件的事务，让其生效
        accountDao.reducePrice(a , price);
        int i = 10 / 0;
        accountDao.addPrice(b , price);

    }
}
