package com.example.develop.service;

import com.example.develop.domain.Node;
import com.example.develop.helper.Message;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Hello-World
 * @description:
 * @author: guohuixie2
 * @create: 2019-06-17 20:19
 **/

@Service
public interface OrgTreeService {

    /**
     * queryOrgTreeDataByParent
     * @return
    */
    Message queryTreeById(String parentId);


    /**
     * insertTreeNode
     * @return
     */
    Message insertTreeNode(Node node);

    /**
     * batchInsertTreeNodes
     * @return
     */
    Message batchInsertTreeNodes(List<Node> list);

    /**
     * deleteTreeNode
     * @return
     */
    Message deleteTreeNode();

    Message batchDeleteTreeNodes();

    Message updateTreeNode();

    Message batchUpdateTreeNodes();





}
