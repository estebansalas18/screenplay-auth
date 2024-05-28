package co.com.auth.models;

public class LoginModel {
    private final String user;
    private final String password;

    public LoginModel(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
