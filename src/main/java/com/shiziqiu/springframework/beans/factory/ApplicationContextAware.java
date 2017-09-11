package com.shiziqiu.springframework.beans.factory;

import com.shiziqiu.springframework.context.ApplicationContext;

public interface ApplicationContextAware {

	void setApplicationContext(ApplicationContext applicationContext) throws Exception;
}
