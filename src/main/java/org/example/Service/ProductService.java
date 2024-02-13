package org.example.Service;

import org.example.Exception.ProductException;
import org.example.Model.Product;
import org.example.Model.Seller;

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
        if(p.getProductName() == null || p.getSellerName() == null){
            throw new ProductException("Product name and seller name fields must not be null");
        }

        String sellerName = p.getSellerName();

        if(!sellerService.sellerExists(sellerName)){
            throw new ProductException("Seller " + sellerName + " not found");
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

    public void deleteProductByID(Long id){
        for(int i=0; i < productList.size(); i++){
            Product currentProduct = productList.get(i);
            if(currentProduct.getProductID() == id) {
                productList.remove(getProductById(id));
            }
        }

    }

    public void updateProduct(Long id, Product updatedProduct){

        Product productToUpdate = getProductById(id);

        if(productToUpdate !=null) {
            productToUpdate.setProductName(updatedProduct.getProductName());
            productToUpdate.setSellerName(updatedProduct.getSellerName());
            productToUpdate.setProductPrice(updatedProduct.getProductPrice());
        }
    }






}
