package org.example.creation.singleton;

public class Demo {

    public static void main(String[] args) {

        OrderManagementService orderManagementService = OrderManagementService.getInstance();
        // orderManagementService2 = new OrderManagementService();
        OrderManagementService orderManagementService3 = OrderManagementService.getInstance();

        System.out.println(orderManagementService == orderManagementService3);
       // System.out.println(orderManagementService == orderManagementService2);

    }
}
