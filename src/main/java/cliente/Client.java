package cliente;

import connection.Connection;

import java.math.BigInteger;

public class Client {
    public void startClient() {
        try {
            Connection connection = new Connection("localhost", 12345);
            RSA rsa = new RSA(new BigInteger("17"), new BigInteger("23"), new BigInteger("3"));

            String message = "Hello, Server!";
            BigInteger cipher = rsa.encrypt(new BigInteger(message.getBytes()));

            System.out.println("Cifrado: " + cipher);
            connection.send(cipher.toString());

            String received = connection.receive();
            BigInteger decryptedMessage = rsa.decrypt(new BigInteger(received));
            System.out.println("Decifrado: " + new String(decryptedMessage.toByteArray()));

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
