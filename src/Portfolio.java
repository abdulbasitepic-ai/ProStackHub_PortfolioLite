import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private double cash;
    private HashMap<String , Integer> holdings;
    private HashMap<String , Stock> stocks;

    public Portfolio(double cash){
        this.cash = cash;
        holdings = new HashMap<>();
        stocks = new HashMap<>();
    }

    public double getCash() {
        return cash;
    }

    public void buyStock(Stock stock , int quantity ){
        double totalcost;
        double stockprice = stock.getPrice();
        totalcost = stockprice * quantity;
        if( cash >= totalcost){
            cash = cash - totalcost;
            int currentShares = holdings.getOrDefault(stock.getSymbol() , 0);
            int newQuantity = currentShares + quantity;
            stocks.put(stock.getSymbol() , stock);
            holdings.put(stock.getSymbol() , newQuantity);
            System.out.println("\n===== PURCHASE RECEIPT =====");
            System.out.println("Transaction : BUY");
            System.out.println("Stock       : " + stock.getName());
            System.out.println("Symbol      : " + stock.getSymbol());
            System.out.println("Quantity    : " + quantity);
            System.out.printf("Price       : $%.2f%n", stockprice);
            System.out.printf("Total Cost  : $%.2f%n", totalcost);
            System.out.printf("Remaining Cash : $%.2f%n", cash);
            System.out.println("============================");
        }else{
            System.out.println("Insufficient Cash");
        }
    }

    public void sellStock(Stock stock , int quantity){
        int currentShares = holdings.getOrDefault(stock.getSymbol() , 0);
        double stockprice = stock.getPrice();
        if( currentShares >= quantity){
            double totalvalue = stockprice*quantity;
            cash = cash+(stockprice * quantity);
            currentShares = currentShares - quantity;
            holdings.put(stock.getSymbol() , currentShares);
            System.out.println("\n===== SALE RECEIPT =====");
            System.out.println("Transaction : SELL");
            System.out.println("Stock       : " + stock.getName());
            System.out.println("Symbol      : " + stock.getSymbol());
            System.out.println("Quantity    : " + quantity);
            System.out.printf("Price       : $%.2f%n", stockprice);
            System.out.printf("Total Value : $%.2f%n", totalvalue);
            System.out.printf("Remaining Cash : $%.2f%n", cash);
            System.out.println("========================");
        }else{
            System.out.println("Don't have enough shares");
        }

    }

    public void displayHoldings(){
        System.out.println("===== YOUR HOLDINGS =====");
        for( Map.Entry<String , Integer> entry : holdings.entrySet()){
            System.out.println(entry.getKey()+" = "+ entry.getValue());
        }

    }

    public double getStockvalue( Stock stock){
        double stockPrice = stock.getPrice();
        int shares  = holdings.getOrDefault(stock.getSymbol() , 0);

        double totalvalue = stockPrice * shares;
        return totalvalue;
    }

    public double getTotalPortfolioValue(){
        double totalvalue = cash;
        for( Map.Entry<String , Stock > entry : stocks.entrySet()){
            Stock stock = entry.getValue();
            totalvalue = totalvalue +  getStockvalue(stock);
        }
        return totalvalue;
    }

    public HashMap<String , Integer> getholdings(){
        return holdings;

    }
}
