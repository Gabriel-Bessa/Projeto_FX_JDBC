package Model.service;

import Model.entities.Departamento;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoService {
    
    public List<Departamento> findAll(){
        List<Departamento> list = new ArrayList<>();
        
        list.add(new Departamento(1, "Computadores"));
        list.add(new Departamento(2, "Moda"));
        list.add(new Departamento(3, "Comida"));
        list.add(new Departamento(4, "Eletrônicos"));
        
        return list;
    }
    
}
