package com.scs.web.space.api.domain.dto;

import lombok.Data;

/**
 * @ClassName UserDto
 * @Description TODO
 * @Author mq_xu
 * @Date 2019/12/1
 **/
@Data
public class UserDto {
    private String mobile;
    private String password;
    private String code;
}
