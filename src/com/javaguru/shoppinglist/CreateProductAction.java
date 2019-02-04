package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;

    }

    @Override
    public void execute() {
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
        ProductValidationService productValidationService = new ProductValidationService();

        product.setProductCategory(ProductCategory.valueOf(productCategory));
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setDiscount(new BigDecimal(discount));
        product.setDescription();
        product.discountPrice();

        try {
            Long response = productService.create(product);
            productValidationService.checkTest(product);
            System.out.println("Response: " + response);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
