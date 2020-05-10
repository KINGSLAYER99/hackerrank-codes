//https://www.hackerrank.com/contests/launch-assessment-mock-2-batch-2/challenges/the-matrix-reloaded
/*

*/
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int n;
        scanf("%d",&n);
        int arr[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                scanf("%d%*c",&arr[i][j]);
            }
        }
        //int final[n*n];
        int start, destination;
        start = arr[0][0];
        destination=arr[(n-1)/2][(n-1)/2];
        int p=0;
        if(destination>start)
            printf("-1\n");
        else if(destination==start)
            printf("0\n");
        else{
            for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                    {
                        if(i==0 && j==0)
                        {
                           //final[p++]=start;
                            p++;
                        }
                        else if(arr[i][j]<start && arr[i][j]>destination)
                        {
                            //final[p++]=arr[i][j];
                            p++;
                        }   
                    }
                }
            /*int temp;
           for(int i=0;i<p-1;i++)
            {
                for(int j=i+1;j<p;j++)
                {
                    if(final[i]<final[j])
                    {
                        temp=final[i];
                        final[i]=final[j];
                        final[j]=temp;
                    }
                }
            }
            int count=1;
            for(int i=1;i<p;i++)
            {
                if(final[i]!=final[i-1])
                    count++;
            }
            printf("%d\n",count);*/
            printf("%d\n",p);
            
        }
    }
    return 0;
}
