package com.whgb.service;

import com.whgb.utils.ServerUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wangh09 on 2017/4/30.
 */
@Service
public class SystemService {
    @Resource
    RestTemplate restTemplate;
    public void addApi(Map<String,Object> apiServiceMap) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String,Object>> entity = new HttpEntity<Map<String,Object>>(apiServiceMap,headers);
        HttpEntity<Map> response = restTemplate.exchange(ServerUtils.API_ADD_URL, HttpMethod.POST, entity, Map.class);
    }
}
