package com.whgb.service.impl;

import com.whgb.mapper.AcDAccountMapper;
import com.whgb.model.AcDAccount;
import com.whgb.model.AcDAccountExample;
import com.whgb.service.BaseCRUDService;
import com.whgb.service.SystemService;
import com.whgb.utils.TextUtils;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.xml.soap.Text;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangh09 on 2017/6/17.
 */
@Service
public class AcAccountService implements BaseCRUDService {
    @Resource
    AcDAccountMapper mapper;
    @Override
    public int edit(Object object) {
        AcDAccount account = (AcDAccount) object;
        return mapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public int insert(Object object) {
        AcDAccount account = (AcDAccount) object;
        account.setId(TextUtils.getIdByUUID());
        if(account.getPasswd() != null) {
            account.setPasswd(TextUtils.md5(TextUtils.base64Decode(account.getPasswd())));
        }
        account.setCreateTime(TextUtils.getNowTime());
        account.setGlobalStateType(1);
        return mapper.insert(account);
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public Map<String, Object> list(Object object, int page, int perPage) {
        AcDAccount account = (AcDAccount) object;
        AcDAccountExample example = new AcDAccountExample();
        example.setLimit(perPage);
        example.setOffset((page-1)*perPage);
        example.setOrderByClause("create_time");
        AcDAccountExample.Criteria criteria = example.createCriteria();

        Map<String,Object> result = new HashMap<String,Object>();
        List<AcDAccount> items = mapper.selectByExample(example);
        result.put("data",items);
        result.put("total",mapper.countByExample(example));
        return result;
    }

    @Override
    public Object get(String id) {
        return mapper.selectByPrimaryKey(id);
    }


    public Object login(String certificateName, String passwd) {
        AcDAccountExample example = new AcDAccountExample();
        AcDAccountExample.Criteria criteria = example.createCriteria();
        criteria.andAccountPhoneEmailOrEqualTo(certificateName);
        criteria.andPasswdEqualTo(TextUtils.md5(TextUtils.base64Decode(passwd)));
        List<AcDAccount> accounts = mapper.selectByExample(example);
        if(accounts.size() > 0) {
            AcDAccount resAccount = accounts.get(0);

            AcDAccount updateLoginAccount = new AcDAccount();
            updateLoginAccount.setId(resAccount.getId());
            updateLoginAccount.setLastLoginTime(TextUtils.getNowTime());
            mapper.updateByPrimaryKeySelective(updateLoginAccount);

            //***********************************************补充字典信息

            return resAccount;
        }
        return null;
 //       return mapper.selectByPrimaryKey(id);
    }
}
