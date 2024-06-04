package com.ralph.bean.definition.factory;

import com.ralph.bean.definition.serviceloader.CustomService;
import com.ralph.bean.definition.serviceloader.CustomServiceImpl1;
import com.ralph.bean.definition.serviceloader.CustomServiceImpl2;
import org.springframework.beans.factory.config.ListFactoryBean;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * @ClassName: CustomServiceFactory
 * @description: 自定义的 factory bean 工厂
 * @author: Neng.Tian
 * @create: 2024-05-21 09:44
 **/
public class CustomServiceFactory {

    private ServiceLoader<CustomService> customServiceServiceLoader;

    /**
     * 通过依赖注入 方式设置 ServiceLoader
     *
     * @param customServiceServiceLoader
     */
    public void setCustomServiceServiceLoader(ServiceLoader<CustomService> customServiceServiceLoader) {
        this.customServiceServiceLoader = customServiceServiceLoader;
    }

    /**
     * 手动通过 ServiceLoader 加载 CustomService
     * @return
     */
    public List<CustomService> loadCustomService() {
        ServiceLoader<CustomService> load = ServiceLoader.load(CustomService.class);
        List<CustomService> customServices = new ArrayList<>();
        for (CustomService customService : load) {
            customServices.add(customService);
        }

        return customServices;
    }

    /**
     * 工厂方法，将 service loader 转成 list
     *
     * @param
     * @return
     */
    public List<CustomService> loadCustomServiceByListFactoryBean() {
        List<CustomService> customServices = new ArrayList<>();

        for (CustomService customService : customServiceServiceLoader) {
            customServices.add(customService);
        }

        return customServices;
    }
}