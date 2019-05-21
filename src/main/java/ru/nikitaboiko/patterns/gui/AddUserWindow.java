package ru.nikitaboiko.patterns.gui;

import lombok.Getter;
import lombok.Setter;
import ru.nikitaboiko.patterns.services.ViewController;

import javax.swing.*;

@Getter
@Setter
public class AddUserWindow extends JFrame {
    private JButton jButtonAdd;
    private JLabel jLabelName;
    private JLabel jLabelEmail;
    private JTextField jTextFieldName;
    private JTextField jTextFieldEmail;
    private ViewController viewController;

    public AddUserWindow(ViewController viewController) {
        this.viewController = viewController;
        initComponents();
    }

    private void initComponents() {

        jTextFieldName = new JTextField();
        jTextFieldEmail = new JTextField();
        jButtonAdd = new JButton();
        jLabelName = new JLabel();
        jLabelEmail = new JLabel();

        jButtonAdd.addActionListener(event -> addUser());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jButtonAdd.setText("Добавить");

        jLabelName.setText("Имя пользователя:");
        jLabelName.setToolTipText("");

        jLabelEmail.setText("email:");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(104, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelName)
                                                        .addComponent(jLabelEmail))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldName, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldEmail)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(jButtonAdd)))
                                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(100, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelName))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelEmail))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAdd)
                                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void addUser() {
        viewController.addNewUserToDb();
    }
}
