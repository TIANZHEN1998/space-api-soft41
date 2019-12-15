package com.scs.web.space.api.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail163Test {
     public static void Email(String email) throws Exception{
                 //0.1 确定连接位置
                 Properties props = new Properties();
                //获取163邮箱smtp服务器的地址，
                 props.setProperty("mail.host", "smtp.163.com");
                 //是否进行权限验证。
                 props.setProperty("mail.smtp.auth", "true");
                //0.2确定权限（账号和密码）
                Authenticator authenticator = new Authenticator() {
             @Override
             public PasswordAuthentication getPasswordAuthentication() {
                                //填写自己的163邮箱的登录帐号和授权密码，授权密码的获取，在后面会进行讲解。
                 return new PasswordAuthentication("15152231582@163.com","cao5841314244");
                             }
         };

                 //1 获得连接
                 /**
         37          * props：包含配置信息的对象，Properties类型
         38          *         配置邮箱服务器地址、配置是否进行权限验证(帐号密码验证)等
         39          *
         40          * authenticator：确定权限(帐号和密码)
         41          *
         42          * 所以就要在上面构建这两个对象。
         43          */

                Session session = Session.getDefaultInstance(props, authenticator);


                 //2 创建消息
               Message message = new MimeMessage(session);
                // 2.1 发件人        xxx@163.com 我们自己的邮箱地址，就是名称
                 message.setFrom(new InternetAddress("15152231582@163.com"));
                /**
         53          * 2.2 收件人
         54          *         第一个参数：
         55          *             RecipientType.TO    代表收件人
         56          *             RecipientType.CC    抄送
         57          *             RecipientType.BCC    暗送
         58          *         比如A要给B发邮件，但是A觉得有必要给要让C也看看其内容，就在给B发邮件时，
         59          *         将邮件内容抄送给C，那么C也能看到其内容了，但是B也能知道A给C抄送过该封邮件
         60          *         而如果是暗送(密送)给C的话，那么B就不知道A给C发送过该封邮件。
         61          *     第二个参数
         62          *         收件人的地址，或者是一个Address[]，用来装抄送或者暗送人的名单。或者用来群发。可以是相同邮箱服务器的，也可以是不同的
         63          *         这里我们发送给我们的qq邮箱
         64          */
                 message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
                 // 2.3 主题（标题）
                 message.setSubject("邮件的标题");
                 // 2.4 正文
                 String str = "tao： <br/>" +
                                        "您好，您在本空间注册用户，点击下面url进行激活<br/>" +
                                        "http://localhost:8080//api/user/u<br/>" +
                                        "如果不能点击，请复制直接激活<br/>" +
                                         "如果不是本人，请删除邮件";
                 //设置编码，防止发送的内容中文乱码。
                 message.setContent(str, "text/html;charset=UTF-8");

                //3发送消息
                Transport.send(message);
            }

    public static void main(String[] args) {
        try {
            Email("1244353765@qq.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }
