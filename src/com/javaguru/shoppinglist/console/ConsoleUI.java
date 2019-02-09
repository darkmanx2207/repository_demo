package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductCategory;
import com.javaguru.shoppinglist.service.ProductService;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    private ProductService productService = new ProductService();

    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Find by ID");
                System.out.println("2. Create Product");
                System.out.println("3. Exit");
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
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    public void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        String price = scanner.nextLine();
        System.out.println("Enter product discount");
        String discount = scanner.nextLine();
        System.out.println("Enter product category");
        String productCategory = scanner.nextLine();
        System.out.println("Enter product description");
        String description = scanner.nextLine();

        Product product = new Product(new BigDecimal(discount), ProductCategory.valueOf(productCategory), new String(description));

        product.setProductCategory(ProductCategory.valueOf(productCategory));
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(new BigDecimal(discount));
        product.setDescription();
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





















