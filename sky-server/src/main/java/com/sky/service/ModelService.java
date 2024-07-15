package com.sky.service;

import com.sky.entity.Model;

import java.util.List;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
public interface ModelService {
    /**
     * 查询所有模型
     * @return
     */
    List<Model> getAll();

    /**
     * 根据Id获取单个模型信息
     * @param id
     * @return
     */
    Model getById(Long id);

    /**
     * 根据生产流程查询模型
     * @param lineDetails
     * @return
     */
    Model getByLineDetails(String lineDetails);
}
