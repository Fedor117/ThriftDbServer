package view;

import controller.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

/**
 * Created by Dzmitry Saladukha on 15.04.2016.
 */
public class DeletingPanel extends JPanel {
    public DeletingPanel(Controller controller) {
        super(new BorderLayout());

        JButton button = new JButton("delete");
        JTextField textField = new JTextField(20);
        JPanel panel = new JPanel();
        JLabel label = new JLabel();

        button.addActionListener((e) -> {
            String name = textField.getText().trim();
            String result = controller.delete(name);
            if (result != null) {
                label.setText("<html><body style=\"padding: 20px\"><p style=\"font-size: 2em\">" + result +
                        "</p></body></html>");
            } else {
                label.setText(
                        "<html><body style=\"padding: 20px\"><p style=\"font-size: 2em\">Nothing was found.</p></body></html>");
            }
        });

        panel.add(textField);
        panel.add(button);
        add(panel, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
    }
}
