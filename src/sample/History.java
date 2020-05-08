package sample;

import java.sql.Date;
import java.sql.Time;

public class History {
    private int userid;
    private String transfer;
    private Time time;
    private int credit;
    private String login;

    public History( int userid, String transfer, Time time, int credit, String login) {
        this.userid = userid;
        this.transfer = transfer;
        this.time = time;
        this.credit = credit;
        this.login = login;
    }
    public History(int userid,Time time,int credit,String login) {
        this.userid = userid;
        this.time = time;
        this.credit = credit;
        this.login = login;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Override
    public String toString() {
        return "History{" +
                "userid=" + userid +
                ", transfer='" + transfer + '\'' +
                ", time=" + time +
                ", credit=" + credit +
                ", login='" + login + '\'' +
                '}';
    }
}
