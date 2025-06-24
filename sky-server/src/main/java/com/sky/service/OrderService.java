package com.sky.service;

import com.sky.entity.Order;

import java.util.List;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
public interface OrderService {
    /**
     * 根据id下单
     * @param id
     */
    void orderAndProduce(Long id);

    /**
     * 停止生产当前产品、删除订单
     * @param orderId
     */
    void stopProducingAndRemoveOrder(String orderNum);

    /**
     * 查询全部订单
     *
     * @return
     */
    List<Order> getAll();

    /**
     * 查询最新一条订单信息
     * @return
     */
    Order getLast();
}
