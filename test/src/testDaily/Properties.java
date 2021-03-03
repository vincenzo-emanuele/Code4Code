package testDaily;

import java.io.Serializable;

public class Properties implements Serializable {

    public Properties(String name, String privacy) {
        this.name = name;
        this.privacy = privacy;
    }

    public String getName() {
        return name;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", privacy='" + privacy + '\'';
    }

    private String name;
    private String privacy;
}
