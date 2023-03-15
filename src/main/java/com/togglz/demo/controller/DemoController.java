package com.togglz.demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DemoController {

    private final FeatureManager manager;

    public static final Feature NEW_PRODUCT = new NamedFeature("NEW_PRODUCT");

    @RequestMapping("/demo")
    public ResponseEntity<String> demo() {

        if (manager.isActive(NEW_PRODUCT)) {
            log.info("new product feature enabled");
        } else {
            log.info("running the old code");
        }
        return ResponseEntity.ok().build();
    }
}
