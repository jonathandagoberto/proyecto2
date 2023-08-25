import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class LeerArchivo {

    public void lectura(String archivo, int al[]) {
        try {
            BufferedReader lectura = new BufferedReader(new FileReader(archivo));
            String leerLinea = lectura.readLine();            
            int i=0;
            while (leerLinea != null) {    
                int aux=Integer.valueOf(leerLinea);            
                al[i]=aux;
                leerLinea = lectura.readLine();
                i++;
            }            
        } catch (FileNotFoundException e) {
            System.out.println("El Archivo solicitado no ha sido encontrado: " + e.getMessage());
        } catch (IOException IOe) {
            System.out.println("El Archivo solicitado no se pudo abrir o cerrar" + IOe.getMessage());
        }
    }

}
