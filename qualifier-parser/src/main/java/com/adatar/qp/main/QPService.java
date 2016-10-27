package com.adatar.qp.main;

import com.adatar.qp.conf.QPConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class QPService extends Application<QPConfiguration> {

    @Override
    public String getName() {
        return "qualifier-parser-service";
    }

    @Override
    public void initialize(Bootstrap<QPConfiguration> bootstrap) {
    }


    @Override
    public void run(QPConfiguration qpConfiguration, Environment environment) throws Exception {

        final QPHandler handler = new QPHandler();
        environment.jersey().register(handler);
    }

    public static void main(String[] args) throws Exception {
        new QPService().run(args);
    }

}
