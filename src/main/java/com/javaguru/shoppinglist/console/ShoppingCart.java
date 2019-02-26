package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.CartService;

import java.util.Scanner;

public class ShoppingCart {
    private final CartService cartService;

    public ShoppingCart(CartService cartService) {
        this.cartService = cartService;
    }

    public void executeShoppingCart() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. add product");
                System.out.println("2. product list");
                System.out.println("3. total cost of all products");
                System.out.println("4. remove product from cart");
                System.out.println("5. exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        showCartList();
                        break;
                    case 3:
                        sumOfAllProducts();
                        break;
                    case 4:
                        removeProduct();
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name :");
        String name = scanner.nextLine();
        String findedProduct = cartService.findProductByName(name);
        System.out.println("Product : " + findedProduct);
    }

    public void showCartList() {
        cartService.getCart();
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id :");
        Long id = scanner.nextLong();
        Product findedProduct = cartService.removeProductByName(id);
        System.out.println("Remove product : " + findedProduct);
    }

    public void sumOfAllProducts() {
        System.out.println("Sum of all prices : " + cartService.sumOfCartPrices());
    }
}