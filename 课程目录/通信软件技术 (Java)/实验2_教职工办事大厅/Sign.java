package sign;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import javax.print.ServiceUI;
import javax.swing.*;
import javax.swing.event.*;
public class Sign extends JFrame implements ActionListener
{
	private JTextField number;//�˺��ı�
	private JPasswordField password;//�����ı�
	private JCheckBox[] checkbox;//"�Զ���¼","��ס����"��ѡ��
	protected JButton register,sign_in;//ע�ᡢ��¼��ť
	File file1=new File("C:\\Users\\admin\\Desktop\\java�γ���ҵ\\java\\�˺�����.txt ");//�˺������ļ�
	File file2=new File("C:\\Users\\admin\\Desktop\\java�γ���ҵ\\java\\�Զ���¼.txt ");//�Զ���¼�ļ�
	File file3=new File("C:\\Users\\admin\\Desktop\\java�γ���ҵ\\java\\��ס����.txt ");//��ס�����ļ�
	JTextField text;//�����ı��༭��
	public Sign()
	{
		super("��ְ�����´���");
		this.setSize(350,185);//���ô��ڴ�С
		this.setLocationRelativeTo(null);//������������Ļ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//�������ڵĹرհ�ť��������������
		this.setLayout(new GridLayout(4,1));//������񲼾֣�4��1��
		JPanel panel1=new JPanel();
		this.add(panel1);
		panel1.add(this.number=new JTextField("�˺�",20));
		panel1.add(this.number,"Center");
		JPanel panel2=new JPanel(new FlowLayout());
		this.add(panel2);
		panel2.add(this.password=new JPasswordField("",20));
		panel2.add(this.password,"Center");
		JPanel panel3=new JPanel();
		this.add(panel3);
		String[] str1= {"�Զ���¼","��ס����"};
		this.checkbox=new JCheckBox[str1.length];//��ѡ������
		for(int i=0;i<str1.length;i++)
		{
			panel3.add(this.checkbox[i]=new JCheckBox(str1[i]));
			this.checkbox[i].addActionListener(this);//��ѡ����������¼�
		}
		
		JPanel panel4=new JPanel();
		this.add(panel4); 
		panel4.add(this.register=new JButton("ע��"));
		this.register.addActionListener(this);//ע�ᰴť���������¼�
		panel4.add(this.sign_in=new JButton("��¼"));
		this.sign_in.addActionListener(this);//��¼��ť���������¼�
		this.text=new JTextField("123");
		this.setVisible(true);
		this.readFrom(this.file1,this.text);//��ȡ�˺������ļ����ݵ��ı���
		String c=text.getText();//�ַ���c����ı����ַ���
		this.readFrom(this.file2,this.text);//��ȡ�Զ���¼�ļ����ݵ��ı���
		String a=text.getText();
		this.readFrom(this.file3,this.text);//��ȡ��ס�����ļ����ݵ��ı���
		String b=text.getText();
		//�����Զ���¼����ťΪѡ��״̬ʱ
		if(a.equals("true"))
		{
			number.setText(c.substring(0,c.indexOf("#")));
			password.setText(c.substring(c.indexOf("#")+1));
			new JPanel();
    	    this.setVisible(false);
    	    checkbox[0].setSelected(true);
		}
		else ;
		//������ס���롱��ťΪѡ��״̬ʱ
		if(b.equals("true"))
		{
			number.setText(c.substring(0,c.indexOf("#")));
			password.setText(c.substring(c.indexOf("#")+1));
			checkbox[1].setSelected(true);
		}
		else ;
	}
	public void actionPerformed(ActionEvent event)//�����¼�������
	{
		this.readFrom(this.file1,this.text);//��ȡ�˺������ļ����ݵ��ı���
		String n=text.getText();//�ַ���n����ı����ַ���
		String str1=number.getText();
		String str2=password.getText();
		boolean isDigit=false;  //û������
		boolean isLetter=false;//û����ĸ
		for(int i=0;i<str2.length();i++) 
		{
			if(Character.isDigit(str2.charAt(i)))  
			{
				isDigit=true;
			}
			if(Character.isLetter(str2.charAt(i)))
			{
				isLetter=true;
			}
		}
		//ע��
		if(event.getSource()==register)
		{
			{
				if(JOptionPane. showConfirmDialog(this,"ע�����˻�?","ȷ��",
						JOptionPane.YES_NO_OPTION) ==0)
				    {
				        if(str2.length()<8)//���볤��С��8λ
					    {
				        	password.setText("");
					    	JOptionPane.showMessageDialog(this, "�����ʽ��������Ӧ����8λ���Ұ���Ӣ����ĸ�����֣�");
					    }
					    else if(isDigit==false)//�ж����������Ƿ�������
						{
							password.setText("");
						    JOptionPane.showMessageDialog(this, "�����ʽ��������Ӧ����Ӣ����ĸ�����֣�");
						}
					    else if(isLetter==false)//�ж����������Ƿ�����ĸ
						{
					    	password.setText("");
					    	JOptionPane.showMessageDialog(this, "�����ʽ��������Ӧ����Ӣ����ĸ�����֣�");
					    }	
					    else
					    {
					    	text.setText(str1+"#"+str2);//�趨�ı����ַ���Ϊ�˺ź�����
					    	this.writeTo(this.file1,text);//�����µ��˺ź�����
		    	            JOptionPane.showMessageDialog(this,"ע��ɹ���");
					    }
				   }
		     }
		}
		//��¼
		if(event.getSource()==sign_in)
		{
			if(str1.equals(n.substring(0,n.indexOf("#")))==false)
				{
				    number.setText("");
			    	JOptionPane.showMessageDialog(this,"��������ȷ���˻�����");
			    }
			else if(str2.equals(n.substring(n.indexOf("#")+1))==false)
		        {
				    password.setText("");
				    JOptionPane.showMessageDialog(this,"��������ȷ�����룡");
		        }	
		    else
				{
		    	    new ServiceUI();
		    	    this.setVisible(false);
				}
		 }
		//��ѡ�Զ���¼
		if(event.getSource()==checkbox[0]) 
		{
		    if(checkbox[0].isSelected()==true)//�Զ���¼Ϊѡ��״̬
			{
				text.setText("true");
				this.writeTo(this.file2,text);//�ı�����д���Զ���¼�ļ�
				new ServiceUI();
	            this.setVisible(false);
			}
			else
			{
				text.setText("false");
				this.writeTo(this.file2,text);
			}
		}
		//��ѡ��ס����
		if(event.getSource()==checkbox[1])
		{
			if(checkbox[1].isSelected()==true)//��ס����Ϊѡ��״̬
			{
				text.setText("true");
				this.writeTo(this.file3,text);//�ı�����д���ס�����ļ�
			}
			else
			{
				text.setText("false");
				this.writeTo(this.file3,text);
			}
		}
	}
	//��ȡ�˺������ļ����ַ�������ӵ�text�ı�����
	public void readFrom(File filename,JTextField text)
	{
		try
		{
			Reader reader = new FileReader(filename);//�ļ��ַ�������
			BufferedReader bufrd = new BufferedReader(reader);//�����ַ�������
			text.setText("");//����ı���
			String line;
			while((line=bufrd.readLine()) != null)//��ȡ�ַ����������ַ���������������null
			text.setText(line);//�ı������line�ַ���
			bufrd.close();
			reader.close();
		}
		catch(FileNotFoundException ex)//���ļ������ڣ�������ļ�
		{
			if(!filename. equals(""))
				JOptionPane.showMessageDialog(null,"\""+filename+"\"�ļ�������.");
		}
		catch(IOException ex){}
	}
	//��text�ı����е��ַ���д�뵽�˺������ļ�
	public void writeTo(File filename,JTextField text)
	{
		try
		{
			Writer wr = new FileWriter(filename);//�ļ��ַ������
			wr.write(text.getText());//д���ı����е��ַ���
			wr.close();
		}
		catch(FileNotFoundException ex)//�ļ��������쳣
		{
			JOptionPane.showMessageDialog(null,"\""+filename+"\"�ļ�������.");
		}
		catch(IOException ex){}
	}
	
	public static void main(String[] arg)
	{
		new Sign();
	}
}