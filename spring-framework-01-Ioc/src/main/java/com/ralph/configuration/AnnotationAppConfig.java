package com.ralph.configuration;

import com.ralph.domain.pojo.Hero;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: AnnotationAppConfig
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-19 10:16
 **/
@Configuration
public class AnnotationAppConfig {

    @Bean("simpleString")
    public String getSimpleString() {
        return "custom string from factory bean";
    }

    @Bean
    public Hero getHero() {
        Hero hero = new Hero();
        hero.setName("superwomen");
        hero.setSex("female");

        return hero;
    }
}
