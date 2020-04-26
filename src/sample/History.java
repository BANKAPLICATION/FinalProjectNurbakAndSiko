package sample;

import java.sql.Date;

public class History {
    private int userid;
    private String transfer;
    private Date date;
    private int credit;
    private String login;

    public History( int userid, String transfer, Date date, int credit, String login) {
        this.userid = userid;
        this.transfer = transfer;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                ", userid=" + userid +
                ", transfer='" + transfer + '\'' +
                ", date=" + date +
                ", credit=" + credit +
                ", login='" + login + '\'' +
                '}';
    }
}
