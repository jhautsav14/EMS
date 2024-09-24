package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame {

    Choice choiceEmpId;

    RemoveEmployee(){

        JLabel label = new JLabel("Employee Id");
        label.setBounds(50,50,100,30);
        add(label);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(200,50,150,30);
        add(choiceEmpId);



        try {
            conn c = new conn();
            String query = "select * from employee";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                choiceEmpId.add(resultSet.getString("empId"));
            }


        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(50,100,100,30);
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(200,100,100,30);
        add(textName);

        JLabel labelPosition = new JLabel("Position");
        labelPosition.setBounds(50,150,100,30);
        add(labelPosition);

        JLabel textPosition = new JLabel();
        textPosition.setBounds(200,150,100,30);
        add(textPosition);

        JLabel labelSalary = new JLabel("Salary");
        labelSalary.setBounds(50,200,100,30);
        add(labelSalary);

        JLabel textSalary = new JLabel();
        textSalary.setBounds(200,200,100,30);
        add(textSalary);

        try {
            conn c = new conn();
            String query = "select * from employee where empId = '"+choiceEmpId.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPosition.setText(resultSet.getString("position"));
                textSalary.setText(resultSet.getString("salary"));
            }


        }catch (Exception E){
            E.printStackTrace();
        }
        choiceEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c = new conn();
                    String query = "select * from employee where empId = '"+choiceEmpId.getSelectedItem()+"'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPosition.setText(resultSet.getString("position"));
                        textSalary.setText(resultSet.getString("salary"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        // Button
        JButton del = new JButton("Delete");
        del.setBounds(80,300,100,30);
        del.setBackground(Color.red);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==del){


                    try{
                        conn c = new conn();
                        String query = "delete from employee where empId = '"+ choiceEmpId.getSelectedItem()+"'";

                        c.statement.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Deleted successfully");
                        setVisible(false);
                        new Main_class();

                    }catch (Exception E){
                        E.printStackTrace();
                    }

                }

            }
        });
        add(del);

        JButton back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.white);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main_class();


            }
        });
        add(back);




        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);


    }


    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
