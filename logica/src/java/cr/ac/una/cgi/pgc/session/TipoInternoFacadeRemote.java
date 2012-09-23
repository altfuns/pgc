/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.ac.una.cgi.pgc.session;

import cr.ac.una.cgi.pgc.entity.TipoInterno;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author red
 */
@Remote
public interface TipoInternoFacadeRemote {

    void create(TipoInterno tipoInterno);

    void edit(TipoInterno tipoInterno);

    void remove(TipoInterno tipoInterno);

    TipoInterno find(Object id);

    List<TipoInterno> findAll();

    TipoInterno findByDescripcion(String desc);

}
