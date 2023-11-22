/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO extends Usuario{
    private static final String SQL_FIND_ALL = "SELECT  *  FROM USER WHERE ";

    private MotorSQL motorSql;

    public UserDAO() {

        this.motorSql = new MotorSQL();
    }

    public boolean findAll(Usuario bean) {
        boolean bool = true;
         this.motorSql.connect();
        String sql = SQL_FIND_ALL
            + "nombre= " +"'" +bean.getNombre()+"'"  + " AND pass like " + "'%" +bean.getPassword()+"%'";

        System.out.println("SQL-> " + sql);
        ResultSet rs = this.motorSql.executeQuery(sql);
        try {
            if (!rs.next()){ // la exclamacion hace que te devuelva un booleano en caso de que esté vacio o no
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
