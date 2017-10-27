import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private String content;
    private Date time ;
    private User user;//from which user
    private Channel channel;//message belongs to which channel


    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    private MessageType messageType;

    public Message(String message){
        content = message;
        time = new Date();
    }

    public String toString(){
        if (user == null) return ("NULL" +"\r\n\r\r\r"+content);
        else return (user.toString()+"\r\n\r\r\r"+content);
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
