package mess;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//public class Mess extends JPanel implements ActionListener,CaretListener, MouseListener
//
//{
//	public JComboBox<String> combox;//��Ϣ��Ͽ�
//	private JTextField text_keyword;//"������ؼ���"�ı�
//	protected JButton delete,delete_all;//ɾ����ɾ��ȫ����ť
//	protected JList<String> jlist;//�б��
//	protected DefaultListModel<String> listmodel;//�б��ģ��
//	String[] str={
//			"���ڿ�չ��̬�������⹤����֪ͨ",
//			"�����������ܱ�·����ʱ��ͨ���Ƶ�֪ͨ",
//			"��ϪУ��ѧ����У��ܰ��ʾ",
//			"���ڻ�ϪУ����������ʱ��ͨ���Ƶ�֪ͨ",
//			"���ڼ�ǿ��ϪУ�����������֪ͨ"
//		};
//	
//	public Mess()
//	{
//		this.setLayout(new BorderLayout());//���߲���
//		this.setBorder(new TitledBorder("��Ϣ����"));//���������д�����߿�
//		
//		this.listmodel=new DefaultListModel<String>();//�����յ��б��ģ��
//		if(str!=null)
//			for(int i=0;i<str.length;i++)
//				this.listmodel.addElement(str[i]);//�б��ģ�����������
//		
//		this.jlist=new JList<String>(this.listmodel);//�����б��ָ���б��ģ��
//		this.add(new JScrollPane(this.jlist));//�����Ӱ����б��Ĺ�������
//		jlist.addMouseListener(this);//�б��ѡ���¼�������
//		
//		JPanel cmdpanel=new JPanel();//�������
//		this.add(cmdpanel,"North");//���������������
//		
//		String[][] str= {{"ɾ��","ɾ��ȫ��"},{"ȫ��","�Ѷ�","δ��"}};
//		cmdpanel.add(this.combox=new JComboBox<String>(str[1]));//��������������Ϣ��Ͽ�
//		combox.addActionListener(this);//"ȫ��","�Ѷ�","δ��"��Ͽ���������¼�
//		
//		cmdpanel.add(this.text_keyword=new JTextField("������ؼ���",8));
//		text_keyword.addCaretListener(this);//"������ؼ���"�༭�¼�������
//		
//		for(int i=0;i<str.length;i++)//������������"ɾ��"��"ɾ��ȫ��"��ť
//		{
//			JButton button=new JButton(str[0][i]);
//			button.addActionListener(this);//"ɾ��","ɾ��ȫ��"��ť���������¼�
//			cmdpanel.add(button);
//		}
//		
//		this.setVisible(true);
//	}
//	
//	//���ĳ����Ϣ�󣬸���Ϣ��Ϊ�Ѷ�
//	//���·���ʵ�� Mouselistener����¼��ӿ�
//	public void mouseClicked(MouseEvent event)//�б��ѡ���¼�������
//	{
//		String str1 = jlist.getSelectedValue();//����ѡ�ж���
//		int j=jlist.getSelectedIndex();//����ѡ�������
//      for(int i=0;i<str.length;i++)
//		    {
//      	    if(str[i].equals(str1)==true)
//      		{
//      	    	if(!str[i].endsWith("(�Ѷ�)"))
//      	    	{
//      	    		str[i]+="(�Ѷ�)";
//      	            listmodel.removeElementAt(j);//ɾ����j��
//      	            listmodel.insertElementAt(str[i], j);
//      	            this.jlist.setSelectedIndex(j);
//      	    	}
//      	    }
//          }
//	}
//	public void mousePressed( MouseEvent event) {}
//	public void mouseReleased(MouseEvent event) {}
//	public void mouseEntered( MouseEvent event) {}
//	public void mouseExited ( MouseEvent event) {}
//	
//	//���Һ��йؼ��ֵ���Ϣ
//	public void caretUpdate(CaretEvent event)//�ı��༭�����¼�
//	{
//		this.listmodel.removeAllElements(); //ɾ������������
//		String shuru=this.text_keyword.getText();
//	    for(int i=0;i<str.length;i++)
//		    {
//		    	if(str[i].indexOf(shuru)!=-1)
//				this.listmodel.addElement(str[i]);
//			}
//	}
//
//	public void actionPerformed(ActionEvent event)//�����¼�������
//	{
//		//"ɾ��"��"ɾ��ȫ��"
//		if(event.getSource()instanceof JButton)
//		{
//			switch(event.getActionCommand())
//		    {
//		        case "ɾ��":
//			        removeSelected(this.jlist,this.listmodel);break;
//	            case "ɾ��ȫ��":
//			        remove(this.listmodel);break;
//		    }
//		}
//		
//		//��ʾ"ȫ��"��"�Ѷ�"��"δ��"
//		else if(event.getSource()instanceof JComboBox)
//		{
//			if(combox.getSelectedItem()=="ȫ��")
//			{
//				listmodel.removeAllElements();
//				for(int i=0;i<str.length;i++)
//					this.listmodel.addElement(str[i]);
//			}
//			else if(combox.getSelectedItem()=="�Ѷ�")
//	        {
//	        	listmodel.removeAllElements();
//	        	for(int i=0;i<str.length;i++)
//					{
//	        		if(str[i].indexOf("(�Ѷ�)")!=-1)
//	        		this.listmodel.addElement(str[i]);
//	        		}
//	        }
//			else if(combox.getSelectedItem()=="δ��")
//	        {
//	        	listmodel.removeAllElements();
//	        	for(int i=0;i<str.length;i++)
//				    {
//      		    if(str[i].indexOf("(�Ѷ�)")==-1)
//      		    this.listmodel.addElement(str[i]);
//      		    }
//	        }
//		}
// }

