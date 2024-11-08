package org.example.structural.decorator;

public class Client {

    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();

        // café simple
        System.out.println(coffee.getDescription() + " cost : " + coffee.cost() );

        // cafe lait
        Coffee milkCoffe = new MilkDecorator(coffee);
        System.out.println(milkCoffe.getDescription() + " cost : " + milkCoffe.cost() );

        // café lait + sucre
        Coffee sugarCoffeMilk = new SugarDecorator(milkCoffe);
        System.out.println(sugarCoffeMilk.getDescription() + " cost : " + sugarCoffeMilk.cost() );

        // café sucré
        Coffee sugarCoffee = new SugarDecorator(coffee);
        System.out.println(sugarCoffee.getDescription() + " cost : " + sugarCoffee.cost() );



    }
}
