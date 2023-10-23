import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PassWordGenerator extends JFrame {

    public PasswordGeneratorLogic passWordGeneratorCall;

    public PassWordGenerator() {
        super("Password Generator");

        this.setSize(600, 700);
        this.setLayout(null);
        setLocationRelativeTo(null); //sets to middle in user's screen

        passWordGeneratorCall = new PasswordGeneratorLogic();

        addGuiComponents();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        PassWordGenerator mainFrame = new PassWordGenerator();

        mainFrame.setVisible(true);
    }

    private void addGuiComponents() {

        //title 

        JLabel title = new JLabel("Password Generator");

        title.setFont(new Font("Roboto", Font.BOLD, 30 ));

        title.setHorizontalAlignment(SwingConstants.CENTER);

        title.setBounds(0, 13, 560, 45);

        add(title);


        //result box

        JTextArea resultBox = new JTextArea();

        resultBox.setEditable(false); //user cannot edit this box

        resultBox.setFont(new Font("Roboto", Font.BOLD, 28));

        //in case result generated is long

        JScrollPane resultBoxPane = new JScrollPane(resultBox);

        resultBoxPane.setBounds(35, 98, 510, 65);

        resultBoxPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        add(resultBoxPane);

        //password length for user to choose

        JLabel passwordLength = new JLabel("Password Length");

        passwordLength.setFont(new Font("Roboto", Font.BOLD, 20));


        passwordLength.setBounds(38, 200, 560, 45);

        add(passwordLength);

        JTextArea passwordLengthInput = new JTextArea();

        passwordLengthInput.setFont(new Font("Roboto", Font.PLAIN, 18));

        passwordLengthInput.setBounds(300, 200, 250, 50);

        passwordLengthInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(passwordLengthInput);

        //creating toggles for user to choose 

        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Roboto", Font.PLAIN, 15));
        numbersToggle.setBounds(38, 300, 200, 60);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Roboto", Font.PLAIN, 15));
        symbolsToggle.setBounds(320, 300, 200, 60);
        add(symbolsToggle);

        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Roboto", Font.PLAIN, 15));
        uppercaseToggle.setBounds(38, 400, 200, 60);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Roboto", Font.PLAIN, 15));
        lowercaseToggle.setBounds(320, 400, 200, 60);
        add(lowercaseToggle);

        //generate button

        JButton generateButton = new JButton("Generate");

        generateButton.setFont(new Font("Roboto", Font.PLAIN, 18));

        generateButton.setBounds(175, 540, 200, 43);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (passwordLengthInput.getText().length() < 0) {
                    return;
                }

                boolean toggleSelected= lowercaseToggle.isSelected() || uppercaseToggle.isSelected() || symbolsToggle.isSelected() || numbersToggle.isSelected();


                int passwordLength = Integer.parseInt(passwordLengthInput.getText());

                if (toggleSelected) {
                    String passGenerate = passWordGeneratorCall.generatePassword(passwordLength, lowercaseToggle.isSelected(), uppercaseToggle.isSelected(), symbolsToggle.isSelected(), numbersToggle.isSelected());

                    resultBox.setText(passGenerate);

                }

                
            }
        });

        add(generateButton);
    }

    
}