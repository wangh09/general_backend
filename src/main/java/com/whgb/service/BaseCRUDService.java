package com.whgb.service;

import java.util.Map;

/**
 * Created by wangh09 on 2017/4/12.
 */
public interface BaseCRUDService {
    int insert(Object object);
    Map<String,Object> list(Object object, int page, int perPage);
    int edit(Object object);
    int delete(String id);
    Object get(String id);

}
