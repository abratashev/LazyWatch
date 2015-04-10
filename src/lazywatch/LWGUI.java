//Lazy Watch Graphic User Interface Class
package lazywatch;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;

class LWGUI {

    JFrame settingsframe;

    void createGUI() {
        setConnectionPort();
        CreateSettingsMenu();
        setTray();

    }

    private static void setConnectionPort() {
       
    }
    
    

 //Создание меню в трее
    private void setTray() {

        //Cлушатель для трея
        ActionListener menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Popup menu item ["
                        + event.getActionCommand() + "] was pressed.");
            switch (event.getActionCommand()) {
            case "Settings":  settingsframe.setVisible(true);
                     break;
            case "Exit":  System.exit(0);
                     break;
             default: JOptionPane.showMessageDialog(null, "Error! Cannot find settings for ["
                        + event.getActionCommand() + "] item.");
                     break;    
            }
            }
        };
        //~~Cлушатель для трея
            
        
        MenuItem item;

        if (!SystemTray.isSupported()) {
            return;
        }

        PopupMenu trayMenu = new PopupMenu();
        
        trayMenu.add(item = new MenuItem("ololo"));
        item.addActionListener(menuListener);
        
        trayMenu.add(item = new MenuItem("Settings"));
        item.addActionListener(menuListener);
        trayMenu.add(item = new MenuItem("Exit"));
        item.addActionListener(menuListener);
        TrayIcon trayIcon = new TrayIcon(createIcon(Variables.ICON_STR), Variables.APP_NAME, trayMenu);

        trayIcon.setImageAutoSize(
                true);

        SystemTray tray = SystemTray.getSystemTray();

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        trayIcon.displayMessage(Variables.APP_NAME,
                "Application started!",
                TrayIcon.MessageType.INFO);
    }
    
    
    //Создание формы настроек
        private void CreateSettingsMenu()  {    
        settingsframe = new JFrame("Settings");
        JPanel panel = new JPanel();
        JButton button1 = new JButton();
        ImageIcon icon1 = new ImageIcon(createIcon(Variables.ICON_STR));
        button1.setIcon(icon1);
        panel.add(button1);
        settingsframe.getContentPane().add(panel);
        settingsframe.setMinimumSize(new Dimension(300, 200));
        settingsframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        settingsframe.pack();

    }


    //Создание изображения по пути
        private static Image createIcon(String path) {
        URL imgURL = LWGUI.class.getResource(path);
        if (imgURL != null) {
            return Toolkit.getDefaultToolkit().getImage(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }
        

}
