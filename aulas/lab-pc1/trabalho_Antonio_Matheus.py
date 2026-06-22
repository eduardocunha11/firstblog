
# TRABALHO LAB PC1 Prof Eduardo Cunha
""" Este programa tem o objetivo de armazenar uma agenda de telefones em um dicionário, e com os recursos 
baseado em um Menu para a criacao e manuntenção da agenda"""

# GRUPO 2:
# 1 - Antonio jorge dos santos Ra 20253005338
# 2 - Matheus Henrique Cunha Clemente Ra 20253003164
# 3 -
# 
import json             # Importa a Biblioteca json


""" Essa função chama a Agenda ou cria uma agenda nova caso nao exista, 
são responsaveis pelos Arquivos"""

# --- FUNÇÕES DE ARQUIVO ---

def salvar_dados():
    with open("agenda.json", "w", encoding="utf-8") as arquivo:
        json.dump(agenda, arquivo, indent=4)

# Esta parte do Codigo é uma seguranca para os dados dentro da Agenda
#  SEFURNACA DOS DADOS:
def carregar_dados():
    try:
        with open("agenda.json", "r", encoding="utf-8") as arquivo:
            return json.load(arquivo)
    except (FileNotFoundError, json.JSONDecodeError): 

        """Se o arquivo sumir ou se alguém apagar uma aspa (corromper), 
        neste passo o programa não trava, ele apenas começa uma agenda vazia,
        na versao anterior ele tavava e dava um erro.""" 
        
        print(" Observacao: Criando nova agenda ou recuperando de erro de leitura.")
        return {}

"""As funçõesa abaixo são responsaveis pelas entradas de dados do Menu"""

 # --- FUNÇÕES DA AGENDA ---

def incluirNovoNome(nome, telefones):  # Essa Função tem o objetivo de incuir nomes na agenda
    agenda[nome] = telefones
    salvar_dados()
    print(f" {nome} adicionado!")

def incluirTelefone(nome, telefone):    # Essa Outra Inclui o telefone, caso nao exista ela cria um novo
    if nome in agenda:
        agenda[nome].append(telefone)
        salvar_dados()
        print(" Telefone adicionado!")
    else:
        op = input(f" {nome} não existe. Criar novo? (s/n): ")
        if op.lower() == 's':
            incluirNovoNome(nome, [telefone])

def excluirTelefone(nome, telefone):    # Essa função Exclui o telefone da Agenda se tiver apenas 1 exclui o nome tambem
    if nome in agenda and telefone in agenda[nome]:
        agenda[nome].remove(telefone)
        if not agenda[nome]:
            del agenda[nome]
        salvar_dados()
        print(" Telefone removido!")
    else:
        print(" Não encontrado.")

def excluirNome(nome):  # Essa função Exclui o nome 
    if nome in agenda:
        del agenda[nome]
        salvar_dados()
        print(f" {nome} removido!")

def consultarTelefone(nome):    # Essa função faz a consulta de nomes, caso nao exista retorna " Nao encontrado"
    return agenda.get(nome, " Não encontrado.")

def editarNome(antigo, novo):   # Essa função tem o Objetivo de Editar o nome na agenda
    if antigo in agenda:
        agenda[novo] = agenda.pop(antigo)
        salvar_dados()
        print(" Nome alterado!")
           
def editarTelefone(nome, t_antigo, t_novo):     # Ja esse edita o telefone da lista
    if nome in agenda and t_antigo in agenda[nome]:
        idx = agenda[nome].index(t_antigo)
        agenda[nome][idx] = t_novo
        salvar_dados()
        print(" Telefone alterado!")

""" Essa função ela é reponsavel pelo carregamento da agenda e as opções 
para a entrada de dados de cada Opção"""

# --- INÍCIO ---
agenda = carregar_dados()

while True:
    print("\n---  AGENDA COMPLETA ---")
    print("1. Novo Contato (Nome e fones)")
    print("2. Adicionar Telefone")
    print("3. Excluir Telefone")
    print("4. Excluir Nome")
    print("5. Consultar Telefones")
    print("6. Editar Nome")
    print("7. Editar Telefone")
    print("8. Ver Agenda Toda")
    print("0. Sair")
    
    """ Essa parte do codigo são responsavel pala entrada dos dados baseado nas opções escolhidas"""

    opcao = input("\nEscolha: ")

    if opcao == "1":
        n = input("Nome: ")
        f = input("Telefones (separe por vírgula): ").split(",")
        incluirNovoNome(n, [i.strip() for i in f])

    elif opcao == "2":
        n = input("Nome: ")
        f = input("Novo telefone: ")
        incluirTelefone(n, f)

    elif opcao == "3":
        n = input("Nome: ")
        f = input("Telefone para remover: ")
        excluirTelefone(n, f)

    elif opcao == "4":
        n = input("Nome para excluir: ")
        excluirNome(n)

    elif opcao == "5":
        n = input("Nome: ")
        print(f" Números: {consultarTelefone(n)}")

    elif opcao == "6":
        ant = input("Nome antigo: ")
        nov = input("Nome novo: ")
        editarNome(ant, nov)

    elif opcao == "7":
        n = input("Nome: ")
        ant = input("Telefone antigo: ")
        nov = input("Telefone novo: ")
        editarTelefone(n, ant, nov)

    elif opcao == "8":
        print("\n Agenda:", agenda)

    elif opcao == "0":
        print("Saindo... Dados salvos!")
        break
    else:
        print(" Opção inválida!")
