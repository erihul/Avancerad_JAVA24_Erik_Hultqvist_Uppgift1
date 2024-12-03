package Components;

public class User {

    private int userBalance;

    public User(int userBalance) {
        this.userBalance = userBalance;
    }
    public void addUserBalance(int userBalance) {
        this.userBalance += userBalance;
    }
    public int getUserBalance() {
        return userBalance;
    }

}
