package hadleys.hope.minisims.test.utils;

import hadleys.hope.minisims.MiniPoolApp;

public class ApplicationTask implements Runnable {

    @Override
    public void run() {
        MiniPoolApp.main(new String[0]);
    }
    
    public void shutdownApp() {
        MiniPoolApp.endGame();
    }
}
