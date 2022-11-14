import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try {
            Socket me = new Socket(hostName, portNumber);
            // return the output to server
            PrintWriter out = new PrintWriter(me.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String fromUser, clientName = "null";
            Scanner scanner = new Scanner(System.in);

            while (stdIn.readLine() != null) {
                if (clientName.equals("null")) {
                    System.out.println("Enter your name: ");
                    clientName = scanner.nextLine();
                    if (clientName.equals("exit"))
                        break;
                }
                else {
                    String mesaj = ( "(" + clientName + ")" + " message : " );
                    System.out.println(mesaj);
                    fromUser = scanner.nextLine();
                    out.println(mesaj + " " + fromUser);
                    if (fromUser.equals("exit")) {
                        //read input from server
                        break;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}