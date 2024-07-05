package setting;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
public class Setting extends JPanel implements ActionListener
{
	protected JButton modify,reset;//�޸����롢�������밴ť
	protected JLabel name,old,new_password,confirm;//�����������롢�����롢ȷ���������ǩ
	private JTextField text_name;//���������ı��༭��
	private JPasswordField text_old,text_new,text_confirm;//�����롢�����롢ȷ��������
	
	File file=new File("C:\\Users\\admin\\Desktop\\java�γ���ҵ\\java\\�˺�����.txt ");//�˺������ļ�
	JTextField text;//�����ı��༭��
	
	public Setting()
	{	
		this.setLayout(new GridLayout(5,2));//������񲼾֣�5��2��
		this.setBorder(new TitledBorder("��������"));//���������д�����߿�
		JPanel panel1=new JPanel(new BorderLayout());//panel1��壬�߲���
		this.add(panel1);
		panel1.add(this.modify=new JButton("�޸�����"));
		panel1.add(this.modify,"East");//panel1��嶫�����"�޸�����"��ť4
		this.modify.addActionListener(this);//"�޸�����"��ť���������¼�
		JPanel panel2=new JPanel(new BorderLayout());//panel2��壬�߲���
		this.add(panel2);
		panel2.add(this.reset=new JButton("��������"));
		panel2.add(this.reset,"West");//panel2����������"��������"��ť
		this.reset.addActionListener(this);//"��������"��ť���������¼�
		this.add(this.name=new JLabel("����",JLabel.LEFT));
		this.add(this.text_name=new JTextField());
		this.add(this.old=new JLabel("������",JLabel.LEFT));
		this.add(this.text_old=new JPasswordField());
		this.add(this.new_password=new JLabel("������",JLabel.LEFT));
		this.add(this.text_new=new JPasswordField());
		this.add(this.confirm=new JLabel("ȷ��������",JLabel.LEFT));
		this.add(this.text_confirm=new JPasswordField());
		this.text=new JTextField("321");
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)//�����¼�������
	{
		this.readFrom(this.file,this.text);//��ȡ�˺������ļ����ݵ��ı���
		String n=text.getText();//�ַ���n����ı����ַ���
		String str1=text_old.getText();
		String str2=text_new.getText();
		String str3=text_confirm.getText();
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
		//�޸�����
		if(event.getSource()==modify)
		    {
			  if(JOptionPane. showConfirmDialog(this,"�޸�����?","ȷ��",
					JOptionPane.YES_NO_OPTION) ==0)
			    {
				   
			        if(text_name.getText().equals(n.substring(0,n.indexOf("#")))==false)
				    {
			            text_name.setText("");
			    	    JOptionPane.showMessageDialog(this,"��������ȷ��������");
			    	}
			        else if(str1.equals(n.substring(n.indexOf("#")+1))==false)
		            {
				        text_old.setText("");
				    	JOptionPane.showMessageDialog(this,"��������ȷ�ľ����룡");
		            }
				    else if(str2.equals(str3)==false)
				    {
			        	text_confirm.setText("");
			    	    JOptionPane.showMessageDialog(this,"ȷ�������룡");
				    }
				    else if(str2.length()<8)//���볤��С��8λ
				    {
				    	text_new.setText("");
			            text_confirm.setText("");
				    	JOptionPane.showMessageDialog(this, "�����ʽ��������Ӧ����8λ���Ұ���Ӣ����ĸ�����֣�");
				    }
				    else if(isDigit==false)//�ж����������Ƿ�������
					{
					    text_new.setText("");
					    text_confirm.setText("");
					    JOptionPane.showMessageDialog(this, "�����ʽ��������Ӧ����Ӣ����ĸ�����֣�");
					}
				    else if(isLetter==false)//�ж����������Ƿ�����ĸ
					{
						text_new.setText("");
						text_confirm.setText("");
						JOptionPane.showMessageDialog(this, "�����ʽ��������Ӧ����Ӣ����ĸ�����֣�");
				    }	
				    else
				    {
				    	text.setText(text_name.getText()+"#"+str2);//�趨�ı����ַ���Ϊ������������
				    	this.writeTo(this.file,text);//�����µ�����������
	    	            JOptionPane.showMessageDialog(this,"�޸ĳɹ���");
				    }
			    }
		    }
		//��������
		if(event.getSource()==reset)
		    {
			  if(JOptionPane. showConfirmDialog(this,"��������?","ȷ��",
						JOptionPane.YES_NO_OPTION) ==0)
			   {
				   if(text_name.getText().equals(n.substring(0,n.indexOf("#")))
						   &&str1.equals(n.substring(n.indexOf("#")+1))
						   &&str2.equals(str3))
		               {
		    	          text_old.setText("aaaa1111");//�趨������Ϊ"aaaa1111"
					      text.setText(text_name.getText()+"#"+text_old.getText());
					      this.writeTo(this.file,text);//���������
		    	          JOptionPane.showMessageDialog(this,"���óɹ�,������Ϊaaaa1111");
		    	       }
		          else
			           {
		        	      text_name.setText("");
		        	      text_old.setText("");
		        	      text_new.setText("");
			        	  text_confirm.setText("");
		    	          JOptionPane.showMessageDialog(this,"��������ȷ��������������");
		    	       }
			   }
		    }
	}

	private void writeTo(File file2, JTextField text2) {
		// TODO Auto-generated method stub
		
	}

	private void readFrom(File file2, JTextField text2) {
		// TODO Auto-generated method stub
		
	}
}

//public class Setting extends JPanel {
//private JPasswordField oldPasswordField;
//private JPasswordField newPasswordField;
//private JPasswordField confirmPasswordField;
//
//public SettingsPanel() {
//  // ��ʼ����岼�ֺ����
//
//  // ��ӡ��������롱��ť�ļ�����
//  resetButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//          // ����������ΪĬ��ֵ
//          newPasswordField.setText("aaaa1111");
//          confirmPasswordField.setText("aaaa1111");
//      }
//  });
//
//  // ��ӡ��޸����롱��ť�ļ�����
//  changeButton.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
//          // ��֤�������Ƿ���ȷ
//          char[] oldPassword = oldPasswordField.getPassword();
//          if (!Arrays.equals(oldPassword, "aaaa1111".toCharArray())) {
//              JOptionPane.showMessageDialog(SettingsPanel.this, "�����벻��ȷ������������");
//              oldPasswordField.setText("");
//              newPasswordField.setText("");
//              confirmPasswordField.setText("");
//              return;
//          }
//
//          // ��֤�������Ƿ���Ϲ���
//          char[] newPassword = newPasswordField.getPassword();
//          char[] confirmPassword = confirmPasswordField.getPassword();
//          if (newPassword.length < 8 || !hasDigit(newPassword) || !hasLetter(newPassword) || !Arrays.equals(newPassword, confirmPassword)) {
//              JOptionPane.showMessageDialog(SettingsPanel.this, "�����벻���Ϲ�������������");
//              newPasswordField.setText("");
//              confirmPasswordField.setText("");
//              return;
//          }
//
//          // �����֤ͨ������������
//          // TODO: ��������Ĵ���
//      }
//  });
//}