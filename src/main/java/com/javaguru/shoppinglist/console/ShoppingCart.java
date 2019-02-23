package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
    public Map<Long, Product> cartList = new HashMap<>();
    private Long id = 0L;
    ProductInMemoryRepository memoryRepository = new ProductInMemoryRepository();

    public void executeShoppingCart() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. add product");
            System.out.println("2. product list");
            System.out.println("3. total cost of all product");
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
                    break;
                case 4:
                    break;
                case 5:
                    return;
            }
        }
    }

    public Product addProduct() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        for(Map.Entry<Long,Product> list:memoryRepository.getDatabase().entrySet()){
            if(list.getValue().getName().equals(name)){
                System.out.println("aaaaaaaa");
                cartList.put(id, list.setValue(product));
            }
        }
        System.out.println(cartList.entrySet());
        return product;
    }

    public void showCartList(){
        System.out.println(cartList.entrySet());
    }

}
