import javax.swing.*;

public class ItemView {
    private JButton selectButton;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField qtyField;
    private JTextField create_dataField;
    private JTextArea infoText;
    private JPanel buttonPanel;
    private JPanel attributesPanel;
    private JButton insertButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ItemView");
        frame.setContentPane(new ItemView().attributesPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
