package shejimoshi.muban;

/**
 * 计算一段代码执行的耗时
 * 模板模式：定义好一个逻辑骨架，具体的差异化内容让子类自己去实现。
 * 优点是可以应对灵活多变的需求。
 * 缺点是逻辑骨架有变化的话，需要修改父类，导致全部都会变化
 */
public abstract class GetTime {
    public long getTime() {
        long start = System.currentTimeMillis();

        this.code();

        long end = System.currentTimeMillis();
        return end - start;
    }

    public abstract void code();
}
