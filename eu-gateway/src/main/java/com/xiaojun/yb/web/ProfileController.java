package com.xiaojun.yb.web;

import com.netflix.zuul.context.RequestContext;
import com.xiaojun.infra.ActionResult;
import com.xiaojun.yb.comm.Ref;
import com.xiaojun.yb.comm.enums.ErrorCode;
import com.xiaojun.yb.service.VO.AccountPwdVO;
import com.xiaojun.yb.service.VO.LockVO;
import com.xiaojun.yb.service.VO.ProfileVO;
import com.xiaojun.yb.service.VO.RegMemberVO;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping({"/profile"})
public class ProfileController extends BasicController {


    @RequestMapping(
            method = {RequestMethod.POST}
    )
    @ApiOperation("添加用户")
    public ActionResult add(@RequestBody ProfileVO profileVO, @RequestHeader(value = "x-user-id", defaultValue = "") String userId) throws Exception {
        Ref ref = new Ref("");
        if (StringUtils.isBlank(profileVO.getSpaceId())) {
//            String a1 = this.profileService.item(userId).getSpaceId();
//            profileVO.setSpaceId(a1);
        }
//        return this.actionResult(this.profileService.insert(profileVO, ref), ref.get());
        return null;
    }


    @RequestMapping(
            value = {"/getUserInfo"},
            method = {RequestMethod.GET}
    )
    @ApiOperation("查询Oauth2个人信息")
    public ActionResult getUserInfo(@RequestHeader(name = "x-app-id", required = false, defaultValue = "gateway") String appId, @RequestHeader(name = "x-user-id", required = false, defaultValue = "") String userId) throws Exception {
//        return this.actionResult(this.profileService.getUserInfo(appId, userId));
        return null;
    }

    @RequestMapping(
            value = {"/list"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("查询用户列表")
    public ActionResult list(@RequestHeader("x-user-id") String userId) {
//        return this.actionResult(this.profileService.list(condition, userId).getPageInfo());
        return null;
    }

    @RequestMapping(
            value = {"/detail"},
            method = {RequestMethod.GET}
    )
    @ApiOperation("查询用户列表详细信息")
    public ActionResult detail(@RequestParam("userId") String userId) throws Exception {
//        return this.actionResult(this.profileService.item(userId));
        return null;
    }

    @RequestMapping(
            value = {"/getLogin"},
            method = {RequestMethod.GET}
    )
    @ApiOperation("查询登录用户信息")
    public ActionResult<ProfileVO> getLoginUser(@RequestHeader(name = "x-user-id", required = false, defaultValue = "") String userId) throws Exception {
//        return this.actionResult(this.profileService.queryLoginUser(userId));

//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpSession httpSession = ctx.getRequest().getSession();
        return actionResult(ErrorCode.NeedLogin);
    }

    @RequestMapping(
            value = {"/updateUserInfo"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("修改用户信息（用户管理）")
    public ActionResult updateUserInfo(@RequestBody ProfileVO profileVO) throws Exception {
//        return StringUtil.isNullOrEmpty(profileVO.getUserId()) ? this.actionResult(ErrorCode.IllegalArument) : this.actionResult(this.profileService.update(profileVO));
        return null;
    }

    @RequestMapping(
            value = {"/addUserWithAccount"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("添加用户账号和密码(生成用户信息)")
    public ActionResult addUserWithAccount(@RequestBody AccountPwdVO accountPwdVO) throws Exception {
        Ref a = new Ref("");
//        return this.actionResult(this.profileService.addUserWithAccount(accountPwdVO, a), a.get());
        return null;
    }

    @RequestMapping(
            value = {"/userInfo"},
            method = {RequestMethod.GET}
    )
    @ApiOperation("查询个人信息")
    public ActionResult queryUserInfo(@RequestHeader("x-user-id") String userId) throws Exception {
//        return this.actionResult(this.profileService.queryLoginUser(userId));
        return null;
    }

    @RequestMapping(
            value = {"/listAll"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("查询系统所有用户")
    public ActionResult listAll(@RequestHeader("x-user-id") String userId) {
//        return this.actionResult(this.profileService.listAll(condition, userId).getPageInfo());
        return null;
    }

    @RequestMapping(
            value = {"/listByWorkspace"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("查询工作空间下用户集合")
    public ActionResult listByWorkspace() {
//        return this.actionResult(this.profileService.listByWorkspace(condition).getPageInfo());
        return null;
    }

    @RequestMapping(
            value = {"/regMember"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("注册用户信息")
    public ActionResult regMember(@RequestBody RegMemberVO regMemberVO) {
//        return this.actionResult(this.profileService.regMember(regMemberVO));
        return null;
    }

    @RequestMapping(
            value = {"/userDetail"},
            method = {RequestMethod.GET}
    )
    @ApiOperation("获取用户缓存信息")
    public ActionResult getUserDetail(@RequestParam("userId") String userId) {
//        return this.actionResult(this.profileService.getUserCache(userId));
        return null;
    }

    @RequestMapping(
            value = {"/remove"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("批量删除用户")
    public ActionResult removeUsers(@RequestBody List userIds, @RequestHeader("x-user-id") String userId) throws Exception {
//        return userIds.contains(userId) ? this.actionResult(ErrorCode.CannotRemoveYouself) : this.actionResult(this.profileService.removeByIds(userIds));
        return null;
    }

    @RequestMapping(
            value = {"/updateUserByAccount"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("根据登录名修改用户信息")
    public ActionResult updateUserByAccount(@RequestBody ProfileVO profileVO) throws Exception {
//        return this.actionResult(this.profileService.updateByAccount(profileVO));
        return null;
    }

    @RequestMapping(
            value = {"/updateLock"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("用户禁用与启用")
    public ActionResult lock(@RequestBody LockVO lockVO) {
//        return this.actionResult(this.profileService.updateLock(lockVO));
        return null;
    }

    @RequestMapping(
            value = {"/update"},
            method = {RequestMethod.POST}
    )
    @ApiOperation("修改个人信息（个人中心）")
    public ActionResult update(@RequestBody ProfileVO profileVO, @RequestHeader("x-user-id") String userId) throws Exception {
        profileVO.setUserId(userId);
//        return this.actionResult(this.profileService.update(profileVO));
        return null;
    }

}
