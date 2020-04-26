package Server;


import jdk.nashorn.internal.ir.RuntimeNode;
import sample.Database;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerRunnable extends Thread {
    private Socket socket;
    public ServerRunnable(Socket socket) {
        this.socket = socket;
    }
    private Request request = new Request();
    private Database database = new Database();
    @Override
    public void run() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while ((request = (Request) inputStream.readObject())!= null ) {
                System.out.println(request);
                if (request.getOperationType().equals("GET_USERS")) {
                    outputStream.writeObject(new Request("USERS_GOT", database.getUser(), null, null));
                }
                if (request.getOperationType().equals("ADD_USER")) {
                    System.out.println("zxc");
                    database.addUser(request.getLogin(), request.getPassword(), request.getCity(), request.getNumberphone(), request.getOperator(), request.getDate(), request.getAnswer());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
