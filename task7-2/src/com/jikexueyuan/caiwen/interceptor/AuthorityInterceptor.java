package com.jikexueyuan.caiwen.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Created by caiwen on 2016/7/16.
 */
public class AuthorityInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("鉴权拦截");
        ActionContext context = ActionContext.getContext();
        String userRole = (String) context.getSession().get("loginRole");
        Object paramUserId = context.getParameters().get("userId");
        String sessUserId =  String.valueOf(context.getSession().get("userId"));

        if ("admin".equals(userRole) || sessUserId.equals(paramUserId)) {
            return actionInvocation.invoke();
        } else {
            if(userRole == null) {
                System.out.println("未登录操作！");
            }
            if (!sessUserId.equals(paramUserId)) {
                System.out.println("越权操作！");
            }
            return "authFailed";
        }


    }
    //TODO

}
