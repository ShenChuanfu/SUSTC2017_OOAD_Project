import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class User implements Serializable{
    private String userName;
    private String userID;
    private String password;
    private static int userCount;
    private List<Channel> channels;

    public User(){
        this("");
        this.setUserName(userID);

    }
    public User(String name){

        userID = "US"+userCount;
        userName = name;
        userCount++;
        password = "000000";
        channels = new LinkedList<Channel>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getUserCount() {
        return userCount;
    }

    public static void setUserCount(int userCount) {
        User.userCount = userCount;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public String toString(){
        return userName;
    }

}
