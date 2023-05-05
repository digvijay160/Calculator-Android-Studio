#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

const char *keywords[] = { "if", "else", "while", "for", "do", "int", "float", "char", "double", "return" };
const int num_keywords = 10;

int is_keyword(char *str) {
    for (int i = 0; i < num_keywords; i++) {
        if (strcmp(str, keywords[i]) == 0) {
            return 1;
        }
    }
    return 0;
}

void lexicalanalyser(char *code){
    int i=0;

    while(code[i]){
        if(isdigit(code[i])){
                char num[100];
                int j=0;
                num[j++] = code[i];
                i++;
                while (isdigit(code[i])) {
                    num[j++] = code[i];
                    i++;
                }
                num[j] = '\0';
                printf("NUMBER %s\n", num);
            }
        else if (isalpha(code[i])) {
                char word[100];
                int j = 0 ;
                word[j++] = code[i];
                i++;
                while (isalpha(code[i])) {
                    word[j++] = code[i];
                    i++;
                }
                word[j]= '\0';
                if(is_keyword(word)){
                    printf("keyword %s\n", word);
                }
                else{
                    printf("identifier %s\n", word);
                }
        }
        else{
            char operators[9] = {'+','-','*','/','=','^','<','>'};
            for(int j=0;j<9;j++){
                if(code[i]==operators[j]){
                    printf("Operator: %s\n",code[i++]);
                    break;
                }
            }
        }
        i++;
    }
}

int main()
{
    char *p = "while(num<2)";
    lexicalanalyser(p);
    return 0;
}
