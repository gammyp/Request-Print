package RequestPrintModel;

public class Users extends Person {

    private static int runId = 1;
    private int userId;
    private String userName;
    private String password;

    public Users() {
        super(null ,null, null ,null);
        userId = runId++;
    }

    
    
    public Users(String userName, String password, String name, String surname, String phone, String email) {
        super(name, surname, phone, email);
        this.userName = userName;
        this.password = password;
        userId = runId++;
    }

    public static int getRunId() {
        return runId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return "Username: " + userName + "\nPassword: " + password;
    }

    @Override
    public String toString() {
        return 
                 "UserId: " + userId
                + "\nUsername: " + userName
                + "\nPassword: " + password;
    }

}
