package com.ralph.bean.dependency;

import com.ralph.bean.BaseTest;
import com.ralph.service.CommandService;
import org.junit.Test;

/**
 * @ClassName: MethodInjectionTest
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-11 08:52
 **/
public class MethodInjectionTest extends BaseTest {

    @Test
    public void methodInject() {
        CommandService commandService = applicationContext.getBean("commandService", CommandService.class);

        for (int i = 0; i < 10; i++) {
            commandService.executeCommand();
        }
    }

}
