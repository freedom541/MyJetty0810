package com.ccl.main;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 * Created by ccl on 16/8/10.
 */
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages("com.ccl.action");
        register(JacksonFeature.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
    }
}
