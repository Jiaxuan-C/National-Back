package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 订单
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    /**
     *  模型状态 0 生产中 1 已交付
     */
    public static final Integer PRODUCING = 0;
    public static final Integer COMPLETE = 1;

    private Long id;

    //订单号
    private String orderNumber;

    //订单状态
    private Integer status;

    // 模型名称
    private String modelName;

    // 下单时间
    private LocalDateTime orderTime;

    // 完成时间
    private LocalDateTime completeTime;

}