public class Mess extends JPanel {
    private ArrayList<Message> messages; // �洢���е���Ϣ
    private JList<Message> messageList; // ��ʾ��Ϣ���б��
    private DefaultListModel<Message> listModel; // �б�������ģ��
    private JButton readButton; // ���Ϊ�Ѷ���ť
    private JButton deleteButton; // ɾ��ѡ�а�ť
    private JButton deleteAllButton; // ɾ��ȫ����ť
    private JTextField filterField; // �����ı���

    public Mess() {
        messages = new ArrayList<Message>();
        listModel = new DefaultListModel<Message>();
        messageList = new JList<Message>(listModel);
        JScrollPane scrollPane = new JScrollPane(messageList);
        
        // ��ʼ���ؼ�
        readButton = new JButton("���Ϊ�Ѷ�");
        readButton.setEnabled(false);
        deleteButton = new JButton("ɾ��ѡ��");
        deleteButton.setEnabled(false);
        deleteAllButton = new JButton("ɾ��ȫ��");
        filterField = new JTextField();
        
        // ���ò��ֹ�����
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(readButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(deleteAllButton);
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(filterField, BorderLayout.SOUTH);
        
        // ����¼�������
        messageList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) { // ѡ����Ϣʱ�����ñ��Ϊ�Ѷ���ɾ��ѡ�а�ť   
                if (!messageList.isSelectionEmpty()) {
                    readButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                } else 
                {readButton.setEnabled(false);
                 deleteButton.setEnabled(false);}
            }
        });
        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Message selected : messageList.getSelectedValuesList()) {// ���ѡ�е���ϢΪ�Ѷ�
                    selected.setRead(true);
                }
                messageList.repaint(); // ˢ���б��
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                // ɾ��ѡ�е���Ϣ
                for (Message selected : messageList.getSelectedValuesList())
                {messages.remove(selected);}
                listModel.removeRange(messageList.getMinSelectionIndex(), messageList.getMaxSelectionIndex());
            }
        });
        deleteAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                // ɾ��ȫ����Ϣ
                messages.clear();
                listModel.removeAllElements();
            }
        });
        filterField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                // ������Ϣ
                String text = filterField.getText().toLowerCase();
                DefaultListModel<Message> filteredModel = new DefaultListModel<Message>();
                for (Message message : messages) {
                    if (message.getContent().toLowerCase().contains(text)) {
                        filteredModel.addElement(message);
                    }
                }
                messageList.setModel(filteredModel);
            }
        });
    }
    
    //�����Ϣ����Ϣ����
    public void addMessage(Message message) {
        messages.add(message);
        listModel.addElement(message);
    }
    private static class Message {
        private String content; // ����
        private boolean read; // �Ƿ��Ѷ�
        
        public Message(String content) 
        {
        	this.content = content;
         this.read = false;
        }
        public String getContent() 
        {
        	return content;
        }
        public boolean isRead() 
        {
        	return read;
        }
        public void setRead(boolean read) 
        {
        	this.read = read;
        }

        @Override
        public String toString() {
            return content + (read ? " [�Ѷ�]" : "");
        }
    }
}

