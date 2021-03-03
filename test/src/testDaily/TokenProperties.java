package testDaily;

public class TokenProperties {

    public TokenProperties(boolean isOwner, String user_name, String room_name) {
        this.is_owner = isOwner;
        this.user_name = user_name;
        this.room_name = room_name;
    }

    public boolean isIs_owner() {
        return is_owner;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setIs_owner(boolean is_owner) {
        this.is_owner = is_owner;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    @Override
    public String toString() {
        return "TokenProperties{" +
                "isOwner=" + is_owner +
                ", user_name='" + user_name +
                ", room_name='" + room_name +
                '}';
    }

    private boolean is_owner;
    private String user_name;
    private String room_name;

}
