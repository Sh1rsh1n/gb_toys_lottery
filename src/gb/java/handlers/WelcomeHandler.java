package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class WelcomeHandler implements HttpHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        OutputStream outputStream = exchange.getResponseBody();

        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>")
                .append("<body>")
                .append("<h1>")
                .append("Welcome to Funny Toys Lottery")
                .append("</h1>")
                .append("</body>")
                .append("</html>");
        String htmlStr = htmlBuilder.toString();
        exchange.sendResponseHeaders(200, htmlStr.length());

        outputStream.write(htmlStr.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}