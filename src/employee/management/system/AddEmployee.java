package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame  {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JTextField tname,tposition,tsalary ;
    JComboBox Boxposition;
    JLabel tempid;



    AddEmployee(){
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,25));
        add(heading);

        // empid
        JLabel empid = new JLabel("Employee Id");
        empid.setBounds(500,150,150,30);
        add(empid);
        tempid = new JLabel(""+number);
        tempid.setBounds(650,150,150,30);
        add(tempid);


        // name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        add(tname);

        // tposition
        String items[] = {"Manager", "Developer", "HR"};

        Boxposition = new JComboBox(items);
        JLabel position = new JLabel("Position");
        position.setBounds(50,200,150,30);
        add(position);


        Boxposition.setBounds(200,200,150,30);
        add(Boxposition);
        // tsalary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(50,250,150,30);
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(200,250,150,30);
        add(tsalary);


        // Button
        JButton add = new JButton("Add Employee");
        add.setBounds(335,500,150,40);
        add.setBackground(Color.cyan);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==add){
                    String name = tname.getText();
                    String empid = tempid.getText();
                    String position = (String) Boxposition.getSelectedItem();
                    String salary = tsalary.getText();

                    try{
                        conn c = new conn();
                        String query = "insert into employee values('"+name+"','"+position+"','"+salary+"','"+empid+"');";
                        c.statement.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Details added successfully");
                        setVisible(false);
                        new Main_class();

                    }catch (Exception E){
                        E.printStackTrace();
                    }

                }

            }
        });
        add(add);

        JButton back = new JButton("Back");
        back.setBounds(50,500,150,40);
        back.setBackground(Color.white);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(back);





        setSize(980,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);


    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
