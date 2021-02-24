package com.company;

import controllers.MedicineController;
import entities.Medicine;

import java.util.ArrayList;
import java.util.Scanner;

public class MyApplication {
    private final MedicineController medicineController;
    private final Scanner scanner;

    public MyApplication(MedicineController medicineController) {
        this.medicineController = medicineController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Choose one option:\n 1) Add new medicine\n 2) Search for any medicine by id\n 3) Search for any medicine by name\n 4) Remove medicine\n 5) Show all medicines\n "+ "6) Search for any medicine by manufacturer\n"
            + " 0) Exit\n");
            int choice = scanner.nextInt();

            if (choice == 1) {
                addMedicineMenu();
            } else if (choice == 2) {
                getMedicineByIdMenu();
            } else if (choice == 3) {
                searchMedicineByNameMenu();
            } else if (choice == 4) {
                removeMedicineByIdMenu();
            } else if (choice == 5) {
                showAllMedicines();
            }
                else if (choice == 6) {
                    searchMedicineByManufacturer();

                } else {
                break;
            }

            System.out.println("____________________________");
        }
    }



    public void searchMedicineByNameMenu() {
        System.out.println("Write the name of medicine!");
        String name = scanner.next();
        String result = medicineController.searchMedicineByName(name);
        System.out.println(result);
    }

    public void getMedicineByIdMenu() {
        System.out.println("Write the id of medicine!");
        int id = scanner.nextInt();
        String result = medicineController.getMedicineById(id);
        System.out.println(result);
    }

    public void addMedicineMenu() {
        System.out.println("Write medicine's id");
        int id = scanner.nextInt();
        System.out.println("Write medicine's name");
        String name = scanner.next();
        System.out.println("Write medicine's price!");
        double price = scanner.nextDouble();
        System.out.println("Write medicine's manufacturer");
        String manufacturer = scanner.next();
        System.out.println("Write expiration date");
        String ex_date = scanner.next();


        String result;
        result = medicineController.addMedicine(id, name, price, ex_date, manufacturer);

        System.out.println(result);
    }

    public void removeMedicineByIdMenu() {
        System.out.println("Write medicine's id!");
        int id = scanner.nextInt();

        String result = medicineController.removeMedicineById(id);

        System.out.println(result);
    }

    public void showAllMedicines(){

        ArrayList<Medicine> result = medicineController.showAllMedicines();
        System.out.println("The list of medicines:");
        System.out.println(result);

    }
    public void searchMedicineByManufacturer() {
        System.out.println("Write the manufacturer of medicine!");
        String manufacturer = scanner.next();
        String result = medicineController.searchMedicineByManufacturer(manufacturer);
        System.out.println(result);
    }

}

