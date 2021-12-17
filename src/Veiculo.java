public class Veiculo {

    private int id;
    private String modelo;
     private String placa;

    public Veiculo(int id, String modelo, String placa) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
    }
    public Veiculo( String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    public Veiculo() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Veiculo");
        sb.append("id=").append(id);
        sb.append(", modelo='").append(modelo).append('\'');
        sb.append(", placa='").append(placa).append('\'');
        sb.append('}');
        return sb.toString();
    }
}