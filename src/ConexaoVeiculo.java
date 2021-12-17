import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoVeiculo {
        private ConexaoVeiculo() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {

        Connection connection = null;


        try (InputStream input = ConexaoVeiculo.class.getClassLoader().getResourceAsStream("Propriedades")) {

            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");


            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();


            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
            } catch (SQLException e) {
                System.out.println("FALHA ao tentar criar conexão");
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println("FALHA ao tentar carregar aquivos de propriedades");
            e.printStackTrace();
        }

        return connection;
    }
}