package hello.proxy.app.v2;

public class OrderRepositoryV2 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생");
        }

        sleep(1000);
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
