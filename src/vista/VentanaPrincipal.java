package vista;

import datos.Tabla;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaPrincipal extends JFrame {
    /**
     * @aggregation composite
     * @label muestra
     */
    private Sobre vp_About =  new Sobre();

    /**
     * @aggregation shared
     * @label muestra
     */
    private Tabla tabla = null;
    BorderLayout layoutMain = new BorderLayout();
    JPanel panelCenter = new JPanel();
    JMenuBar menuBar = new JMenuBar();
    JMenu archivo = new JMenu();
    JMenuItem menuFileExit = new JMenuItem();
    JMenu menuHelp = new JMenu();
    JMenuItem menuHelpAbout = new JMenuItem();
    JToolBar toolBar = new JToolBar();
    ImageIcon imageOpen = new ImageIcon(VentanaPrincipal.class.getResource("openfile.gif"));
    ImageIcon imageClose = new ImageIcon(VentanaPrincipal.class.getResource("closefile.gif"));
    ImageIcon imageHelp = new ImageIcon(VentanaPrincipal.class.getResource("help.gif"));
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable jTable1 = new JTable();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JButton jButton1 = new JButton();
    private JSpinner jSpinner1 = new JSpinner();
    private JSpinner jSpinner2 = new JSpinner();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JSeparator jSeparator1 = new JSeparator();
    private JSeparator jSeparator2 = new JSeparator();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JButton jButton4 = new JButton();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JSeparator jSeparator3 = new JSeparator();

    public VentanaPrincipal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar( menuBar );
        this.getContentPane().setLayout( layoutMain );
        panelCenter.setLayout(borderLayout1);
        this.setSize(new Dimension(636, 388));
        this.setTitle("Generador de datos");
        archivo.setText("Archivo");
        menuFileExit.setText("Salir");
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        menuHelp.setText("Ayuda");
        menuHelpAbout.setText("Sobre");
        menuHelpAbout.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent e ) {
                    helpAbout_ActionPerformed(e);
                } } );
        jScrollPane1.setDoubleBuffered(true);
        jTable1.setDoubleBuffered(true);
        jButton1.setText("Generar datos ...");
        jButton1.setToolTipText("Genera datos de un tipo genérico.");
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jLabel1.setText("n datos =>");
        jLabel1.setToolTipText("Escribir la cantidad de filas a generar.");
        jLabel2.setText("% de errores =>");
        jLabel2.setToolTipText("Se generarán datos con errores según el porcentage indicado.");
        jSeparator1.setOrientation(SwingConstants.VERTICAL);
        jSeparator2.setOrientation(SwingConstants.VERTICAL);
        jButton2.setText("Guardar");
        jButton2.setToolTipText("Guarda los datos en un archivo tipo Excel.");
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jButton3.setText("Copiar");
        jButton3.setToolTipText("Copia los datos en el porta papeles compatible con Excel.");
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton3_actionPerformed(e);
                }
            });
        jButton4.setText("Generar errores");
        jButton4.setToolTipText("Busca caracteres y los remplaza por otros.");
        jButton4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton4_actionPerformed(e);
                }
            });
        jTextField1.setText("a");
        jTextField1.setToolTipText("Caracteres a buscar");
        jTextField2.setText("&");
        jTextField2.setToolTipText("Caracteres para remplazar. Escribir caracteres imcompatibles con los tipos de datos.");
        jSeparator3.setOrientation(SwingConstants.VERTICAL);
        archivo.add( menuFileExit );
        menuBar.add( archivo );
        menuHelp.add( menuHelpAbout );
        menuBar.add( menuHelp );
        this.getContentPane().add(toolBar, BorderLayout.NORTH);
        toolBar.add(jButton1, null);
        toolBar.add(jButton2, null);
        toolBar.add(jButton3, null);
        toolBar.add(jSeparator1, null);
        toolBar.add(jLabel1, null);
        toolBar.add(jSpinner1, null);
        toolBar.add(jSeparator2, null);
        toolBar.add(jButton4, null);
        toolBar.add(jTextField1, null);
        toolBar.add(jTextField2, null);
        toolBar.add(jSeparator3, null);
        toolBar.add(jLabel2, null);
        toolBar.add(jSpinner2, null);
        jScrollPane1.getViewport().add(jTable1, null);
        panelCenter.add(jScrollPane1, BorderLayout.CENTER);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);
        tabla = new Tabla(jTable1);
        this.jSpinner1.setValue(1000);
        jSpinner1.setMinimumSize(new Dimension(70, 19));
        jSpinner1.setPreferredSize(new Dimension(70, 19));
        jSpinner1.setToolTipText("Escribir la cantidad de filas a generar.");
        this.jSpinner2.setValue(20);
        jSpinner2.setMinimumSize(new Dimension(50, 19));
        jSpinner2.setPreferredSize(new Dimension(50, 19));
        jSpinner2.setToolTipText("Porcentage de caracteres a remplazar en los datos.");
        jSpinner1.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    jSpinner1_stateChanged(e);
                }
            });
        jSpinner1.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    jSpinner1_keyTyped(e);
                }

                public void keyPressed(KeyEvent e) {
                    jSpinner1_keyPressed(e);
                }
            });
        jSpinner2.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    jSpinner2_stateChanged(e);
                }
            });
        jSpinner2.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    jSpinner2_keyTyped(e);
                }
            });
        
        
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }
    void helpAbout_ActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, vp_About , "Sobre el Generador de Datos", JOptionPane.PLAIN_MESSAGE);
    }

    private void jButton1_actionPerformed(ActionEvent e) {
        
        this.jButton1.setEnabled(false);
        this.toolBar.setEnabled(false);
        tabla.borrarDatos(); 
        tabla.generarDatos(Integer.valueOf(jSpinner1.getValue().toString()), Integer.valueOf(jSpinner2.getValue().toString()));
        this.jButton1.setEnabled(true);
        this.toolBar.setEnabled(true);
    }

    private void jSpinner1_stateChanged(ChangeEvent e) {
        int x = Integer.valueOf(jSpinner1.getValue().toString());
        if(x<=0) jSpinner1.setValue(1000);
        if(x>65535) jSpinner1.setValue(1000);
    }

    private void jSpinner1_keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if(!(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9')) 
            e.consume();
    }

    private void jSpinner2_stateChanged(ChangeEvent e) {
        int x = Integer.valueOf(jSpinner2.getValue().toString());
        if(x<0) jSpinner2.setValue(20);
        if(x>100) jSpinner2.setValue(20);
    }

    private void jSpinner2_keyTyped(KeyEvent e) {

    }

    private void jSpinner1_keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        if(!(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9')) 
            e.consume();
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        this.jButton2.setEnabled(false);
        this.toolBar.setEnabled(false);
        tabla.guardarTXT();
        this.jButton2.setEnabled(true);
        this.toolBar.setEnabled(true);
        
    }

    private void jButton3_actionPerformed(ActionEvent e) {
        this.jButton3.setEnabled(false);
        this.toolBar.setEnabled(false);
        tabla.guardarPortaPapeles();
        this.jButton3.setEnabled(true);
        this.toolBar.setEnabled(true);
    }

    private void jButton4_actionPerformed(ActionEvent e) {
        this.jButton4.setEnabled(false);
        this.toolBar.setEnabled(false);
        tabla.generarErrores(jTextField1.getText(), jTextField2.getText(), Integer.valueOf(jSpinner2.getValue().toString()));
        this.jButton4.setEnabled(true);
        this.toolBar.setEnabled(true);
    }

}
