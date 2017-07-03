package com.whgb.service.impl;

import com.whgb.mapper.AcDAccountMapper;
import com.whgb.mapper.AcEUserMapper;
import com.whgb.mapper.AcRAccountRoleMapper;
import com.whgb.model.*;
import com.whgb.service.BaseCRUDService;
import com.whgb.utils.StateUtils;
import com.whgb.utils.TextUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-06-21.
 */
@Service
public class AcUserService implements BaseCRUDService {
    @Resource
    AcEUserMapper userMapper;
    @Resource
    AcAccountService accountService;
    @Resource
    AcAccountRoleService accountRoleService;
    @Override
    public int edit(Object object) {
        AcEUser user = (AcEUser) object;
        if (user.getAccount() != null) {
            int status = accountService.edit(user.getAccount());
            if(status != 1) {
                return status;
            }
        }
        return userMapper.updateByPrimaryKeySelective(user);

    }

    @Override
    public int insert(Object object) {

        AcEUser user = (AcEUser) object;
        user.setId(TextUtils.getIdByUUID());
        Date createTime = new Date();
        Boolean needAddAccount = true;
        if (user.getAccountId() != null) {
            AcDAccountExample example = new AcDAccountExample();
            AcDAccountExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(user.getAccountId());

            AcDAccount checkAccount = (AcDAccount) accountService.get(user.getAccountId());
            if (checkAccount != null) {
                user.setAccountId(checkAccount.getId());
                user.account.setId(user.getAccountId());
                needAddAccount = false;
            }
        }
        if (needAddAccount) {
            user.account.setDicDefaultRoleType(StateUtils.ROLE_USER);
            int result = accountService.insert(user.account);
            if (result == 1) {
                user.setAccountId(user.account.getId());
                AcRAccountRole accountRole = new AcRAccountRole();
                accountRole.setAccountId(user.getAccountId());
                accountRole.setDicRoleType(StateUtils.ROLE_USER);
                accountRoleService.insert(accountRole);
            } else
                return result;
        }
        user.setCreateTime(createTime);
        user.setPoint(0);
        int result = userMapper.insert(user);
        return result;
    }

    @Override
    public int delete(String id) {
        return accountService.delete(id);
    }

    @Override
    public Map<String, Object> list(Object object, int page, int perPage) {
        AcEUser user = (AcEUser)object;
        AcEUserExample example = new AcEUserExample();
        AcEUserExample.Criteria criteria = example.createCriteria();
        if(user.getWechatId() != null)
            criteria.andWechatIdEqualTo(user.getWechatId());

        Map<String,Object> result = new HashMap<String,Object>();
        List<AcEUser> items = userMapper.selectByExample(example);
        result.put("data",items);
        result.put("total",userMapper.countByExample(example));
        return result;
    }

    @Override
    public Object get(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
