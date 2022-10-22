package decorator;

public class Main {
  public static void main(String[] args) {
    Pizza cheesePizza = new CheesePizza(new DoughPizza());
    Pizza pepperoniPizza = new PepperoniPizza(new DoughPizza());
    Pizza meatPizza = new MeatPizza(new DoughPizza());
    Pizza cheesePepperoniPizza = new PepperoniPizza(new CheesePizza(new DoughPizza()));
    Pizza cheesePepperoniMeatPizza = new MeatPizza(new PepperoniPizza(new CheesePizza(new DoughPizza())));

    System.out.println(cheesePizza.makePizza());
    System.out.println(pepperoniPizza.makePizza());
    System.out.println(meatPizza.makePizza());
    System.out.println(cheesePepperoniPizza.makePizza());
    System.out.println(cheesePepperoniMeatPizza.makePizza());
  }
}

interface Pizza {

  String makePizza();
}

class DoughPizza implements Pizza {

  @Override
  public String makePizza() {
    return "with";
  }
}

class CheesePizza implements Pizza {
  public Pizza pizza;

  public CheesePizza(Pizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public String makePizza() {
    return pizza.makePizza() + " cheese";
  }
}

class PepperoniPizza implements Pizza {
  public Pizza pizza;

  public PepperoniPizza(Pizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public String makePizza() {
    return pizza.makePizza() + " pepperoni";
  }
}

class MeatPizza implements Pizza {
  public Pizza pizza;

  public MeatPizza(Pizza pizza) {
    this.pizza = pizza;
  }

  @Override
  public String makePizza() {
    return pizza.makePizza() + " meat";
  }
}
