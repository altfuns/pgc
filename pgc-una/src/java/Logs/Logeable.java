/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Logs;

/**
 *
 * @author alfonso
 */
public interface Logeable {
    /**
     * Contruye el la sentencia INSERT con los datos que tenga la clase Logeable
     * @return
     * Cadena de caractares que representan la sentencia SQL de insertar el bean
     */
    public String getInsertString();
    /**
     * Contruye  la sentencia DELETE con los datos que tenga la clase Logeable
     * @return
     * Cadena de caractares que representan la sentencia SQL de borrar el bean
     */
    public String getDeleteString();
    /**
     * Contruye  la sentencia UPDATE con los datos que tenga la clase Logeable
     * @return
     * Cadena de caractares que representan la sentencia SQL de actualizar el bean
     */
    public String getUpdateString();
    /**
     * Obtener la tabla sobre la que el bean maneja los datos
     * @return
     * Cadena de caractares que representan el nombre de la tabla
     */
    public String getTablaString();  
}
