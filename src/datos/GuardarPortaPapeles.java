package datos;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import java.awt.datatransfer.StringSelection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class GuardarPortaPapeles {
    private JTable tabla = null;
    private StringBuffer bfw = null;
    private Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
    private StringSelection ss = null;
    public GuardarPortaPapeles(JTable tabla) {
        super();
        this.tabla = tabla;
    }
    public void guardaTabla(){
            bfw=new StringBuffer("");
            try {
                for (int i = 0 ; i < tabla.getRowCount(); i++) {
                    for(int j = 0 ; j < tabla.getColumnCount();j++) {
                       // bfw = bfw + tabla.getValueAt(i,j);
                        bfw.append(tabla.getValueAt(i,j));
                        if (j < tabla.getColumnCount() -1) { 
                           // bfw = bfw + "\t";
                            bfw.append("\t");
                        }
                    }
                    //bfw = bfw + "\r" + "\n"; 
                    bfw.append("\r" + "\n");
                }
                ss = new StringSelection(bfw.toString());
                cb.setContents(ss, ss);

                JOptionPane.showMessageDialog(null, "Se ha copiado en el porta papeles, pegar en Excel...", "Copiado al porta papeles" ,JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
}
