package com.cocky.jdbc;


import java.sql.*;

public class MysqlClient {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test? user=root&password=root");
            preparedStatement = connection.prepareStatement("SELECT model_id,model_name FROM jc_model", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            resultSet = preparedStatement.executeQuery();
            while (!resultSet.isLast()) {
                resultSet.next();
                System.out.println(resultSet.getString("model_id") + "|" + resultSet.getString("model_name"));
            }
            resultSet.absolute(4);
            System.out.println(resultSet.getString("model_id") + "|" + resultSet.getString("model_name"));
            resultSet.updateString("model_name", "wechat");
            resultSet.updateRow();
            System.out.println(resultSet.getString("model_id") + "|" + resultSet.getString("model_name"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
