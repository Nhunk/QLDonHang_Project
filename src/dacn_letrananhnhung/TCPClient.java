
package dacn_letrananhnhung;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    Socket socket = null;

    public void ConnectServer(String host, int port) throws IOException {

        socket = new Socket(host, port);
        System.out.println("done");
    }

    public void Close() {
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void output(String mess) throws IOException {
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println(mess);
        System.out.println(mess);
    }

    public String input() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String mess = input.readLine();
        System.out.println(mess);
        return mess;
    }
}
