package com.study.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 樊斌 on 2017/12/7.
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

    @Bean
    public Docket docApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("doc").pathMapping("/").select()
                .apis(RequestHandlerSelectors.basePackage("com.study.api.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(docApiInfo());
    }

    private ApiInfo docApiInfo(){
        return new ApiInfoBuilder()
                .title("springboot+dubbo学习")
                .description("小菜的学习记录")
                .version("1.0")
                .termsOfServiceUrl("NO terms of service")
                .license("The Apache License,Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}
