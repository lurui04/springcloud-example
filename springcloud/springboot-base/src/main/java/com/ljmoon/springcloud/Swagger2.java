package com.ljmoon.springcloud;

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
 * @author lurui
 * @Package com.ljmoon.springcloud
 * @ClassName Swagger2
 * @Description 自动API文档生成
 * @Date 2020/2/4 21:56
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ljmoon.springcloud"))
                .paths(PathSelectors.any())
                .build();
    }


    /**
     * 设置swagger页面属性
     *
     * @param
     * @return springfox.documentation.service.ApiInfo
     * @methodname apiInfo
     * @author lurui
     * @date 2020/2/4 21:56
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot脚手架接口文档")
                .description("springboot脚手架接口文档")
                .termsOfServiceUrl("")
                .contact("base")
                .version("1.0")
                .build();
    }

}