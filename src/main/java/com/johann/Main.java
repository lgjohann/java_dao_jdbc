package com.johann;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findByID ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(department);
        for(Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");

        sellers = sellerDao.findAll();
        for(Seller obj : sellers) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "a@gmail.com", new Date(), 4000.00, department);

        sellerDao.insert(newSeller);
        System.out.println("Inserted New id = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Test");
        sellerDao.update(seller);
        System.out.println("Update completed!");

    }
}