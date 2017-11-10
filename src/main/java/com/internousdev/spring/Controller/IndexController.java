package com.internousdev.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.internousdev.spring.Service.ExceptionTestInterface;
import com.internousdev.spring.Util.LoggerFactoryUtil;


@Controller
@ComponentScan("com.internousdev.spring.Service")
@ComponentScan("com.internousdev.spring.Util")
public class IndexController extends LoggerFactoryUtil{

	@Autowired
	ExceptionTestInterface exceptionTestInterface;

	IndexController() {
		super(IndexController.class);
	}

	@RequestMapping("/")
	public String doGet() throws Exception {

		try {
			//exceptionTestInterface.getException();
		} catch(Exception e) {
			super.writeException(e);
		}
		return "index";
	}
}
