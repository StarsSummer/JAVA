
import java.util.Scanner;

public class LCM {
    int numofnum=0;
	static int[][] table1=new int[10][2];
	static int[][] table2=new int[10][2];
	public static void main(String[] args){
		int num1,num2,ans,i,j;
		int[][] tablef=new int[20][2];
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入第一个数");
		num1=scanner.nextInt();
		System.out.print("请输入第二个数");
		num2=scanner.nextInt();
		table1=getPrimeFactors(num1);
		table2=getPrimeFactors(num2);
		/*for(int a=0;a<10;a++)
			System.out.println(table1[a][0]+" "+table1[a][1]);
		for(int a=0;a<10;a++)
			System.out.println(table2[a][0]+" "+table2[a][1]);*/               //辅助检查prime factor table
		i=0;j=0;ans=1;
		while(table1[i][0]!=0){
			tablef[i][0]=table1[i][0];
			tablef[i][1]=table1[i][1];
			for(j=0;j<10;j++)
				if(table1[i][0]==table2[j][0]){
					if(table1[i][1]<table2[j][1])
	                	  tablef[i][1]=table2[j][1]; 
					table2[j][0]=-1;
				}
            i++;                
		}
		j=0;
		while(table2[j][0]!=0){
			if(table2[j][0]!=-1){
				tablef[i][0]=table2[j][0];tablef[i][1]=table2[j][1];i++;
			}
			j++;	
		}
		/*for(int a=0;a<20;a++)
			System.out.println(tablef[a][0]+" "+tablef[a][1]);*/                //查看最终的prime factor table
		while(i>=0){
			while(tablef[i][1]>0){
              ans=ans*tablef[i][0];
              tablef[i][1]--;
			}
			i--;
		}
		System.out.println(num1+"和"+num2+"的最小公倍数是"+ans);
	}
	static int[][] getPrimeFactors(int n){
		int i,j;
		j=0;i=2;
		int[][] table=new int[10][2];
		while(n!=1){
			if(n%i==0){
			  if(table[j][0]==0)
				table[j][0]=i;
			  table[j][1]++;
			  n=n/i;
			}
			else{
			  if(table[j][0]!=0)
				  j++;
			  i++;
			}	   
		}
    	return table;
	}
}