package nine;

public class Nine {
	    public static void main(String[] args) 
	    {
	        for(int i = 9;i > 0;i--) 
	        {
	            for(int j = 1,k = 10 - i;j <= i;j++,k++) 
	            {
	                System.out.print(j+"��"+k+"="+k*j+"\t");// \t ������һ��TABλ�ã����ּ�����
	            }
	            System.out.println();
	            }
	        }

//	 public static void main1(String[] args) {
//	        int[][] table = new int[9][9];
//
//	        // ��ʼ����ά����                                      
//	        for (int i = 0; i < 9; i++) {
//	            for (int j = 0; j < 9; j++) {
//	                table[i][j] = (i + 1) * (j + 1);
//	            }
//	        }
//
//	        // ����žų˷���
//	        for (int i = 0; i < 9; i++) {
//	            for (int j = 0; j < 9; j++) {
//	                System.out.print(table[i][j] + "\t");
//	            }
//	            System.out.println();
//	        }
//	    }
	}
