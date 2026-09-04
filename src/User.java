
public class User {
    private String name;
    private Portfolio portfolio;

    public User(String name, Portfolio portfolio) {
        this.name = name;
        this.portfolio = portfolio;
    }

    public String getName() {
        return name;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }


}