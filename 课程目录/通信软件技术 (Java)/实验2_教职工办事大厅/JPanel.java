package jPanel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.event.*;
import mess.Mess;
import setting.Setting;
import stud.Stud;
import work.Work;
public class JPanel extends JFrame implements ActionListener
{
	protected JButton message_center,student_information,work_log,personality_settings;//��Ϣ���ġ�ѧ����Ϣ��������־���������ð�ť
	JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);//���´�������ڷָ����ߵ����
	File file=new File("C:\\Users\\admin\\Desktop\\java�γ���ҵ\\java\\�˺�����.txt ");
	JTextField text;//�����ı��༭��
	private JLabel name;
	public JPanel()
	{
		super("��ְ�����´���");
		this.setSize(990,180);//���ô��ڴ�С
		this.setLocationRelativeTo(null);//������������Ļ����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//�������ڵĹرհ�ť��������������
		this.getContentPane().add(split);//������ݴ�������ӷָ�����
		split.setDividerLocation(137);//����ˮƽ�ָ�����λ��
		split.setOneTouchExpandable(true);
	    JPanel leftpanel=new JPanel();//��������񲼾֣�6��1��
	    split.add(leftpanel);//����������left���
	    this.text=new JTextField("456");
		this.readFrom(this.file,this.text);
		String name=text.getText();
		leftpanel.add(this.name=new JLabel("��ʦ ������죡"));
//		leftpanel.add(new RollbyJPanel(n.substring(0,n.indexOf("#"))+" �������!"));
		leftpanel.add(this.message_center=new JButton("��Ϣ����"));
		leftpanel.add(this.student_information=new JButton("ѧ����Ϣ"));
		leftpanel.add(this.work_log=new JButton("������־"));
		leftpanel.add(this.personality_settings=new JButton("��������"));
		split.add(new Mess());//��������Message���
		this.message_center.setSelected(true);
		this.message_center.addActionListener(this);//��Ϣ���İ�ť���������¼�
		this.student_information.addActionListener(this);//ѧ����Ϣ��ť���������¼�
		this.work_log.addActionListener(this);//������־��ť���������¼�
		this.personality_settings.addActionListener(this);//�������ð�ť���������¼�
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent event)//�����¼�������
	{
		if(event.getSource()==message_center)//����"��Ϣ����"��ť
		{
			this.split.setRightComponent(new Mess());
		}
		else if(event.getSource()==student_information)//����"ѧ����Ϣ"��ť
		{
			this.split.setRightComponent(new Stud());
		}
		else if(event.getSource()==work_log)//����"������־"��ť
		{
			this.split.setRightComponent(new Work());
		}
		else if(event.getSource()==personality_settings)//����"��������"��ť
		{
			this.split.setRightComponent(new Setting());
		}
	}
	//��ȡ�˺������ļ����ַ�������ӵ�text�ı�����
		public void readFrom(File filename,JTextField text)
		{
			try{
				Reader reader = new FileReader(filename);//�ļ��ַ�������
				BufferedReader bufrd = new BufferedReader(reader);//�����ַ�������
				text.setText("");//����ı���
				String line;
				while((line=bufrd.readLine()) != null)//��ȡ�ַ����������ַ���������������null
				text.setText(line);//�ı������line�ַ���
				bufrd.close();
				reader.close();}
			catch(FileNotFoundException ex)//���ļ������ڣ�������ļ�
			{
				if(!filename. equals(""))
					JOptionPane.showMessageDialog(null,"\""+filename+"\"�ļ�������.");
			}
			catch(IOException ex){}
		}
	public static void main(String[] arg)
	{new JPanel();}
}