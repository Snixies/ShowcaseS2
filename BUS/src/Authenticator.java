

public class Authenticator {
    private String vNumber;
    private String password;

    public Authenticator(String vNumber, String password) {
        this.vNumber = vNumber;
        this.password = password;
    }

    public String getvNumber() {
        return vNumber;
    }

    public String getPassword() {
        return password;
    }
}
