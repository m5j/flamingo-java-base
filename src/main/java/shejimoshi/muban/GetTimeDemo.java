package shejimoshi.muban;

public class GetTimeDemo {
    public static void main(String[] args) {
        //思考一下，需要测试耗时的代码可能多种多样，不能直接像这样写死了。应该怎么办
        //要不定义一个抽象的code()方法，让子类去实现，把需要测试耗时的代码放在code方法里面
        //这就是模板模式，把差异化的代码延迟实现，让子类去实现，父类（抽象类）把其他的事情先做好，

        GetTime getTime = new MyClass();
        long time = getTime.getTime();
        System.out.println(time);
    }
}
