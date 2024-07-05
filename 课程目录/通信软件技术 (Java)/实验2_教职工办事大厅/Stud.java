package stud;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class Stud extends JPanel implements TableModelListener
{
	private DefaultTableModel tablemodel;//���ģ��
	String[][] students= {{"roy","20210106","��","20030208","������Ϣ����","2021��"},
			{"zero","20210102","Ů","20030607","ͨ�Ź���","2021��"},
			{"pezing","20210121","��","20031204","��ľ����","2021��"},
			{"fish","20210402","��","20010518","�������","2021��"}};
	
	public Stud()
	{
		this.setLayout(new BorderLayout());//���߲���
		this.setBorder(new TitledBorder("ѧ����Ϣ"));//���������д�����߿�
		String[] titles= {"����","ѧ��","�Ա�","��������","רҵ","�꼶"};
		this.tablemodel=new DefaultTableModel(students,titles);//Ĭ�ϱ��ģ�ͣ�titlesָ���б���
		JTable jtable=new JTable(this.tablemodel);//�������ָ�����ģ��
		jtable.setAutoCreateRowSorter(true);
		this.add(new JScrollPane(jtable));//��ӹ�������
		this.tablemodel.addTableModelListener(this);//���ģ�ͼ����¼�
		this.setVisible(true);
	}
	
	public void tableChanged(TableModelEvent event)//���ģ�ͼ����¼�������
	{
		int row=event.getFirstRow();//���ر��ģ���е�һ�������ĵ���
		String newnum=(String)tablemodel.getValueAt(row, 1);//����row��1�е�Ԫ��ֵ
		if(newnum.length()==8&&newnum.substring(0,4).equals("2021"))
		{
			JOptionPane.showMessageDialog(this,"�޸ĳɹ���");
		}
		else
		{
			JOptionPane.showMessageDialog(this,"ѧ�Ų�����Ҫ���޸�ʧ�ܣ�");
		}
	}
}