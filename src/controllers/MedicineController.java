package controllers;

import entities.Medicine;
import repositories.interfaces.IMedicineRepository;

import java.time.LocalDate;
import java.lang.NullPointerException;
import java.util.ArrayList;


public class MedicineController {
    private final IMedicineRepository medicineRepository;

    public MedicineController(IMedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public String searchMedicineByName(String name) {
        String result = medicineRepository.searchMedicineByName(name).toString();

        return result;
    }

    public String getMedicineById(int id) {
        String result = medicineRepository.getMedicineById(id).toString();

        return result;
    }

    public String removeMedicineById(int id) {
        boolean removed = medicineRepository.removeMedicineById(id);

        if (removed) {
            return "Medicine was removed!";
        }

        return "Medicine was not removed!";
    }

    public String addMedicine(int id , String name, double price,String ex_date, String manufacturer) {
        LocalDate expirationDate = LocalDate.parse(ex_date);
        Medicine medicine=new Medicine(id, name,price,expirationDate,manufacturer);
        boolean added = medicineRepository.addMedicine(medicine);

        if (added) {
            return "Medicine was added!";
        }

        return "Medicine was not added!";

    }

    public ArrayList<Medicine>  showAllMedicines() {
        ArrayList<Medicine> medicines = new ArrayList<>();
        medicines=medicineRepository.showAllMedicines();
        return medicines;
    }

    public String searchMedicineByManufacturer(String manufacturer) {
        String result = medicineRepository.searchMedicineByManufacturer(manufacturer).toString();

        return result;
    }

}

