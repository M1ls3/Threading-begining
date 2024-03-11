public class ThreadsHandler extends Thread
{
    private final int index;
    private final StopThreads stopThreads;
    public ThreadsHandler(int index, StopThreads stopThreads)
    {
        this.index = index;
        this.stopThreads = stopThreads;
    }

    @Override
    public void run()
    {
        long eta = 0;
        boolean isStop = false;
        while (!isStop)
        {
            eta = eta + 2;
            isStop = stopThreads.isCanBreak();
        }

        System.out.println("Thread " + index + ": " + eta);
    }

}
