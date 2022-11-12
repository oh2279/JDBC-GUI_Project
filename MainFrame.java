import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    JComboBox<String> DeptComboBox = new JComboBox<>();
    JComboBox<String> SexComboBox = new JComboBox<>();
    JComboBox<String> BdateComboBox = new JComboBox<>();
    JTextField Salary = new JTextField();
    JTextField Underling = new JTextField();

    // 크게 7개의 패널로 구분 (기능별)
    MainFrame()
    {
        // -----첫번째 패널 : 콤보박스들만 있는 패널-----
        JPanel ComboBoxPanel = new JPanel();// 생성

        String[] SearchScope = { "전체", "부서", "성별", "연봉(초과)", "생일(월)", "부하직원"}; // 검색 범위
        String[] Bdate = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] Department = { "Research", "Administration", "Headquarters" };
        String[] Sexs = { "M", "F" };

        // list처럼 콤보박스에 String 추가
        JComboBox<String> Category = new JComboBox<>(SearchScope);

        Category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeptComboBox.setVisible(false);
                SexComboBox.setVisible(false);
                Salary.setVisible(false);
                BdateComboBox.setVisible(false);
                Underling.setVisible(false);

                if("부서".equals(Category.getSelectedItem().toString())){
                    DeptComboBox.setVisible(true);
                }
                else if("성별".equals(Category.getSelectedItem().toString())){
                    SexComboBox.setVisible(true);
                }
                else if("연봉(초과)".equals(Category.getSelectedItem().toString())){
                    Salary.setVisible(true);
                }
                else if(("생일(월)".equals(Category.getSelectedItem().toString()))){
                    BdateComboBox.setVisible(true);
                }
                else if(("부하직원".equals(Category.getSelectedItem().toString()))){
                    Underling.setVisible(true);
                }
            }
        });
        ComboBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽에 배치
        ComboBoxPanel.add(new JLabel("검색 범위 "));
        ComboBoxPanel.add(Category);

        DeptComboBox = new JComboBox<>(Department);
        ComboBoxPanel.add(DeptComboBox);

        SexComboBox = new JComboBox<>(Sexs);
        ComboBoxPanel.add(SexComboBox);

        Salary = new JTextField(10);
        ComboBoxPanel.add(Salary);

        BdateComboBox = new JComboBox<>(Bdate);
        ComboBoxPanel.add(BdateComboBox);

        Underling = new JTextField(10);
        ComboBoxPanel.add(Underling);

        DeptComboBox.setVisible(false);
        SexComboBox.setVisible(false);
        Salary.setVisible(false);
        BdateComboBox.setVisible(false);
        Underling.setVisible(false);

        // ----------

        // ----- 두번째 패널 : 체크박스들만 있는 패널 -----
        JPanel CheckBoxPanel = new JPanel(); // 생성

        CheckBoxPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽에 배치
        CheckBoxPanel.add(new JLabel("검색 항목 "));

        // 일단 전부 check된 채로 표시
        JCheckBox nameCheckBox = new JCheckBox("Name", true);
        JCheckBox ssnCheckBox = new JCheckBox("Ssn", true);
        JCheckBox bdateCheckBox = new JCheckBox("Bdate", true);
        JCheckBox addressCheckBox = new JCheckBox("Address", true);
        JCheckBox sexCheckBox = new JCheckBox("Sex", true);
        JCheckBox salaryCheckBox = new JCheckBox("Salary", true);
        JCheckBox supervisorCheckBox = new JCheckBox("Supervisor", true);
        JCheckBox departmentCheckBox = new JCheckBox("Department", true);
        JButton SearchButton = new JButton("검색");
        CheckBoxPanel.add(nameCheckBox);
        CheckBoxPanel.add(ssnCheckBox);
        CheckBoxPanel.add(bdateCheckBox);
        CheckBoxPanel.add(addressCheckBox);
        CheckBoxPanel.add(sexCheckBox);
        CheckBoxPanel.add(salaryCheckBox);
        CheckBoxPanel.add(supervisorCheckBox);
        CheckBoxPanel.add(departmentCheckBox);
        CheckBoxPanel.add(SearchButton);
        // ----------

        // ----- 세번째 패널 : 선택한 직원을 보여주는 패널-----
        JPanel SearchResultPanel = new JPanel();
        SearchResultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel SelectedEmployee = new JLabel("선택한 직원: ");
        SelectedEmployee.setFont(new Font("Dialog", Font.BOLD, 18));

        JLabel ShowSelectedEmployee = new JLabel(); // 선택한 직원 보여주기
        ShowSelectedEmployee.setFont(new Font("Dialog", Font.BOLD, 18));
        SearchResultPanel.add(SelectedEmployee);
        SearchResultPanel.add(ShowSelectedEmployee);
        // ----------

        // ----- 네번째 패널 : 인원수 보여주는 패널 -----
        JPanel TotalPanel = new JPanel();
        TotalPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel PeopleCount = new JLabel("인원수 : ");
        JLabel ShowPeopleCount = new JLabel();
        TotalPanel.add(PeopleCount);
        TotalPanel.add(ShowPeopleCount);
        // ----------

        // ----- 다섯번째 패널 : 내용 수정하는 패널 -----
        JPanel UpdatePanel = new JPanel();
        UpdatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel UpdateLabel = new JLabel("수정");
        JTextField Input = new JTextField(20); // 입력
        JButton UpdateButton = new JButton("UPDATE");

        String[] UpdateScope = { "Address", "Sex", "Salary"}; // 수정 가능한 항목

        // list처럼 콤보박스에 String 추가
        JComboBox<String> UpdateCategory = new JComboBox<>(UpdateScope);
        UpdatePanel.add(UpdateLabel);
        UpdatePanel.add(UpdateCategory);
        UpdatePanel.add(Input);
        UpdatePanel.add(UpdateButton);
        // -----------

        // ----- 여섯번째 패널 : 데이터 삭제하는 패널-----
        JPanel DeletePanel = new JPanel();
        DeletePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton DeleteButton = new JButton("선택한 데이터 삭제");
        DeletePanel.add(DeleteButton);
        // ----------

        // ----- 일곱번째 패널 : 새로운 직원 정보 추가하는 패널 -----
        JPanel InsertPanel = new JPanel();
        InsertPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton InsertButton = new JButton("새로운 직원 정보 추가");
        InsertPanel.add(InsertButton);
        InsertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2();
            }
        });
        // ----------

        // ----- 패널 레아아웃 구성 -----
        JPanel Top = new JPanel();
        Top.setLayout(new BoxLayout(Top, BoxLayout.Y_AXIS));
        Top.add(ComboBoxPanel);
        Top.add(CheckBoxPanel);

        JPanel Half = new JPanel();
        Half.setLayout(new BoxLayout(Half, BoxLayout.X_AXIS));
        Half.add(SearchResultPanel);

        JPanel Bottom = new JPanel();
        Bottom.setLayout(new BoxLayout(Bottom, BoxLayout.X_AXIS));
        Bottom.add(TotalPanel);
        Bottom.add(UpdatePanel);
        Bottom.add(DeletePanel);
        Bottom.add(InsertPanel);

        JPanel ShowVertical = new JPanel();
        ShowVertical.setLayout(new BoxLayout(ShowVertical, BoxLayout.Y_AXIS));
        ShowVertical.add(Half);
        ShowVertical.add(Bottom);


        add(Top, BorderLayout.NORTH);
        add(ShowVertical, BorderLayout.SOUTH);
        // ----------

        // 기본 설정
        setTitle("Information Retrival System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}