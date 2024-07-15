package com.sky.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@Configuration
@ConfigurationProperties(prefix = "remote")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RemoteConfigurationProperties {
    String runRemoteUrl;

    String stopRemoteUrl;

    String resetRemoteWorkflowId;

    String stopResetRemoteWorkflowId;

    String remoteSocket;

    String mode;
}