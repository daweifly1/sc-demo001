package com.xiaojun.yb.service;

import com.xiaojun.rbac.api.RbacService;
import com.xiaojun.rbac.api.vo.SysUserDetail;
import com.xiaojun.yb.comm.Ref;
import com.xiaojun.yb.comm.enums.ErrorCode;
import com.xiaojun.yb.service.VO.AccountPwdVO;
import com.xiaojun.yb.service.VO.AccountVO;
import com.xiaojun.yb.service.VO.PasswordVO;
import com.xiaojun.yb.service.VO.UpdatePasswordVO;
import com.xiaojun.yb.service.VO.UserLoginVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private RbacService rbacService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public ErrorCode addAccount(AccountVO a1) {

        return ErrorCode.Success;
    }


    public ErrorCode updatePassword(String a1, String a2) throws Exception {
        return ErrorCode.Success;
    }

    public ErrorCode rmAccountByUserId(String a1) {
        return ErrorCode.Success;
    }

    public ErrorCode insertPassword(AccountPwdVO a1) throws Exception {
        return ErrorCode.Success;
    }

    public ErrorCode insertPassword(PasswordVO a1) throws Exception {
        return ErrorCode.Success;
    }

    public AccountVO queryAccountById(String a1) {


        return null;
    }


    public ErrorCode updateLoginName(AccountVO a1) {
        return ErrorCode.Success;
    }

    public ErrorCode removePassword(String a1, Integer a2) {
        return ErrorCode.Success;
    }

    public ErrorCode removeAccountByUserId(String a1) {
        if (ErrorCode.Success != rmAccountByUserId(a1)) {
            return ErrorCode.FailedToRemoveRecord;
        } else {
            return removePassword(a1, Integer.valueOf(0));
        }
    }

    public ErrorCode resetPassword(List a1) throws Exception {
        ArrayList var2 = new ArrayList();
        Iterator a2 = a1.iterator();

        while (a2.hasNext()) {
            String var3 = (String) a2.next();
            ErrorCode var4 = updatePassword(var3, "123456");
            if (0 != var4.getCode()) {
                var2.add(var3);
            }
        }

        if (!var2.isEmpty()) {
            return ErrorCode.FailedToUpdateRecord;
        } else {
            return ErrorCode.Success;
        }
    }


    public ErrorCode checkLoginName(String a1) {
        return ErrorCode.Success;
    }

    public ErrorCode addAccountPwd(AccountPwdVO a1) throws Exception {
        return ErrorCode.Success;

    }

    public ErrorCode login(UserLoginVO userLoginVO, Ref<SysUserDetail> ref, Integer a3) throws Exception {
        if (StringUtils.isBlank(userLoginVO.getCode())) {
            return ErrorCode.FailedToVerifyCode;
        }
//        if (!userLoginVO.getCode().equalsIgnoreCase(a4)) {
//            return ErrorCode.FailedToVerifyCode;
//        }

        SysUserDetail ru = rbacService.findByUsername(userLoginVO.getLoginName());
        if (null == ru) {
            return ErrorCode.CheckLoginFailure;
        }
        ref.set(ru);
        if (passwordEncoder.matches(userLoginVO.getPassword(), ru.getPassword())) {
            return ErrorCode.Success;
        }
        return ErrorCode.CheckLoginFailure;
    }

    public ErrorCode removeAllPassword(String a1) {
        return removePassword(a1, Integer.valueOf(0));
    }

    public String queryUserIdByAccount(String a1) {
        return null;
    }


    public ErrorCode removeAccount(String a1) {
        return ErrorCode.Success;
    }

    public ErrorCode checkExistAccountName(String a1) {
        return ErrorCode.Success;
    }

    public ErrorCode updatePassword(String a1, UpdatePasswordVO a2) throws Exception {
        return ErrorCode.Success;
    }
}
