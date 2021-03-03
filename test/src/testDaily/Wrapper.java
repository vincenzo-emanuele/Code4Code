package testDaily;

public class Wrapper {

    public Wrapper(Properties properties){
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private Properties properties;

}
