package com.whoofy.eservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletContext;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

 @Bean
 public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                    .basePackage("com.whoofy.eservice.rest"))
            .paths(PathSelectors.any())
            .build();
 }
 
 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry.addResourceHandler("swagger-ui.html")
             .addResourceLocations("classpath:/META-INF/resources/");

     registry.addResourceHandler("/webjars/**")
             .addResourceLocations("classpath:/META-INF/resources/webjars/");
 }
}