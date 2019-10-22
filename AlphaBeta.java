import java.util.Scanner;
public class AlphaBeta
{
	static int MAX=Integer.MAX_VALUE;
	static int MIN=Integer.MIN_VALUE;
	
	static int minmax(int depth, int nodeIndex, boolean MaxPlayer, int values[], int alpha, int beta,
			int h)
	{
		int best;
		if(depth==h)
		{
			return values[nodeIndex];
		}
		if(MaxPlayer)
		{
			best=MIN;
			for(int i=0;i<2;i++)
			{
				int val=minmax(depth+1,nodeIndex*2+i,false,values,alpha,beta,h);
				best=Math.max(best, val);
				alpha=Math.max(alpha, best);
				if(beta<=alpha)
					break;
			}
		}
		else
		{
			best=MAX;
			for(int i=0;i<2;i++)
			{
				int val=minmax(depth+1, nodeIndex*2+i,true,values,alpha,beta,h);
				best=Math.min(best, val);
				beta=Math.min(beta, best);
				if(beta<=alpha)
					break;
			}
		}
		return best;
	}
	static int log2(int n)
	{
		return(n==1?0:1+log2(n/2));
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int h,n;
		System.out.println("\nEnter number of values : ");
		n=sc.nextInt();
		h=log2(n);
		System.out.println("\nThe depth of tree is : "+h);
		int values[]=new int[n];
		System.out.println("\nEnter values : ");
		for(int i=0;i<n;i++)
		{
			values[i]=sc.nextInt();
		}
		int opt=minmax(0,0,true,values,MIN,MAX,h);
		System.out.println("\nOptimal value is : "+opt);
		sc.close();
	}
}