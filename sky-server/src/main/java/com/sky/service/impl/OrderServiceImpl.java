package com.sky.service.impl;

import com.sky.config.RemoteConfigurationProperties;
import com.sky.entity.Model;
import com.sky.entity.Order;
import com.sky.exception.BaseException;
import com.sky.mapper.ModelMapper;
import com.sky.mapper.OrderMapper;
import com.sky.service.ModelService;
import com.sky.service.OrderService;
import com.sky.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ModelService modelService;
    @Autowired
    RemoteConfigurationProperties remoteConfigurationProperties;

    /**
     * 根据模型id下单
     * @param id
     */
    @Override
    @Transactional
    public void orderAndProduce(Long id) {
        // 根据id查询模型
        Model model = modelService.getById(id);
        // 检查status，状态为0抛异常
        if (Model.STOP.equals(model.getStatus())) {
            throw new BaseException("模型停产！");
        }
        // 构造订单信息
        Order order = Order.builder()
                .orderTime(LocalDateTime.now())
                .orderNumber(UUID.randomUUID().toString())
                .status(Order.PRODUCING)
                .modelName(model.getName())
                .build();
        // 插入订单
        orderMapper.add(order);
        // 发送消息
        String url = remoteConfigurationProperties.getRunRemoteUrl();
        HashMap<String, String> paramMap = new HashMap<>();
        // 查询启动流
        paramMap.put("workflowInstanceId", model.getRemoteApiPost());
        if (!remoteConfigurationProperties.getMode().equals("debug")) {
            try {
                HttpClientUtil.doPost(url, paramMap);
            } catch (IOException e) {
                log.info("远程调用失败！" + " " + url + " " + paramMap.get("workflowInstanceId"));
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    @Transactional
    public void stopProducingAndRemoveOrder(String orderNum) {
        // 查询订单
        Order order = orderMapper.selectByOrderId(orderNum);
        String modelName = order.getModelName();
        Model model = modelMapper.selectByName(modelName);
        // 停止生产
        String url = remoteConfigurationProperties.getStopRemoteUrl();
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("workflowInstanceId", model.getRemoteApiPost());
            // 发送post
        if (!remoteConfigurationProperties.getMode().equals("debug")) {
            try {
                HttpClientUtil.doPost(url, paramMap);
            } catch (IOException e) {
                log.info("远程调用失败！" + " " + url + " " + paramMap.get("workflowInstanceId"));
                throw new RuntimeException(e);
            }
        }
        // 删除订单
        orderMapper.deleteOrder(orderNum);
    }

    @Override
    public List<Order> getAll() {
        return orderMapper.getAllOrders();
    }

    @Override
    public Order getLast() {
        return orderMapper.getLastOrder();
    }

}