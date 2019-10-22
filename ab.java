import java.util.*;
import java.lang.Math; 


class ab{

	static int MIN=-1000;
	static int MAX=1000;

	static int minmax(int depth,int nodeIndex,Boolean maximazingp,int values[],int alpha,int beta,int n)
	{
		if(depth==n)
			return values[nodeIndex];

		if(maximazingp)
		{
			int best=MIN;

			
			for(int i=0;i<2;i++)
			{
				int val=minmax(depth+1,nodeIndex*2+i,false,values,alpha,beta,n);

				best=Math.max(best,val);
				alpha=Math.max(alpha,val);

				if(beta<=alpha)
					break;
			}
			return best;
		}
		else
		{
			int best=MAX;

			
			for(int i=0;i<2;i++)
			{
				int val=minmax(depth+1,nodeIndex*2+i,true,values,alpha,beta,n);

				best=Math.min(best,val);
				beta=Math.min(beta,best);

				if(beta<=alpha)
					break;
			}
			return best;
		}

	}

	public static void main(String[] args)
	{
		//int values[]={3,5,6,9,1,2,0,-1};
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter depth:");
		double depth=sc.nextInt();
		double two=2;

		//int n=2^depth;
		int n=1;
		for(int i=0;i<depth;i++)
		{
			n=n*2;
		}
		int [] values=new int[n];
		System.out.println(n);
		for(int i=0;i<n;i++)
		{
			values[i]=sc.nextInt();
		}


		System.out.println("The optimal value is : " + minmax(0,0,true,values,MIN,MAX,n));
	}
}