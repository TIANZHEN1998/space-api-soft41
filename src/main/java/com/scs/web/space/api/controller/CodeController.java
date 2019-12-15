package com.scs.web.space.api.controller;

import com.scs.web.space.api.domain.entity.CorrectCode;
import com.scs.web.space.api.service.RedisService;
import com.scs.web.space.api.util.VerifyUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName CodeController
 * @Description TODO
 * @Author 田震
 * @Date 2019/12/3
 **/

@RestController
@RequestMapping(value = "/api/code")
public class CodeController {
    @Resource
    private RedisService redisService;
    private static final long serialVersionUID = 3398560501558431737L;
    @RequestMapping(value="/authImage",method= RequestMethod.GET)
    public String authImage() {
        return "authImage";
    }
    /**
     * 获取验证码照片
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value="/getImage",method=RequestMethod.GET)
    public void CodeController (@RequestParam(value = "mobile") String mobile, HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        String verifyCode = VerifyUtil.generateVerifyCode(6);
        System.out.println("验证码："+ verifyCode);
        HttpSession session = request.getSession(true);
        response.setHeader("Access-Token", session.getId());
        response.setContentType("image/jpeg");
        CorrectCode correct=new CorrectCode(mobile,verifyCode);
        redisService.set(mobile,correct);
        int w = 100, h = 30;
        ServletOutputStream out = response.getOutputStream();
        VerifyUtil.outputImage(w, h, out, verifyCode);
    }
}