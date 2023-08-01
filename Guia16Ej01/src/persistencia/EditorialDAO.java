/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Editorial;

/**
 *
 * @author cristian
 */
public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void persistirEntidad(Editorial object) {
        super.persistirEntidad(object);
    }

    @Override
    protected void actualizarEntidad(Editorial object) {
        super.persistirEntidad(object);
    }

    @Override
    protected void borrarEntidad(Editorial object) {
        super.persistirEntidad(object);
    }

}
