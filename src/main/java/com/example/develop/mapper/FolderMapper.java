package com.example.develop.mapper;

import com.example.develop.vo.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FolderMapper {
    @Select("select * from pandora_folder ")
    @Results({
            @Result(property = "id",column = "id",javaType = Long.class),
            @Result(property = "folderName",column = "folder_name",javaType = String.class)
    })
    List<UserEntity> getDatas();
}
