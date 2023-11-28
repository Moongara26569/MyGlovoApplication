import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RestauranteDAO extends Restaurante{

    private MotorSQL motorSql;

    public RestauranteDAO() {
        this.motorSql = new MotorSQL();
    }

    public ArrayList<Restaurante> findAll(String SQL) {
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        this.motorSql.connect();

        try (ResultSet resultSet = this.motorSql.executeQuery(SQL)) {

            while (resultSet.next()) {
                int idRestaurante = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String desc = resultSet.getString("descripcion");
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
