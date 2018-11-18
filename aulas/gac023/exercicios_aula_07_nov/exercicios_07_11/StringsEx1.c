#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

    char vet[20];
    char vet_aux[20];
    char vet_aux2[20];
    int i, pos = 0;
    int tamanho = 0;

    printf("\n Digite a string: ");
    gets(vet);

    tamanho = strlen(vet);
    printf("\n Tamanho: %d", tamanho);

    for (i = 0; vet[i] != '\0'; i++) {
        vet_aux[pos] = vet[i];
        pos = pos + 1;
    }
    vet_aux[pos] = '\0';

    printf("\n String auxiliar: %s", vet_aux);
    puts(vet_aux);

	pos = 0;
    for (i = tamanho-1; i >= 0; i--) {
        vet_aux2[pos] = vet[i];
		pos = pos + 1;
    }

    printf("\n String invertida: %s", vet_aux2);

	return 0;
}
