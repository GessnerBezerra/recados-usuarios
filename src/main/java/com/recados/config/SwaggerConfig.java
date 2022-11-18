package com.recados.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration //configuração
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2) // retorna a documentação
                .select() // digo quem vou selecionar
                .apis(RequestHandlerSelectors.any())//eu indico quais pacotes eu vou ler
                .paths(PathSelectors.any())//eu indico quais entpoints
                .build()
                .apiInfo (metaInfo());
  }


    private ApiInfo metaInfo() {

            ApiInfo apiInfo = new ApiInfo(
              "Recados API REST",
              "API REST de usuarios e recados",
              "1.0",
              "Terms of Service",
              new Contact("Gessner","https://www.linkedin.com/in/gessner-de-oliveira-bezerra",
                "gessnerbezerra@gmail.com"),
              "Apache License Version 2.0",
              "https://www.apache.org/licesen.html", new ArrayList< VendorExtension>()
            );

            return apiInfo;
          }



    //exemplo de como mapear apenas um controler ou mais de um, sem ser todos
//  @Bean
//  public Docket productApi(){
//    return new Docket(DocumentationType.SWAGGER_2) // retorna a documentação
//            .select() // digo quem vou selecionar
//            .apis(RequestHandlerSelectors.basePackage("com.vendas.controller"))//eu indico quais pacotes eu vou ler
//            .paths(PathSelectors.regex("/user/*"))//eu indico quais entpoints
//            .build();
//  }
}
