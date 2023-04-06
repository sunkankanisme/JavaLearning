package com.sunk.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author sunk
 * @since 2023/4/6
 */
public class DruidTest {

    public static void main(String[] args) throws Exception {
        final Properties properties = new Properties();
        properties.load(DruidTest.class.getResourceAsStream("/druid.properties"));


        final DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        final Connection connection = dataSource.getConnection();

        final PreparedStatement statement = connection.prepareStatement("show databases");
        final ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

}
