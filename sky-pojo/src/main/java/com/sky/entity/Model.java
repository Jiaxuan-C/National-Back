package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 模型实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {
    /**
     *  模型状态 0停产，1可生产
     */
    public static final Integer PRODUCING = 1;
    public static final Integer STOP = 0;

    private Long id;

    // 模型名称
    private String name;

    // 模型状态
    private Integer status;

    // 远端API请求体
    private String remoteApiPost;

    // 产线流程
    private String lineDetails;
}