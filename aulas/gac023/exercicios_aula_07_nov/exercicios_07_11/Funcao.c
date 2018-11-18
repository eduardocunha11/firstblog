#include <stdio.h>
#include <stdlib.h>

int calcula_expressao(int x, int y) {
    int resp = 5;
    resp = resp + (y%x) + (y*x);
    return resp;
}

int main() {
    int a = 10, b = 20;

    resp = calcula_expressao(a, b);
    printf("\nRetorno: %d ", resp);

    printf("\nResp: %d ", resp);

    return 0;
}
