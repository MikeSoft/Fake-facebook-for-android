package rootingtheai.mikeolivera.facebook.Models;

/**
 * Created by mikes on 19-Sep.
 */

public class Account {
    String username,password, date;
    int id;

    public Account(int id,String username, String password, String date){
        this.id = id;
        this.username=username;
        this.password=password;
        this.date=date;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
