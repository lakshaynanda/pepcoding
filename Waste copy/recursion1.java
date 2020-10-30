import java.util.*;

public class recursion1
{
	public static String BetaPattern(int number, int step) {

		String result = "";
		if(number<0){
			result += " ";
		}
		if (number > 0) {
			step = step * -1;
			return "-1";
		}

		if (number == 0) {
			result += Integer.toString(number);
			step = step * -1;
			return result;
		}

		result += Integer.toString(number);
		String ans = BetaPattern(number + step, step);
		if (ans!="-1") {
			result += ans;
			result += Integer.toString(number);

		}
		return result + " ";
	}
	public static void rec(int n)
	{
		if(n==0)
		{
			return;
		}
		else
		{
			//rec(n-1);//Increasing
			System.out.println(n);
			rec(n-1);//Decreasing
			System.out.println(n);
		}
	}
	public static int fact(int n)
	{
		if(n==1)
		{
			return 1;
		}
		int m=n*fact(n-1);
		return m;

	}
	public static void fn(int n)
	{
		if(n==0)
		{
			return;
		}
		System.out.println(n);
		fn(n-1);
		System.out.println(n);
		fn(n-1);
		System.out.println(n);
	}
	public static void oddeven(int n)
	{
		if(n==0)
		{
			return;
		}
		else if(n%2==1)
		{
			System.out.println(n);
		}
		oddeven(n-1);
		if(n%2==0)
		{
			System.out.println(n);
		}

	}
	public static void toh(int n, String s, String h, String d)
	{
		if(n==0)
		{
			return;
		}

		toh(n-1,s,d,h);
		System.out.println("move "+n+"th disk from "+s+" to "+d);
		toh(n-1,h,s,d);
	}
	public static void main(String args[])
	{
		System.out.println(BetaPattern(-12,3));
	}
}