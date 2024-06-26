package HoterlReserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

    public class Database {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/Trabalho_p3";
            String username = "root";
            String password = "12345678";
            Connection connection = null;
            Statement statement = null;

            try {
                connection = DriverManager.getConnection(url, username, password);

                statement = connection.createStatement();

                String query = "SELECT * FROM Reserva";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String dataCheckIn = resultSet.getString("dataCheckIn");
                    String dataCheckOut = resultSet.getString("dataCheckOut");

                    System.out.println("ID: " + id);
                    System.out.println("Nome: " + nome);
                    System.out.println("Check-in: " + dataCheckIn);
                    System.out.println("Check-out: " + dataCheckOut);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null)
                        statement.close();
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

