package Components;
// The user class is created to so that the rental costs can be added to a object
public class User {

    private int userBalance;
    // The user has a balance integer and two methods
    public User(int userBalance) {
        this.userBalance = userBalance;
    }
    // A method to see what the balnce is
    public int getUserBalance() {
        return userBalance;
    }
    // A method to add to balance (used when renting)
    public void addUserBalance(int userBalance) {
        this.userBalance += userBalance;
    }

}
