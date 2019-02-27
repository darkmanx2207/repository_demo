package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.CartService;

import java.util.Scanner;

public class ShoppingCartConsoleUI {
    private final CartService cartService;

    public ShoppingCartConsoleUI(CartService cartService) {
        this.cartService = cartService;
    }

    public void executeShoppingCart() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. create shopping cart name");
                System.out.println("2. add cart");
                System.out.println("3. product list");
                System.out.println("4. total cost of all products");
                System.out.println("5. remove product from cart");
                System.out.println("6. exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                       readCartName();
                       break;
                    case 2:
                        createCart();
                        break;
                    case 3:
                        showCartList();
                        break;
                    case 4:
                        sumOfAllProducts();
                        break;
                    case 5:
                        removeProduct();
                        break;
                    case 6:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
    private String readCartName() {
       // ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cart name:");
        String name = scanner.nextLine();
       // shoppingCart.setName(name);
        return name;
    }

    public void createCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name :");
        String name = scanner.nextLine();
        String findedProduct = cartService.createCart(name);
        System.out.println("Product : " + findedProduct);
    }

    public void showCartList() {
        cartService.getCart();
    }

    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name :");
        String name = scanner.nextLine();
        String findedProduct = cartService.removeProductByName(name);
        System.out.println("Remove product : " + findedProduct);
    }

    public void sumOfAllProducts() {
        System.out.println("Sum of all prices : " + cartService.sumOfCartPrices());
    }
}