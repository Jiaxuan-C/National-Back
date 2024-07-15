package com.sky.controller.line;

import com.sky.entity.Model;
import com.sky.result.Result;
import com.sky.service.LinerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@RestController
@RequestMapping("/admin/line")
@Slf4j
@Api(tags = "产线管理接口")
public class LinerController {
    @Autowired
    LinerService linerService;

    @GetMapping("/reset")
    @ApiOperation("复位产线")
    public Result resetLine() {
        log.info("复位产线");
        linerService.reset();
        return Result.success();
    }

    @GetMapping("/stopReset")
    @ApiOperation("停止复位产线")
    public Result stopResetLine() {
        log.info("停止复位产线");
        linerService.stopReset();
        return Result.success();
    }
}