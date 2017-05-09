/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariohoja;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.swingx.JXDatePicker;
/**
 *
 * @author Angie Castañeda
 */
public class DialogoNuevo extends JDialog implements ActionListener, KeyListener{
    
    private JPanel panel;
    private JLabel LTitulo, LNombre, LApellido1, LApellido2, LCedula, LFecha, LEmail, LGenero, LProfesion, etiquetaImagen, LMensaje;
    private JTextField JTNombre, JTApellido1, JTApellido2, JTCedula, JTEmail;
    private JCheckBox CBMasculino, CBFemenino;
    private JComboBox <Profesion> CBProfesion;
    private ButtonGroup  CBGroupGenero;
    private JButton BCambiar, BRegistrar;
    private PanelBotones botones;
    private String mensaje;
    ValidacionCorreo valida;
    private int progress;
    private String BTN_REGISTRA = "BTN_REGISTRA";
    private String BTN_CAMBIA = "BTN_CAMBIA";
    private JXDatePicker JDFecha;
    private List<Persona> listaHojasArchivo;
            
   public DialogoNuevo(PanelBotones botones) {
       
       this.botones = botones;
       setSize(600, 600);
       setLocationRelativeTo(null);
       setResizable(false);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       
       listaHojasArchivo = new ArrayList<Persona>();
       
       panel = new JPanel();
       panel.setLayout(null);
       panel.setBackground(Color.WHITE);
       
       ImageIcon icon = new ImageIcon("imagen/imagen.JPG");
       etiquetaImagen = new JLabel();
       etiquetaImagen.setIcon(icon);
       etiquetaImagen.setBounds(420, 20, 140, 170);
       add(etiquetaImagen);
       
       LTitulo = new JLabel("HOJA DE VIDA");
       LNombre = new JLabel("Nombre:");
       LApellido1 = new JLabel("Primer Apellido:");
       LApellido2 = new JLabel("Seg. Apellido:");
       LFecha = new JLabel("Fecha nacim:");
       LCedula = new JLabel ("Cédula:");
       LEmail = new JLabel("Email:");
       LMensaje = new JLabel();
       LGenero = new JLabel("Genero:");
       LProfesion = new JLabel("Profesión:");
       
       LTitulo.setBounds(200, 40, 200, 20);
       LTitulo.setFont(new Font("Britanic Bold", 1, 16));
       panel.add(LTitulo);
       
       LNombre.setBounds(80, 80, 100, 20);
       panel.add(LNombre);
         
       LApellido1.setBounds(80, 110, 100, 20);
       panel.add(LApellido1);
         
       LApellido2.setBounds(80, 140, 100, 20);
       panel.add(LApellido2);
       
       LFecha.setBounds(80, 170, 100, 20);
       panel.add(LFecha);

       LCedula.setBounds(80, 200, 100, 20);
       panel.add(LCedula);
       
       LEmail.setBounds(80, 230, 100, 20);
       panel.add(LEmail);
       
       LMensaje.setBounds(190, 250, 150, 20);
       panel.add(LMensaje);
       
       LGenero.setBounds(80, 290, 100, 20);
       panel.add(LGenero);
       
       LProfesion.setBounds(80, 320, 100, 20);
       panel.add(LProfesion);
       
       JTNombre = new JTextField();
       JTNombre.setBounds(190, 80, 150, 20);
       //JTNombre.addKeyListener(this);
       panel.add(JTNombre);
       
       JTApellido1 = new JTextField();
       JTApellido1.setBounds(190, 110, 150, 20);
       panel.add(JTApellido1);
       
       JTApellido2 = new JTextField();
       JTApellido2.setBounds(190, 140, 150, 20);
       panel.add(JTApellido2);
       
       JDFecha = new JXDatePicker();
       JDFecha = new JXDatePicker();
       JDFecha.setDate(Calendar.getInstance().getTime());
       JDFecha.setFormats(new SimpleDateFormat("dd/MM/yyyy"));    
       JDFecha.setBounds(190, 170, 150, 20);
       
       panel.add(JDFecha);
       
       JTCedula = new JTextField();
       JTCedula.setBounds(190, 200, 150, 20);
       panel.add(JTCedula);  
       
       JTEmail = new JTextField();
       JTEmail.setBounds(190, 230, 150, 20);
       JTEmail.addKeyListener(this);
       panel.add(JTEmail);
       
       CBProfesion = new JComboBox<>();
       CBProfesion.setModel(new DefaultComboBoxModel<>(Profesion.values()));
       CBProfesion.setBounds(190, 320, 150, 20);
       panel.add(CBProfesion);
       
       CBGroupGenero = new ButtonGroup();
       
       CBMasculino = new JCheckBox("Masculino");
       CBMasculino.setBounds(190, 290, 100, 20);
       panel.add(CBMasculino);
       //CBMasculino.addItemListener(this);

       CBFemenino = new JCheckBox("Femenino");
       CBFemenino.setBounds(290, 290, 100, 20);
       panel.add(CBFemenino);
       //CBFemenino.addItemListener(this);
       
       CBGroupGenero.add(CBMasculino);
       CBGroupGenero.add(CBFemenino);

       BRegistrar = new JButton("Registrar");
       BRegistrar.setBounds(190, 370, 100, 20);
       BRegistrar.addActionListener((ActionListener)this);
       BRegistrar.setActionCommand(BTN_REGISTRA);
       panel.add(BRegistrar);
       
       BCambiar = new JButton("Cargar Imagen");
       BCambiar.setBounds(420, 200, 130, 20);
       BCambiar.addActionListener((ActionListener)this);
       BCambiar.setActionCommand(BTN_CAMBIA);
       panel.add(BCambiar);
       
       
       add(panel);
       setVisible(true);
       
   }

    


