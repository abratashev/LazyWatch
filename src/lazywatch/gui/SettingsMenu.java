/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lazywatch.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import lazywatch.Variables;


public class SettingsMenu extends JFrame {
    
    public SettingsMenu(int x, int y, int width, int height){
        JPanel panel = new JPanel();
        JButton button1 = new JButton();
        ImageIcon icon1 = new ImageIcon(LWGUI.createIcon(Variables.ICON_STR));
        button1.setIcon(icon1);
        panel.add(button1);
        getContentPane().add(panel);
        setMinimumSize(new Dimension(300, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setBounds(x, y, width, height);
    }
}
