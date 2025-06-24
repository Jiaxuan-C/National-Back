package com.sky.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    String resetRemoteworkflowInstanceId;

    String stopResetRemoteworkflowInstanceId;

    String remoteSocket;

    String mode;
}