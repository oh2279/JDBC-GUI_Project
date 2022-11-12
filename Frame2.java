import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends JFrame{

    Frame2() {
        JPanel InsertPanel = new JPanel();
        InsertPanel.setLayout(new GridLayout(10,2));
        String[] Sex = {"M", "F"}; // 성별 선택

        JTextField InputFname = new JTextField(10);
        JTextField InputMiddleInit = new JTextField(10);
        JTextField InputLname = new JTextField(10);
        JTextField InputSsn = new JTextField(10);
        JTextField InputBdate = new JTextField(10);
        JTextField InputAddress = new JTextField(10);
        JComboBox<String> SexCategory = new JComboBox<>(Sex);
        JTextField InputSalary = new JTextField(10);
        JTextField InputSuper_ssn = new JTextField(10);
        JTextField InputDno = new JTextField(10);


        InsertPanel.add(new JLabel("First Name: "));
        InsertPanel.add(InputFname);
        InsertPanel.add(new JLabel("Middle Initial: "));
        InsertPanel.add(InputMiddleInit);
        InsertPanel.add(new JLabel("Last name: "));
        InsertPanel.add(InputLname);
        InsertPanel.add(new JLabel("Ssn: "));
        InsertPanel.add(InputSsn);
        InsertPanel.add(new JLabel("Birthdate: "));
        InsertPanel.add(InputBdate);
        InsertPanel.add(new JLabel("Address: "));
        InsertPanel.add(InputAddress);
        InsertPanel.add(new JLabel("Sex: "));
        InsertPanel.add(SexCategory);
        InsertPanel.add(new JLabel("Salary: "));
        InsertPanel.add(InputSalary);
        InsertPanel.add(new JLabel("Super_Ssn: "));
        InsertPanel.add(InputSuper_ssn);
        InsertPanel.add(new JLabel("Dno: "));
        InsertPanel.add(InputDno);

        JPanel InsertButtonPanel = new JPanel();
        JButton InsertButton = new JButton("정보 추가하기");
        InsertButtonPanel.add(InsertButton);
        InsertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(InsertPanel, BorderLayout.CENTER);
        add(InsertButtonPanel, BorderLayout.SOUTH);

        setTitle("New Employee Insert System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(200, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Frame2();
    }
    // 기본 설정

}
