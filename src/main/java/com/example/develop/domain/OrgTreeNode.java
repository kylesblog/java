package com.example.develop.domain;

import java.util.List;

/**
 * @program: Hello-World
 * @description:
 * @author: guohuixie2
 * @create: 2019-06-19 21:04
 **/


public class OrgTreeNode<T> {

    private T node;

    private boolean hasChildren = false;

    private List<OrgTreeNode<T>> children ;


    public OrgTreeNode() {
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
