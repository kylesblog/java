package com.example.develop.service.impl;

import com.example.develop.dao.OrgTreeResponsitory;
import com.example.develop.domain.Node;
import com.example.develop.helper.Message;
import com.example.develop.helper.StringHelper;
import com.example.develop.service.OrgTreeService;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @program: Hello-World
 * @description:
 * @author: guohuixie2
 * @create: 2019-06-17 20:25
 **/

@Slf4j
public class OrgTreeServiceImpl implements OrgTreeService {

    @Autowired
    private OrgTreeResponsitory orgTreeResponsitory;

    @Override
    public Message queryTreeById(String parentId) {
        try {
            if(StringUtils.isEmpty(parentId)){
                return Message.buildInValidParamResult();
            }
            List<Node> nodes = orgTreeResponsitory.queryOrgTreeByParentId(parentId);
            getOrgTreeData(nodes,parentId);
            return Message.buildSuccessResult(nodes);
        } catch (Exception e) {
            return Message.buildExceptionResult();
        }
    }


    private  List<Node> getOrgTreeData(List<Node> nodes,String parentId){
        if(CollectionUtils.isEmpty(nodes)){
            return null;
        }
        for(Node node : nodes){
            String nodeCode = node.getNodeCode();
            if(parentId.equals(nodeCode)){
                continue;
            }
            String pId = nodeCode.substring(0,nodeCode.length()-2);
            node.setParentId(pId);
        }
        return nodes;
    }


    @Override
    public Message insertTreeNode(Node node) {
        try {
            if(Objects.isNull(node)){
                return Message.buildInValidParamResult();
            }
            /**
             * 获得当前节点下的所有信息
             */
            String pId = getParentId(node.getNodeCode());
            List<Node> list = orgTreeResponsitory.queryOrgTreeByParentId(pId);
            /**
             * 获得当前树节点的下一层节点
             */
            Set<Integer> nextTree = new TreeSet<>();
            getNextTreeData(pId, list, nextTree);

            /**
             * 获得新节点的nodeCode
             */
            String nodeCode = getBrokenPoint(nextTree.toArray(new Integer[0]),pId);
            node.setNodeCode(nodeCode);

            /**
             * 记录创建时间
             */
            node.setCreateTime(new Date());

            /**
             * 落库
             */
            int res  = orgTreeResponsitory.insert(node);

            if(res<1){
                log.info("插入失败,nodeCode:{}!",node.getNodeCode());
                return Message.buildExceptionResult();
            }
        } catch (Exception e) {
            log.error("插入失败,nodeCode:{}!",node.getNodeCode());
            return Message.buildExceptionResult();
        }
        return Message.buildSuccessResult("插入成功！");
    }

    private void getNextTreeData(String pId, List<Node> list, Set<Integer> nextTree) {
        for (Node nd : list){
            String parnetId = getParentId(nd.getNodeCode());
            if(parnetId.equals(pId)){
                nextTree.add(Integer.valueOf(parnetId));
            }
        }
    }

    private String getBrokenPoint(Integer[] arrays,String pId) throws Exception{
        if(arrays.length == 0){
            return pId+"001";
        }
        for(int i = 1;i< arrays.length;i++) {
            if(arrays[i].equals(arrays[i-1])){
                throw new Exception("nodeCode={}出现重复！" + arrays[i]);
            }
            if((arrays[i] - arrays[i-1]) > 1){
                return StringHelper.formateInteger(arrays[i-1] + 1);
            }
        }
        return StringHelper.formateInteger(arrays[arrays.length - 1] + 1);
    }


    private String getParentId(String nodeCode) {
        return nodeCode.substring(0,nodeCode.length()-2);
    }

    @Override
    public Message batchInsertTreeNodes(List<Node> list) {


        return null;
    }

    @Override
    public Message deleteTreeNode() {
        return null;
    }

    @Override
    public Message batchDeleteTreeNodes() {
        return null;
    }

    @Override
    public Message updateTreeNode() {
        return null;
    }

    @Override
    public Message batchUpdateTreeNodes() {
        return null;
    }
}
