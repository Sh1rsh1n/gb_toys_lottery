package handlers;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 *  класс HttpServerThreads реализует интерфейс Runnable
 *  в конструктор передаем порт, имя хоста и HTTP сервер
 */
public class HttpServerThread implements Runnable
{
    private String hostname;
    private int port;
    private HttpServer httpServer;


    public HttpServerThread(String hostname, int port) throws IOException
    {
        this.hostname = hostname;
        this.port = port;
        httpServer = HttpServer.create(new InetSocketAddress(this.hostname, this.port), 0);
    }

    /**
     *  переопределяем метод run() в нем создаем httpServer.createContext
     *  в котором указываем какой класс, на какой запрос будет откликаться
     *  httpServer.setExecutor отвечает за потоки
     */
    @Override
    public void run()
    {
        httpServer.createContext("/", new WelcomeHandler());
//        httpServer.createContext("/persons", new PersonsHandler(new PersonDao()));
        httpServer.setExecutor(Executors.newFixedThreadPool(4));
        httpServer.start();
    }
}
