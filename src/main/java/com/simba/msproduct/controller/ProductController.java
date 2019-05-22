package com.simba.msproduct.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-05-18
 */
@RestController
@RequestMapping(value = "/products")
@Slf4j
public class ProductController {

    private static final String LOCAL_SERVER_PORT = "local.server.port";
    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity<String> getProduct() {
        log.info("***** processing get product *****");
        return ResponseEntity.ok("Product Controller, Port:  " + environment.getProperty(LOCAL_SERVER_PORT));
    }
}
