package br.com.psmcompany.gestao.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket gestaoApi() {
        Set<String> protolocos = new HashSet<>();
        protolocos.add("http");

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("All")
                .select()
                .paths(PathSelectors.any())
                .apis( RequestHandlerSelectors.basePackage( "br.com.psmcompany.gestao" ) )
                .build()
                .protocols(protolocos)
                .ignoredParameterTypes(ApiIgnore.class)
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Gestão de Funcionários - REST API")
                .description("API para realizar a gestão dos funcionários")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Rodrigo Araújo", "https://github.com/rodrigo2005", "rodrigo.rsa2005@gmail.com"))
                .build();
    }

}
