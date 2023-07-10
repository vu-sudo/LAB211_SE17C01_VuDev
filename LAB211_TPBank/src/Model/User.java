package Model;

public class User {
    private String userName;
    private String userPassWord;

    public String getUserName() {
        return userName;
    }
    public String getUserPassWord() {
        return userPassWord;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public User(String userName, String userPassWord) {
        this.userName = userName;
        this.userPassWord = userPassWord;
    }

    @Override
    public String toString() {
        return this.userName + " - " + this.userPassWord;
    }
}
