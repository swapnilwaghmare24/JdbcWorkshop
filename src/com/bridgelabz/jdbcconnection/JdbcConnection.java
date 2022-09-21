package com.bridgelabz.jdbcconnection;

import java.sql.*;

public class JdbcConnection
{
    public void connection()
    {
        String jdbcPath="jdbc:mysql://localhost:3306/addressbook";
        String userName="root";
        String password="root";
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(jdbcPath,userName,password);
            Statement st=con.createStatement();
            ResultSet resultSet=st.executeQuery("select * from myaddressbook");
            while (resultSet.next())
            {
                System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)
                +"\t"+resultSet.getString(4));
            }

           //PreparedStatement ps=con.prepareStatement("update myaddressbook set city=+""culcutta"+"where name="swapnil");

        } catch (ClassNotFoundException e) {
            System.out.println("unable to load driver");
        } catch (SQLException e) {
            System.out.println("connection to database failed");
        }
    }
}
