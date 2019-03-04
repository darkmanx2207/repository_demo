package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.CartService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ShoppingCartConsoleUI {
    private final CartService cartService;
    private ShoppingCart shoppingCart;
   // ShoppingCart shoppingCart = new ShoppingCart();
    //Product product = new Product();

    public ShoppingCartConsoleUI(CartService cartService, ShoppingCart shoppingCart) {
        this.cartService = cartService;
        this.shoppingCart = shoppingCart;
    }

    public void executeShoppingCart() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. create shopping cart");
                System.out.println("2. add product");
                System.out.println("3. show shopping cart");
                System.out.println("4. total cost of all prod1ucts");
                System.out.println("5. remove product from cart");
                System.out.println("6. exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        createCart();
                        break;
                    case 2:
                       addProduct();
                        break;
                    case 3:
                        showCart();
                        break;
                    case 4:

                        //  sumOfAllProducts();
                        break;
                    case 5:
                        //  removeProduct();
                        break;
                    case 6:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }


    private void createCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cart name:");
        String cartName = scanner.nextLine();
        shoppingCart.setName(cartName);
        Long response = cartService.createCart(shoppingCart);
        System.out.println("Shopping carts: " + response);
    }

    public void addProduct() {
        Product product = new Product();
       // ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name :");
        String productName = scanner.nextLine();
         cartService.addProductInCart(productName,product);

        // System.out.println("Product name : " + name );
    }


    public void showCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. show all carts");
        System.out.println("2. choose cart from id");
        System.out.println("3. exit");
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                //  showAllCarts();

                break;
            case 2:
                showCartById();
                break;
            case 3:

                return;
        }
    }

    // public void showAllCarts() {
    //    //ShoppingCart shoppingCart = new ShoppingCart();
    //   System.out.println(cartService.showCarts());
    // }

    public void showCartById() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        int id = scanner.nextInt();
        //   Object aaa = cartService.findCartById(id);
        //  System.out.println("Response: " + aaa);
    }
}













/*
        public void removeProduct () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter product id :");
            Long id = scanner.nextLong();
            Product findedProduct = cartService.removeProductByName(id);
            System.out.println("Enter product name :");
            String name = scanner.nextLine();
            String findedProduct = cartService.removeProductByName(name);
            System.out.println("Remove product : " + findedProduct);
        }


        public BigDecimal sumOfAllProducts () {
        }
    }*/




