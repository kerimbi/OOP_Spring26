public interface CanHavePizza {
    int PIZZA_SIZE = 8;
    void eatPizza();
}

interface CanHaveRetake {
    void takeRetake();
}

interface CanHaveParty {
    void dance();
}

interface LivingBeing {
    void breathe();
    void move();
    void eat();
}

interface Payable {
    double getBalance();
    void pay(double amount);
}