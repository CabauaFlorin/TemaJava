import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class ServerThread extends Thread{
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;
    static ArrayList<Human> humans = new ArrayList<>();

    Comparator<Human> c = new Comparator<Human>() {
        //  https://stackoverflow.com/questions/46429938/adding-to-an-arraylist-in-order-of-age
        @Override
        public int compare(Human o1, Human o2) {
            return Integer.compare(o1.get_varsta(), o2.get_varsta());
        }
    };

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //returning the output to client
            output = new PrintWriter(socket.getOutputStream(),true);

            //infinite loop server
            while(true) {
                String outputString = input.readLine();
                if(outputString.equals("exit")) {
                    break;
                }
                printToALlClients(outputString);
                System.out.println("Server received " + outputString);

                String type;
                Scanner inputLine = new Scanner(outputString);

                inputLine.next();
                if(inputLine.hasNext()) {
                    inputLine.next();
                    if(inputLine.hasNext()) {
                        inputLine.next();
                        if(inputLine.hasNext()) {
                            type = inputLine.next();

                            if(Objects.equals(type, "Student")) {
                                System.out.println("Se adauga un " + type);
                                String nume = inputLine.next();
                                String prenume = inputLine.next();
                                String acronim = inputLine.next();
                                int varsta =  Integer.parseInt(inputLine.next());
                                int anStudiu = Integer.parseInt(inputLine.next());
                                Student stud = new Student(nume, prenume, acronim, varsta, anStudiu);
                                humans.add(stud);
                            } else if (Objects.equals(type, "Profesor")) {
                                System.out.println("Se adauga un " + type);
                                String nume = inputLine.next();
                                String prenume = inputLine.next();
                                String acronim = inputLine.next();
                                int varsta =  Integer.parseInt(inputLine.next());
                                String materie = inputLine.next();
                                Profesor prof = new Profesor(nume, prenume, acronim, varsta, materie);
                                humans.add(prof);
                            }
                            else {
                                System.out.println("Eroare tip Human!!!");
                            }
                        }
                    }
                }
                humans.sort(c);
                for(Human hu : humans)
                {
                    System.out.println(hu.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error occured " + e.getStackTrace());
        }
    }

    private void printToALlClients(String outputString) {
        for( ServerThread sT: threadList) {
            sT.output.println(outputString);
        }
    }
}