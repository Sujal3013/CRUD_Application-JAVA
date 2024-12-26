package code.sujal.dataBaseUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    private static Connection connection=null;

    private DataBaseConnection(){}

    public static Connection getConnection() throws IOException, SQLException {
        if(connection==null){
            FileInputStream fis=new FileInputStream("src/application.properties");
            Properties properties=new Properties();
            properties.load(fis);
            connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
        }
        return connection;
    }
}
