package com.internousdev.spring.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.internousdev.spring.Const.Constants;

@Component
public class ManagerMailAtomicUtil {

	private final JavaMailSender javaMailSender;

	@Autowired
	ManagerMailAtomicUtil(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	private SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

	/**
	 * Mail送信
	 * @param errorMessage
	 */
	@Async
	public void sendMail(String errorMessage) {

		simpleMailMessage.setFrom(Constants.ManagerAcountSetting.MANAGER_MAIL_ADDRESS);
		simpleMailMessage.setTo("zozozonbi@gmail.com");
		simpleMailMessage.setSubject("Errorログ出力検知");
		simpleMailMessage.setText(errorMessage);

		this.javaMailSender.send(simpleMailMessage);
	}
}
