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
public class UpdatingPanel extends JPanel {
    public UpdatingPanel(Controller controller) {
        super(new BorderLayout());

        JButton button = new JButton("update");
        JTextField nameTF = new JTextField(15);
        JTextField definitionTF = new JTextField(30);
        JPanel panel = new JPanel();
        JLabel label = new JLabel();

        button.addActionListener((e) -> {
            String name = nameTF.getText().trim();
            String definition = definitionTF.getText().trim();
            String result = controller.update(name, definition);
            if (result != null) {
                label.setText(
                        "<html><body style=\"padding: 20px\"><p style=\"font-size: 2em\">" + result +"</p></body></html>");
            } else {
                label.setText(
                        "<html><body style=\"padding: 20px\"><p style=\"font-size: 2em\">Nothing was found.</p></body></html>");
            }
        });

        panel.add(nameTF);
        panel.add(definitionTF);
        panel.add(button);
        add(panel, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
    }
}
