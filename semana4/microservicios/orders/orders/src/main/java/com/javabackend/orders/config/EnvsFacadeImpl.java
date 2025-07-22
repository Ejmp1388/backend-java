package com.javabackend.orders.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvsFacadeImpl implements EnvsFacade{
    @Value("${app.envs.client.host}")
    String host;//esto quiero que lo inyecte como variable de entorno
    @Override
    public String getClientHostEnv() {

        return "";
    }
}
