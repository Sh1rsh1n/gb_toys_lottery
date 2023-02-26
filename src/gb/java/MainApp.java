
import handlers.HttpServerThread;

import java.io.IOException;

/**
 * Основной класс, для запуска сервера
 * создаем новый объект класса Thread и в его параметрах создадим new HttpServerThread
 * вызываем метод thread1.start() для запуска HTTP сервера
 */
public class MainApp {
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        System.out.printf("\"Toys Lottery\" HTTP-server started.\nGo to address http://%s:%d/", HOSTNAME, PORT);

        Thread thread = new Thread(new HttpServerThread(HOSTNAME, PORT));

        thread.start();

    }
}