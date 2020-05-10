//https://www.hackerrank.com/contests/upcurve1/challenges/mind-palaces
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n,m;
    scanf("%d%d",&n,&m);
    int arr[n][m];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            scanf("%d%*c",&arr[i][j]);
        }
    }
   /* for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            printf("%d ",arr[i][j]);
        }
        printf("\n");
    }*/
    int q;
    scanf("%d",&q);
    int arq[q];
    for(int i=0;i<q;i++)
    {
        scanf("%d",&arq[i]);
    }
    
    int flag;
    for(int k=0;k<q;k++)
    {
         flag=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j]==arq[k])
                {
                    flag=1;
                    printf("%d %d\n",i,j);
                    break;
                }
            }
            if(flag==1)
                break;
            
        }
        if(flag==0)
        printf("-1 -1\n");
    }
    
    return 0;
}
