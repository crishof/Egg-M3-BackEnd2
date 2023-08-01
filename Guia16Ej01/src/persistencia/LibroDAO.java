/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Libro;

/**
 *
 * @author cristian
 */
public class LibroDAO extends DAO<Libro>{
    
        @Override
    public void persistirEntidad(Libro object) {
        super.persistirEntidad(object);
    }
    
@Override
    protected void actualizarEntidad(Libro object) {
        super.persistirEntidad(object);
    }

@Override
    protected void borrarEntidad(Libro object) {
        super.persistirEntidad(object);
    }
    
}
