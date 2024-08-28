
package transaccionjdbc.test;

import java.sql.Connection;
import manejojdbc.datos.Conexion;
import transaccionjdbc.datos.ConexionTransaccion;
import transaccionjdbc.datos.PersonaDaoTransaccion;

public class testManejoPersonas {

    PersonaDaoTransaccion personaJdbc = new PersonaDaoTransaccion();
    Connection conexion = ConexionTransaccion.getConection();
    
}
