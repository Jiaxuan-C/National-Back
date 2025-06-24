package com.sky.mapper;

import com.sky.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@Mapper
public interface OrderMapper {

    void add(Order order);
    @Select("select * from orders where order_number = #{orderNum}")
    Order selectByOrderId(String orderNum);
    @Delete("delete from orders where order_number = #{orderNum}")
    void deleteOrder(String orderNum);
    @Select("select * from orders")
    List<Order> getAllOrders();

    @Select("select * from orders order by order_time desc limit 1")
    Order getLastOrder();
}
