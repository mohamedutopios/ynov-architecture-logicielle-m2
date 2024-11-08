package org.example.structural.decorator;

public class SugarDecorator extends CoffeeDecorator{


    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sucre";
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }


}
