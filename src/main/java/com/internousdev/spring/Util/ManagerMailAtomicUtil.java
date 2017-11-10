package com.internousdev.spring.Util;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
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

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("serviceName", Constants.EmailMessageSetting.PROJECT_NAME);
		velocityContext.put("exceptionName", Constants.ExceptionMessage.SQL_EXCEPTION);
		velocityContext.put("exceptionInfo", errorMessage);

		Template template = Velocity.getTemplate("src/main/resources/mailtemplate/ExceptionMessageTemplate.vm", "UTF-8");

		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		stringWriter.flush();

		String[] toAccount = {Constants.ManagerAcountSetting.TO_MAIL_ADDRESS_1,Constants.ManagerAcountSetting.TO_MAIL_ADDRESS_2
				,Constants.ManagerAcountSetting.TO_MAIL_ADDRESS_3};

		simpleMailMessage.setFrom(Constants.ManagerAcountSetting.MANAGER_MAIL_ADDRESS_1);
		simpleMailMessage.setTo(toAccount);
		simpleMailMessage.setSubject(Constants.EmailMessageSetting.SUBJECT_NAME);
		simpleMailMessage.setText(stringWriter.toString());

		this.javaMailSender.send(simpleMailMessage);
	}
}
