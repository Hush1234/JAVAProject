import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Player extends JFrame {
		JTextField tf = new JTextField(20);
		JTextArea ta = new JTextArea(7, 20);

		String word = "�ڹ�";
		String listword;
		
		public void c(String list)
		{
			 this.word = list;
		}
		
		public boolean b(String list)
		{
			this.listword = list;
			int lastIndex = word.length() -1;
			char lastChar = word.charAt(lastIndex);
			char firstChar = listword.charAt(0);
			//ta.append("lastChar:"+lastChar+"\n");
			//ta.append("firstChar:"+firstChar+"\n");
			if(lastChar == firstChar)
			{
				return true;
			}
			
			return false;
		}
		
		
		public void a(){
			String[] name = {"user1","user2"};
			setTitle("�����ձ�");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			c.add(new JLabel("�Է� �� <Enter> Ű�� �Է��ϼ���"));
			c.add(tf);
			c.add(new JScrollPane(ta));
			ta.setText("���۴ܾ�� �ڹ� �Դϴ�\n");
			tf.addActionListener(new ActionListener() {
				int i = 0;
				boolean ch = true;
				public void actionPerformed(ActionEvent e) {
					JTextField t = (JTextField)e.getSource();
					ta.append(name[i]+">>" + t.getText() + "\n");
					if(b(t.getText()) == false)
					{
						ta.append(name[i]+" �й�\n");
						JOptionPane.showMessageDialog(null, name[i] + " �й�");
						System.exit(0);
					}
					c(t.getText());
					if(i == 1)
					{
						i = 0;
					}else{
						i++;
					}
					t.setText("");
				}
			});

			setSize(300,300);
			setVisible(true);
		}

}
