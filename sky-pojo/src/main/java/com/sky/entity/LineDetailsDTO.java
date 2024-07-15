package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineDetailsDTO {
    private String lineDetails;
}