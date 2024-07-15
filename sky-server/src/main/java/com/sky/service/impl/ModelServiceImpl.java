package com.sky.service.impl;

import com.sky.entity.Model;
import com.sky.mapper.ModelMapper;
import com.sky.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@Service
@Slf4j
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Model> getAll() {
        List<Model> models = modelMapper.selectAll();
        return models;
    }

    @Override
    public Model getById(Long id) {
        Model model = modelMapper.selectById(id);
        return  model;
    }

    @Override
    public Model getByLineDetails(String lineDetails) {
        Model model = modelMapper.selectByLineDetails(lineDetails);
        return  model;
    }
}