package vip.ablog.api.user;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class UserInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation inv) {
        System.out.println("Before invoking " + inv.getActionKey());
        inv.invoke();
        System.out.println("After invoking " + inv.getActionKey());
    }
}
