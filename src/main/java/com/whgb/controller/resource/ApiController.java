package com.whgb.controller.resource;

import com.whgb.model.RcDApi;
import com.whgb.service.impl.RcApiService;
import com.whgb.utils.TextUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangh09 on 2017/6/20.
 */
@RestController
@RequestMapping("/resource-service/api")
public class ApiController{
    @Resource
    RcApiService service;

    @RequestMapping(value="/add-batch",method= RequestMethod.POST)
    public Map<String,Object> add_batch(@RequestBody Map<String,String> apis){
        Map<String,Object> res = new HashMap<String,Object>();
        try {
            int status = 1;
            int count = 1;
            RcDApi api = new RcDApi();
            for (String key: apis.keySet()) {
                api.setApi(key);
                Map<String,Object> apiInsert = service.list(api,1,1);
                if((Long)apiInsert.get("total")  == 0) {
                    api.setServiceName(apis.get(key));
                    api.setIsPublic(false);
                    status += service.insert(api);
                }
                count ++;
            }
            if(status == count){
                res.put("status",200);
                res.put("message","添加成功!");
            }else {
                res.put("status",200);
                res.put("msg","添加完成!存在重复");
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status",210);
            res.put("message", TextUtils.underline2Camel(e.getCause().getMessage()));
        }
        return res;
    }

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public Map<String, Object> insert(@RequestBody RcDApi object) {
        try {
            int status = service.insert(object);
            return TextUtils.buildControllerResult(status,null);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
    }

    @RequestMapping(value="/edit",method= RequestMethod.POST)
    public Map<String, Object> edit(@RequestBody RcDApi object) {
        try {
            int status = service.edit(object);
            return TextUtils.buildControllerResult(status,null);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public Map<String, Object> list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int perPage, @RequestParam(required = false) Map<String, Object> params) {
        try {
            RcDApi api = new RcDApi();
            if(params.containsKey("api")) {
                api.setApi((String)params.get("api"));
            }
            Map<String,Object> result = service.list(api, page, perPage);
            return TextUtils.buildControllerResult(1,result);
        }
        catch (Exception e) {
            return TextUtils.catchControllerError(e);
        }
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
