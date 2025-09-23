
def eh_triangulo(lado1, lado2, lado3):
    if (lado1 > 0 and lado2 > 0 and lado3 > 0):
        if (lado1 < lado2 + lado3) and (lado2 < lado1 + lado3) and (lado3 < lado1 + lado2):
            return True
        else:
            return False

def tipo_triangulo(lado1, lado2, lado3):
    if eh_triangulo(lado1, lado2, lado3):
        if (lado1 == lado2 == lado3):
            print("Triangulo Equilátero!")
        else:
            if (lado1 == lado2) or (lado1 == lado3) or (lado2 == lado3):
                print("Triangulo Isósceles!")
            else:
                print("Triangulo Escaleno!")
    else:
        print("Os lados nao formam um triangulo!")


a = int(input("Digite o valor do primeiro lado: ")) 
b = int(input("Digite o valor do segundo lado: "))
c = int(input("Digite o valor do terceiro lado: "))

resp = eh_triangulo(a, b, c) 

if resp == True:
    print("Eh um triangulo!!!")
else:
    print("Nao eh triangulo!")

tipo_triangulo(a, b, c)

