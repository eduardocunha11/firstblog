#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_CADASTROS 5

struct cadastro {
    char nome[30];
    int idade;
    float salario;
    char sexo;
};

int main() {

    struct cadastro cadastros[MAX_CADASTROS];
    int i;

    for (i = 0; i < MAX_CADASTROS; i++) {
        printf("\n Digite um nome: ");
        gets(cadastros[i].nome);
        getchar();

        printf("\n Digite uma idade: ");
        scanf("%d", &cadastros[i].idade);
        getchar();

        printf("\n Digite o salario: ");
        scanf("%f", &cadastros[i].salario);
        getchar();

        printf("\n Digite o sexo da pessoa ('m' ou 'f'): ");
        scanf("%c", &cadastros[i].sexo);
        getchar();
    }

    //Imprima apenas os homens com salario maior do que 1000

    printf("\n Os homens com salario maior do que 1000 sao: ");
    for(i = 0; i < MAX_CADASTROS; i++) {
        if (cadastros[i].sexo == 'm' && cadastros[i].salario > 1000) {
            printf("\n Nome: %s ", cadastros[i].nome);
        }
    }
    return 0;
}
