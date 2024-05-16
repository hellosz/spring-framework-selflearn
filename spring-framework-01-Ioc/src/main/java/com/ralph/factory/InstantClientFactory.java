package com.ralph.factory;

import com.ralph.service.ClientService;

/**
 * @ClassName: InstantClientFactory
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-10 09:36
 **/
public class InstantClientFactory {

    private ClientService clientService;

    public InstantClientFactory() {
        clientService = new ClientService();
    }

    /**
     * 通过实例工厂方法，获取 bean 对象
     *
     * @return
     */
    public ClientService getInstantClientService() {
        return clientService;
    }
}
