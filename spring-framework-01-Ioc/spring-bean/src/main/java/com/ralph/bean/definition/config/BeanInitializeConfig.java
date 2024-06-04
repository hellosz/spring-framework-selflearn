package com.ralph.bean.definition.config;

import com.ralph.bean.definition.domain.bean.InitSequenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @ClassName: BeanInitializeConfig
 * @description: bean 初始化配置
 * @author: Neng.Tian
 * @create: 2024-06-01 23:39
 **/
@Configuration
public class BeanInitializeConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
//    @Lazy
    public InitSequenceBean initSequenceBean()
    {
        return new InitSequenceBean();
    }
}
