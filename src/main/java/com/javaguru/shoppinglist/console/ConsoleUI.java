package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductCategory;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
    private final ShoppingCartConsoleUI shoppingCart;
    private final ProductService productService;

    public ConsoleUI(ShoppingCartConsoleUI shoppingCart, ProductService productService) {
        this.shoppingCart = shoppingCart;
        this.productService = productService;

    }

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Find by ID");
                System.out.println("2. Create Product");
                System.out.println("3. Exit");
                System.out.println("4. Shopping cart");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        findProduct();
                        break;
                    case 2:
                        createProduct();
                        break;
                    case 3:
                        return;
                    case 4:
                        shoppingCart.executeShoppingCart();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    private String readProductName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        return name;
    }

    private BigDecimal readProductPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product price:");
        String price = scanner.nextLine();
        return new BigDecimal(price);
    }

    private BigDecimal readProductDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product discount:");
        String discount = scanner.nextLine();
        return new BigDecimal(discount);
    }

    private ProductCategory readProductCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product category:");
        String productCategory = scanner.nextLine();
        return ProductCategory.valueOf(productCategory);
    }

    private String readProductDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product description:");
        String description = scanner.nextLine();
        return description;
    }

    public void createProduct() {
        Product product = new Product();
        product.setName(readProductName());
        product.setPrice(readProductPrice());
        product.setDiscount(readProductDiscount());
        product.setProductCategory(readProductCategory());
        product.setDescription(readProductDescription());
        product.discountPrice();
        try {
            Long response = productService.createProduct(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        Product response = productService.findProductbyId(id);
        System.out.println("Response: " + response);
    }
}