//https://www.hackerrank.com/contests/upcurve1/challenges/arpita-and-ropes
#include<stdio.h>
#include<math.h>
int main(){
    int t,max=0,n,i,x;
    scanf("%d",&t);
    while(t--){
        scanf("%d",&n);
        max=n;                  //max=1 instead of 0
        for(i=1;i<=n-1;i++){    //<=
            scanf("%d",&x);
            if((i+x)>max)
                max=i+x;    //max=i+x instead of i
        }
        for(i=1;i<=n-1;i++){       // <=
            scanf("%d",&x);
            if((i+x)>max) //i+x instead of x
                max=i+x;    //max=i+x instead of i
        }
        printf("%d\n",max);        
    }
}