package org.example.Service;

import org.example.Exception.SellerException;
import org.example.Model.Seller;

import java.util.ArrayList;
import java.util.List;

public class SellerService {

    List<Seller> sellerList;

    public SellerService(){
        this.sellerList = new ArrayList<>();
    }

    public List<Seller>getSellerList(){
        return sellerList;
    }

    public void addSeller(Seller newSeller) throws SellerException {
        for (Seller existing : sellerList) {
            System.out.println("Existing: " + existing.getName());
            if (existing.getName().equals(newSeller.getName())){
                System.out.println("Duplicate found");
                throw new SellerException("Seller name already exists");
            }
        }
        sellerList.add(newSeller);

    }

    public boolean sellerExists(String name){
        for (Seller seller : sellerList){
            if(seller.getName().equals(name)){
                return true;
            }
        }
        return false;
    }


}

