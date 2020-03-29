package pharos.solutions.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private static final String TITLE = " Mypost REST API";
    private static final String DESCRIPTION = " Allow users to create posts ";
    private static final String VERSION = "API 1.0.0";
    private static final String CONTACT_PERSON_NAME = "Sherin Medhat";
    private static final String CONTACT_PERSON_EMAIL = "sherin.medhat@yahoo.com";

    @Bean
    public Docket api() {
        ArrayList<ApiKey> keys = new ArrayList<>();
        keys.add(new ApiKey("Authorization", "Bearer", "header"));
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pharos.solutions.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo()).securitySchemes(keys);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(TITLE, DESCRIPTION, VERSION, "",
                new Contact(CONTACT_PERSON_NAME, "", CONTACT_PERSON_EMAIL), "", "");
    }
}
