package com.bloglaptrinh.app.config;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Value;

public class EsProvider {

    @Value("")
    private Client client;


}
