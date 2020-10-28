package Tutorials_Week5;

/**
 * @author: Callum Jenkins
 * 07/10/2020
 * <p>
 * Class: Stock
 */

public class Stock {

    private long stockNumber;
    private String stockDescription;
    private int stockLevel;

    public Stock(long stockNumber, String stockDescription, int stockLevel) {
        this.stockNumber = stockNumber;
        this.stockDescription = stockDescription;
        this.stockLevel = stockLevel;
    }


    public long getStockNumber() {
        return stockNumber;
    }


    public void setStockNumber(long stockNumber) {
        this.stockNumber = stockNumber;
    }
    public void setStockNumber() {
        long stockNumber;
        Utilities scanner = new Utilities();
        stockNumber = Long.parseLong(scanner.getUserInput("Please enter this persons name: "));
        this.stockNumber = stockNumber;
    }


    public String getStockDescription() {
        return stockDescription;
    }

    public void setStockDescription(String stockDescription) {
        this.stockDescription = stockDescription;
    }
    public void setStockDescription() {
        String stockDescription;
        Utilities scanner = new Utilities();
        stockDescription = scanner.getUserInput("Please enter this persons name: ");
        this.stockDescription = stockDescription;
    }


    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
    public void setStockLevel() {
        int stockLevel;
        Utilities scanner = new Utilities();
        stockLevel = Integer.parseInt(scanner.getUserInput("Please enter this persons name: "));
        this.stockLevel = stockLevel;
    }


    public void updateStock(int quantityPurchased) {
        if (this.stockLevel <= quantityPurchased)
        {
            this.stockLevel -= quantityPurchased;
        }
    }


    public void displayAllDetails() {
        System.out.println("Stock number: " + stockNumber);
        System.out.println("Stock description: " + stockDescription);
        System.out.println("Stock level: " + stockLevel);
    }

}
