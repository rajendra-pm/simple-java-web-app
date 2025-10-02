// public class Main {
//     public static void main(String[] args) {
//         System.out.println("Hello! This is a simple Java application for CI/CD .");
//     }
// }

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // default executor
        server.start();
        System.out.println("Server started at http://0.0.0.0:8080");
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String response = "<h1>Hello! This is a simple Java web app for CI/CD</h1>";
            t.getResponseHeaders().add("Content-Type", "text/html");
            t.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
