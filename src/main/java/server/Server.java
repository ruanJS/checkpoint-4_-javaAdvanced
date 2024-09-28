package server;
import connection.Connection;

import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor iniciado. Aguardando conexões...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado!");

            Connection connection = new Connection(clientSocket);
            RSA rsa = new RSA(new BigInteger("17"), new BigInteger("23"), new BigInteger("3"));

            String received = connection.receive();
            BigInteger cipher = new BigInteger(received);
            System.out.println("Cifrado recebido: " + cipher);

            BigInteger decryptedMessage = rsa.decrypt(cipher);
            System.out.println("Decifrado: " + new String(decryptedMessage.toByteArray()));

            connection.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
