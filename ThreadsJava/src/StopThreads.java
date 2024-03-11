public class StopThreads implements Runnable {
    private boolean canStop = false;
    @Override
    public void run()
    {
        try {
            Thread.sleep(30 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        canStop = true;
    }
    synchronized public boolean isCanBreak() {
        return canStop;
    }
}
