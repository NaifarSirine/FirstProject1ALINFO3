package tn.esprit.spring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("TP 1 ALINFO 3")
                .description("Projet du cours")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("contact US")
                .email("esprit2425-1ALINFO3@esprit.tn");
        return contact;
    }
    @Bean
    public GroupedOpenApi helloWorldPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only HelloWorld")
                .pathsToMatch("/UserRestController/helloWorld*/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi allPublicApi() {
        return GroupedOpenApi.builder()
                .group("All")
                .pathsToMatch("/**")
                .pathsToExclude("/UserRestController/helloWorld*/**")
                .build();
    }
}