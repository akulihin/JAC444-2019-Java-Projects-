package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread implements Runnable {
    private Socket Socket;
    private String Name;

    public ClientThread(Socket Socket, String name) {
        this.Socket = Socket;
        this.Name = name;
    }

    public void run() {
        try {
            if (Socket.isConnected()) {
                System.out.println("Client connected to " + Socket.getInetAddress() + " on port " + Socket.getPort());

                var console = new PrintWriter(Socket.getOutputStream(), true);
                
                while (true) {
                    System.out.print(Name + ": ");
                    var buffer = new BufferedReader(new InputStreamReader(System.in));

                    var msgtoServerString = buffer.readLine();
                    console.println(Name + ": " + msgtoServerString);
                    console.flush();

                    if (msgtoServerString.toLowerCase().contains("!exit"))
                        break;
                }
                Socket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}