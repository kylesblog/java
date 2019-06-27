package com.example.develop.dao;


import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BaseResponsitory {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<Object,Object>> getDatas(){
        String sql = " select * from pandora_folder where folder_name = ? ";
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, "助学贷1");
        return null;
    }

}
