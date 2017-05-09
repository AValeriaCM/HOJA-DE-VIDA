/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariohoja;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Angie Castañeda
 */
public class PanelImagen extends JPanel {
    
    private JLabel etiquetaImagen;
    
    public PanelImagen(){
        setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("imagen/logo.JPG");
        etiquetaImagen = new JLabel();
        etiquetaImagen.setIcon(icon);
        add(etiquetaImagen);
        String texto = "<html><body>Angie Valeria Castañeda Moreno<br>Leidy Milena Torres Guerrero<br>Ing. de Sistemas</body></html>";
        JLabel info = new JLabel(texto);
        add(info);
    }
}
