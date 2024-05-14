public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private boolean broker;

    public User(String userName,String password, String phoneNumber,boolean broker) {
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.broker = broker;

    }

    public User() {

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isBroker() {
        return broker;
    }






}
