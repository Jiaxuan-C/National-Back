package com.sky.controller.model;


import com.sky.entity.LineDetailsDTO;
import com.sky.entity.Model;
import com.sky.result.Result;
import com.sky.service.ModelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@RestController
@RequestMapping("/admin/model")
@Slf4j
@Api(tags = "模型接口")
public class ModelController {
    @Autowired
    ModelService modelService;

    /**
     * 查询所有模型
     * @return
     */
    @GetMapping("/getAll")
    @ApiOperation("查询所有模型信息")
    public Result<List<Model>> getAll() {
        log.info("查询所有模型信息");
        List<Model> result =  modelService.getAll();
        return Result.success(result);
    }

    /**
     * 通过Id查询模型信息
     * @return
     */
    @GetMapping("/getById")
    @ApiOperation("通过Id查询模型信息")
    public Result<Model> getById(Long id) {
        log.info("通过Id选择模型");
        Model result = modelService.getById(id);
        return Result.success(result);
    }


    @PostMapping("/getByLineDetails")
    @ApiOperation("根据生产流程查询模型")
    public Result<Model> getByLineDetails(@RequestBody LineDetailsDTO lineDetailsDTO) {
        log.info("根据生产流程查询模型");
        Model result = modelService.getByLineDetails(lineDetailsDTO.getLineDetails());
        return Result.success(result);
    }
}