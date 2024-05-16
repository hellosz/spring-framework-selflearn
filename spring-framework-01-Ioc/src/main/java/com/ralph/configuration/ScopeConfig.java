package com.ralph.configuration;

import com.ralph.domain.pojo.ScopedBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ScopeConfig
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-20 22:08
 **/
@Configuration
public class ScopeConfig {

    @Bean(initMethod = "init", destroyMethod = "close")
    public ScopedBean scopedBean() {
        return new ScopedBean();
    }
}
