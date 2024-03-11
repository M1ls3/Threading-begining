public class Main {
    public static void main(String[] args) {
        StopThreads upsilon = new StopThreads();
        new ThreadsHandler(1, upsilon).start();
        new ThreadsHandler(2, upsilon).start();
        new ThreadsHandler(3, upsilon).start();
        new ThreadsHandler(4, upsilon).start();
        new Thread(upsilon).start();
    }
}