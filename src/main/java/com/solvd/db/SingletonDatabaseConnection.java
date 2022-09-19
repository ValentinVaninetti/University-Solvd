package com.solvd.db;

import com.solvd.utils.CommonUtils;
import com.solvd.utils.Constants;
import org.apache.commons.dbcp.BasicDataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SingletonDatabaseConnection {
    private static SingletonDatabaseConnection singletonInstance;
    private static final BasicDataSource dataSource = new BasicDataSource();
    private static String configPath = Constants.CONFIG_PATH;

    private SingletonDatabaseConnection() {
        try {
            dataSource.setDriverClassName(CommonUtils.readPropertiesFile(configPath, "DB_DRIVER"));
            dataSource.setUrl(CommonUtils.readPropertiesFile(configPath, "DB_URL") + CommonUtils.readPropertiesFile(configPath, "DB_NAME"));
            dataSource.setUsername(CommonUtils.readPropertiesFile(configPath, "DB_USERNAME"));
            dataSource.setPassword(CommonUtils.readPropertiesFile(configPath, "DB_PASSWORD"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SingletonDatabaseConnection getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SingletonDatabaseConnection();
            System.out.println("a");
            return singletonInstance;
        }
        System.out.println("b");
        return singletonInstance;

    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}


