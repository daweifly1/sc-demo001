package com.xiaojun.yb.web;

import com.xiaojun.auth.filter.JWTConsts;
import com.xiaojun.auth.filter.TokenAuthenticationHandler;
import com.xiaojun.common.fastjson.FastJsonUtil;
import com.xiaojun.common.http.CookieUtil;
import com.xiaojun.infra.ActionResult;
import com.xiaojun.rbac.api.vo.SysUserDetail;
import com.xiaojun.yb.comm.Ref;
import com.xiaojun.yb.comm.enums.ErrorCode;
import com.xiaojun.yb.service.AccountService;
import com.xiaojun.yb.service.AuthService;
import com.xiaojun.yb.service.VO.UpdatePasswordVO;
import com.xiaojun.yb.service.VO.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping({"/auth"})
public class AuthController extends BasicController {

    @Autowired
    AuthService authService;
    @Autowired
    AccountService accountService;


    @RequestMapping(
            value = {"/authInfo"},
            method = {RequestMethod.GET}
    )
    public ActionResult authInfo() {
        return actionResult(authService.createAuthInfo());
    }

    @RequestMapping(
            value = {"/signin"},
            method = {RequestMethod.POST}
    )
    public ActionResult login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, @RequestParam("authId") String authId, @RequestParam("code") String code, @RequestHeader("x-from-site") Integer site) throws Exception {
        UserLoginVO a = new UserLoginVO();
        a.setAuthId(authId);
        a.setCode(code);
        a.setLoginName(loginName);
        a.setPassword(password);
        Ref a1 = new Ref("");
        return actionResult(accountService.login(a, a1, site), a1.get());
    }

    @RequestMapping(
            value = {"/password"},
            method = {RequestMethod.POST}
    )
    public ActionResult password(@RequestHeader("x-user-id") String userId, @RequestBody UpdatePasswordVO updatePasswordVO) throws Exception {
        return actionResult(accountService.updatePassword(userId, updatePasswordVO));
    }

    @RequestMapping(
            value = {"/kaptcha"},
            method = {RequestMethod.GET}
    )
    public void kaptcharImg(@RequestParam("authid") String authId, HttpServletResponse httpServletResponse) throws Exception {
//        Object a = null;
//        ByteArrayOutputStream a1 = new ByteArrayOutputStream();
//        ImageIO.write(authService.createVerifyImg(authId), RoleMenuVO.userContextService("7-:"), a1);
//        byte[] a2 = a1.toByteArray();
////        httpServletResponse.setHeader(UserRoles.userContextService("c;j=/m6v*m4"), RoleMenuVO.userContextService("32p.)2/8"));
////        httpServletResponse.setHeader(UserRoles.userContextService("R*c?o9"), RoleMenuVO.userContextService("32p><>58"));
////        httpServletResponse.setDateHeader(UserRoles.userContextService("z(k*g+"), 0L);
////        httpServletResponse.setContentType(RoleMenuVO.userContextService("40<:8r7-8:"));
//        ServletOutputStream var10001 = httpServletResponse.getOutputStream();
//        var10001.write(a2);
//        var10001.flush();
//        var10001.close();
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

        BufferedImage verifyImg = authService.createVerifyImg(authId);
        ImageIO.write(verifyImg, "jpg", jpegOutputStream);

        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0L);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    public ActionResult<String> login(@RequestBody UserLoginVO userLoginVO, @RequestHeader("x-from-site") Integer site, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Ref<SysUserDetail> ref = new Ref(null);
        ActionResult r = actionResult(accountService.login(userLoginVO, ref, site), ref.get().getUsername());
        if (r.getCode() == ErrorCode.Success.getCode()) {
            TokenAuthenticationHandler tokenAuthenticationHandler = new TokenAuthenticationHandler();
            SysUserDetail userDetails = ref.get();
            String token = tokenAuthenticationHandler.generateToken(FastJsonUtil.toJSONString(userDetails));
            tokenAuthenticationHandler.doRefreshToken(response, token, true);
        }
        return r;
    }

    @RequestMapping(
            value = {"/logout"},
            method = {RequestMethod.POST}
    )
    public ActionResult logout(HttpServletResponse response) {
        CookieUtil.setCookie(response, JWTConsts.HEADER_STRING, "", 0);
        return actionResult("");
    }
}
