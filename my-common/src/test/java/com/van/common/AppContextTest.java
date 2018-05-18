package com.van.common;

import com.van.common.core.AppContext;
import com.van.common.domain.LoginInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AppContextTest {

    @Test
    public void setTest(){

        String key = "LOGIN-00003";
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setOrgId("0001");
        loginInfo.setUserName("范海辛");
        loginInfo.setSessionId(key);

        AppContext.getInstance().setLoginInfo(key, loginInfo);

        System.out.println("+++++++++++++++++++++++++++ ok! ++++++++++++++++++++++++++++++");

    }


    @Test
    public void getTest(){
        String key = "LOGIN-123456";

        LoginInfo loginInfo = AppContext.getInstance().getLoginInfo(key);

        System.out.println(loginInfo.toString());
    }

}
