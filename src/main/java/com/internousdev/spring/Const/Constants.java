package com.internousdev.spring.Const;

/**
 * サービスで利用する定数をまとめたクラス
 * @author mitsuhashi
 *
 */
public final class Constants {

	/**
	 * Constantsクラスルール
	 */
	private Constants() {

	}

	/**
	 * Logger用ErrorMessage
	 * @author mitsuhashi
	 *
	 */
	public static class LogErrorMessage {
		public static final String ERROR_DETECTION = "====== ERRORを検知 ======";
		public static final String NULL_POINTER_MESSAGE = "====== NULL POINTER ERROR ======";
		public static final String CLASS_NOT_FOUND_MESSAGE = "====== CLASS NOT FOUND ERROR ======";
		public static final String SQL_MESSAGE = "====== SQL ERROR ======";
		public static final String IO_MESSAGE = "====== SQL ERROR ======";
		public static final String EXCEPTION_MESSAGE = "====== EXCEPTION ERROR ======";
	}

	public static class ExceptionMessage {
		public static final String NULL_POINTER_EXCEPTION = "NullPointerException";
		public static final String CLASS_NOT_FOUND_EXCEPTION = "ClassNotFoundException";
		public static final String SQL_EXCEPTION = "SQLException";
		public static final String EXCEPTION = "Exception";
	}

	public static class ManagerAcountSetting {
		public static final String MANAGER_MAIL_ADDRESS_1 = "r.mitsuhashi.internous@gmail.com";
		public static final String TO_MAIL_ADDRESS_1 = "zozozonbi@gmail.com";
		public static final String TO_MAIL_ADDRESS_2 = "yakou_kmk_yym_eysy@softbank.ne.jp";
		public static final String TO_MAIL_ADDRESS_3 = "hyodo@internous.co.jp";
 	}

	public static class EmailMessageSetting {
		public static final String SUBJECT_NAME = "Detect Exception";
		public static final String PROJECT_NAME = "回楽天市場";
	}
}
