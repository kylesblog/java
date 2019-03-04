package com.example.develop.controller;


import com.example.develop.dao.BaseResponsitory;
import com.example.develop.mapper.FolderMapper;
import com.example.develop.message.MessageMap;
import com.example.develop.vo.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional(rollbackFor = Exception.class)
public class TestController {


    @Autowired
    BaseResponsitory baseResponsitory;

    @Autowired
    FolderMapper folderMapper;

    @GetMapping(value = "/test")
    public void test(){
       /* baseResponsitory.getDatas();*/
        try {
            PageHelper.startPage(1,10);
           List<UserEntity> list =  folderMapper.getDatas();
            System.out.println(MessageMap.objectTOJson(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
