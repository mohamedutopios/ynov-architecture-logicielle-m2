package org.example.behavior.strategy;

public class Demo {
    public static void main(String[] args) {

        PriceCalculator priceCalculator = new PriceCalculator();

        priceCalculator.setDiscountStrategy(new StudentDiscount());

        System.out.println("Prix a payer pour un etudiant : " + priceCalculator.calculatePrice(100));

        priceCalculator.setDiscountStrategy(new PremiumDiscount());

        System.out.println("Prix à payer pour un premium : " + priceCalculator.calculatePrice(100));

        priceCalculator.setDiscountStrategy(new NoDiscount());

        System.out.println("Prix à payer sans remise : " + priceCalculator.calculatePrice(100));

    }
}
