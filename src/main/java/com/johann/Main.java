package com.johann;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

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


    }
}