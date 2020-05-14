//https://www.hackerrank.com/challenges/nimble-game-1/problem

#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char** split_string(char*);

// Complete the nimbleGame function below.

// Please either make the string static or allocate on the heap. For example,
// static char str[] = "hello world";
// return str;
//
// OR
//
// char* str = "hello world";
// return str;
//
char* nimbleGame(int s_count, int* s) {
    char* ans;
    int output = 0;
    for(int i = 1; i < s_count; i++) {
        // for each odd number, i am calculating the moves available for it. If we move a piece from even block, we will lose,hence optimally I need to make sure that my move always makes my opponent's move start for EVEN. At each move I have to think to win. so, if the value is 0 0 1. I can't make it to 0 1 0, since optimally I need to win.

//if it is 0 1 1, I can't do 1 0 1, as then I will lose. How can I win here? I have to make a state even. So that whatever move 2nd Player makes, I will always win. so, I will do 0 2 0. Now I win.
        if(s[i] % 2 == 1) {
            output = output ^ (i);
        }
//suppose it is 0 1 1 1. Then my 1st move, if i do 1 0 1 1. Then he will make it 1 0 2 0 and then I will lose for sure. So, I have to make it even, then my next step to make it even is 0 1 2 0. So, since its even, Now, opponent will try to even it for me to be at disadvantage. So, he will do - 0 2 1 0. Now I am at disadvantage, whatever I do, I will lose, as, if i do 0 3 0 0, he will do 1 2 0 0 and i lose. if i do 1 2 0 0, same thing, I lose. So, if played optimally, player 2 always wins here       
    }
    if(output == 0) {
        //printf("Second");
        ans = "Second";
    }
    else {
        //printf("First");
        ans = "First";
    }
    return ans;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char* t_endptr;
    char* t_str = readline();
    int t = strtol(t_str, &t_endptr, 10);

    if (t_endptr == t_str || *t_endptr != '\0') { exit(EXIT_FAILURE); }

    for (int t_itr = 0; t_itr < t; t_itr++) {
        char* n_endptr;
        char* n_str = readline();
        int n = strtol(n_str, &n_endptr, 10);

        if (n_endptr == n_str || *n_endptr != '\0') { exit(EXIT_FAILURE); }

        char** s_temp = split_string(readline());

        int* s = malloc(n * sizeof(int));

        for (int i = 0; i < n; i++) {
            char* s_item_endptr;
            char* s_item_str = *(s_temp + i);
            int s_item = strtol(s_item_str, &s_item_endptr, 10);

            if (s_item_endptr == s_item_str || *s_item_endptr != '\0') { exit(EXIT_FAILURE); }

            *(s + i) = s_item;
        }

        int s_count = n;

        char* result = nimbleGame(s_count, s);

        fprintf(fptr, "%s\n", result);
    }

    fclose(fptr);

    return 0;
}

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char* data = malloc(alloc_length);

    while (true) {
        char* cursor = data + data_length;
        char* line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line) { break; }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') { break; }

        size_t new_length = alloc_length << 1;
        data = realloc(data, new_length);

        if (!data) { break; }

        alloc_length = new_length;
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';
    }

    data = realloc(data, data_length);

    return data;
}

char** split_string(char* str) {
    char** splits = NULL;
    char* token = strtok(str, " ");

    int spaces = 0;

    while (token) {
        splits = realloc(splits, sizeof(char*) * ++spaces);
        if (!splits) {
            return splits;
        }

        splits[spaces - 1] = token;

        token = strtok(NULL, " ");
    }

    return splits;
}
