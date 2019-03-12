package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductCategory;
import com.javaguru.shoppinglist.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final ProductService productService;
    private final ShoppingCartConsoleUI shoppingCartConsoleUI;

    @Autowired
    public ConsoleUI(ProductService productService, ShoppingCartConsoleUI shoppingCartConsoleUI) {
        this.productService = productService;
        this.shoppingCartConsoleUI = shoppingCartConsoleUI;
    }

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Find by ID");
                System.out.println("2. Create Product");
                System.out.println("3. Create Shopping cart");
                System.out.println("4. Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        findProduct();
                        break;
                    case 2:
                        createProduct();
                        break;
                    case 3:

                        shoppingCartConsoleUI.executeShoppingCart();
                    case 4:
                        return;
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

    private void createProduct() {
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

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long id = scanner.nextLong();
        Product response = productService.findProductById(id);
        System.out.println("Response: " + response);
    }
}