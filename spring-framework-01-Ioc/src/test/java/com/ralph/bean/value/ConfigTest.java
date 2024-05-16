package com.ralph.bean.value;

import com.ralph.bean.BaseTest;
import com.ralph.configuration.AppConfig;
import com.ralph.service.ConfigService;
import org.junit.Test;

/**
 * @ClassName: ConfigTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-18 09:46
 **/
public class ConfigTest extends BaseTest {
    
    @Test
    public void getConfig () {
        ConfigService configService = applicationContext.getBean("configService", ConfigService.class);

        AppConfig appConfigure = configService.getAppConfigure();
        System.out.println("appConfigure.getAppName() = " + appConfigure.getAppName());
        System.out.println("appConfigure.getVersion() = " + appConfigure.getVersion());

        Integer evalDynamicValue = configService.getEvalDynamicValue();
        System.out.println("evalDynamicValue = " + evalDynamicValue);
    }
}
