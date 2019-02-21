package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductDescriptionValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductPriceValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductUniqueNameValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.util.HashSet;
import java.util.Set;

class ShoppingListApplication {

    public static void main(String[] args) {
        ProductInMemoryRepository repository = new ProductInMemoryRepository();

        ProductValidationRule productNameValidationRule = new ProductNameValidationRule();
        ProductValidationRule productUniqueValidationRule = new ProductUniqueNameValidationRule(repository);
        ProductValidationRule productDescriptionValidationRule = new ProductDescriptionValidationRule();
        ProductValidationRule productDiscountValidationRule = new ProductDiscountValidationRule();
        ProductValidationRule productPriceValidationRule = new ProductPriceValidationRule();

        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(productNameValidationRule);
        rules.add(productUniqueValidationRule);
        rules.add(productDescriptionValidationRule);
        rules.add(productDiscountValidationRule);
        rules.add(productPriceValidationRule);

        ProductValidationService validationService = new ProductValidationService(rules);
        ProductService productService = new ProductService(repository, validationService);

        ConsoleUI ui = new ConsoleUI(productService);
        ui.execute();
    }
}