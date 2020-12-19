import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class JPanel01 extends JPanel {  // 1��° �г�
    
    private JButton j1;
    private JButton j2;
    private PJ_GUI win;
    
    public JPanel01(PJ_GUI win){
        this.win = win;
        setLayout(null);
        
        JLabel text = new JLabel("�����ձ� ����");
        text.setBounds(150, 100, 100, 100);
        add(text);
        
        j1 = new JButton("Start");
        j1.setSize(70,50);        
        j1.setLocation(50, 250);
        add(j1);
        
        j2 = new JButton("EXIT");
        j2.setSize(70,50);        
        j2.setLocation(250, 250);
        add(j2);
        
        j1.addActionListener(new MyActionListener());
        j2.addActionListener(new MyActionListener());
        
    }
    class MyActionListener implements ActionListener {    // ��ư Ű ������ �г� 2�� ȣ��
        @Override
        public void actionPerformed(ActionEvent e)
        {
        	if(e.getSource() == j1)
        	{
        		win.change("panel02");
        	}
        	else if (e.getSource() == j2)
        	{
        		System.exit(0);
        	}
        }
     }
}


class JPanel02 extends JPanel{        // 2��° �г�
    private JTextField textField;
    private JPasswordField passwordField;
    private PJ_GUI win;
    private String word;
    private final static String newline = "\n";
    
    public JPanel02(PJ_GUI win) {
        setLayout(null);
        this.win = win;

        //�Է� ����
        JTextField tf = new JTextField(); 
        tf.setSize(300, 30);
        tf.setLocation(5, 5);
        add(tf);
        
        //�Է��� ���� ���̴� â
        JTextArea ta = new JTextArea(); 
        JScrollPane jsp = new JScrollPane(ta); //â ��ũ��
        jsp.setSize(300, 200);
        jsp.setLocation(5, 50);
        add(jsp);
        //tf.setText(word);
        
        
        JButton btn1 = new JButton("�Է�");
        add(btn1);
        btn1.setBounds(310, 5, 60, 30);
        
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //�Ѹ� �Է�
                //������ �������� ������ ����
            	String word = tf.getText();
            	ta.append(word + newline);
            	tf.selectAll();
            	ta.setCaretPosition(ta.getDocument().getLength());
            
            	
            }
            
        });
    }
}

class JPanel03 extends JPanel {  // 3��° �г�
    
    private JButton j1;
    private JButton j2;
    private PJ_GUI win;
    
    public JPanel03(PJ_GUI win){
        this.win = win;
        setLayout(null);
        
        JLabel text = new JLabel("�����ձ� ������ �������ϴ�.");
        text.setBounds(150, 100, 100, 100);
        add(text);
        
        j1 = new JButton("RESTART");
        j1.setSize(70,50);        
        j1.setLocation(50, 250);
        add(j1);
        
        j2 = new JButton("EXIT");
        j2.setSize(70,50);        
        j2.setLocation(250, 250);
        add(j2);
        
        j1.addActionListener(new MyActionListener());
        j2.addActionListener(new MyActionListener());
        
    }
    class MyActionListener implements ActionListener {    // ��ư Ű ������ �г� 2�� ȣ��
        @Override
        public void actionPerformed(ActionEvent e)
        {
        	if(e.getSource() == j1)
        	{
        		win.change("panel02");
        	}
        	else if (e.getSource() == j2)
        	{
        		System.exit(0);
        	}
        }
     }
}


class PJ_GUI extends JFrame{
    
    public JPanel01 jpanel01 = null;
    public JPanel02 jpanel02 = null;
    public JPanel03 jpanel03 = null;
    
    public void change(String panelName){        // �г� 1���� 2�� ���� �� �缳��
        
        if(panelName.equals("panel01")){
            getContentPane().removeAll();
            getContentPane().add(jpanel01);
            revalidate();
            repaint();
        }else {
            getContentPane().removeAll();
            getContentPane().add(jpanel02);
            revalidate();
            repaint();
        }
    }
    
    public static void main(String[] args) {
        
       PJ_GUI win = new PJ_GUI();            
        
        win.setTitle("�����ձ� ����");
        win.jpanel01 = new JPanel01(win);
        win.jpanel02 = new JPanel02(win);
        
        win.add(win.jpanel01);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(400,400);
        win.setVisible(true);    
    }
}