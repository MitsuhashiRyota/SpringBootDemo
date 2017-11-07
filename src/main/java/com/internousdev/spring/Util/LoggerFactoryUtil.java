package com.internousdev.spring.Util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.internousdev.spring.Const.Constants;

/**
 * ExceptionHandler
 * @author mitsuhashi
 *
 */
public class LoggerFactoryUtil {

	protected static Logger logger;

	protected static StringWriter stringWriter = new StringWriter();

	protected static PrintWriter printWriter;

	@Autowired
	protected ManagerMailAtomicUtil managerMailAtomicUtil;

	protected LoggerFactoryUtil(Object className) {
		logger = LoggerFactory.getLogger(className.getClass());
		printWriter  = new PrintWriter(stringWriter);
	}

	protected void writeException(Exception e) throws Exception {

		e.printStackTrace(printWriter);
		printWriter.flush();

		String exceptionMessage = stringWriter.toString();

		logger.error(Constants.LogErrorMessage.ERROR_DETECTION);

		switch (e.getMessage()) {
		case "NullPointerException":
			this.catchClassNotFoundException(exceptionMessage);

			break;
		case "ClassNotFoundException":
			this.catchClassNotFoundException(exceptionMessage);

			break;
		case "SQLException":
			this.catchSQLException(exceptionMessage);

			break;
		default:
			this.catchException(exceptionMessage);

			break;
		}

		managerMailAtomicUtil.sendMail(exceptionMessage);
	}

	protected void catchNullPointerException(String errorMessage) {
		logger.error(Constants.LogErrorMessage.NULL_POINTER_MESSAGE);
		logger.error(errorMessage);
	}

	protected void catchClassNotFoundException(String errorMessage) {
		logger.error(Constants.LogErrorMessage.CLASS_NOT_FOUND_MESSAGE);
		logger.error(errorMessage);
	}

	protected void catchSQLException(String errorMessage) {
		logger.error(Constants.LogErrorMessage.SQL_MESSAGE);
		logger.error(errorMessage);
	}

	protected void catchException(String errorMessage) {
		logger.error(Constants.LogErrorMessage.EXCEPTION_MESSAGE);
		logger.error(errorMessage);
	}
}
