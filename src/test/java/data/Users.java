package data;

public enum Users {
    ALEX ("AlexTerrible", "Qwer!1234"),
    ARANE("arane1223", "Arane@1223");

    public final String userName;
    public final String password;
    Users (String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
