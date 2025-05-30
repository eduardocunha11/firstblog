'''Calcula o valor do somatorio de 1 até N'''

def somatorio(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    else:
        return n + somatorio(n - 1)
    

numero = int(input("Digite o valor de N: "))
soma = somatorio(numero)

print(f" O valor do somatorio de 1 a N eh: {soma}")