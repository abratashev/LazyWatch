//Lazy Watch Graphic User Interface Class
package lazywatch.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import lazywatch.Variables;

public class LWGUI {

    SettingsMenu settings;
    TrayMenu trayMenu;

    public LWGUI() {
        settings = new SettingsMenu(100,100,50,50);
        setConnectionPort();
        trayMenu = new TrayMenu();//Variables.ICON_STR


    }

      private void setConnectionPort() {
      JFrame frame = new JFrame();
      JOptionPane.showInputDialog(frame, "Please input port for our Server");  
    }
    
      
        //Создание изображения по пути
        static Image createIcon(String path) {
        URL imgURL = LWGUI.class.getResource(path);
        if (imgURL != null) {
            return Toolkit.getDefaultToolkit().getImage(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }
        

}
