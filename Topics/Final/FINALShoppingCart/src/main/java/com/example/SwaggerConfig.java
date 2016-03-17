package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;


@Configuration
@EnableSwagger
public class SwaggerConfig {
private SpringSwaggerConfig springSwaggerConfig;
@Autowired
public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
this.springSwaggerConfig = springSwaggerConfig;
}
@Bean

public SwaggerSpringMvcPlugin customImplementation() {
return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
apiInfo()).includePatterns("/shoppcart/.*");
}
private ApiInfo apiInfo() {
ApiInfo apiInfo = new ApiInfo("ShoppinG CART API", "API Shopping Cart",
"brandon API terms of service", "torressbrandon@gmail.com",
"brandon API Licence Type", "branodnAPI License URL");
return apiInfo;
}
}
