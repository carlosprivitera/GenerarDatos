package datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class GuardarArchivoTXT {
    JTable tabla = null;
    public GuardarArchivoTXT(JTable tabla) {
        super();
        this.tabla = tabla;
    }
    public void guardaTabla(){
        File miArchivo = new File("archivoTXT.csv");
        String archivoTXT = miArchivo.getPath();
        String caminoTXT = miArchivo.getAbsolutePath();
        
            try {
                BufferedWriter bfw = new BufferedWriter(new FileWriter(archivoTXT));
                for (int i = 0 ; i < tabla.getRowCount(); i++) 
                {
                    for(int j = 0 ; j < tabla.getColumnCount();j++) 
                    {
                        bfw.write((String)(tabla.getValueAt(i,j)));
                        if (j < tabla.getColumnCount() -1) { 
                            bfw.write(";");
                        }
                    }
                    bfw.newLine(); 
                }

                bfw.close(); 
                JOptionPane.showMessageDialog(null, "Se ha guardado en: " + caminoTXT, "Archivo guardado", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error:" + e.getMessage() + " - " + archivoTXT, "Error al guardar", JOptionPane.ERROR_MESSAGE);
            }
        }
}
