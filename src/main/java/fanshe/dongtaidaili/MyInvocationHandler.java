package fanshe.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target; //将要代理的那个对象A

    //构造方法的形式把对象A注入
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("权限校验");
        Object result = method.invoke(target, args);
        System.out.println("日志记录");
        System.out.println("-------------");
        return result; //最终返回的是代理对象
    }
}
