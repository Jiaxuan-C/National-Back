package com.sky.service.impl;

import com.sky.config.RemoteConfigurationProperties;
import com.sky.service.LinerService;
import com.sky.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * @ Author: Jiaxuan Chen
 * @ Version: v1.0
 */
@Service
@Slf4j
public class LinerServiceImpl implements LinerService {
    @Autowired
    RemoteConfigurationProperties remoteConfigurationProperties;
    @Override
    public void reset() {
        String workflowId = remoteConfigurationProperties.getResetRemoteWorkflowId();
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("workflowId", workflowId);
        String url = remoteConfigurationProperties.getRunRemoteUrl();
        if (!remoteConfigurationProperties.getMode().equals("debug")) {
            try {
                HttpClientUtil.doPost(url, paramMap);
            } catch (IOException e) {
                log.info("远程调用失败！" + " " + url + " " + paramMap.get("workflowId"));
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void stopReset() {
        String workflowId = remoteConfigurationProperties.getStopResetRemoteWorkflowId();
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("workflowId", workflowId);
        String url = remoteConfigurationProperties.getStopRemoteUrl();
        if (!remoteConfigurationProperties.getMode().equals("debug")) {
            try {
                HttpClientUtil.doPost(url, paramMap);
            } catch (IOException e) {
                log.info("远程调用失败！" + " " + url + " " + paramMap.get("workflowId"));
                throw new RuntimeException(e);
            }
        }
    }
}