package org.example.Service;

import org.example.Exception.ProductException;
import org.example.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
//dependency injection-included SellerService inside of product service and scoped it to the entire class line 13
    SellerService sellerService;
    List<Product> productList;

    public ProductService(SellerService sellerService){
        this.sellerService = sellerService;
        productList = new ArrayList<>();
    }
    public List<Product>getProductList(){
        return productList;
    }
    public Product addProduct(Product p) throws ProductException {
        if(p.getProductName() == null || p.getSellerName() ==null){
            throw new ProductException("Product name and seller name fields must not be null");
        }

        long id = (long) (Math.random() * Long.MAX_VALUE);
        p.setProductID(id);
        productList.add(p);
        return p;

    }

    public Product getProductById(Long id){
        for(int i=0; i < productList.size(); i++){
            Product currentProduct = productList.get(i);
            if(currentProduct.getProductID() == id){
                return currentProduct;
            }

        }
        return null;

    }

}
