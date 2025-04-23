import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="SportsTeamRegistration.class" width="800" height="600"></applet>
*/

public class SportsTeamRegistration extends Applet implements ActionListener, ItemListener {
    TextField nameField, rollField, phoneField;
    Choice sportChoice;
    Button submitButton, clearButton;
    String message = "", selectedSport = "";
    Image backgroundImage;

    public void init() {
        setLayout(null);

        backgroundImage = getImage(getCodeBase(), "OIP.jpg");  // Load image

        Label nameLabel = new Label("Name:");
        Label rollLabel = new Label("Roll No:");
        Label sportLabel = new Label("Sport:");
        Label phoneLabel = new Label("Phone:");

        nameField = new TextField(20);
        rollField = new TextField(20);
        phoneField = new TextField(20);

        sportChoice = new Choice();
        sportChoice.add("Select Sport");
        sportChoice.add("Cricket");
        sportChoice.add("Football");
        sportChoice.add("Basketball");
        sportChoice.add("Volleyball");
        sportChoice.add("Tennis");

        submitButton = new Button("Submit");
        clearButton = new Button("Clear");

        // Set bounds for components
        nameLabel.setBounds(100, 80, 100, 30);
        nameField.setBounds(220, 80, 200, 30);

        rollLabel.setBounds(100, 130, 100, 30);
        rollField.setBounds(220, 130, 200, 30);

        sportLabel.setBounds(100, 180, 100, 30);
        sportChoice.setBounds(220, 180, 200, 30);

        phoneLabel.setBounds(100, 230, 100, 30);
        phoneField.setBounds(220, 230, 200, 30);

        submitButton.setBounds(150, 300, 100, 40);
        clearButton.setBounds(280, 300, 100, 40);

        // Add components to applet
        add(nameLabel);
        add(nameField);
        add(rollLabel);
        add(rollField);
        add(sportLabel);
        add(sportChoice);
        add(phoneLabel);
        add(phoneField);
        add(submitButton);
        add(clearButton);

        // Register listeners
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        sportChoice.addItemListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            showDialog();
        } else if (e.getSource() == clearButton) {
            clearForm();
        }
    }

    public void itemStateChanged(ItemEvent e) {
        selectedSport = sportChoice.getSelectedItem();
    }

    private void showDialog() {
        String name = nameField.getText();
        String roll = rollField.getText();
        String phone = phoneField.getText();

        if (selectedSport.equals("Select Sport")) {
            selectedSport = "Not Selected";
        }

        Dialog d = new Dialog((Frame) null, "Registration Details", true);
        d.setLayout(new GridLayout(5, 1));
        d.setSize(400, 250);

        d.add(new Label("Registration Successful!"));
        d.add(new Label("Name: " + name));
        d.add(new Label("Roll No: " + roll));
        d.add(new Label("Sport: " + selectedSport));
        d.add(new Label("Phone: " + phone));

        Button okButton = new Button("OK");
        okButton.addActionListener(ae -> d.setVisible(false));
        d.add(okButton);

        d.setLocation(300, 300);
        d.setVisible(true);
    }

    private void clearForm() {
        nameField.setText("");
        rollField.setText("");
        phoneField.setText("");
        sportChoice.select(0);
        message = "";
        repaint();
    }

    public void paint(Graphics g) {
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        g.setColor(Color.WHITE); // Text color
        g.setFont(new Font("Serif", Font.BOLD, 18));
        g.drawString("Sports Team Registratiossn Form", 240, 50);
    }
}