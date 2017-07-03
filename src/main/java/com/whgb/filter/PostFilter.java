package com.whgb.filter;

import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.whgb.utils.JWTUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by wangh09 on 2017/6/16.
 */
public class PostFilter extends ZuulFilter {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String filterType() {

        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object run() {

        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            String uri = request.getRequestURI();
            if (uri.equals("/account-service/account/login")) {
                if (ctx.getResponseStatusCode() == 200) {
                    try (final InputStream responseDataStream = ctx.getResponseDataStream()) {
                        JSONObject jb = JSONObject.fromObject(CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8")));
                        Map<String, Object> response = jb;
                        if ((Integer) response.get("status") == 200) {
                            Map<String, Object> result = (Map<String, Object>) response.get("result");
                            Map<String, Object> account = (Map<String, Object>) result.get("account");
                            String role = (String) account.get("dicDefaultRoleType").toString();
                            String id = (String) account.get("id");
                            if (role == null) role = "2";
                            if (id == null) id = "wrong";
                            String jwt = JWTUtils.createJWT(id, role, -1);
                            //  ctx.addZuulResponseHeader("Access-Token",jwt);
                            result.put("accessToken", jwt);
                        }
                        ctx.setResponseBody(jb.toString());
                    } catch (IOException e) {
                        JSONObject jb = JSONObject.fromObject("{\"status\":210}");
                        ctx.setResponseBody(jb.toString());
                        System.out.println(e);
                    }
                    return null;
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
