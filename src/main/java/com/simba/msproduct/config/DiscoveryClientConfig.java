package com.simba.msproduct.config;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-05-22
 */
@Slf4j
@Configuration
public class DiscoveryClientConfig {

    @Bean
    public DiscoveryClient.DiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
        log.info("*** chargement des certificats ***");
        DiscoveryClient.DiscoveryClientOptionalArgs args = new DiscoveryClient.DiscoveryClientOptionalArgs();
        System.setProperty("javax.net.ssl.keyStore", "src/main/resources/msproduct.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "msproduct");
        System.setProperty("javax.net.ssl.trustStore", "src/main/resources/msproduct.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "msproduct");
        EurekaJerseyClientImpl.EurekaJerseyClientBuilder builder = new EurekaJerseyClientImpl.EurekaJerseyClientBuilder();
        builder.withClientName("product-service");
        builder.withSystemSSLConfiguration();
        builder.withMaxTotalConnections(10);
        builder.withMaxConnectionsPerHost(10);
        args.setEurekaJerseyClient(builder.build());
        log.info("**** certificats {} *** ", builder);
        return args;
    }
}
