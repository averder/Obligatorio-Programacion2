package persistencia;

import dominio.Sistema;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persistencia {
    
    public boolean guardarSistema(Sistema sis) {
        boolean ok = true;
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("salida"));
            out.writeObject(sis);
            out.close();
        } catch (Exception err) {
            ok = false;
        }
        return ok;
    }

    public Sistema cargarSistema() {
        Sistema sis = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("salida"));
            sis = (Sistema) in.readObject();
        } catch (Exception err) {
            sis = new Sistema();
        }
        return sis;
    }
}
