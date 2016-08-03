package controller;

import view.MainFrame;

import javax.swing.*;

/**
 * Created by Dzmitry Saladukha on 15.04.2016.
 */
public class EntryPoint {
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (UnsupportedLookAndFeelException e1) {
                e1.printStackTrace();
            }
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
