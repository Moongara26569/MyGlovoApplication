import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestauranteDAO extends Restaurante{

    private MotorSQL motorSql;

    public RestauranteDAO() {
        this.motorSql = new MotorSQL();
    }

    public ArrayList<Restaurante> findAll() {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        this.motorSql.connect();
        String sql = "SELECT * FROM RESTAURANTES WHERE 1=1";
        try (ResultSet resultSet = this.motorSql.executeQuery(sql)) {

            while (resultSet.next()) {
                int idRestaurante = resultSet.getInt("idRestaurante");
                String nombre = resultSet.getString("nombre");
                String desc = resultSet.getString("desc");
                String tlfn = resultSet.getString("tlfn");
                String categoria = resultSet.getString("categoria");

                Restaurante restaurante = new Restaurante(idRestaurante, nombre, desc, tlfn, categoria);
                restaurantes.add(restaurante);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return restaurantes;
    }
    public RestauranteDAO(int idRestaurante, String nombre, String desc, String tlfn, String categoria) {
        super(idRestaurante, nombre, desc, tlfn, categoria);
    }
}
