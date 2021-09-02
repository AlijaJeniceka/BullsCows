package com.company.Game;

import com.company.dbhelper.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Registration {
    private static JLabel userNameLabel, accountLabel, failLabel;
    private static JTextField userNameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JButton button2, button3, button4;
    private static JLabel success;
    private static Font titleFont = new Font("Times New Roman", Font.BOLD, 30);
    private static Font normalTitle = new Font("Times New Roman", Font.PLAIN, 25);


    public static void main() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        accountLabel = new JLabel("Create your account");
        accountLabel.setBounds(100, 70, 600, 50);
        accountLabel.setFont(normalTitle);
        panel.add(accountLabel);

        userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(100, 200, 80, 25);
        panel.add(userNameLabel);

        userNameText = new JTextField(20);
        userNameText.setBounds(240, 200, 165, 25);
        panel.add(userNameText);


        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 240, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(240, 240, 165, 25);
        panel.add(passwordText);


        button = new JButton("Exit");
        button.setBounds(100, 320, 100, 25);
        panel.add(button);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
                button2 = new JButton("Register");
                button2.setBounds(240, 320, 100, 25);
                panel.add(button2);
                frame.setVisible(true);



                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        String userName = userNameText.getText();
                        String password = passwordText.getText();

                        if(userNameText.getText().length() != 0 && passwordText.getText().length() != 0 )
                        {
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/game_bulls_cows", User.USERNAME.getValue(), User.PASSWORD.getValue());
                            String query = "INSERT INTO CowsAndBulls(username, password)" + "VALUES('" + userName + "', '" + password + "')";
                            Statement sta = connection.createStatement();
                            int x = sta.executeUpdate(query);

                            JFrame frame2 = new JFrame();
                            JPanel panel2 = new JPanel();
                            frame2.setSize(600, 600);
                            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame2.add(panel2);

                            panel2.setLayout(null);

                            success = new JLabel("Registration successful.");
                            success.setBounds(50, 150, 300, 25);
                            panel2.add(success);

                            button3 = new JButton("Start new game");
                            button3.setBounds(50, 200, 200, 25);
                            panel2.add(button3);

                            button3.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    CowsAndBulls.main();
                                    frame2.dispose();

                                }
                            });
                            button4 = new JButton("Start new hard game");
                            button4.setBounds(300, 200, 200, 25);
                            button4.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    HardGame.main();
                                    frame2.dispose();

                                }
                            });
                            panel2.add(button4);

                            button = new JButton("Exit");
                            button.setBounds(50, 250, 100, 25);
                            panel2.add(button);
                            frame2.setVisible(true);
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.exit(0);
                                }
                            });


                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Please enter another username, this already exist.", "Error", JOptionPane.ERROR_MESSAGE);
                            main();


                        }}
                        else{
                            JOptionPane.showMessageDialog(null, "Please enter username and password.", "Error", JOptionPane.ERROR_MESSAGE);
                            main();
                        }


                    }

                });

    }
}

