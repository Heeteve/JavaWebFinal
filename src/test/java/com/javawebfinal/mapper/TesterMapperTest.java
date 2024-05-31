package com.javawebfinal.mapper;

import com.javawebfinal.model.Tester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TesterMapperTest {
    
    @Autowired
    private TesterMapper testerMapper;
    
    @Test
    void testSelectAll() {
        List<Tester> testers = testerMapper.selectAll();
        for (Tester tester : testers) {
            System.out.println(tester);
        }
    }

}