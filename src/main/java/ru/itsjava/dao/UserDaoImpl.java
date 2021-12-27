package ru.itsjava.dao;

import lombok.AllArgsConstructor;
import ru.itsjava.domain.User;
import ru.itsjava.utils.Props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@AllArgsConstructor
public class UserDaoImpl implements UserDao{
    private  final Props props;

    @Override
    public User findByNameAndPassword(String name, String password) {
        try (Connection connection = DriverManager.getConnection(
                props.getValue("db.url"),
                props.getValue("db.login"),
                props.getValue("db.password"))
        ){
            PreparedStatement preparedStatement = connection.prepareStatement("");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
