package com.cmct.ysq.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aswords
 * @Date 2017/2/13
 * @since v0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConf {

    @Value("${jwt.header}")
    private String jwtHeader;

    @Bean
    public Docket createSwagger() {

        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameterBuilder.name(jwtHeader)
                .description("身份token")
                .modelRef(new ModelRef("String"))
                .required(true)
                .parameterType("header")
                .required(false).build();
        parameters.add(parameterBuilder.build());


        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("恭逸Api")
                .description("ERP接口api")
                .contact(new Contact("重庆XXX有限公司", null, "335340681@qq.com"))
                .version("1.0")
                .build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(parameters).apiInfo(apiInfo).select()
                .apis(RequestHandlerSelectors.basePackage("com.cmct"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
