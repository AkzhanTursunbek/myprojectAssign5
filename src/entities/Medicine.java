package entities;

import java.time.LocalDate;

public class Medicine {
    private int ID;
    private String name;
    private double price;
    private LocalDate expirationDate;
    private String manufacturer;


    public Medicine(int ID, String name, double price, LocalDate expirationDate, String manufacturer) {
        setID(ID);
        setName(name);
        setPrice(price);
        setManufacturer(manufacturer);
        setExpirationDate(expirationDate);

    }
    public Medicine(){

    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID= ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return " \n _______________________ \n" + " Medicine №" +  ID  +
                ",\n \n  name:'" + name + '\'' +
                ",\n \n  price:" + price +
                ",\n \n  expirationDate:" + expirationDate +
                ",\n \n  manufacturer:'" + manufacturer + '\'';
    }
}