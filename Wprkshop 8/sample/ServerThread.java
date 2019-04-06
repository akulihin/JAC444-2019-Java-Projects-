package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.*;
import java.util.ArrayList;

class ServerThread implements Runnable {
    private ArrayList<Socket> Clients;

    public ServerThread(ArrayList<Socket> clients) {
        Clients = clients;
    }

    public void run() {
        try {
            while (true) {

                for (var client : Clients) {
                    var reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    var writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

                    if (reader == null || writer == null) {
                        continue;
                    }

                    if (reader.ready()) {
                        BufferedReader(reader, writer);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void BufferedReader(BufferedReader reader, PrintWriter writer) {
        try {
            var msg = reader.readLine();

            if (msg != null && !msg.contains("null")) {
                System.out.println(msg);
                writer.println(msg);
            }
            
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}