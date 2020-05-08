package Server;
import sample.Employee;
import sample.Main;
import sample.Schets;
import sample.User;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class ClientHandler {

    private static ObjectOutputStream oos;
    private static ObjectInputStream ois;
    public static ArrayList<User> users;
    public static ArrayList <Employee> employees;
    public static ArrayList <Schets> schets;
    static {
        try {
            oos = new ObjectOutputStream(Main.socket.getOutputStream());
            ois = new ObjectInputStream(Main.socket.getInputStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void writeRequest(String operationType) throws IOException {
        oos.writeObject(new Request(operationType));
    }

    public void writeRequest(String operationType,String login, String password) throws IOException {
        oos.writeObject(new Request(operationType,login,password));
    }

    public void writeRequest(String operationType, int id, String email) throws IOException {
        oos.writeObject(new Request(operationType,id,email));
    }

    public void writeRequest(String operationType, int id,String valuta,int amount) throws IOException {
        oos.writeObject(new Request(operationType,id,valuta,amount));
    }

    public void writeRequest(String operationType, String login, String password, String city, String numberphone, String operator, LocalDate date, String answer ) throws IOException {
        oos.writeObject(new Request(operationType,login,password,city,numberphone,operator,date,answer));
    }

    public void writeRequest(String operationType,int userid,int amount) throws IOException {
        oos.writeObject(new Request(operationType,userid,amount));
    }

    public void writeRequest(String operationType, String senderPhone, String recipient, int amount) throws IOException {
        oos.writeObject(new Request(operationType,senderPhone,recipient,amount));
    }

    public void writeRequest(String operationType, User user) throws IOException {
        oos.writeObject(new Request(operationType,user));
    }
    public void writeRequest(String operationType, int id, String login, String  password) throws IOException {
        oos.writeObject(new Request(operationType,id,login,password));
    }
    public void writeRequest(String operationType, String nickname) throws IOException {
        oos.writeObject(new Request(operationType,nickname));
    }
    public void writeRequest(String operationType , int id) throws IOException {
        oos.writeObject(new Request(operationType,id));
    }
    public void writeRequest(String operationType, String newPassword,int id) throws IOException {
        oos.writeObject(new Request(operationType,newPassword,id));
    }
    public void writeRequest(String operationType, ArrayList <User> users, ArrayList <Schets> schets, ArrayList <Employee> employees) throws IOException {
            oos.writeObject(new Request(operationType,users,schets,employees));
    }
    public boolean checkRequest(String operationType) {
        try {
            Request request;
            request = (Request) ois.readObject();
            if (request.getOperationType().equals(operationType)) {
                users = request.getUsers();
                schets = request.getSchets();
                employees = request.getEmployees();
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}