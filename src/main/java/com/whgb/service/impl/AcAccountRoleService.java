package com.whgb.service.impl;

import com.whgb.mapper.AcRAccountRoleMapper;
import com.whgb.model.AcRAccountRole;
import com.whgb.model.AcRAccountRoleExample;
import com.whgb.service.BaseCRUDService;
import com.whgb.utils.StateUtils;
import com.whgb.utils.TextUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangh09 on 2017/6/23.
 */
@Service
public class AcAccountRoleService implements BaseCRUDService {
    @Resource
    AcRAccountRoleMapper mapper;
    @Override
    public int insert(Object object) {
        AcRAccountRole role = (AcRAccountRole)object;
        role.setId(TextUtils.getIdByUUID());
        role.setGlobalStateType(StateUtils.STATE_NORMAL);
        role.setCreateTime(TextUtils.getNowTime());
        return mapper.insert(role);
    }

    @Override
    public Map<String, Object> list(Object object, int page, int perPage) {
        AcRAccountRole role = (AcRAccountRole)object;
        AcRAccountRoleExample example = new AcRAccountRoleExample();
        example.setLimit(perPage);
        example.setOffset((page-1)*perPage);
        AcRAccountRoleExample.Criteria criteria = example.createCriteria();
        if(role.getAccountId() != null)
            criteria.andAccountIdEqualTo(role.getAccountId());
        if(role.getDicRoleType() != null)
            criteria.andDicRoleTypeEqualTo(role.getDicRoleType());

        Map<String,Object> result = new HashMap<String,Object>();
        List<AcRAccountRole> items = mapper.selectByExample(example);
        result.put("data",items);
        result.put("total",mapper.countByExample(example));
        return result;
    }
    @Override
    public int edit(Object object) {
        AcRAccountRole role = (AcRAccountRole)object;
        return mapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public Object get(String id) {
        return null;
    }
}
