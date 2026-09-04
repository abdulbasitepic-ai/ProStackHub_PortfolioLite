import java.util.Random;

public class Stock {
    private String name;
    private String symbol;
    private double price;

       public Stock( String name , String symbol , double price){
           this.name = name;
           this.symbol = symbol;
           this.price = price;
       }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public String getSymbol(){
           return symbol;
    }

    public void setprice(double price){
       this.price = price;
    }

    public void priceChange( double price){
        Random random = new Random();
        double change = (random.nextDouble()*0.10)-0.05 ;
           this.price = this.price * (1 + change);
    }
}
