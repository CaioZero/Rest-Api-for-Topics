package com.springboot.javabrains.courseapi.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@SuppressWarnings("rawtypes")
@Configuration
@EnableSwagger2
/**
 * SwaggerConfig
 */
public class SwaggerConfig {

    /** This first Method its for return a docket, a external class */
    @Bean
    public Docket doctorAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.javabrains.courseapi"))/** Package where is all files */
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaInfo());/** call an method with all details about the api and the developer */
    }


    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
            "Topics API",
            "Rest API For Topics",
            "1.0.0",
            "termsOfServiceUrl",
            new Contact("Caio Augusto",
                        "https://www.linkedin.com/in/caioaugustozero/",
                        "caioaugusto.zero@gmail.com"),
            "Apache License Version 2.0",
            "https://www.apache.ogr/license.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}
