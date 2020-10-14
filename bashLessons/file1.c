#include <stdio.h>
#include <stdlib.h>

int main(void) {
char *myenvvar=getenv("EDITOR");
char str[31] = "";
printf("enter str: ");
scanf("%30s", str);
printf("you enter: %s ", str);
printf("\n The editor environment variable is set to %s \n",myenvvar);
}
