package com.sky.mapper;

import com.sky.entity.Model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@Mapper
public interface ModelMapper {
    @Select("select * from model")
    List<Model> selectAll();

    @Select("select  * from model where id = #{id}")
    Model selectById(Long id);

    @Select("select * from model where name = #{modelName}")
    Model selectByName(String modelName);

    @Select("select * from model where line_details = #{lineDetails}")
    Model selectByLineDetails(String lineDetails);
}
