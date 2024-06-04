package com.ralph.bean.definition.serviceloader;

import org.springframework.stereotype.Service;

/**
 * @ClassName: CustomServiceImpl1
 * @description:
 * @author: Neng.Tian
 * @create: 2024-05-16 10:02
 **/
@Service
public class CustomServiceImpl2 implements CustomService{
    @Override
    public void execute() {
        System.out.println("CustomServiceImpl2.handler");
    }
}
