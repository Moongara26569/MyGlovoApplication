import java.sql.ResultSet;
import java.sql.SQLException;

public class PropietarioDAO extends Propietario{
    private static final String SQL_FIND_ALL = "SELECT  *  FROM PROPIETARIO WHERE ";

    private static MotorSQL motorSql;

    public PropietarioDAO() {

        this.motorSql = new MotorSQL();
    }

    public boolean find(Propietario bean) {
        boolean bool = true;
        this.motorSql.connect();
        String sql = SQL_FIND_ALL
                + "nombre= " +"'" +bean.getNombre()+"'"  + " AND pass like " + "'%" +bean.getPassword()+"%'";

        System.out.println("SQL-> " + sql);
        ResultSet rs = this.motorSql.executeQuery(sql);
        try {
            if (!rs.next()){
                bool= false;
            }else{
                bool= true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            motorSql.disconnect();
        }
        return bool;
    }
}
