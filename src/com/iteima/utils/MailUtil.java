package com.iteima.utils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
 
public class MailUtil {
	//�����˵��������Ȩ��
	private final String myEmailAccount = "ycr18797511157@163.com";//���͵�����
	private final String myEmailPassword = "LWQLKSFJWAPGNWLT";
	private String receiveMailAccount = null ;
	private String info=null;
	// ��Ϣ����
	public void setReceiveMailAccount(String receiveMailAccount) {
		this.receiveMailAccount = receiveMailAccount;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	                                  
	// ����163����� SMTP ��������ַΪ: smtp.163.com
	private  String myEmailSMTPServer = "smtp.163.com";
 
	public  void Send() throws Exception {
		// 1. ������������, ���������ʼ��������Ĳ�������
		Properties props = new Properties();                    // ��������
		props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
		props.setProperty("mail.smtp.host", myEmailSMTPServer);   // �����˵������ SMTP ��������ַ
		props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤
		
		//���Ͷ˿�
		final String smtpPort = "994";
		props.setProperty("mail.smtp.port", smtpPort);
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", smtpPort);
 
 
		// 2. �������ô����Ự����, ���ں��ʼ�����������
		Session session = Session.getDefaultInstance(props);
		// ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
		session.setDebug(true);                                
 
		// 3. ����һ���ʼ�
		MimeMessage message = createMessage(session, myEmailAccount, receiveMailAccount,info);
 
		// 4. ���� Session ��ȡ�ʼ��������
		Transport transport = session.getTransport();
 
		transport.connect(myEmailAccount, myEmailPassword);
 
		// 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
		transport.sendMessage(message, message.getAllRecipients());
 
		// 7. �ر�����
		transport.close();
	}
 
    //�����ʼ�
	public  MimeMessage createMessage(Session session, String sendMail, String receiveMail,String info) throws Exception {
		// 1. ����һ���ʼ�
		MimeMessage message = new MimeMessage(session);
		// 2. From: �����ˣ��ǳ��й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸��ǳƣ�
		message.setFrom(new InternetAddress(sendMail, "������֤�����", "UTF-8"));
		// 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "xx�û�", "UTF-8"));
		// 4. Subject: �ʼ����⣨�����й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ı��⣩
		message.setSubject("��֤��", "UTF-8");
		// 5. Content: �ʼ����ģ�����ʹ��html��ǩ���������й�����ɣ����ⱻ�ʼ�����������Ϊ���ķ������������ʧ�ܣ����޸ķ������ݣ�
		message.setContent("����֤�롿:"+info, "text/html;charset=UTF-8");
		// 6. ���÷���ʱ��
		message.setSentDate(new Date());
		// 7. ��������         
		message.saveChanges();
 
		return message;
	}
}
