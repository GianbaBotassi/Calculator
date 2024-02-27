import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

//  Initializing frame components
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton,delButton,clrButton;
    JPanel panel;

//    Calculator font
    Font myFont = new Font("Calibri", Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

//    Constructor
    Calculator(){
//        Setting window frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

//        Setting textfield
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

//        Button list right side and bottom side
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(",");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

//        Put into array functional buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

//      add listener for each functional button
        for (JButton butt:functionButtons
             ) {
            butt.addActionListener(this);
            butt.setFont(myFont);
            butt.setFocusable(false);
        }

//      add listener for each number button
        for(int i = 0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

//      Setting size and position
        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            if(!textField.getText().contains(".")){
                textField.setText(textField.getText().concat("."));
            }
        }
        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource()==delButton){
            if(!textField.getText().isEmpty()){
            textField.setText(textField.getText().substring(0,textField.getText().length() - 1));
            }
        }
        if(e.getSource()==equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            };
            textField.setText(String.valueOf(result));
            num1=result;
        }

        if(e.getSource()==clrButton){
            num1 = 0;
            num2 = 0;
            result = 0;
            textField.setText("");
        }
    }


}
