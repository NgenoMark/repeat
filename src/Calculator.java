import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator  implements  ActionListener {

    JTextField textfield;
    JFrame frame;
    JPanel panel;
    JButton[] numberbutton = new JButton[10];
    JButton[] functionbutton = new JButton[7];
    JButton addbutton,subbutton,mulbutton,divbutton,modbutton,equbutton,clrbutton;

    double fig1=0,fig2=0,answ=0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setSize(450,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        textfield = new JTextField();
        textfield.setBounds(50,25,300,40);
        textfield.setEditable(false);
        textfield.setVisible(true);

        addbutton = new JButton("+");
        subbutton = new JButton("-");
        mulbutton = new JButton("*");
        divbutton = new JButton("/");
        modbutton = new JButton("%");
        equbutton = new JButton("=");
        clrbutton = new JButton("clr");


        functionbutton[0] = addbutton;
        functionbutton[1] = subbutton;
        functionbutton[2] = mulbutton;
        functionbutton[3] = divbutton;
        functionbutton[4] = modbutton;
        functionbutton[5] = equbutton;
        functionbutton[6] = clrbutton;



        for (int i=0;i<7;i++){
            functionbutton[i].addActionListener(this);
        }

        for(int i=0;i<10;i++){
            numberbutton[i] = new JButton(String.valueOf(i));
            numberbutton[i].addActionListener(this);
        }

        clrbutton.setBounds(150,430,100,50);



        panel= new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberbutton[7]);
        panel.add(numberbutton[8]);
        panel.add(numberbutton[9]);
        panel.add(addbutton);
        panel.add(numberbutton[4]);
        panel.add(numberbutton[5]);
        panel.add(numberbutton[6]);
        panel.add(subbutton);
        panel.add(numberbutton[1]);
        panel.add(numberbutton[2]);
        panel.add(numberbutton[3]);
        panel.add(mulbutton);
        panel.add(numberbutton[0]);
        panel.add(modbutton);
        panel.add(divbutton);
        panel.add(equbutton);



        frame.add(textfield);
        frame.add(clrbutton);
        frame.add(panel);
        frame.setVisible(true);

    }


    public static void main (String [] args){
        Calculator calc = new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if( e.getSource()== numberbutton[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == addbutton){
            fig1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if(e.getSource()==subbutton){
            fig1=Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if(e.getSource()==mulbutton){
            fig1=Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if(e.getSource()==divbutton){
            fig1=Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if(e.getSource()==modbutton){
            fig1=Double.parseDouble(textfield.getText());
            operator = '%';
            textfield.setText("");
        }




        if(e.getSource()==equbutton){
            fig2 = Double.parseDouble(textfield.getText());

            switch (operator){
                case '+':
                    answ = fig1+fig2;
                    break;
                case '-':
                    answ = fig1-fig2;
                    break;
                case '*':
                    answ = fig1 * fig2;
                    break;
                case '/':
                    answ = fig1/fig2;
                    break;
                case'%':
                    answ = fig1 % fig2;
                    break;


            }
            textfield.setText(String.valueOf(answ));
            fig1=answ;
        }

        if (e.getSource()==clrbutton){
            textfield.setText("");
        }

    }
}
