package com.javawebfinal.controller;

import com.javawebfinal.service.TesterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TesterController {
    @Autowired
    private TesterService testerService;
    
    @RequestMapping("/test")
    public String test(){
        log.info("TesterController.test()");
        return testerService.list();
    }
}