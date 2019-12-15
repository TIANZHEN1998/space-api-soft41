package com.scs.web.space.api.domain.entity;

import lombok.Data;
import org.springframework.data.redis.core.index.PathBasedRedisIndexDefinition;

import java.io.Serializable;

/**
 * @ClassName CorrectCode
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/7
 **/
@Data
public class CorrectCode  implements Serializable {
    private  String mobile;
    private  String correctCode;

    public  CorrectCode(String mobile,String verifyCode){
        this.mobile=mobile;
        this.correctCode=verifyCode;

    }
}