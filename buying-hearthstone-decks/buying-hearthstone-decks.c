//https://www.hackerrank.com/contests/basics-of-problem-solving/challenges/buying-hearthstone-decks/
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
//This function calculates the max value possible from the given sets recursively.
int count(int arr[], int k, int cardsInSet, int n) {
    // Static keyword is used because it stores the value till program scope, so it won't get deleted as Activation Record gets removed.
    static int max = 0;
      max = cardsInSet;   
   //this loop is used bcoz we can use the same card set again, so all the sets must be checked at every iteration
    for ( int i = 0; i < k; i++) {
        if (max == n) {//There is no further point in looping if I reach max value, thus after this break, all other AR get updated with the same Max since static, and thus all AR break recursively, returning the same max value.
        break;
        }
        if (cardsInSet + arr[i] <= n) {//it means there is still scope for max to be updated
            count(arr, k, cardsInSet + arr[i], n); 
        }       
    }
    return max;
}

int main() {
    int n, k, cardsInSet = 0;
    scanf("%d %d",&n, &k); 
    int arr[k];
    for ( int i = 0; i < k; i++) {
        scanf("%d%*c", &arr[i]);
    }
    printf("%d",count(arr, k, cardsInSet, n));
    return 0;
}