package project2;

public class Project2 {

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		 int money = 0;
		
		System.out.println("taxable Income"+" "+"Single"+" "+"Married Jiont"+" "+"Married Separate"+" "+"Head of House");
		for(money = 50000;money<=60000;money+=50)
		{
			System.out.println(money+"         "+Smaths(money)+"     "+MJmaths(money)+"      "+MSmaths(money)+"        "+HHmaths(money));
		}
	}

	public static double Smaths(int money)
	{
		return (4090+(money-29700)*0.25);
	}
	public static double MJmaths(int money)
	{
		if(money>59400)
		return (8180+(money-59400)*0.35);
		else
			return (1460+(money-14600)*0.15);
	}
	public static double MSmaths(int money)
	{
		if(money>59975)
		return (11658.75+(money-58875)*0.28);
		else return (4090+(money-29700)*0.25);
	}
	public static double HHmaths(int money)
	{
		return (5447.5+(money-39800)*0.35);
	}
}
