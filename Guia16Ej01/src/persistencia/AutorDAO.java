/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Autor;

/**
 *
 * @author cristian
 */
public class AutorDAO extends DAO<Autor>{
    
    @Override
    public void persistirEntidad(Autor object) {
        super.persistirEntidad(object);
    }
    
@Override
    protected void actualizarEntidad(Autor object) {
        super.persistirEntidad(object);
    }

@Override
    protected void borrarEntidad(Autor object) {
        super.persistirEntidad(object);
    }
    
}
