package fanshe.beijing;

/**
 * @author minwujun
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        //基本的用户操作
        UserDao userDao = new UserDaoImpl();
        userDao.add();
        userDao.delete();
        userDao.edit();
        userDao.query();
        System.out.println("=======================");

        //增加了权限校验和日志功能的用户操作
        UserDao userDao2=new UserDaoImpl2();
        userDao2.add();
        userDao2.delete();
        userDao2.edit();
        userDao2.query();
        System.out.println("=======================");

        //如果除了用户类，其他的类也需要权限校验和日志记录呢？每个实现类都去加上权限和日志的代码，明显不科学
        //所以引入了动态代理
        //代理：自己的事情，让别人来帮我做，这个“别人”就称为代理
        //动态代理：在程序运行过程中产生这个代理对象。程序运行中去产生对象，其实就是利用的【反射】
    }
}
