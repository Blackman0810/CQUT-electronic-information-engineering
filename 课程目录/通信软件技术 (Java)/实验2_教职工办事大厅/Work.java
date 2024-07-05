package work;
	import java.awt.*;
	import java.awt.event.*;
	import java.awt.font.TextAttribute;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.Reader;
	import java.io.Writer;
	import java.util.HashMap;
	import javax.swing.*;
	import javax.swing.border.TitledBorder;

	public class Work extends JPanel implements ActionListener
	{
		private JComboBox<String> combox_typeface;//��������Ͽ�����������ΪString
		protected JComboBox<Integer> combox_size;//�ֺ���Ͽ�����������ΪInteger
		private JCheckBox[] checkbox;///���θ�ѡ������
		private JRadioButton[] radios;///��ɫ��ѡ��ť����
		protected Color[] colors= {Color.red,Color.green,Color.blue};//��ɫ������������
		private String[] colorname= {"red","green","blue"};//��ɫ�������ַ�������
		protected JTextArea text;//�ı���
		protected JToolBar toolbar;//������
		private File file;
		protected JFileChooser fchooser;//�ļ�ѡ��Ի���
		private JButton bopen;
		private JButton bsave;
		
		public Work()
		{
			this.setLayout(new BorderLayout());//���߲���
			this.setBorder(new TitledBorder("������־"));//���������д�����߿�
			this.toolbar=new JToolBar();//��������Ĭ��ˮƽ����
			this.add(this.toolbar,"North");//����ڿʹ��񱱱���ӹ�����
			
			GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
			String[] fontsName=ge.getAvailableFontFamilyNames();//�������ϵͳ���������ַ���
			this.combox_typeface=new JComboBox<String>(fontsName);//��Ͽ���ʾϵͳ����
			this.combox_typeface.addActionListener(this);//������Ͽ���������¼�
			this.toolbar.add(this.combox_typeface);//�����������������Ͽ�
			
			Integer[] sizes= {12,22,32,42,52};//�ֺ�
			this.combox_size=new JComboBox<Integer>(sizes);//�ֺ���Ͽ�
			this.combox_size.setEditable(true);// ������Ͽ�ɱ༭
			this.combox_size.addActionListener(this);
			this.toolbar.add(this.combox_size);//�ֺ���ϼ��������¼�
			
			String[] stylestr= {"����","б��","�»���"};//����
			this.checkbox=new JCheckBox[stylestr.length];//���θ�ѡ������
			for(int i=0;i<stylestr.length;i++)
			{
				this.toolbar.add(this.checkbox[i]=new JCheckBox(stylestr[i]));
				this.checkbox[i].addActionListener(this);//��ѡ����������¼�
			}
			
			ButtonGroup bgroup_color=new ButtonGroup();//��ť��
			this.radios=new JRadioButton[this.colorname.length];//��ɫ��ѡ��ť����
			for(int i=0;i<this.radios.length;i++)
			{
				this.radios[i]=new JRadioButton(this.colorname[i]);//��ɫ��ѡ��ť����
				this.radios[i].setForeground(this.colors[i]);//���õ�ѡ��ť���ı���ɫ
				this.radios[i].addActionListener(this);//��ɫ��ѡ��ť������������¼�
				bgroup_color.add(this.radios[i]);//��ť����ӵ�ѡ��ť
				this.toolbar.add(this.radios[i]);//��������ӵ�ѡ��ť
			}
			this.radios[0].setSelected(true);//���õ�ѡ��ťΪѡ��״̬
			bopen=new JButton("��",new ImageIcon("C:/Users/Pictures/��.gif"));//��ť����ͼ��
			bopen.addActionListener(this);
			this.toolbar.add(bopen);//��������Ӱ�ť
			bsave=new JButton("����",new ImageIcon("C:/Users/Pictures/����.gif"));
			bsave.addActionListener(this);
			this.toolbar.add(bsave);
			this.text=new JTextArea("ף��ÿ�칤�����!");
			this.add(new JScrollPane(this.text));//�����Ӱ����ı����Ĺ�������
			this.text.setForeground(colors[0]);//�����ı�����ɫ
			this.fchooser=new JFileChooser(new File("C:\\Users\\admin\\Desktop\\java�γ���ҵ\\java",""));//�����ļ��Ի���ָ����ʼ·��
			this.setVisible(true);
		}
		public void actionPerformed(ActionEvent event)//�����¼�������
		{
			//��ɫ
			if(event.getSource()instanceof JRadioButton)//������ɫ��ť
			    this.text.setForeground(((JComponent)event.getSource()).getForeground());//�����ı������ı���ɫͬѡ�а�ť
			//���µ����������йص���Ͽ򡢸�ѡ��ʱ���޸��ı���������
			else if(event.getSource() instanceof JComboBox<?>||event.getSource() instanceof JCheckBox)
			{
				int size = 0;
				//����
				String fontname = (String)this.combox_typeface.getSelectedItem();//���������
				Object obj =this.combox_size.getSelectedItem();//����ֺ���Ͽ�ѡ���������ֵ
				if(obj != null)//ִ��combox.removeAllItems()����������obj==null
				{
					try
					{
						if(obj instanceof Integer)//�ж�obj�Ƿ�����Integerʵ��
							size = ((Integer)obj).intValue();//�������ֵ
						else if(obj instanceof String)//�ֺ���Ͽ������ַ���
							size = Integer.parseInt((String)obj);//����ֺ�
						if(size<20||size>200)//���ֺų�����Χ���׳��쳣
							throw new Exception(size+"�ֺų���20~20B��Χ��");
						java.awt.Font font = this.text.getFont();//����ı����ĵ�ǰ�������	
						//����
						int style =font.getStyle();//�������
						switch(event.getActionCommand())//��ѡ��
						{case "����":style ^= 1; break;
						case "б��":style ^= 2; break;}	
						//�����ı������塢���Ρ��ֺ�
						this.text.setFont(new Font(fontname,style, size));
						//�»���
						if(event.getSource()==checkbox[2])
						{
							HashMap<TextAttribute,Object> hm=new HashMap<TextAttribute,Object>();
						    hm.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
						    hm.put(TextAttribute.SIZE,size);//�»��߳���
						    if(checkbox[2].isSelected()==true)
						    	this.text.setFont(new Font(hm));
						}
						insert(this.combox_size,size);//�������ֺŲ��뵽�ֺ���Ͽ򣬲������ظ���
					}
					catch(NumberFormatException ex)//������ֵ��ʽ�쳣
					{
						JOptionPane.showMessageDialog(this,ex.getMessage()+"����ת����������");
					}
					catch(Exception ex)//�����������͵��쳣
					{
						JOptionPane.showMessageDialog(this, ex.toString());
					}
				}
			}
			//��
			else if(event.getSource()==bopen&&fchooser.showOpenDialog(this)==0)
			{
				this.file=fchooser.getSelectedFile();//��ȡ�ļ��Ի����ѡ���ļ�
				this.readFrom(this.file,this.text);//��ȡ�ļ����ı���
				return;
			}
			//����
			else if(event.getSource()== bsave&&fchooser.showSaveDialog(this)==0)
			{
				this.file=fchooser.getSelectedFile();//��ȡ�ļ��Ի����ѡ���ļ�
				if(!file.getName().endsWith(".txt"))
				    this.file=new File(this.file.getAbsolutePath()+".txt");//����ļ���չ��
				this.writeTo(this.file, this.text);//�����ļ�����
			}
		}
		private void insert(JComboBox<Integer> combox_size2, int size) {
			// TODO Auto-generated method stub
		}
		//��ȡ�ļ����ַ�������ӵ�text�ı�����
		public void readFrom(File filename,JTextArea text)
		{
			try
			{Reader reader = new FileReader(filename);//�ļ��ַ�������
			BufferedReader bufrd = new BufferedReader(reader);//�����ַ�������
			text.setText("");//����ı���
			String line;
			while((line=bufrd.readLine()) != null)//��ȡ�ַ����������ַ���������������null
				text.append(line+"\r\n");//�ı������line�ַ���
			bufrd.close();
			reader.close();}
			catch(FileNotFoundException ex)//���ļ������ڣ�������ļ�
			{
				if(!filename. equals(""))
					JOptionPane.showMessageDialog(null,"\""+filename+"\"�ļ�������.");
			}
			catch(IOException ex){}
		}
		//���ı����е��ַ���д�뵽�ļ�
		public void writeTo(File filename,JTextArea text)
		{
			try
			{Writer wr = new FileWriter(filename);//�ļ��ַ������
				wr.write(text.getText());//д���ı����е��ַ���
				wr.close();}
			catch(FileNotFoundException ex)//�ļ��������쳣
			{JOptionPane.showMessageDialog(null,"\""+filename+"\"�ļ�������.");}
			catch(IOException ex){}
		}
}