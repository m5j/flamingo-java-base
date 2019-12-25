package duoXianCheng.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 带版本戳的引用类型原子类
 */
public class AtomicStampedReferenceDemo {
    static AtomicStampedReference<String> atomicStampedReference
            = new AtomicStampedReference<>("Mark", 0);


    public static void main(String[] args) throws InterruptedException {

        final int oldStamp = atomicStampedReference.getStamp(); //拿初始版本号
        final String oldReference = atomicStampedReference.getReference(); //拿初始值
        System.out.println(oldStamp + "===" + oldReference);

        Thread thread1 = new Thread(() -> {
            boolean result = atomicStampedReference.compareAndSet(oldReference, oldReference + "New", oldStamp, oldStamp + 1);
            System.out.println(Thread.currentThread().getName() + " "
                    + atomicStampedReference.getStamp() + "==="
                    + atomicStampedReference.getReference() + " " + result);
        });

        Thread thread2 = new Thread(() -> {
            boolean result = atomicStampedReference.compareAndSet(oldReference, oldReference + "New22", oldStamp, oldStamp + 1);
            System.out.println(Thread.currentThread().getName() + " "
                    + atomicStampedReference.getStamp() + "==="
                    + atomicStampedReference.getReference() + " " + result);
        });

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

        System.out.println(atomicStampedReference.getStamp() + "===" + atomicStampedReference.getReference());

    }
}
