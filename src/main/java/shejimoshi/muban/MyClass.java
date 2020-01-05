package shejimoshi.muban;

public class MyClass extends GetTime {
    @Override
    public void code() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
