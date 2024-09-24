package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class  extends JFrame {
    Main_class(){

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(150,270,150,40);
        add.setBackground(Color.cyan);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== add){
                    setVisible(false);
                    new AddEmployee();
                }

            }
        });
        add(add);

        JButton view = new JButton("Display Employees");
        view.setBounds(300,270,150,40);
        view.setBackground(Color.cyan);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==view){
                    setVisible(false);
                    new View_Employee();
                }

            }
        });
        add(view);

//        JButton avg = new JButton("Calculate Average Salary");
//        avg.setBounds(335,330,150,40);
//        avg.setBackground(Color.cyan);
//        avg.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        add(avg);

        JButton rem = new JButton("Remove Employees");
        rem.setBounds(650,270,150,40);
        rem.setBackground(Color.red);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RemoveEmployee();

            }
        });
        add(rem);


        JButton exit = new JButton("Exit");
        exit.setBounds(50,450,150,40);
        exit.setBackground(Color.gray);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();

            }
        });
        add(exit);



        setSize(1200,630);
        setLocation(250,100);
        setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
