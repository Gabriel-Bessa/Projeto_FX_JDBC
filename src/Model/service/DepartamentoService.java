package Model.service;

import Model.DAO.Departamento_dao;
import Model.DAO.Fabrica_dao;
import Model.entities.Departamento;
import java.util.List;

public class DepartamentoService {
    
    private Departamento_dao dao = Fabrica_dao.createDepartmentDao();
    
    public List<Departamento> findAll(){
        return dao.findAll();
    }
    
}
