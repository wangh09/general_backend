package com.whgb.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by wangh09 on 2017/6/17.
 */
public interface BaseCRUDController {
    Map<String,Object> insert(@RequestBody Object object);
    Map<String,Object> edit(@RequestBody Object object);
    Map<String,Object> list(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int perPage,
                                   @RequestParam(required = false) Map<String,Object> params);
    Map<String,Object> delete(@RequestParam(required = true) String id);
    Map<String,Object> get(@RequestParam(required = true) String id);
}
