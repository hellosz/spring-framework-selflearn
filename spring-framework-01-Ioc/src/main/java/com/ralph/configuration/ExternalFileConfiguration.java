package com.ralph.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @ClassName: ExternalFileConfiguration
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-18 09:52
 **/
@Configuration
@PropertySource("classpath:application.properties") // 导入外部配置文件
//@PropertySource("classpath:application.yml") // spring 不支持直接导入 yml 文件，需要 springboot 下使用
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:another-application.properties")
})
public class ExternalFileConfiguration {
}
