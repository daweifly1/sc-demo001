package com.xiaojun.yb.service;

import com.xiaojun.yb.service.VO.AuthInfoVO;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class AuthService {

    public BufferedImage createVerifyImg(String a1) {
//        String var2;
//        if (StringUtils.isBlank(var2 = this.authInfoManager.getRedisCode(a1))) {
//            var2 = this.defaultKaptcha.createText();
//            this.authInfoManager.savAuthKaptcha(a1, var2);
//        }
//
//        return this.defaultKaptcha.createImage(var2);
        return null;
    }

    public AuthInfoVO createAuthInfo() {

        AuthInfoVO authInfoVO = new AuthInfoVO();
//        authInfoVO.setAuthId(((Long) this.genServiceWrapper.getGenClient().newGuid().getValue()).toString());
//
//        if ("on".equals(flag.toLowerCase())) {
//            authInfoVO.setVerifyCode("1234");
//        } else {
//            authInfoVO.setVerifyCode(this.defaultKaptcha.createText());
//        }
//
//        this.authInfoManager.savAuthKaptcha(authInfoVO.getAuthId(), authInfoVO.getVerifyCode());
        return authInfoVO;
    }
}
