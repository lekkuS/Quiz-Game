import java.awt.event.*;
import  java.awt.*;
import javax.swing.*;
public class Quiz implements ActionListener {
    String[] questions = {
                           "Which company created Java?",
                           "Which year was Java Created?",
                           "What was Java originally called?",
                           "who is credited with creating Java?",
                           "Which is a reserved word in java programing language?",
                           "Which is a valid keyworld in java?",
                           "Which one of the folling will declare an array and initialize it with five numbers?",
                           "Which is a validdeclaration of a string?",
                           "What is numerical range of char?",
                           "What is the name of mathod used to start a thread execution?"
                          };
    String[][] options ={
                        {"Sun Microsystem","Starbucks","Microsoft","alphabet"},
                        {"1989","1996","1972","1492"},
                        {"Apple","Lattre","Oak","Koffing"},
                        {"Steve Jobs","Bill Gates","James Gosling","Mark Zurkerburk"},
                        {"method","native","subclasses","reference"},
                        {"interface","string","Flot","unsinged"},
                        {"Array a=new Array(5)","int[] a={23,22,21,20,19}","int a[] = new int[5]","int[5]array"},
                        {"String s1 = null;","String s2 = 'null';","String s3 = (String)'abc'","String s4 = (String)'\ufeed"},
                        {"-128 to 127","65456","0 to 32767","0 to 65535"},
                        {"init()","start()","run()","resume()"}

                        };
    char[] answers={
                    'A',
                    'B',
                    'C',
                    'C',
                    'B',
                    'A',
                    'B',
                    'A',
                    'D',
                    'B'
                    };
    char guess;
    char answer;
    int index;
    int correct_guesses =0;
    int total_questions = questions.length;
    int result;
    int seconds=10;
    JFrame frame =new JFrame();
    JTextField ttextfield =new JTextField();
    JTextArea textArea=new JTextArea();
    JButton buttonA =new JButton();
    JButton buttonB =new JButton();
    JButton buttonC =new JButton();
    JButton buttonD =new JButton();

    JLabel answer_lableA=new JLabel();
    JLabel answer_lableB=new JLabel();
    JLabel answer_lableC=new JLabel();
    JLabel answer_lableD=new JLabel();
    JLabel time_lable=new JLabel();
    JLabel seconds_left=new JLabel();
    JTextField number_right=new JTextField();
    JTextField percentage = new JTextField();


    Timer timer= new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds<=0){
                displayAnswer();

            }

        }
    });
    public Quiz(){
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(650,650);
     frame.getContentPane().setBackground(new Color(50,50,50));
     frame.setLayout(null);
     frame.setResizable(false);

     ttextfield.setBounds(0,0,650,50);
     ttextfield.setBackground(new Color(25,25,25));
     ttextfield.setForeground(new Color(25,250,0));
     ttextfield.setFont(new Font("Ink Free",Font.BOLD,30));
     ttextfield.setBorder(BorderFactory.createBevelBorder(1));
     ttextfield.setHorizontalAlignment(JTextField.CENTER);
     ttextfield.setEditable(false);



        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("MV Boli",Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_lableA.setBounds(125,100,500,100);
        answer_lableA.setBackground(new Color(50,50,50));
        answer_lableA.setForeground(new Color(25,255,0));
        answer_lableA.setFont(new Font("MV Boli",Font.PLAIN,35));



        answer_lableB.setBounds(125,200,500,100);
        answer_lableB.setBackground(new Color(50,50,50));
        answer_lableB.setForeground(new Color(25,255,0));
        answer_lableB.setFont(new Font("MV Boli",Font.PLAIN,35));


        answer_lableC.setBounds(125,300,500,100);
        answer_lableC.setBackground(new Color(50,50,50));
        answer_lableC.setForeground(new Color(25,255,0));
        answer_lableC.setFont(new Font("MV Boli",Font.PLAIN,35));


        answer_lableD.setBounds(125,400,500,100);
        answer_lableD.setBackground(new Color(50,50,50));
        answer_lableD.setForeground(new Color(25,255,0));
        answer_lableD.setFont(new Font("MV Boli",Font.PLAIN,35));

        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(225,0,0));
        seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_lable.setBounds(535,475,100,25);
        time_lable.setBackground(new Color(50,50,50));
        time_lable.setForeground(new Color(225,0,0));
        time_lable.setFont(new Font("MV Boli",Font.PLAIN,16));
        time_lable.setText("timer >:D");

        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,225,0));
        number_right.setFont(new Font("Ink Free",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,225,0));
        percentage.setFont(new Font("Ink Free",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        frame.add(time_lable);
        frame.add(seconds_left);
        frame.add(answer_lableA);
        frame.add(answer_lableB);
        frame.add(answer_lableC);
        frame.add(answer_lableD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
     frame.add(textArea);
     frame.add(ttextfield);
     frame.setVisible(true);

     nextQuestion();
    }


    public void nextQuestion() {
        if (index>= total_questions) {
            results();
        }
        else {
            ttextfield.setText("Question"+(index+1));
            textArea.setText(questions[index]);

            answer_lableA.setText(options[index][0]);
            answer_lableB.setText(options[index][1]);
            answer_lableC.setText(options[index][2]);
            answer_lableD.setText(options[index][3]);
            timer.start();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);


        if (e.getSource()==buttonA) {
            answer='A';
            if (answer== answers[index]) {
                correct_guesses++;

            }

        }
        if (e.getSource()==buttonB) {
            answer='B';
            if (answer== answers[index]) {
                correct_guesses++;

            }

        }
        if (e.getSource()==buttonC) {
            answer='C';
            if (answer== answers[index]) {
                correct_guesses++;

            }

        }
        if (e.getSource()==buttonD) {
            answer='D';
            if (answer== answers[index]) {
                correct_guesses++;

            }

        }
        displayAnswer();


    }
    public void displayAnswer(){
        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] !='A')
            answer_lableA.setForeground(new Color(225,0,0));
        if(answers[index] !='B')
            answer_lableB.setForeground(new Color(225,0,0));
        if(answers[index] !='C')
            answer_lableC.setForeground(new Color(225,0,0));
        if(answers[index] !='D')
            answer_lableD.setForeground(new Color(225,0,0));

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_lableA.setForeground(new Color(25,225,0));
                answer_lableB.setForeground(new Color(25,225,0));
                answer_lableC.setForeground(new Color(25,225,0));
                answer_lableD.setForeground(new Color(25,225,0));

                answer =' ';
                seconds=10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();

            }
        });
     pause.setRepeats(false);
     pause.start();
    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_guesses/(double)total_questions)*100);

        ttextfield.setText("RESULTS!");
        textArea.setText("");
        answer_lableA.setText("");
        answer_lableB.setText("");
        answer_lableC.setText("");
        answer_lableD.setText("");

        number_right.setText("("+correct_guesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        frame.add(number_right);
        frame.add(percentage);


    }
}
