package com.alejobrosxd.zemoga.core.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SpringFoxConfiguration {

    private ApiInfo apiInfo() {
        return new ApiInfo("Zemoga API", "API to create and modify user profile info", "1.0.0", "Private Repo "
            + "for Selection Process",
            new Contact("Mario Alejandro Martinez Perdomo", "https://github.com/AlejoBros",
                "alejandro.martinez.az@gmail.com"), "License of API",
            "API license URL", Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).useDefaultResponseMessages(false).select()
            .apis(RequestHandlerSelectors.basePackage("com.alejobrosxd.zemoga.controller.impl"))
            .paths(PathSelectors.any()).build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder().deepLinking(true).displayOperationId(false).defaultModelsExpandDepth(1)
            .defaultModelExpandDepth(1).defaultModelRendering(ModelRendering.EXAMPLE).displayRequestDuration(false)
            .docExpansion(DocExpansion.NONE).filter(true).maxDisplayedTags(null)
            .operationsSorter(OperationsSorter.ALPHA).showExtensions(false).tagsSorter(TagsSorter.ALPHA)
            .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS).validatorUrl(null).build();
    }

}
