package users;

import users.model.User;

import javax.net.ssl.SSLContext;
import javax.swing.text.html.StyleSheet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserRepository {
    //get All user
    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/social_media",
                        "postgres",
                        "123");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                )
        {
            while (resultSet.next()){
                userList.add(
                        new User(
                                resultSet.getInt("user_id"),
                                resultSet.getString("user_uuid"),
                                resultSet.getString("user_name"),
                                resultSet.getString("user_email"),
                                resultSet.getString("user_password"),
                                resultSet.getDate("created_date"),
                                resultSet.getBoolean("is_deleted")
                        )
                );
            }
            return userList;
        }catch (SQLException sqlException){
            System.out.println("Problem during getting all users: " + sqlException.getMessage());
        }
        return null;
    }
    public int deleteUserUuid(String uuid){
        String sql = "DELETE FROM users where user_uuid = ?";
        try(
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/social_media",
                        "postgres",
                        "123");
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

        )
        {
            preparedStatement.setString(1,uuid);
            System.out.print("> Do you want to commit (y/n): ");
            String isCommitted = new Scanner(System.in).nextLine();
            connection.setAutoCommit(isCommitted.equalsIgnoreCase("y"));
            return preparedStatement.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println("Problem during deleting user: " + sqlException.getMessage());
        }
        return 0;
    }
}
