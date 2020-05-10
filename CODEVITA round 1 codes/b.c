#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    char arrp[1001][27];
    char arrs[1001][101];
    char arro[1001][101];
    int lenp[1001];
    int lens[1001];
    int leno[1001];
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        scanf("%s",arrp[i]);
        scanf("%s",arrs[i]);
    } 
    for(int i=0;i<n;i++)
    {
      lenp[i]=strlen(arrp[i]);
      lens[i]=strlen(arrs[i]);
    }
    int p=0;
    for(int i=0;i<n;i++)
    {
        //printf("%d\n",i);
        for(int j=0;j<lenp[i];j++)
        {
           // printf("%c-\t",arrp[i][j]);
            for(int k=0;k<lens[i];k++)
            {
               // printf("%c,",arrs[i][k]);
                if(arrp[i][j]==arrs[i][k])
                {
               // printf("---(%c-%c)\n",arrp[i][j],arrs[i][k]);
                 arro[i][p]=arrp[i][j];
                 printf("%c",arro[i][p]);
                 p++;
                }
            }
        }
        printf("\n");
    }

    return 0;
}