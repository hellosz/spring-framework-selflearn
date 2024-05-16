package com.ralph.service;

import com.ralph.domain.pojo.Command;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @ClassName: CommandService
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-11 08:53
 **/
public class CommandService implements ApplicationContextAware {
    /**
     * 通过实现 ApplicationContextAware 接口注入 application，实现在单例的 bean 中调用非单例的 bean，
     * 每次得到不同实例的效果
     */
    private static ApplicationContext application;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        application = applicationContext;
    }

    private Command createCommand() {
        Command command = application.getBean("command", Command.class);
        return command;
    }

    public void executeCommand() {
        Command command = createCommand();
        System.out.println("execute command: " + command);
        System.out.println("System.identityHashCode(command) = " + System.identityHashCode(command));
    }
}
