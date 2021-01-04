package Model.DAO;

import Model.DAO.impl.Departamento_dao_JDBC;
import Model.DAO.impl.Vendedor_dao_JDBC;
import db.DB;

public class Fabrica_dao {

    public Fabrica_dao() {
    }
        
    public static Vendedor_dao_JDBC createVendedorDao(){
        return new Vendedor_dao_JDBC(DB.getConnection()) ;
    }
    public static Departamento_dao_JDBC createDepartmentDao(){
        return new Departamento_dao_JDBC(DB.getConnection());
    }
}
