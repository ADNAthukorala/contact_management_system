import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ContactManagementFrame extends JFrame implements ListSelectionListener, ActionListener {
    JLabel nameLabel, phoneNumberLabel;
    JTextField nameTextField, phoneNumberTextField;
    JList<String> contactList;
    JButton addButton, deleteButton;
    JPanel mainPanel, inputPanel, buttonPanel;
    String[] contacts = new String[100];

    ContactManagementFrame() {
        // Create label objects
        nameLabel = new JLabel("Name:");
        phoneNumberLabel = new JLabel("Phone Number:");

        // Create text field objects
        nameTextField = new JTextField(15);
        phoneNumberTextField = new JTextField(15);

        // Create list object
        contactList = new JList<>(contacts);
        contactList.setBorder(new LineBorder(Color.black));
        contactList.setVisibleRowCount(4);
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
        mainPanel.add(contactList, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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