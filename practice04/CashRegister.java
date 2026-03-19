public class CashRegister {
    String location;
    double pizzaPrice;

    CashRegister(String location, double pizzaPrice) {
        this.location = location;
        this.pizzaPrice = pizzaPrice;
    }

    void charge(Payable customer) {
        System.out.println("[" + location + "] Charging $" + pizzaPrice + "...");
        customer.pay(pizzaPrice);
    }
}