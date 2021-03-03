package testDaily;

public class TokenPropertiesWrapper {

    public TokenPropertiesWrapper(TokenProperties properties) {
        this.properties = properties;
    }

    public TokenProperties getProperties() {
        return properties;
    }

    public void setProperties(TokenProperties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "TokenPropertiesWrapper{" +
                "properties=" + properties +
                '}';
    }

    private TokenProperties properties;

}
