package org.example;

import io.javalin.Javalin;
import org.example.Controller.ProductController;
import org.example.Service.ProductService;
import org.example.Service.SellerService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SellerService sellerService = new SellerService();
        ProductService productService = new ProductService(sellerService);
        ProductController productController = new ProductController(sellerService, productService);
        Javalin api = productController.getAPI();
        api.start(9013);

    }
}