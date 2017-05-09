/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariohoja;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angie Castañeda
 */
public class PanelBotones extends JPanel implements ActionListener{
    
    private final JButton btnNuevo;
    private final JButton btnVer;
    private final String BTN_NUEVO = "NUEVO";
    private final String BTN_VER= "VER";
    private VentanaPrincipal principal;
    private List<Persona> listaPersona;
    
    public PanelBotones(VentanaPrincipal principal) {
        this.principal = principal;
        setBackground(Color.WHITE);
        setLayout(new GridLayout(6, 1));
        
        listaPersona = new ArrayList<Persona>();
        
        btnNuevo = new JButton ("Nueva Hoja");
        btnNuevo.addActionListener((ActionListener) this);
        btnNuevo.setActionCommand(BTN_NUEVO);
        add(btnNuevo);
        
        btnVer = new JButton ("Ver Listado");
        btnVer.addActionListener((ActionListener) this);
        btnVer.setActionCommand(BTN_VER);
        add(btnVer);
        
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(BTN_NUEVO.equals(e.getActionCommand())){
              DialogoNuevo persona = new DialogoNuevo(this); 
              persona.setVisible(true);
        } else {
              DialogoLista consulta1 = new DialogoLista(this);
              consulta1.actualizarTabla();
              consulta1.setVisible(true);
        }
    
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }
    
    
    
}
