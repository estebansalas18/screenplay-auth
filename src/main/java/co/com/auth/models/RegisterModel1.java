package co.com.auth.models;

public class RegisterModel1 {
    private final String firstName;
    private final String lastName;
    private final String idType;
    private final String idNumber;
    private final String phoneNumber;
    private final String birthDate;

    public RegisterModel1(String firstName, String lastName, String idType, String idNumber, String phoneNumber,
            String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idType = idType;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
