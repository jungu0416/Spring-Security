package com.springsecurity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(ApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springsecurity.security"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo ApiInfo() {
        return new ApiInfoBuilder()
                .title("security REST API")
                .version("1.0.1")
                .description("스프링 시큐리티 swagger api")
                .build();
    }


}
