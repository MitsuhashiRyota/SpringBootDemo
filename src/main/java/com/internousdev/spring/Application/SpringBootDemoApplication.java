package com.internousdev.spring.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringBoot実行クラス
 * @author internous
 *
 */
@SpringBootApplication
@ComponentScan("com.internousdev.spring.Controller")
public class SpringBootDemoApplication {

	/**
	 * Controller実行クラス
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
