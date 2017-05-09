/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariohoja;
import javax.swing.JDialog;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angie Castañeda
 */
public class DialogoLista extends JDialog{
    
        
    private JTable tablaHojas;
    private DefaultTableModel dtm;
    private PanelBotones ventana;
    
    public DialogoLista(PanelBotones ventana){
        this.ventana = ventana;
        setBackground(Color.WHITE);
        setSize(530, 550);
        setLayout(null);
        
        dtm = new DefaultTableModel();
        tablaHojas = new JTable(dtm);
        
        Object[] columna = {"Cedula", "Nombre", "1° Apellido", "2° Apellido", "Profesion"};
        for (Object columna1 : columna) {
            dtm.addColumn(columna1);
        }
        
        JScrollPane scrollPane = new JScrollPane(tablaHojas);
        scrollPane.setBounds(30, 30, 450, 370);
        add(scrollPane);
    }
    
    public void actualizarTabla(){
        try {
            List<Persona> lista = this.ventana.getListaPersona();
            for (Persona persona : lista) {
             Object[] fila = {persona.getCedula(), persona.getNombre(), persona.getApellido1(), persona.getApellido2(), persona.getProfesion()};
             dtm.addRow(fila);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this,"No hay hojas creadas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    

