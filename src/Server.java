import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        try {
            ServerSocket server = new ServerSocket(port);
            ArrayList<ServerThread> threadList = new ArrayList<>();
            while(true) {
                Socket socket = server.accept();
                ServerThread serverThread = new ServerThread(socket, threadList);

                threadList.add(serverThread);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}