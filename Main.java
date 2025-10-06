// public class Main {
//     public static void main(String[] args) {
//         System.out.println("Hello! This is a simple Java application for CI/CD .");
//     }
// }


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            String response = "Hello Rajendra! Your Java App is running on EC2 🚀";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
        System.out.println("Server started on port 8080...");
        server.start();
    }
}
