package person;

public class Person {
public String name;     //������ʵ����Ա������������Ա
public int birthYear;  //�������

//(����ṹ�ο��˿α�P75-76��
public Person(String name,int birthYear) //���췽��
{
	this.name = name;
	this.birthYear = birthYear;  //���ø�ֵ
}
public int getAge(int year)  //�������ֵ
{
	return year-birthYear;  //����ĳ��ʱĳ�˵�����
}
public int getAge()  //�������
{
	int thisYear = 2023; // ������2023�� 
	return thisYear - birthYear; //���ؽ���ʱĳ�˵�����
}
public int olderThan(Person per) //�Ƚ�����
{
	return this.birthYear - per.birthYear; //���������ֵ
}
public boolean equals(Person per) //�Ƚ����
{
    return this.name.equals(per.name) && this.birthYear == per.birthYear; //���ص�ǰ���������ʵ����Ӧ��Ա����ֵ�Ƿ����
}
public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
