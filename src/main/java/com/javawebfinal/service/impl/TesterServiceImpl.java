package com.javawebfinal.service.impl;

import com.javawebfinal.mapper.TesterMapper;
import com.javawebfinal.model.Tester;
import com.javawebfinal.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterServiceImpl implements TesterService {
    @Autowired
    private TesterMapper testerMapper;
    
    @Override
    public String list() {
        List<Tester> testers = testerMapper.selectAll();
        return testers.toString();
    }
}