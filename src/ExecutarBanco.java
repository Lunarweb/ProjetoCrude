import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExecutarBanco {

    public static void main(String[] args) {


        VeiculoDAO veiculoDAO = new VeiculoDAO();

        List<Veiculo> veiculos = veiculoDAO.list();

        veiculos.stream().forEach(System.out::println);


        Veiculo veiculoParaInsercao = new Veiculo("Volvo", "fvo2021");
        veiculoDAO.create(veiculoParaInsercao);

        Veiculo veiculoParaAtualizar = veiculoDAO.getById(1);
        veiculoParaAtualizar.setModelo("Meriva");
        veiculoParaAtualizar.setPlaca("PSO1298");
        veiculoDAO.update(veiculoParaAtualizar);

        veiculoDAO.delete(1);


    }

}