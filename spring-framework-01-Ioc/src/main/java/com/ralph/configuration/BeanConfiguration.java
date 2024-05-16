package com.ralph.configuration;

import com.ralph.domain.pojo.ConfigurationBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName: BeanConfiguration
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-17 09:31
 **/
@Configuration
public class BeanConfiguration {

    @Bean
    @Primary
    public ConfigurationBean firstGetBean() {
//        System.out.println("BeanConfiguration.firstGetBean");

        ConfigurationBean configurationBean = new ConfigurationBean();
        configurationBean.setName("first");
        return configurationBean;
    }

    @Bean(name = "configurationBean")
    public ConfigurationBean secondGetBean() {
//        System.out.println("BeanConfiguration.firstGetBean");

        ConfigurationBean configurationBean = new ConfigurationBean();
        configurationBean.setName("second");
        return configurationBean;
    }
}
