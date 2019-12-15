package com.scs.web.space.api.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName VerifyNumber
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/6
 **/
@Data
public class VerifyNumber implements Serializable {
    private String code;
    private Date time;
    private String mobile;

    public VerifyNumber(String mobile, String verifyCode, Date date) {
        this.code = verifyCode;
        this.time = date;
        this.mobile = mobile;
    }
}