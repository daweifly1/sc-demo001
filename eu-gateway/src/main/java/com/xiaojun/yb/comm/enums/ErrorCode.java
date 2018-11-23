package com.xiaojun.yb.comm.enums;


public enum ErrorCode {
    Success("Success", 0, 0, "操作成功"),
    Failure("Failure", 1, 1, "操作失败"),
    NeedLogin("NeedLogin", 2, 2, "用户没有登录"),
    UnExceptedError("UnExceptedError", 3, 3, "未知的错误发生"),
    IllegalArument("IllegalArument", 4, 4, "参数错误"),
    SQLIntegrityConstraintViolation("SQLIntegrityConstraintViolation", 5, 5, "违反完整性约束"),
    NoAuthorization("NoAuthorization", 6, 6, "没有权限执行此操作"),
    CheckLoginFailure("CheckLoginFailure", 7, 7, "用户不存在或者密码错误"),
    UserNameExists("UserNameExists", 8, 8, "登录名称已存在"),
    RoleNameExists("RoleNameExists", 9, 9, "角色名已存在"),
    RoleIsUsed("RoleIsUsed", 10, 10, "角色已经被使用"),
    UserLocked("UserLocked", 11, 11, "用户被锁定"),
    OldPwdNotRight("OldPwdNotRight", 12, 12, "原密码不正确"),
    PwdAlreadSet("PwdAlreadSet", 13, 13, "该用户已经设置密码"),
    SqlSyntaxError("SqlSyntaxError", 14, 14, "数据库执行异常"),
    FailedToInsertRecord("FailedToInsertRecord", 15, 15, "插入数据记录失败"),
    FailedToRemoveRecord("FailedToRemoveRecord", 16, 16, "删除数据记录失败"),
    FailedToUpdateRecord("FailedToUpdateRecord", 17, 17, "更新数据记录失败"),
    FailedToRetreiveRecord("FailedToRetreiveRecord", 18, 18, "获取数据记录失败"),
    FailedToVerifyCode("FailedToVerifyCode", 19, 19, "验证码错误"),
    YourErrorCodeGoesHere("YourErrorCodeGoesHere", 20, 1000, "你的失败码请在后面定义"),
    OAuthAppIdNotNull("OAuthAppIdNotNull", 21, 1101, "app_id参数不能为空"),
    OAuthRedirectUrlNotNull("OAuthRedirectUrlNotNull", 22, 1102, "redirect_url参数不能为空"),
    OAuthResponseTypeNotNull("OAuthResponseTypeNotNull", 23, 1103, "response_type参数不能为空"),
    OAuthAppSecretNotNUll("OAuthAppSecretNotNUll", 24, 1104, "app_secret参数不能为空"),
    OAuthGrantTypeNotNull("OAuthGrantTypeNotNull", 25, 1105, "grant_type参数不能为空"),
    OAuthAppIdInvalid("OAuthAppIdInvalid", 26, 1104, "无效的app_id"),
    OAuthRedirectUrlInvalid("OAuthRedirectUrlInvalid", 27, 1105, "无效的redirect_url"),
    OAuthResponseTypeInvalid("OAuthResponseTypeInvalid", 28, 1106, "无效的response_type"),
    OAuthAppSecretInvalid("OAuthAppSecretInvalid", 29, 1104, "无效的app_secret"),
    OAuthGrantTypeInvalid("OAuthGrantTypeInvalid", 30, 1104, "无效的grant_type"),
    OAuthCodeInvalid("OAuthCodeInvalid", 31, 1104, "无效的授权码"),
    OAuthRefreshTokenInvalid("OAuthRefreshTokenInvalid", 32, 1104, "无效的刷新令牌"),
    OAuthGenAuthCodeFail("OAuthGenAuthCodeFail", 33, 1107, "生成授权码失败"),
    OAuthAddAuthRecordFail("OAuthAddAuthRecordFail", 34, 1108, "生成授权记录失败"),
    OAuthGenToeknFail("OAuthGenToeknFail", 35, 1108, "生成授权码失败"),
    DeptNameExist("DeptNameExist", 36, 00, "部门不存在"),
    FailedToNewCode("FailedToNewCode", 36, 00, "FailedToNewCode"),
    FailedDeleteMenu("FailedDeleteMenu", 36, 00, "FailedDeleteMenu"),
    FailedDeleteFixedMenu("FailedToNewCode", 36, 00, "FailedToNewCode"),
    TemplateInUse("TemplateInUse", 36, 00, "TemplateInUse"),
    CannotEditSystemData("CannotEditSystemData", 36, 00, "CannotEditSystemData"),
    CannotRemoveYouself("CannotRemoveYouself", 36, 00, "CannotRemoveYouself"),
    MobileExistError("MobileExistError", 36, 00, "MobileExistError"),
    FailedToCacheUserDate("FailedToCacheUserDate", 36, 00, "FailedToCacheUserDate"),
    FailedToCacheAuthCode("FailedToCacheAuthCode", 36, 00, "FailedToCacheAuthCode"),
    FailedToRenewLeaseSession("FailedToRenewLeaseSession", 36, 00, "FailedToRenewLeaseSession"),
    AdminCannotRemove("AdminCannotRemove", 36, 00, "AdminCannotRemove"),
    thirdIdAlreadyBind("thirdIdAlreadyBind", 36, 00, "thirdIdAlreadyBind"),
    ThirdAuthTypeError("ThirdAuthTypeError", 36, 00, "ThirdAuthTypeError"),
    userIdAlreadyBind("userIdAlreadyBind", 36, 00, "userIdAlreadyBind"),
    AppIdNotExist("AppIdNotExist", 36, 00, "AppIdNotExist"),
    TemplateIsNull("TemplateIsNull", 36, 00, "TemplateIsNull");
    private String desc;
    private int code;
    // $FF: synthetic field
    private static final ErrorCode[] $VALUES = new ErrorCode[]{Success, Failure, NeedLogin, UnExceptedError, IllegalArument, SQLIntegrityConstraintViolation, NoAuthorization, CheckLoginFailure, UserNameExists, RoleNameExists, RoleIsUsed, UserLocked, OldPwdNotRight, PwdAlreadSet, SqlSyntaxError, FailedToInsertRecord, FailedToRemoveRecord, FailedToUpdateRecord, FailedToRetreiveRecord, FailedToVerifyCode, YourErrorCodeGoesHere, OAuthAppIdNotNull, OAuthRedirectUrlNotNull, OAuthResponseTypeNotNull, OAuthAppSecretNotNUll, OAuthGrantTypeNotNull, OAuthAppIdInvalid, OAuthRedirectUrlInvalid, OAuthResponseTypeInvalid, OAuthAppSecretInvalid, OAuthGrantTypeInvalid, OAuthCodeInvalid, OAuthRefreshTokenInvalid, OAuthGenAuthCodeFail, OAuthAddAuthRecordFail, OAuthGenToeknFail};


    private ErrorCode(String var1, int var2, int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getCode() {
        return this.code;
    }

}
