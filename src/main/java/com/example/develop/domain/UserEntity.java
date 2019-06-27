package com.example.develop.domain;

import java.io.Serializable;


public class UserEntity implements Serializable {

    private Long id;
    private String folderName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
