package io.file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\aaa\\bbb\\ccc");

 /*       //创建功能
        System.out.println("mkdir: " + file.mkdir());
        System.out.println("mkdirs: " + file.mkdirs());
        System.out.println("createNewFile: " + file.createNewFile());*/

        //判断功能
        System.out.println("exists: " + file.exists());
        System.out.println("canExecute: " + file.canExecute());
        System.out.println("canRead: " + file.canRead());
        System.out.println("canWrite: " + file.canWrite());
        System.out.println("---------");

        //获取功能
        System.out.println("getName: " + file.getName());
        System.out.println("getAbsolutePath: " + file.getAbsolutePath());
        System.out.println("getCanonicalPath: " + file.getCanonicalPath());
        System.out.println("getParent: " + file.getParent());
        System.out.println("getPath: " + file.getPath());
        System.out.println("getAbsoluteFile: " + file.getAbsoluteFile());
        System.out.println("getCanonicalFile: " + file.getCanonicalFile());
        System.out.println("---------");

        /*//删除功能
        System.out.println("delete: " + file.delete());
        System.out.println("---------");*/
    }
}
