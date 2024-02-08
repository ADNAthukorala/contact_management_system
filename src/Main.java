import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Contact {
    private final String name;
    private final String phoneNumber;

    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return name + " - " + phoneNumber;
    }
}

class ContactManagementFrame extends JFrame implements ListSelectionListener, ActionListener {
    private final DefaultListModel<String> listModel;
    private final JList<String> contactList;
    JLabel nameLabel, phoneNumberLabel;
    JTextField nameTextField, phoneNumberTextField;
    JButton addButton, deleteButton;
    JPanel mainPanel, inputPanel, buttonPanel;

    ContactManagementFrame() {
        // Create list model object
        listModel = new DefaultListModel<>();

        // Create label objects
        nameLabel = new JLabel("Name:");
        phoneNumberLabel = new JLabel("Phone Number:");

        // Create text field objects
        nameTextField = new JTextField(15);
        phoneNumberTextField = new JTextField(15);

        // Create list object
        contactList = new JList<>(listModel);
        contactList.addListSelectionListener(this);

        // Create buttons objects
        addButton = new JButton("Add Contact");
        deleteButton = new JButton("Delete Contact");
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);

        // Create panel objects
        // inputPanel
        inputPanel = new JPanel(new GridLayout(2,2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(phoneNumberLabel);
        inputPanel.add(phoneNumberTextField);

        // buttonPanel
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        // mainPanel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(contactList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();

            Contact contact = new Contact(name, phoneNumber);
            listModel.addElement(contact.toString());

            nameTextField.setText("");
            phoneNumberTextField.setText("");
        }
        if (e.getSource() == deleteButton) {
            int selectedIndex = contactList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManagementFrame frame = new ContactManagementFrame();
        frame.setTitle("Contact Management System");
        frame.setSize(420, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}