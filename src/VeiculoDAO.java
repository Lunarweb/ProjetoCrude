import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    public List<Veiculo> list() {
        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = ConexaoVeiculo.getConnection()) {
            String sql = "SELECT * FROM veiculo";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                String placa = rs.getString("placa");

                veiculos.add(new Veiculo(
                        id,
                        modelo,
                        placa
                ));
            }
        } catch (SQLException e) {
            System.out.println("Listagem de veículos falhou!");
            e.printStackTrace();
        }

        return veiculos;
    }


    public Veiculo getById(int id) {

        Veiculo veiculo = new Veiculo();

        try (Connection conn = ConexaoVeiculo.getConnection()) {
            String sql = "SELECT * FROM veiculo WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                veiculo.setId(rs.getInt("id"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
            }

        } catch (SQLException e) {
            System.out.println("Listagem de veículos falhou!");
            e.printStackTrace();
        }

        return veiculo;
    }

    public void create(Veiculo veiculo) {
        try (Connection conn = ConexaoVeiculo.getConnection()) {

            String sql = "INSERT INTO veiculo(modelo, placa) VALUES( ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção bem sucedida!. Foi adicionada " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Inserção falhou!");
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = ConexaoVeiculo.getConnection()) {

            String sql = "DELETE FROM veiculo WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1 , id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete bem sucedido! Foi deletado " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Delete falhou!");
            e.printStackTrace();
        }
    }


    public void update(Veiculo veiculo) {
        try (Connection conn = ConexaoVeiculo.getConnection()) {

            String sql = "UPDATE veiculo SET modelo = ?, placa = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, veiculo.getModelo());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setInt(3, veiculo.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização bem sucedida! Foi atualizada: " + rowsAffected + " linha");
        } catch (SQLException e) {
            System.out.println("Atualização falhou!");
            e.printStackTrace();
        }
    }

}
