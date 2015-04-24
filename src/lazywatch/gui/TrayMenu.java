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

import lazywatch.gui.*;
import lazywatch.Variables;

/**
 *
 * @author ASUS
 */
public class TrayMenu {

    public TrayMenu() {
        PopupMenu popupMenu = new PopupMenu();
        //Cлушатель для трея
        ActionListener menuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Popup menu item ["
                        + event.getActionCommand() + "] was pressed.");
                switch (event.getActionCommand()) {
                    case "Settings":  //settingsframe.setVisible(true);
                        //LWGUI.settings.setVisible(true);
                        break;
                    case "Exit":
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Error! Cannot find settings for ["
                                + event.getActionCommand() + "] item.");
                        break;
                }
            }
        };

            MenuItem item;

            if (!SystemTray.isSupported()) {
            return;
            }

            popupMenu.add(item = new MenuItem("ololo"));
            item.addActionListener (menuListener);

            popupMenu.add (item = new MenuItem("Settings"));
            item.addActionListener (menuListener);

            popupMenu.add (item = new MenuItem("Exit"));
            item.addActionListener (menuListener);
     
            TrayIcon trayIcon = new TrayIcon(LWGUI.createIcon(Variables.ICON_STR), Variables.APP_NAME, popupMenu);
            trayIcon.setImageAutoSize (true);
            SystemTray tray = SystemTray.getSystemTray();            
            try {
            tray.add(trayIcon);
            }
            catch (AWTException e) {
            e.printStackTrace();
            }

            trayIcon.displayMessage (Variables.APP_NAME,
            "Application started!",
            TrayIcon.MessageType.INFO);
            };
    

                
}
