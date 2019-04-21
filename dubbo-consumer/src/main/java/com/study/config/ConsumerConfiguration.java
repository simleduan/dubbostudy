/*
 * Copyright 2014-2018 the original author or authors..
 * Support: http://www.devutil.cn
 * License: http://www.apache.org/licenses/LICENSE-2.0
 *
 */
package com.study.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * dubbo运行环境配置
 * 
 * @author 柒葉
 * @date 2016年11月26日
 */
@Configuration
@ConditionalOnClass(Exporter.class)
public class ConsumerConfiguration {
	/**
	 * 扫描dubbo annotation
	 * @return
	 */
	@Bean
	public AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage("com.study.api.controller");
		return annotationBean;
	}

	/**
	 * 注入dubbo上下文
	 * 
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "dubbo.application")
	public ApplicationConfig applicationConfig() {
		// 当前应用配置
		ApplicationConfig applicationConfig = new ApplicationConfig();
		return applicationConfig;
	}

	/**
	 * 注入dubbo注册中心配置,基于zookeeper
	 * 
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "dubbo.registry")
	public RegistryConfig registryConfig() {
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		return registry;
	}

	/**
	 * 默认基于dubbo协议提供服务
	 * 
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "dubbo.protocol")
	public ProtocolConfig protocolConfig() {
		// 服务提供者协议配置
		ProtocolConfig protocolConfig = new ProtocolConfig();
		return protocolConfig;
	}

	@Bean(name = "defaultProvider")
	public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
			ProtocolConfig protocolConfig) {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setApplication(applicationConfig);
		providerConfig.setRegistry(registryConfig);
		providerConfig.setProtocol(protocolConfig);
		return providerConfig;
	}
}
