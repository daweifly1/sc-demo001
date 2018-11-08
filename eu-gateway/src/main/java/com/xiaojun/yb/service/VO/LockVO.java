package com.xiaojun.yb.service.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
@Data
public class LockVO {

    @ApiModelProperty("设置锁状态（0启用，1禁用）")
    private Integer lock;
    private List userIds;

}
