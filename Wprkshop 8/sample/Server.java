package sample;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

public class Server {

    public static void main(String[] args) {
        try {
            var socket = new ServerSocket(5500);
            var clients = new ArrayList<Socket>();

            System.out.println("MultiThreadServer started at " + Calendar.getInstance().getTime());

            while (true) {
                var client = socket.accept();
                clients.add(client);

                System.out.println("Connection Received: [addr=" + client.getLocalSocketAddress() + ", port="
                        + client.getPort() + "] at " + Calendar.getInstance().getTime());

                var sw = new ServerThread(clients);
                var t = new Thread(sw);
                t.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}