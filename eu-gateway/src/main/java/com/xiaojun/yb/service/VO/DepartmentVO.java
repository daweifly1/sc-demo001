package com.xiaojun.yb.service.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DepartmentVO {

    @ApiModelProperty("上级机构ID")
    private String parentId;
    private String spaceId;
    @ApiModelProperty("是否是叶子节点 1-叶节点")
    private Integer leaf;
    @ApiModelProperty("机构ID")
    private String id;
    @ApiModelProperty("序号")
    private Integer seq;
    @ApiModelProperty("机构名称")
    private String name;
    @ApiModelProperty("机构编号")
    private String code;

}
