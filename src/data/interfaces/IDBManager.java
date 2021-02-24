package data.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDBManager {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
