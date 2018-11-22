package com.xiaojun.yb.web;

import com.xiaojun.infra.ActionResult;
import com.xiaojun.yb.comm.enums.ErrorCode;
import com.xiaojun.yb.service.VO.MenuDisplayVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/menu"})
public class MenuController extends BasicController {

    @RequestMapping(value = {"/authorized"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @ApiOperation("查询按钮集合（树形结构）")
    public ActionResult authorizedList(@RequestHeader(name = "x-user-id", required = false, defaultValue = "") String userId) {
        //TODO
        List<MenuDisplayVO> menuDisplayVOList = new ArrayList<>();
        return actionResult(ErrorCode.NeedLogin);
    }
}
