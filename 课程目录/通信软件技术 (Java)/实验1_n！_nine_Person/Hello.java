package helloworld; 
import java.util.Scanner;				//����Scanner��
public class Hello 
{
	static int factorial (int n )         //���õݹ麯��
	{
		int a = n - 1;
		if (n == 1)
		{
			return 1;
		}
		else {
			System.out.printf("*"+a);
			a--;
			return n * factorial(n-1);
		}
	}
public static void main (String [] args)
{
	Scanner input = new Scanner(System.in);
	System.out.printf("please input n :");
	int n = input.nextInt();
	int n1 = n,n2 = n,n3 = n,n4 = n;
	int i,j = n - 1,k = n - 1;
	
	//Forѭ��ʵ��n�Ľ׳�
	System.out.printf("forѭ�������n!=" + n);
	for (i = n - 1;i > 0;i--)
	{
		n1 = n1 * i;
		System.out.printf("*" + i);
	}
	System.out.printf("=" + n1);
	System.out.printf("\n");
	
	//whileѭ��ʵ��n�Ľ׳�
	System.out.printf("whileѭ������n!=" + n);
	while (j > 0)
	{
		n2=n2 * j;
		System.out.printf("*" + j);
		j--;
	}
	System.out.printf("=" + n2);
	System.out.printf("\n");
	
	//do whileѭ��ʵ��n�Ľ׳�
	System.out.printf("do whileѭ������n!=" + n);
	do
	{
		n3 = n3 * k;
		System.out.printf("*" + k);
		k--;
	}
	while (k > 0);
	System.out.printf("=" + n3);
	System.out.printf("\n");
	
	//�ݹ�ʵ��n�Ľ׳ˣ��ݹ麯��д��ǰ��
	System.out.printf("�ݹ����n!=" + n);
	n4 = factorial(n);
	System.out.printf("=" + n4);
	

    input.close(); //����������
}
}


