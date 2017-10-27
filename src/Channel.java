import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Channel {


    private static int channelCount;
    private String channelID;
    private int size;
    private int current;
    private String channelName;
    private List<User> users;
    private Date createTime;

    public Channel(){
        this("DEFAULT");
    }


    public Channel(String name){
        channelName = name;
        createTime = new Date();
        size = 100;
        current = 0;
        channelID = "CN"+channelCount;
        channelCount++;
        users = new LinkedList<User>();
    }

    public void addUser(User user){
        users.add(user);
    }
    public void deletUser(User user){
        users.remove(user);
    }

    public static int getChannelCount() {
        return channelCount;
    }

    public static void setChannelCount(int channelCount) {
        Channel.channelCount = channelCount;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
