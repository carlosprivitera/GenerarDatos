package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class About extends JPanel {
    JLabel labelTitle = new JLabel();
    JLabel labelAuthor = new JLabel();
    JLabel labelCopyright = new JLabel();
    JLabel labelCompany = new JLabel();
    GridBagLayout layoutMain = new GridBagLayout();
    Border border = BorderFactory.createEtchedBorder();

    public About() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( layoutMain );
        this.setBorder( border );
        labelTitle.setText( "Título: Generador de datos" );
        labelAuthor.setText( "Autor: David Beisaga" );
        labelCopyright.setText( "Copyright: Galáctico" );
        labelCompany.setText( "Compañia: Universo" );
        this.add( labelTitle, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 15, 0, 15), 0, 0) );
        this.add( labelAuthor, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0) );
        this.add( labelCopyright, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 0, 15), 0, 0) );
        this.add( labelCompany, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 15, 5, 15), 0, 0) );
    }
}
