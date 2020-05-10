#include <stdio.h>
long int count(long int s,int flag)
{
    static long long int max=0;
    if(s==0)
    {
    max=max+1;
    return 0;
    }
    if(s-1>=0)
    count(s-1,0);
    if(s-2>=0)
    count(s-2,0);
    if(s-3>=0 && flag==0)
    count(s-3,1);
    
    return (max%1000000007);
}
int main() {
   long int s;
    scanf("%ld",&s);
    int flag=0;
    printf("%ld",count(s,flag));
    return 0;
}

