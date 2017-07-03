package com.whgb.controller.account;

import com.whgb.model.AcDAccount;
import com.whgb.service.impl.AcAccountService;
import com.whgb.utils.StateUtils;
import com.whgb.utils.TextUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangh09 on 2017/6/17.
 */
@RestController
@RequestMapping("/gb-inner/account-service/account")
public class AccountController{
    @Resource
    private AcAccountService accountService;
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public Map<String, Object> insert(AcDAccount object) {
        try {
            int status = accountService.insert(object);
            return TextUtils.buildControllerResult(status,null);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
    }
    @RequestMapping(value="/edit",method= RequestMethod.POST)
    public Map<String, Object> edit(@RequestBody AcDAccount object) {
        try {
            int status = accountService.edit(object);
            return TextUtils.buildControllerResult(status,null);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
    }
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int perPage,
                                    @RequestParam(required = false) Map<String, Object> params) {
        try {
            AcDAccount account = new AcDAccount();
            if(params.containsKey("name")) {
                account.setName((String)params.get("name"));
            }
            Map<String,Object> result = accountService.list(account, page, perPage);
            return TextUtils.buildControllerResult(1,result);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
    }

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public Map<String,Object> loginAccount(@RequestBody  Map<String,Object> param){
        Map<String,Object> res = new HashMap<String,Object>();
        try {
            if(!param.containsKey("account")|| !param.containsKey("passwd")) {
                res.put("status",210);
                res.put("message", "账户或密码为空");
                return res;
            }
            AcDAccount data = (AcDAccount) accountService.login(param.get("account").toString(),param.get("passwd").toString());
            if(data != null) {
                int state = data.getGlobalStateType();
                if(state == StateUtils.STATE_NORMAL || state == StateUtils.STATE_UNCERTIFIED){
                    Map<String,Object> result = new HashMap<String,Object>();
                    result.put("account",data);
                    res.put("status", 200);
                    res.put("message", "登陆成功!");
                    res.put("result", result);
                }
                else if(state == StateUtils.STATE_FREEZE)
                {
                    res.put("status", 221);
                    res.put("message", "账户已冻结！");
                    res.put("error",state);
                }
            }
            else {
                res.put("status", 210);
                res.put("message", "账户或密码错误!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status",210);
            res.put("message", TextUtils.underline2Camel(e.getCause().getMessage()));
        }
        return res;
    }

    @RequestMapping(value="/delete",method= RequestMethod.GET)
    public Map<String, Object> delete(@RequestParam(required = true) String id) {
        return null;
    }
    @RequestMapping(value="/get",method= RequestMethod.GET)
    public Map<String, Object> get(@RequestParam(required = true) String id) {
        return null;
    }


}
