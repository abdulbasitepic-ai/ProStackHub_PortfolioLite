import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Portfolio portfolio = new Portfolio(10000);
        User user = new User("Abdul basit" , portfolio);
        Stock apple = new Stock("Apple", "AAPL", 180);
        Stock tesla = new Stock("Tesla", "TSLA", 250);
        Stock microsoft = new Stock("Microsoft", "MSFT", 420);
        Stock google = new Stock("Google", "GOOGL", 170);
        Stock amazon = new Stock("Amazon", "AMZN", 190);

        System.out.println("==== WELCOME TO PORTFOLIOLITE ====");
        System.out.println("Welcome, " + user.getName());

        while(true){
            System.out.println("\n===== MAIN MENU ===== ");
            System.out.println("!. View Cash");
            System.out.println("2. View Holdings");
            System.out.println("3. Buy Stocks");
            System.out.println("4. Sell Stocks");
            System.out.println("5. View Portfolio Value");
            System.out.println("6. Exit");

            System.out.println("Enter Your Choice");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Cash $ " + portfolio.getCash());
                    break;
                case 2:
                    portfolio.displayHoldings();
                    break;
                case 3:
                    System.out.println("===== BUY STOCKS =====");
                    System.out.println("1. Apple(AAPL) - $" + apple.getPrice());
                    System.out.println("2. Tesla(TSLA) - $" + tesla.getPrice());
                    System.out.println("3. Microsoft(MSFT) - $" + microsoft.getPrice());
                    System.out.println("4. Google(GOOGL) - $" + google.getPrice());
                    System.out.println("5. Amazon(AMZN) - $" + amazon.getPrice());

                    System.out.println("Choose Stock : ");
                     int buychoice = scanner.nextInt();


                    System.out.println("Choose Quantity : ");
                    int buyQuantity = scanner.nextInt();

                    Stock buyStock = null;

                    switch (buychoice){
                        case 1:
                            buyStock = apple;
                            break;
                        case 2 :
                            buyStock = tesla;
                            break;
                        case 3:
                            buyStock = microsoft;
                            break;
                        case 4:
                            buyStock = google;
                            break;
                        case 5:
                            buyStock = amazon;
                            break;

                        default:
                            System.out.println("Enter A Valid Value");
                    }

                    if(buyStock != null){
                        portfolio.buyStock(buyStock , buyQuantity);
                    }
                    break;
                case 4:
                    System.out.println("===== SELL STOCKS =====");
                    System.out.println("1. Apple(AAPL)");
                    System.out.println("2. Tesla(TSLA)");
                    System.out.println("3. Microsoft(MSFT)");
                    System.out.println("4. Google(GOOGL)" );
                    System.out.println("5. Amazon(AMZN)");

                    System.out.println("Choose Stock : ");
                    int sellchoice = scanner.nextInt();


                    System.out.println("Choose Quantity : ");
                    int sellQuantity = scanner.nextInt();

                    Stock sellStock = null;

                    switch (sellchoice){
                        case 1:
                            sellStock = apple;
                            break;
                        case 2 :
                            sellStock = tesla;
                            break;
                        case 3:
                            sellStock = microsoft;
                            break;
                        case 4:
                            sellStock = google;
                            break;
                        case 5:
                            sellStock = amazon;
                            break;
                        default:
                            System.out.println("Enter A Valid Stock");
                    }

                    if(sellStock != null){
                        portfolio.sellStock(sellStock , sellQuantity);
                    }
                    break;
                case 5:
                    System.out.println("Portfolio Value: $" + portfolio.getTotalPortfolioValue());
                    break;
                case 6:
                    System.out.println("Thank you For Using Portfolio Lite");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
}