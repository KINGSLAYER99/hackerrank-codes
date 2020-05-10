#include <stdio.h>
int main() {
	int p,q,r,s,max=0;
	int num,den,rem;
	scanf("%d",&p);
	scanf("%d",&q);

	scanf("%d",&r);
	scanf("%d",&s);

	for(int i=p;i<=q;i++)
	{
	    for(int j=r;j<=s;j++)
	    {
	        if(i>=j)
	        {
	        num=i;
	        den=j;
	        }
	        else
	        {
	          num=j;
	          den=i;
	        }
	      while((num/den)!=0) 
	      {
	          max=max+(num/den);
	          rem=(num%den);
	          if(rem==0)
	          {
	              break;
	          }
	          num=den;
	          den=rem;
	      }
	    }
	}
	printf("%d",max);
	
	return 0;
}