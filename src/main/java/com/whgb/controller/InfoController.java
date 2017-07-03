package com.whgb.controller;

import com.whgb.service.SystemService;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangh09 on 2017/6/20.
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    @Resource
    SystemService systemService;
    @RequestMapping(value="/get",method= RequestMethod.GET)
    public Map<String,Object> get(HttpServletRequest request) {

        ServletContext servletContext = request.getSession().getServletContext();
        if (servletContext == null) {
            return null;
        }
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext,
                HandlerMapping.class, true, false);
        Map<String, Object> mappings = new HashMap<String, Object>();
        for (HandlerMapping handlerMapping : allRequestMappings.values()) {
            if (handlerMapping instanceof RequestMappingHandlerMapping) {
                RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) handlerMapping;
                Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
                for (Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoHandlerMethodEntry : handlerMethods.entrySet()) {
                    RequestMappingInfo requestMappingInfo = requestMappingInfoHandlerMethodEntry.getKey();
                    PatternsRequestCondition patternsCondition = requestMappingInfo.getPatternsCondition();
                    Set<String> set = patternsCondition.getPatterns();
                    for (String item : set) {
                        String subItem = item.replace("/gb-inner","");
                        if (subItem.equals("/error") || subItem.equals("/info/get")) continue;
                        String[] separateUris = subItem.split("/");
                        if(separateUris.length < 4)continue;
                        mappings.put(subItem, separateUris[1]);
                    }
                }
            }
        }
        systemService.addApi(mappings);
        return mappings;
    }
}
