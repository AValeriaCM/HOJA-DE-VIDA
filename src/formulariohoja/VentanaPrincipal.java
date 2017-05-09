/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariohoja;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Angie Castañeda
 */
public class VentanaPrincipal extends JFrame{
    
    private PanelImagen pImagen;
    private PanelBotones pBotones;
   
        
    public VentanaPrincipal() {
        setSize(350, 500);
        setTitle("HOJA VIDA");
        setLocation(500, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        pImagen = new PanelImagen();
        pImagen.setBounds(10, 10, 310, 300);
        add(pImagen);
        
        pBotones = new PanelBotones(this);
        pBotones.setBounds(10, 310, 310, 220);
        add(pBotones);
        
        
        
        
        setVisible(true);
    }

    
}
