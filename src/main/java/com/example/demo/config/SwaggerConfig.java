package com.example.demo.config;




import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration

public class SwaggerConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API de pessoas")
                        .description("Api desenvolvida com base no curso Rest")
                        .version("1.0.0")
                        .termsOfService("colocar o terms service")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github")
                        .url("https://github.com/NTN1789"));
    }

}
