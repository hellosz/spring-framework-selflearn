package com.ralph.service;

import com.ralph.configuration.AppConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: ConfigService
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-18 09:39
 **/
@Service
public class ConfigService {

    @Resource
    private AppConfig appConfigure;

    @Resource
    private Integer evalDynamicValue;

    public AppConfig getAppConfigure() {
        return appConfigure;
    }

    public Integer getEvalDynamicValue() {
        return evalDynamicValue;
    }
}
