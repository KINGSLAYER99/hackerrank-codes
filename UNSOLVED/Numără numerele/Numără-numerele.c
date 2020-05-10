//https://www.hackerrank.com/contests/upcurve1/challenges/numara-numerele
//timeout error in 4/7 cases
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
 
int main() {
    int k,t;
    scanf("%d%d",&k,&t);
    int primes[k];
    for(int i=0;i<k;i++)
    {
        scanf("%d%*c",&primes[i]);
    }
    int a[t],b[t];
    for(int i=0;i<t;i++)
    {
        scanf("%d%d",&a[i],&b[i]);
    }
    int vara,varb,prime,count;
    for(int i=0;i<t;i++)
    {
        count=0;
       vara=a[i];
       varb=b[i];
        for(;vara<=varb;vara++)
        {
            for(int j=0;j<k;j++)
            {
                prime=primes[j];
                if((vara%prime)==0)
                {
                    count++;
                    break;
                }
            }
        }
        printf("%d\n",count);
    }
    
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    return 0;
}