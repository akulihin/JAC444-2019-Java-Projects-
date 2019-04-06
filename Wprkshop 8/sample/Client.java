package sample;

import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            System.out.print("What is your name: ");
            
            var sock = new Socket("localhost", 5500);
            var clientName = new Scanner(System.in).nextLine();
            var sendThread = new ClientThread(sock, clientName);
            var threadCustom = new Thread(sendThread);

            threadCustom.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
