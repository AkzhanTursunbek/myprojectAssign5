package com.company;

import controllers.MedicineController;
import data.DBManager;
import data.interfaces.IDBManager;
import repositories.MedicineRepository;
import repositories.interfaces.IMedicineRepository;

public class Main {
    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IMedicineRepository medicineRepository = new MedicineRepository(dbManager);
        MedicineController medicineController = new MedicineController(medicineRepository);
        MyApplication myApplication = new MyApplication(medicineController);
        myApplication.start();
    }
}

