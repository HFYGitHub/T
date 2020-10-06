package com.iteima.utils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
 
public class MailUtil {
	//发件人的邮箱和授权码
	private final String myEmailAccount = "ycr18797511157@163.com";//发送的邮箱
	private final String myEmailPassword = "LWQLKSFJWAPGNWLT";
	private String receiveMailAccount = null ;
	private String info=null;
	// 信息内容
	public void setReceiveMailAccount(String receiveMailAccount) {
		this.receiveMailAccount = receiveMailAccount;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	                                  
	// 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
	private  String myEmailSMTPServer = "smtp.163.com";
 
	public  void Send() throws Exception {
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties();                    // 参数配置
		props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSMTPServer);   // 发件人的邮箱的 SMTP 服务器地址
		props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
		
		//发送端口
		final String smtpPort = "994";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
 
 
		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getDefaultInstance(props);
		// 设置为debug模式, 可以查看详细的发送 log
		session.setDebug(true);                                
 
		// 3. 创建一封邮件
		MimeMessage message = createMessage(session, myEmailAccount, receiveMailAccount,info);
 
		// 4. 根据 Session 获取邮件传输对象
		Transport transport = session.getTransport();
 
		transport.connect(myEmailAccount, myEmailPassword);
 
		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
		transport.sendMessage(message, message.getAllRecipients());
 
		// 7. 关闭连接
		transport.close();
	}
 
    //创建邮件
	public  MimeMessage createMessage(Session session, String sendMail, String receiveMail,String info) throws Exception {
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);
		// 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
		message.setFrom(new InternetAddress(sendMail, "邮箱验证码测试", "UTF-8"));
		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "xx用户", "UTF-8"));
		// 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
		message.setSubject("验证码", "UTF-8");
		// 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
		message.setContent("【验证码】:"+info, "text/html;charset=UTF-8");
		// 6. 设置发件时间
		message.setSentDate(new Date());
		// 7. 保存设置         
		message.saveChanges();
 
		return message;
	}
}
