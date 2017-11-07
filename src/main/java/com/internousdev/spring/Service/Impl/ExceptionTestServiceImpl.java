package com.internousdev.spring.Service.Impl;

import org.springframework.stereotype.Service;

import com.internousdev.spring.Const.Constants;
import com.internousdev.spring.Service.ExceptionTestInterface;

@Service
public class ExceptionTestServiceImpl implements ExceptionTestInterface {

	@Override
	public void getException() throws Exception {
		throw new Exception(Constants.ExceptionMessage.EXCEPTION);
	}

}
