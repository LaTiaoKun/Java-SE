package project3;

import java.util.Scanner;
public class Project3 {

	public static void main(String[] args) {
		int[][]  t1 = new int[20][2];
		int[][]  t2 = new int[20][2];
		int count1 = 0 ,count2 = 0;
		int i = 2;	
		int j = 2;
		int gcd = 1;
		int lcm = 1;
		Scanner Scar = new Scanner(System.in);
		System.out.println("请输入第一个数");
		int a1 = Scar.nextInt();
		while (i<=a1)
		{
			
			if(i==a1)
			{ t1[count1][0]=i;t1[count1][1]++ ; 
			count1++;
			break;}
			else if(a1%i == 0)
			{
				a1/=i;
				t1[count1][0] = i;
				t1[count1][1]++;
				if(a1%i==0);
				else
				{
			     count1++;
				}
			}
			else 
			{
				i++;
			}
			
			
		}
		for(i=0;i<20;i++)
		{
		if(t1[i][1]!=0)
		{
			System.out.println("第"+i+"行"+t1[i][0]+" "+t1[i][1]);
		}
		}
		System.out.println("请输入第二个数");
		int a2 = Scar.nextInt();
		while (j<=a2)
		{
			
			if(j==a2)
			{ 
				t2[count2][0]=j;
				t2[count2][1]++ ; 
		        count2++;
			    break;}
			else if(a2%j == 0)
			{
				a2/=j;
				t2[count2][0] = j;
				t2[count2][1]++;
				if(a2%j==0);
				else
				{
			     count2++;
				}
			}
			else 
			{
				j++;
			}
			
		}
		for(i=0;i<20;i++)
		{
		if(t2[i][1]!=0)
		   {
			System.out.println("第"+i+"行"+t2[i][0]+" "+t2[i][1]);
		   }
		}
		for(i = 0;i<20;i++)
		{
			if(t1[i][1]!=0)
			{
				for(j = 0;j<20;j++)
				{
					if(t1[i][0]==t2[j][0])
					{
						if(t1[i][1]==t2[j][1])
							{
							for(int k = 1;k<=t1[i][1];k++)
							{
								gcd = gcd*t1[i][0];
							}
							}
						else if(t1[i][1]<t2[j][1])
						{
							for(int k = 1; k<=t1[i][1];k++)
							{
								gcd = gcd*t1[i][0];
							}
						}
						else if(t1[i][1]>t2[j][1])
						{
							for(int k = 1; k<=t2[j][1];k++)
							{
								gcd = gcd*t1[i][0];
							}
						}
					}
				}
			}
		}

		if(count1>count2) 
		{
		for(int k = 0;k<20; k++)
		{
			if(t1[k][1]!=0)
			{
				for(int m=0;m<20;m++)
				{
					if(t2[m][0]==t1[k][0])
					{
						if(t2[m][1]>=t1[k][1])
						{
							for(int n =1;n<=t2[m][1];n++)
							lcm = lcm*t2[m][0]; 
							break;
						}
						else
						{
							for(int n =1;n<=t1[k][1];n++)
								lcm=lcm*t2[m][0];
							break;
						}	
					}
					if(m==19&&t2[m][0]!=t1[k][0])
					{
						for(int n=1;n<=t1[k][1];n++)
						lcm =lcm*t1[k][0];
					}
				}
			}
		 }
		}
		else if(count1<count2)
		{
			for(int k = 0;k<20; k++)
			{
				if(t2[k][1]!=0)
				{
					for(int m=0;m<20;m++)
					{
						if(t2[k][0]==t1[m][0])
						{
							if(t2[k][1]>=t1[m][1])
							{
								for(int n =1;n<=t2[k][1];n++)
								lcm = lcm*t1[m][0]; 
								break;
							}
							else
							{
								for(int n =1;n<=t1[m][1];n++)
									lcm=lcm*t1[m][0];
								break;
							}
							
							
						}
						if(m==19&&t2[k][0]!=t1[m][0])
						{
							for(int n=1;n<=t2[k][1];n++)
							lcm =lcm*t2[k][0];
						}
					}
				}
			 }
		}
		if(count1==count2)
		{
			for(int a =0;a<20;a++)
			{
				if(t1[a][0]==t2[a][0])
				{
					if(t1[a][1]>=t2[a][1])
					{
						for(int m = 1;m<=t1[a][1];m++)
						lcm=lcm*t1[a][0];
						
						
					}
					else
					{
						for(int m = 1;m<=t2[a][1];m++)
						lcm=lcm*t1[a][0];
					}
				}
				else {
					for(int m = 1;m<=t1[a][1];m++)
					{
						lcm =lcm*t1[a][0];
					}
					for(int m = 1;m<=t2[a][1];m++)
					{
						lcm =lcm*t2[a][0];
					}
				}
			}
		}
		System.out.println("最小公倍数"+lcm);
        System.out.println("最大公约数"+gcd);
	}
}

