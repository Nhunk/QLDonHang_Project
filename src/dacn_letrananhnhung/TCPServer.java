
package dacn_letrananhnhung;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
ServerSocket serverSocket;
    Socket socket;
    String r = null;
    DanhSachDonHang dsdh = new DanhSachDonHang();

    public void Close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }

    public void output(String mess) throws IOException {
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println(mess);
        System.out.println(mess);
    }

    public String input() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String mess = read.readLine();
        System.out.println(mess);
        return mess;
    }

    public void connectServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void connectClient() throws IOException {
        socket = serverSocket.accept();
    }
}
