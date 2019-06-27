package com.example.develop.dao;


import com.example.develop.domain.Node;
import com.example.develop.helper.StringHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class OrgTreeResponsitory {

    @Autowired
    private  JdbcTemplate jdbcTemplate;

    public static final String BASESQL = " select node_code nodeCode, node_name nodeName, modify_time modifyTime, create_time createTime from tree_node ";
    public static final String QUERYTREEBYPARNETID = "where node_code = %s ";

    public static final String INSERTSQL = " insert into tree_node (node_code,node_name,modify_time,create_time) values (?,?,?,?)";

    public List<Node> queryOrgTreeByParentId(String parentId) throws Exception{

        try {
            String sql = BASESQL + StringHelper.format(QUERYTREEBYPARNETID,StringHelper.appendAfterLike(parentId));
            return jdbcTemplate.queryForList(sql,Node.class);
        } catch (DataAccessException e) {
            return null;
        } catch (Exception e){
            throw e;
        }
    }

    public int insert(Node node){
        try {
            return jdbcTemplate.update(INSERTSQL,node.getNodeCode(),node.getNodeName(),node.getModifyTime(),node.getCreateTime());
        } catch (Exception e) {
            log.error("insert fail...,nodeCode = {}",node.getNodeCode(), e);
            throw e;
        }
    }

    public void batchInsertTreeNodes(){
        //jdbcTemplate.batchUpdate(INSERTSQL,)
    }

}
