package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Общение в рамках договоренности о формате сообщений (протокол)
 *  Каждое сообщение - строка\n
 */
public class ServerLineMessenger {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            // Ожидаем подключения клиента
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress());
            System.out.println(clientSocket.getPort());
            // Дождались клиента
            // Поток для чтения данных от клиента
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()));
            while (true) {


                // Читаем пакет от клиента
                String message = reader.readLine();
                System.out.println(message);

                if(message.equals("exit")) {
                    break;
                }


                Scanner scanner = new Scanner(System.in);

                message = scanner.nextLine();
                // измеряем кол-во байт в сообщении
/*
                size = message.getBytes().length;

                os.writeInt(size); // заголовок пакета
                os.write(message.getBytes()); // тело пакета
                os.flush();
*/
                if(message.equals("exit")) {
                    break;
                }
            }
            clientSocket.close();
            serverSocket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
