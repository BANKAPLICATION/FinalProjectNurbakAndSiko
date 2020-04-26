

package Server;
import sample.Employee;
import sample.Schets;
import sample.User;
import sun.security.timestamp.TSRequest;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
public class Request implements Serializable {
    private  String valuta;
    private String email;
    private String operationType;
    private String login;
    private String password;
    private  String city;
    private String numberphone;
    private String operator;
    private LocalDate date;
    private String answer;
    private int userid;
    private int amount;
    private String senderPhone;
    private String recipient;
    private User user;
    private int id;
    private String nickname;
    private String newPassword;
    private ArrayList<User> users;
    private ArrayList <Employee> employees;
    private ArrayList <Schets> schets;
    public String getOperationType() {
        return operationType;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getCity() {
        return city;
    }
    public String getNumberphone() {
        return numberphone;
    }
    public String getOperator() {
        return operator;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Request{" +
                "operationType='" + operationType + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }
    public int getAmount() {
        return amount;
    }
    public String getSenderPhone() {
        return senderPhone;
    }
    public String getRecipient() {
        return recipient;
    }
    public User getUser() {
        return user;
    }
    public int getId() {
        return id;
    }
    public String getNickname() {
        return nickname;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public ArrayList<Schets> getSchets() {
        return schets;
    }
    public Request() {}

    public Request(String operationType) {
        this.operationType = operationType;
    }
     public Request(String operationType,String login, String password) {
        this.operationType = operationType;
        this.login = login;
        this.password = password;
    }
    public Request(String operationType, int id, String email) {
        this.operationType = operationType;
        this.id = id;
        this.email = email;
    }
    public Request(String operationType, int id,String valuta,int amount) {
        this.operationType = operationType;
        this.id = id;
        this.valuta = valuta;
        this.amount = amount;
    }

    public Request(String operationType,String login, String password, String city,String numberphone, String operator, LocalDate date, String answer ) {
        this.operationType = operationType;
        this.login = login;
        this.password = password;
        this.city = city;
        this.numberphone = numberphone;
        this.operator = operator;
        this.date = date;
        this.answer = answer;
    }
    public Request(String operationType,int userid,int amount) {
        this.operationType = operationType;
        this.userid = userid;
        this.amount = amount;
    }
    public Request(String operationType, String senderPhone, String recipient, int amount) {
        this.operationType = operationType;
        this.senderPhone = senderPhone;
        this.recipient = recipient;
        this.amount = amount;

    }
    public Request(String operationType, User user) {
        this.operationType = operationType;
        this.user = user;
    }
    public Request(String operationType, int id, String login, String  password) {
        this.operationType = operationType;
        this.id = id;
        this.password = password;
    }
    public Request(String operationType, String nickname) {
        this.operationType = operationType;
        this.nickname = nickname;

    }
    public Request(String operationType , int id) {
        this.operationType = operationType;
        this.id = id;
    }
    public Request(String operationType, String newPassword,int id) {
        this.operationType = operationType;
        this.newPassword = newPassword;
        this.id = id;
    }
    public Request(String operationType, ArrayList <User> users, ArrayList <Schets> schets, ArrayList <Employee> employees) {
        this.operationType = operationType;
        this.users = users;
        this.schets = schets;
        this.employees = employees;
    }
}

