
public class TestVolatileThread extends Thread {
	//Declara la variable volatile para propagar su visibilidad y evitar
	//las optimizaciones de la JVM acorde a este programa multithread
	volatile boolean keepRunning = true;

    public void run() {
        long count=0;
        while (keepRunning) {
            count++;
        }

        System.out.println("Thread terminated."+count);
    }
}
