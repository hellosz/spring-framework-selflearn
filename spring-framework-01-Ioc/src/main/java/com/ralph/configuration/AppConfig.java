package com.ralph.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: AppConfig
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-18 09:35
 **/
@Configuration
//@ComponentScan(basePackages = {"com"}, nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class) // 配置自定义的 bean 名称生成器
public class AppConfig {

    @Value("${application.name}")
    private String appName;

    @Value("${application.version}")
    private String version;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
