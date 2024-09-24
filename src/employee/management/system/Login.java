package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;



    Login(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/s2.gif"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,70,100,100);
        add(image);

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);
// login btn
        login = new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);
// back btn
        back = new JButton("Back");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.addActionListener(this);


        add(back);




        setSize(600,300);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == login){
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                conn conn = new conn();
                String query = "Select * from login where username = '"+username+"' and password = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");

                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else if(e.getSource()== back){
            System.exit(90);

        }

    }

    public static void main(String[] args){
        new Login();
    }

}
