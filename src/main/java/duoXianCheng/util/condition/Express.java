package duoXianCheng.util.condition;

/**
 * 快递实体类
 * Created by MIN.WU.JUN on 2020/1/17
 */
public class Express {
    private final static String CITY = "SHANGHAI";
    //快递运输里程数
    private int km;
    //快递到达点
    private String site;

    public Express() {

    }

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm() {
        this.km = 101;
        notify();
    }

    public synchronized void changeSite() {
        this.site = "BEIJING";
        notify();
    }

    public synchronized void waitKm() {
        while (this.km <= 100) {
            try {
                wait();
                System.out.println("check km thread[" + Thread.currentThread().getId() + "] is be notifed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("km已经变成了" + this.km);
    }

    public synchronized void waitSite() {
        while (CITY.equals(this.site)) {
            try {
                wait();
                System.out.println("check site thread[" + Thread.currentThread().getId() + "] is be notifed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("地点已经变成了" + this.site);
    }


}
