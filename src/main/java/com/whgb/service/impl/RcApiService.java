package com.whgb.service.impl;

import com.whgb.mapper.RcDApiMapper;
import com.whgb.model.RcDApi;
import com.whgb.model.RcDApiExample;
import com.whgb.service.BaseCRUDService;
import com.whgb.utils.TextUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangh09 on 2017/6/20.
 */
@Service
public class RcApiService implements BaseCRUDService {
    @Resource
    RcDApiMapper mapper;
    @Override
    public int edit(Object object) {
        RcDApi api = (RcDApi) object;
        return mapper.updateByPrimaryKeySelective(api);
    }

    @Override
    public int insert(Object object) {
        RcDApi api = (RcDApi) object;
        api.setCreateTime(TextUtils.getNowTime());
        return mapper.insert(api);
    }

    @Override
    public int delete(String id) {
        return mapper.deleteByPrimaryKey(Integer.parseInt(id));
    }

    @Override
    public Map<String, Object> list(Object object, int page, int perPage) {
        RcDApi api = (RcDApi) object;
        RcDApiExample example = new RcDApiExample();
        if(page >0 && perPage > 0) {
            example.setLimit(perPage);
            example.setOffset((page - 1) * perPage);
        }

        RcDApiExample.Criteria criteria = example.createCriteria();
        if(api.getServiceName() != null)
            criteria.andServiceNameEqualTo(api.getServiceName());
        if(api.getApi() != null)
            criteria.andApiEqualTo(api.getApi());
        example.setOrderByClause("api");


        Map<String,Object> result = new HashMap<String,Object>();
        List<RcDApi> items = mapper.selectByExample(example);
        result.put("data",items);
        result.put("total",mapper.countByExample(example));
        return result;
    }

    @Override
    public Object get(String id) {
        return mapper.selectByPrimaryKey(Integer.parseInt(id));
    }
}
