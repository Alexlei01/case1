package com.wonderrobot.ankenmatchingu.swagger;
// SwaggerConfig.vm
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

/**
 * Swagger configuration
 */
@EnableOpenApi
@Configuration
public class SwaggerConfig {

	private String title = "案件マッチング.swagger";
	private String description = "案件マッチング.swaggerInterface document description";

    @Bean
    public Docket goodsRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("Com.wonderrobot.ankenmatchingu.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    @Bean
    public UiConfiguration uiConfig() {
    	return UiConfigurationBuilder.builder()
	        .deepLinking(true)
	        .displayOperationId(true)
	        .defaultModelsExpandDepth(1)
	        .defaultModelExpandDepth(1)
	        .defaultModelRendering(ModelRendering.EXAMPLE)
	        .displayRequestDuration(true)
	        .docExpansion(DocExpansion.LIST)
	        .maxDisplayedTags(null)
	        .operationsSorter(OperationsSorter.ALPHA)
	        .showExtensions(false)
	        .showCommonExtensions(false)
	        .tagsSorter(TagsSorter.ALPHA)
	        .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
	        .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .build();
    }
}
