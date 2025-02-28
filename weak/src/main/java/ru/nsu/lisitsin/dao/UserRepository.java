package ru.nsu.lisitsin.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@Slf4j
@Repository
public class UserRepository {

    @Value("${app.database.login}")
    private String databaseUsername;

    @Value("${app.database.password}")
    private String databasePassword;

    @Value("${app.database.url}")
    private String databaseUrl;

    public void save(String login, String password) {
        String insertUserSQL = "INSERT INTO users (login, password) VALUES ('" + login + "', '" + password + "')";

        try (Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(insertUserSQL);

        } catch (SQLException e) {
            log.error("error: {}", e.getMessage());
        }
    }

    public Optional<String> findById(Long userId) {
        String selectUserSQL = "SELECT id, login, password FROM users WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
             PreparedStatement statement = connection.prepareStatement(selectUserSQL)) {

            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(
                        "%d:%s:%s".formatted(
                                resultSet.getLong("id"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        )
                );
            }

        } catch (SQLException e) {
            log.error("error: {}", e.getMessage());
        }

        return Optional.empty();
    }
}