    @Override
    public void keyTyped(KeyEvent e){
    
    }
    @Override
    public void keyPressed(KeyEvent e) { 
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int i = 0;
        
        JTextField textField = (JTextField) e.getSource();
        String text = textField.getText();
        
        int tama = text.length();
        
        if(tama >= 4){
            ValidacionCorreo valida1 = new ValidacionCorreo(text);
            valida1.getMensaje();
            LMensaje.setText(valida1.getMensaje());
            progress=valida1.getColor();
            if((progress==0)){
                LMensaje.setForeground(Color.RED);
            } else {
             LMensaje.setForeground(Color.GREEN);
            }
        }

        if(text.length()==0){
           LMensaje.setText("");
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(BTN_REGISTRA.equals(e.getActionCommand())){
        System.out.println("registra");
            if(validarDatos()){
             Persona persona = new Persona(JTNombre.getText(), JTApellido1.getText(), JTApellido2.getText(), JDFecha.getDate(), Integer.parseInt(JTCedula.getText()),JTEmail.getText(), CBGroupGenero.getSelection().toString(),  (Profesion) CBProfesion.getSelectedItem());
                this.botones.getListaPersona().add(persona);
                listaHojasArchivo.add(persona);
                JOptionPane.showMessageDialog(this, "Formulario creado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                vaciarDatos();
                
        }else {
            JFileChooser fileChooser = new JFileChooser(); 
            FileNameExtensionFilter filtro = new FileNameExtensionFilter(".jpg & .png", "jpg", "png"); 
            fileChooser.setFileFilter(filtro); 
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); 
            int result = fileChooser.showOpenDialog(this); 
            if (result == JFileChooser.APPROVE_OPTION){ 
                File name= fileChooser.getSelectedFile(); 
                System.out.print(fileChooser.getSelectedFile().getPath());
                ImageIcon image = new ImageIcon(fileChooser.getSelectedFile().getPath()); 
                if(image.getIconHeight() > 342 || image.getIconWidth() > 230){ 
                    ImageIcon imageScalada = new ImageIcon(image.getImage().getScaledInstance(140, 140, 170)); 
                    etiquetaImagen.setIcon(imageScalada); 
                } 
                else{ 
                etiquetaImagen.setIcon(image); 
                } 
            }
        }
      }
    }

    
    private void vaciarDatos() {
        JTNombre.setText("");
        LNombre.setForeground(Color.BLACK);
        JTApellido1.setText("");
        LApellido1.setForeground(Color.BLACK);
        JTApellido2.setText("");
        LApellido2.setForeground(Color.BLACK);
        LFecha.setForeground(Color.BLACK);
        JTCedula.setText("");
        LCedula.setForeground(Color.BLACK);
        JTEmail.setText(" ");
        LEmail.setForeground(Color.BLACK);
        LMensaje.setText(" ");
        CBGroupGenero.clearSelection();
        CBProfesion.setSelectedIndex(0);
    }
    
    private boolean validarDatos() {
        if(JTNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LNombre.setForeground(Color.red);
            return false;
        } else if(JTApellido1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Apellido es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LApellido1.setForeground(Color.red);
            return false;       
        }  else if(JTApellido2.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Apellido es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LApellido2.setForeground(Color.red);
            return false;        
        }  else if(JTCedula.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Cedula es dato obligatorio", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LCedula.setForeground(Color.red);
            return false;        
        }  else if(progress!=2){
            JOptionPane.showMessageDialog(this, "Correo inválido", "Mensaje", JOptionPane.ERROR_MESSAGE);
            JTEmail.setText("");
            return false;   
        } 
        return true;
    }
    

    public ButtonGroup getCBGroupGenero() {
        return CBGroupGenero;
    }

    public void setCBGroupGenero(ButtonGroup CBGroupGenero) {
        this.CBGroupGenero = CBGroupGenero;
    }


    
}
    

