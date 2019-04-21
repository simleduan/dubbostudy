/*
 * Copyright 2014-2018 the original author or authors..
 * Support: http://www.devutil.cn
 * License: http://www.apache.org/licenses/LICENSE-2.0
 *
 */
package com.study.api.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.api.service.PersonService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * dubbo consumer
 * 
 * @author 柒葉
 * @date 2016年11月26日
 */
@Component
public class DemoAction implements InitializingBean {
	@Reference
	private PersonService personService;

	@Override
	public void afterPropertiesSet() throws Exception {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			try {
				String hello = personService.sayHello("world" + i);
				System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] " + hello);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Thread.sleep(2000);
		}
	}

}
