package com.sunk.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author sunk
 * @since 2023/4/6
 */
public class C3p0Test {

    public static void main(String[] args) throws SQLException {
        final ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

        final Connection connection = dataSource.getConnection();

        final PreparedStatement statement = connection.prepareStatement("show databases");
        final ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

        resultSet.close();
        statement.close();
        connection.close();
        dataSource.close();
    }

}
