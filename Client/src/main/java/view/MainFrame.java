package view;

import controller.Controller;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 * Created by Dzmitry Saladukha on 15.04.2016.
 */
public class MainFrame extends JFrame {
    private Controller controller;

    public MainFrame() throws HeadlessException {
        super("АИПОС, лабораторная работа №2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(
                Toolkit.getDefaultToolkit().getScreenSize().width / 5 * 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 5 * 2));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        controller = new Controller();

        add(createTabbedPane(), BorderLayout.CENTER);

        setVisible(true);
    }

    private Component createTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Create", null, new CreatingPanel(controller), "Create new record");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.addTab("Read", null, new ReadingPanel(controller), "Read existing record");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        tabbedPane.addTab("Update", null, new UpdatingPanel(controller), "Update existing record");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
        tabbedPane.addTab("Delete", null, new DeletingPanel(controller), "Delete existing record");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        return tabbedPane;
    }
}
