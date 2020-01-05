package fanshe.dongtaidaili;

import java.io.Serializable;

public class UserDaoImpl implements UserDao, Serializable {
    @Override
    public void add() {
        System.out.println("UserDao.add()方法");
    }

    @Override
    public void delete() {
        System.out.println("UserDao.delete()方法");
    }

    @Override
    public void edit() {
        System.out.println("UserDao.edit()方法");
    }

    @Override
    public void query() {
        System.out.println("UserDao.query()方法");
    }
}
