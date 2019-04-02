package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ShoppingCartProductService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AssignProduct {

    private final ShoppingCartProductService service;

    public AssignProduct(ShoppingCartProductService service) {
        this.service = service;
    }

    void executeAssignProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cart name: ");
        String cartName = scanner.nextLine();
        System.out.println("Enter product id: ");
        Long productId = scanner.nextLong();
        service.assignProduct(cartName, productId);
    }
}