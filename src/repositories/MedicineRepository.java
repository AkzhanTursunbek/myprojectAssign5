package repositories;

import data.interfaces.IDBManager;
import entities.Medicine;
import repositories.interfaces.IMedicineRepository;

import java.sql.*;
import java.util.ArrayList;

public class MedicineRepository implements IMedicineRepository {
    private final IDBManager dbManager;


    public MedicineRepository(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Medicine> searchMedicineByName(String name) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines WHERE name LIKE '%" + name + "%';");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> medicines = new ArrayList<>();

            while (resultSet.next()) {
                Medicine medicine = new Medicine(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expiration_date").toLocalDate(),
                        resultSet.getString("manufacturer"));

                medicines.add(medicine);
            }

            return medicines;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Medicine getMedicineById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Medicine medicine = new Medicine();

            if (resultSet.next()) {
                medicine.setID(resultSet.getInt("id"));
                medicine.setName(resultSet.getString("name"));
                medicine.setPrice(resultSet.getDouble("price"));
                medicine.setExpirationDate(resultSet.getDate("expiration_date").toLocalDate());
                medicine.setManufacturer(resultSet.getString("manufacturer"));

            }

            return medicine;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addMedicine(Medicine medicine) {
        Connection con = null;
        try {
            con = dbManager.getConnection();
            String sql = "INSERT INTO medicines(id, name,price,expiration_date,manufacturer) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, medicine.getID());
            st.setString(2, medicine.getName());
            st.setDouble(3, medicine.getPrice());
            st.setDate(4, Date.valueOf(medicine.getExpirationDate()));
            st.setString(5, medicine.getManufacturer());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeMedicineById(int id) {

        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("DELETE FROM medicines WHERE id=?");

            ps.setInt(1, id);

            ps.execute();

            return true;

        } catch ( SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                assert con == null;
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public ArrayList showAllMedicines() {


        Connection con = null;

        try {
            con = dbManager.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM medicines");
            ResultSet resultSet = ps.executeQuery();
            ArrayList<Medicine> medicines = new ArrayList<>();

            while (resultSet.next()) {
                Medicine medicine = new Medicine(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expiration_date").toLocalDate(),
                        resultSet.getString("manufacturer"));

                medicines.add(medicine);
            }
            return medicines;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public ArrayList<Medicine> searchMedicineByManufacturer(String manufacturer) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines WHERE manufacturer=?");
            preparedStatement .setString(1, manufacturer);
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> medicines = new ArrayList<>();

            while (resultSet.next()) {
                Medicine medicine = new Medicine(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expiration_date").toLocalDate(),
                        resultSet.getString("manufacturer"));

                medicines.add(medicine);
            }

            return medicines;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}