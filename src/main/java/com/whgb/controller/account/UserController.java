package com.whgb.controller.account;

import com.whgb.model.AcDAccount;
import com.whgb.model.AcEUser;
import com.whgb.service.impl.AcUserService;
import com.whgb.utils.TextUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangh09 on 2017/6/23.
 */
@RestController
@RequestMapping("/gb-inner/account-service/user")
public class UserController{

    @Resource
    private AcUserService userService;
    @RequestMapping(value="/register",method= RequestMethod.POST)
    public Map<String, Object> register(@RequestBody AcEUser object) {
        try {

            int status = userService.insert(object);
            Map<String,Object> result = new HashMap<String,Object>();
            result.put("user",object);
            return TextUtils.buildControllerResult(status, result);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
    }
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody AcEUser object) {
        try {
            int status = userService.insert(object);
            Map<String,Object> result = new HashMap<String,Object>();
            result.put("account",object);
            return TextUtils.buildControllerResult(status, result);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
    }

    @RequestMapping(value="/edit",method= RequestMethod.POST)
    public Map<String, Object> edit(@RequestBody AcEUser object) {
        try {
            int status = userService.edit(object);
            return TextUtils.buildControllerResult(status, null);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int perPage,
                                    @RequestParam(required = false) Map<String, Object> params) {
        AcEUser user = new AcEUser();
        if(params.containsKey("account")) {
            user.account = new AcDAccount();
            Map<String,Object> accountParams = (Map<String,Object>)params.get("account");
        }
        if(params.containsKey("wechatId")) {
            user.setWechatId((String)params.get("wechatId"));
        }
        Map<String,Object> result = userService.list(user,page,perPage);
        return TextUtils.buildControllerResult(1, result);
    }

    public Map<String, Object> delete(@RequestParam(required = true) String id) {
        try {
            int status = userService.delete(id);
            return TextUtils.buildControllerResult(status, null);
        } catch (Exception e){
            return TextUtils.catchControllerError(e);
        }
    }

    public Map<String, Object> get(@RequestParam(required = true) String id) {
        try {
            Object res = userService.get(id);
            return TextUtils.buildControllerResult(1, res);
        } catch (Exception e){
            return TextUtils.catchControllerError(e);
        }
    }
}
