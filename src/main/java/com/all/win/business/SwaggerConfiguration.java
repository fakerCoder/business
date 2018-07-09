package com.all.win.business;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: 集成swagger的配置类
 * @Author: fakerCoder
 * @Date: 2018/7/5 11:58
 * @Version: 1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.all.win.business.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("帮销系统RestFul_API")
                .contact("FakerCoder")
                .version("1.0.0")
                .description("API描述")
                .build();
    }
}
