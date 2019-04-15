package com.ruoyi.web.core.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ruoyi.common.config.Global;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.misc.Request;

import java.util.function.Predicate;

/**
 * Swagger2的接口配置
 * 
 * @author ruoyi
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi()
    {
        com.google.common.base.Predicate<RequestHandler> selector1 = RequestHandlerSelectors.basePackage("com.ruoyi.web.controller.tool");
        com.google.common.base.Predicate<RequestHandler> selector2 = RequestHandlerSelectors.basePackage("com.ruoyi.web.controller.common");
        return new Docket(DocumentationType.SWAGGER_2)
                // 详细定制
                .apiInfo(apiInfo())
                .select()
                // 指定当前包路径
                .apis(Predicates.or(selector1,selector2))
//                .apis(RequestHandlerSelectors.basePackage("com.ruoyi.web.controller.common.CommonController"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo()
    {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("标题：若依管理系统_接口文档")
                .description("描述：用于管理集团旗下公司的人员信息,具体包括XXX,XXX模块...")
                .contact(new Contact(Global.getName(), null, null))
                .version("版本号:" + Global.getVersion())
                .build();
    }
}
