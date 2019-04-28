package datos;

import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GenerarErrores {
    private Random rndX = new Random();
    JTable tabla = null;
    private DefaultTableModel modelo = null;
    public GenerarErrores(JTable tabla) {
        super();
        this.tabla = tabla;
        modelo = (DefaultTableModel)this.tabla.getModel();
    }
    public void generarErrores(String ch1, String ch2, int porVista) {
        String s1 = ch1;
        String s2 = ch2;
        int por = porVista;
        int xpor = rndX.nextInt(100);
        String bfw = new String("");
        try {
            for (int i = 0 ; i < modelo.getRowCount(); i++) {
                xpor = rndX.nextInt(100);
                if(xpor<por) {  
                  for(int j = 1 ; j < modelo.getColumnCount();j++) {
                    bfw = "" + modelo.getValueAt(i,j);
                    bfw = bfw.replaceAll(s1, s2);
                    modelo.setValueAt(bfw, i, j);
                  }
                }  
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error:" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }    
    }
}
