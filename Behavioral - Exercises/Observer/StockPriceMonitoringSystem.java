// Subject interface
import java.util.ArrayList;
import java.util.List;

// Observable: Stock class
class Stock {
    private String name;
    private double price;
    private double previousClose;
    private final List<Display> observers; // List of display screens

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
        this.previousClose = price;
        this.observers = new ArrayList<>();
    }

    // Add observer (display)
    public void addObserver(Display display) {
        observers.add(display);
    }

    // Remove observer (display)
    public void removeObserver(Display display) {
        observers.remove(display);
    }

    // Notify all observers about price change
    private void notifyObservers() {
        for (Display display : observers) {
            display.update(name, price, previousClose);
        }
    }

    // Change stock price
    public void setPrice(double newPrice) {
        if (newPrice != price) {
            previousClose = price;
            price = newPrice;
            notifyObservers(); // Notify all subscribed displays
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Observer interface
interface Display {
    void update(String stockName, double currentPrice, double previousClose);
}

// Concrete observer: shows current price only
class CurrentPriceDisplay implements Display {
    @Override
    public void update(String stockName, double currentPrice, double previousClose) {
        System.out.println("[CurrentPriceDisplay] " + stockName + " → $" + currentPrice);
    }
}

// Concrete observer: shows percentage change
class PercentageChangeDisplay implements Display {
    @Override
    public void update(String stockName, double currentPrice, double previousClose) {
        double change = ((currentPrice - previousClose) / previousClose) * 100;
        System.out.printf("[PercentageChangeDisplay] %s → %.2f%% change\n", stockName, change);
    }
}

// Another possible observer: shows full stock information
class DetailedDisplay implements Display {
    @Override
    public void update(String stockName, double currentPrice, double previousClose) {
        double change = ((currentPrice - previousClose) / previousClose) * 100;
        System.out.printf("[DetailedDisplay] %s | Previous: $%.2f | Current: $%.2f | Change: %.2f%%\n",
                stockName, previousClose, currentPrice, change);
    }
}

// Main class to demonstrate
public class StockPriceMonitoringSystem {
    public static void main(String[] args) {
        // Create stock objects (observable)
        Stock apple = new Stock("Apple Inc.", 150.00);
        Stock google = new Stock("Google LLC", 2800.00);

        // Create displays (observers)
        Display currentDisplay = new CurrentPriceDisplay();
        Display percentDisplay = new PercentageChangeDisplay();
        Display detailedDisplay = new DetailedDisplay();

        // Add displays to Apple
        apple.addObserver(currentDisplay);
        apple.addObserver(percentDisplay);
        apple.addObserver(detailedDisplay);

        // Add displays to Google
        google.addObserver(detailedDisplay);
        google.addObserver(percentDisplay);

        // Simulate stock price updates
        System.out.println("=== Price Updates ===");
        apple.setPrice(152.00);
        apple.setPrice(148.00);

        google.setPrice(2825.00);
        google.setPrice(2790.00);
    }
}
