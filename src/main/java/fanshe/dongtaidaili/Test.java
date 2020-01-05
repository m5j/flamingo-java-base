package fanshe.dongtaidaili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        InvocationHandler invocationHandler = new MyInvocationHandler(userDao);
        UserDao proxyUserDao = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), //得到ClassLoader对象
                userDao.getClass().getInterfaces(), //userDao.getClass()得到Class对象，Class对象的getInterfaces()方法得到该Class所有实现的接口
                invocationHandler); //自己的InvocationHandler接口的实现类的对象

        proxyUserDao.add(); //调用代理对象的add()方法时，会自动地去调用invocationHandler的invoke方法
        proxyUserDao.delete();
        proxyUserDao.edit();
        proxyUserDao.query();

    }
}
