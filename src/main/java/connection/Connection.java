package connection;

import java.io.*;
import java.net.*;

public class Connection {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Connection(String address, int port) throws IOException {
        socket = new Socket(address, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public Connection(Socket clientSocket) {
    }

    public String receive() throws IOException {
        return in.readLine();
    }

    public void send(String message) {
        out.println(message);
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
