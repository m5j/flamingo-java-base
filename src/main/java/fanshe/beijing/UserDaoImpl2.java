package fanshe.beijing;

public class UserDaoImpl2 implements UserDao {
    @Override
    public void add() {
        System.out.println("权限校验..");
        System.out.println("UserDao.add()方法");
        System.out.println("日志记录...");
        System.out.println("-------------------------");
    }

    @Override
    public void delete() {
        System.out.println("权限校验..");
        System.out.println("UserDao.delete()方法");
        System.out.println("日志记录...");
        System.out.println("-------------------------");
    }

    @Override
    public void edit() {
        System.out.println("权限校验..");
        System.out.println("UserDao.edit()方法");
        System.out.println("日志记录...");
        System.out.println("-------------------------");
    }

    @Override
    public void query() {
        System.out.println("权限校验..");
        System.out.println("UserDao.query()方法");
        System.out.println("日志记录...");
        System.out.println("-------------------------");
    }
}
