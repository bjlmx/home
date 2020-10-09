/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/** @author Baijl
 * 2020/9/17 
 * 13:43 
 * @description swagger2.9的配置类
 */
//@Configuration
//@EnableSwagger2
//@Data
public class SwaggerConfig {
    private Contact contact=new Contact("白纪良","www.qq.com","bjl_mx@163.com");
    @Bean
    public Docket createRestApi(){
       return new Docket(DocumentationType.SWAGGER_2)
               .apiInfo(apiInfo())
               .select()
               .apis(RequestHandlerSelectors.basePackage("com.ruibing.home.controller"))
               .paths(PathSelectors.any())
               .build();
    }

    /**
     * create apiinfo
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot集成Swagger2")
                .description("swagger集成springboot生成文档测试项目")
                .version("v1.0")
                .contact(contact)
                .license("我的授权")
                .licenseUrl("授权url测试")
                .build();
    }
}
