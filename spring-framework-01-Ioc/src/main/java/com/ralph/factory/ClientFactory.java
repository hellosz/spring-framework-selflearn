package com.ralph.factory;

import com.ralph.service.ClientService;

/**
 * @ClassName: ClientFactory
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-10 09:29
 **/
public class ClientFactory {

    private static final ClientService clientService = new ClientService();

    public static ClientService getClientService() {
        return clientService;
    }
}
