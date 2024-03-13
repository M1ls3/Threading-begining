import java.sql.SQLData;

public class Main {
    public static void main(String[] args) {

        int threadsCount = 4;
        ThreadsHandler[] threads = new ThreadsHandler[threadsCount];
        StopThreads upsilon = new StopThreads();

        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new ThreadsHandler(i, upsilon);
            new Thread(threads[i]).start();
        }

        new Thread(upsilon).start();
    }
}