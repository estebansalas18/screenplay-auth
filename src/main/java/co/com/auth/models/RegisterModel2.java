package co.com.auth.models;

public class RegisterModel2 {
    private final String country;
    private final String department;
    private final String city;
    private final String address;
    private final String email;
    private final String password;
    private final String confirmPassword;

    public RegisterModel2(String country, String department, String city, String address, String email,
            String password, String confirmPassword) {
        this.country = country;
        this.department = department;
        this.city = city;
        this.address = address;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getCountry() {
        return country;
    }

    public String getDepartment() {
        return department;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}
