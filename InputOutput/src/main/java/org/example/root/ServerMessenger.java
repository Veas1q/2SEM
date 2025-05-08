package org.example.root;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMessenger {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(50000);
            //Ожидаем подключения клиента
            Socket clientSocket = serverSocket.accept();
            //Дождались клиента
            //Читаем данные от клиента
            DataInputStream is = new DataInputStream(clientSocket.getInputStream());
            //Передаем данные клиенту
            DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                //читаем послание от клиента
                int size = is.readInt();
                byte[] buffer = new byte[size];
                is.read(buffer);
                System.out.println(new String(buffer));

                Scanner scanner = new Scanner(System.in);


                //Отправляем клиенту
                String message = scanner.nextLine();
                size = message.getBytes().length;

                os.writeInt(size); //условно заголовок пакета
                os.write(message.getBytes()); //тело пакета
                os.flush();

                if (message.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
