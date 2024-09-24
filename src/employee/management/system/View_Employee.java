package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame {

    Choice choiceEmp;
    JTable table;
//    JButton search,update, back;

    View_Employee(){
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEmp = new Choice();
        choiceEmp.setBounds(180,20,150,20);
        add(choiceEmp);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEmp.add(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        JButton s = new JButton("Search");
        s.setBounds(20,70,80,20);
        s.setBackground(Color.cyan);
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== s){
                    String query = "select * from employee where empId = '"+choiceEmp.getSelectedItem()+"'";
                    try {
                        conn c = new conn();
                        ResultSet resultSet = c.statement.executeQuery(query);
                        table.setModel(DbUtils.resultSetToTableModel(resultSet));


                    }catch (Exception E){
                        E.printStackTrace();
                    }

                }

            }
        });
        add(s);


        JButton update = new JButton("Update");
        update.setBounds(120,70,80,20);
        update.setBackground(Color.cyan);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== update){
                    setVisible(false);
                    new UpdateEmployee(choiceEmp.getSelectedItem());

                }

            }
        });
        add(update);

        JButton back = new JButton("Back");
        back.setBounds(220,70,80,20);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== back){
                    try{
                        conn c = new conn();
                        ResultSet resultSet = c.statement.executeQuery("select * from employee");
                        table.setModel(DbUtils.resultSetToTableModel(resultSet));

                    }catch (Exception E){
                        E.printStackTrace();
                    }

                }

            }
        });
        add(back);

        JButton home = new JButton("Home");
        home.setBounds(550,70,80,20);

        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== home){
                    setVisible(false);
                    new Main_class();

                }

            }
        });
        add(home);

        // Adding the "Average Salary" Button
        JButton avgSalary = new JButton("Avg Salary");
        avgSalary.setBounds(350, 70, 100, 20);
        avgSalary.setBackground(Color.cyan);
        avgSalary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == avgSalary){
                    String query = "SELECT AVG(salary) AS avg_salary FROM employee";
                    try {
                        conn c = new conn();
                        ResultSet rs = c.statement.executeQuery(query);
                        if(rs.next()){
                            double avgSalary = rs.getDouble("avg_salary");
                            JOptionPane.showMessageDialog(null, "Average Salary: " + avgSalary);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        add(avgSalary);




        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }


    public static void main(String[] args) {
        new View_Employee();
    }
}
