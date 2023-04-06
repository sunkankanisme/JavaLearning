package com.sunk.phoenixtest;

import java.sql.*;
import java.util.Properties;

/**
 * @author sunk
 * @since 2023/1/15
 **/
public class PhoenixTest {


    public static void main(String[] args) {
        try {
            final Properties properties = new Properties();

            properties.setProperty("phoenix.schema.isNamespaceMappingEnabled", "true");
            properties.setProperty("phoenix.schema.mapSystemTablesToNamespace", "true");

            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            final Connection connection = DriverManager.getConnection("jdbc:phoenix:hadoop101,hadoop102,hadoop103:2181", properties);

            System.out.println("START SQL CREATE TABLE ...");
            final PreparedStatement preparedStatement = connection.prepareStatement("create table if not exists GMALL_REALTIME.phoenix_test(id varchar primary key, name varchar)");
            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("START SQL INSERT VALUES ...");
            final PreparedStatement preparedStatement1 = connection.prepareStatement("upsert into GMALL_REALTIME.phoenix_test values ('" + System.currentTimeMillis() + "', 'zhangsan')");
            preparedStatement1.execute();
            connection.commit();
            preparedStatement1.close();

            System.out.println("START SQL QUERY ...");
            String sql = "select * from GMALL_REALTIME.phoenix_test limit 10";
            final PreparedStatement statement = connection.prepareStatement(sql);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("id: %s, name: %s\n", resultSet.getString((1)), resultSet.getString((2)));
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
