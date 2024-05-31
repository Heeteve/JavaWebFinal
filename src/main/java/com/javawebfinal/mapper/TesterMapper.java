package com.javawebfinal.mapper;

import com.javawebfinal.model.Tester;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TesterMapper {
    @Select("SELECT * FROM fi_test")
    List<Tester> selectAll();
}