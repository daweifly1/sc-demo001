package com.xiaojun.yb.service.VO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PasswordVO {

    private Integer type;
    private String userId;
    private String password;

}
