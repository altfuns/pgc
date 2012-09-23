package ModuloAdministracion;

import cr.ac.una.cgi.pgc.entity.GrupoEnvio;
import cr.ac.una.cgi.pgc.session.GrupoEnvioFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

public class GrupoEnvioFacadeManaged {
    @EJB
    private GrupoEnvioFacadeRemote grupoEnvioFacade;

    public GrupoEnvioFacadeManaged() {
    }

    public ArrayList<SelectItem> getOpcionesGruposEnvio(){
        ArrayList<SelectItem> opciones = new ArrayList<SelectItem>();
        try{
           List<GrupoEnvio> grupos = grupoEnvioFacade.findAll();
           for(GrupoEnvio auxGrupo : grupos)
               opciones.add(new SelectItem(auxGrupo, auxGrupo.getNombre()));
        }
        catch(Exception e){
        }

        return opciones;
    }

    public ArrayList<GrupoEnvio> getGruposEnvio(){
        ArrayList<GrupoEnvio> auxGrupos = new ArrayList<GrupoEnvio>();
        try{
            List<GrupoEnvio> grupos = grupoEnvioFacade.findAll();
            auxGrupos.addAll(grupos);
        }
        catch(Exception e){
        }

        return auxGrupos;
    }

}