package com.xiaojun.yb.service;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.xiaojun.yb.service.VO.AuthInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class AuthService {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    public BufferedImage createVerifyImg(String a1) {
        String var2 = "1234";
        return this.defaultKaptcha.createImage(var2);
    }

    public AuthInfoVO createAuthInfo() {

        AuthInfoVO authInfoVO = new AuthInfoVO();
//        authInfoVO.setAuthId(((Long) this.genServiceWrapper.getGenClient().newGuid().getValue()).toString());
//
//        if ("on".equals(flag.toLowerCase())) {
        authInfoVO.setVerifyCode("1234");
//        } else {
//            authInfoVO.setVerifyCode(this.defaultKaptcha.createText());
//        }
//
        return authInfoVO;
    }
}
