package duoXianCheng._3_wait_notify;

/**
 * 起始地点是上海，到达地点是北京
 */
public class Express {
    public final static String CITY = "上海";
    private int km;/*快递运输里程数*/
    private String site;/*快递到达地点*/

    public Express() {
    }
    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    /* 变化公里数，然后通知处于wait状态并需要处理公里数的线程进行业务处理*/
    public synchronized void changeKm() {
        this.km = 101;
        notifyAll();
    }

    /* 变化地点，然后通知处于wait状态并需要处理地点的线程进行业务处理*/
    public synchronized void changeSite() {
        this.site = "北京";
        notifyAll();
    }

    public synchronized void waitKm() {
        while (this.km <= 100) {
            try {
                wait();
                System.out.println("CheckKm 线程[" + Thread.currentThread().getId()
                        + "] 已被通知唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is " + this.km + ",I will change db.");

    }

    public synchronized void waitSite() {
        while (CITY.equals(this.site)) {
            try {
                wait();
                System.out.println("CheckSite 线程[" + Thread.currentThread().getId()
                        + "] 已被通知唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is " + this.site + ",I will call user.");
    }
}
