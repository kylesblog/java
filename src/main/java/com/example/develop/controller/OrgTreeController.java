package com.example.develop.controller;


import com.example.develop.domain.Node;
import com.example.develop.helper.Message;
import com.example.develop.service.OrgTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treeNode")
public class OrgTreeController {

    @Autowired(required=true)
    private OrgTreeService orgTreeService;

    @GetMapping(value = "/test")
    public void test(){

    }

    @GetMapping("/queryTreeById")
    public Message queryTreeById(@RequestParam String pId){
        return orgTreeService.queryTreeById(pId);
    }

    @PostMapping("/insert")
    public Message insertTree(@RequestBody Node node){
        return orgTreeService.insertTreeNode(node);
    }

    @PostMapping("/batchInsert")
    public Message batchInsert(@RequestBody List<Node> list){
        return orgTreeService.batchInsertTreeNodes(list);
    }
}
