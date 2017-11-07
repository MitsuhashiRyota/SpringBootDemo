package com.internousdev.spring.Service;

import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionTestInterface {

	void getException() throws Exception;
}
