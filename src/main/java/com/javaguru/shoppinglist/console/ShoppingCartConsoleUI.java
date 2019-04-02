package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.CartService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ShoppingCartConsoleUI {
    private final CartService cartService;
    private final AssignProduct assignProduct;

    public ShoppingCartConsoleUI(CartService cartService, AssignProduct assignProduct) {
        this.cartService = cartService;
        this.assignProduct = assignProduct;
    }

    void executeShoppingCart() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. create shopping cart");
                System.out.println("2. add product");
                System.out.println("3. show shopping cart");
                System.out.println("4. total cost of products in cart");
                System.out.println("5. assign product to shoppingCart");
                System.out.println("6. remove cart");
                System.out.println("7. exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        createCartWithProduct();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        showCart();
                        break;
                    case 4:
                        sumOfProductsInCart();
                        break;
                    case 5:
                        assignProduct.executeAssignProduct();
                        break;
                    case 6:
                        removeCart();
                        break;
                    case 7:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private void createCartWithProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cart name:");
        String cartName = scanner.nextLine();
        shoppingCart.setName(cartName);
        Long response = cartService.createCart(shoppingCart);
        System.out.println("Shopping carts: " + response);
    }

    private void addProduct() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("enter cart name where you want put product");
        String name = scanner.nextLine();
        ShoppingCart shoppingCart = cartService.findCartByName(name);
        System.out.println("enter product name");
        String productName = scanner2.nextLine();
        cartService.addProductInCart(productName, shoppingCart);
    }

    private void showCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. show all carts");
        System.out.println("2. choose cart from name");
        System.out.println("3. exit");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                showAllCarts();
                break;
            case 2:
                showCartByName();
                break;
            case 3:
        }
    }

    private void showAllCarts() {
        cartService.showCarts();
    }

    private void showCartByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        ShoppingCart response = cartService.findCartByName(name);
        System.out.println("Response: " + response);
    }

    private void sumOfProductsInCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cart name: ");
        String name = scanner.nextLine();
        ShoppingCart shoppingCart = cartService.findCartByName(name);
        cartService.getPrice(shoppingCart);
    }

    private void removeCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cart name ");
        String name = scanner.nextLine();
        cartService.removeCartByName(name);
    }
}