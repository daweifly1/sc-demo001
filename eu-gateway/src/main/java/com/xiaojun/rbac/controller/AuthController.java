package com.xiaojun.rbac.controller;

import com.xiaojun.rbac.api.vo.SysUserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/authInfo")
    public SysUserDetail authInfo() {
        Object userDetails = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        System.out.println(userDetails);
        if (null != userDetails && userDetails instanceof SysUserDetail) {
            return (SysUserDetail) userDetails;
        } else {
            log.info("认证失败");
            return null;
        }
    }
}
