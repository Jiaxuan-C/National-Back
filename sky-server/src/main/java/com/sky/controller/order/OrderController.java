package com.sky.controller.order;

import com.sky.entity.Order;
import com.sky.result.Result;
import com.sky.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */

@RestController
@RequestMapping("/admin/order")
@Slf4j
@Api(tags = "订单接口")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order/{id}")
    @ApiOperation("下单生产")
    public Result orderAndProduce(@PathVariable Long id) {
        orderService.orderAndProduce(id);
        return Result.success("下单成功，开始生产...");
    }

    @GetMapping("/order/stop/{orderNum}")
    @ApiOperation("停止订单及生产")
    public Result stopProducing(@PathVariable String orderNum) {
        orderService.stopProducingAndRemoveOrder(orderNum);
        return Result.success();
    }

    @GetMapping("/order/getAll")
    @ApiOperation("查询订单")
    public Result<List<Order>> getAll() {
        List<Order> list = orderService.getAll();
        return Result.success(list);
    }

}