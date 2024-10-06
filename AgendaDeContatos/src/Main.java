import java.util.InputMismatchException;
import java.util.Scanner;
import service.ContactsManager;

public class Main {
    public static void main(String[] args) {
        ContactsManager contactsManager = new ContactsManager(); 
        Scanner scanner = new Scanner(System.in);
        int option = 0; // Inicializa a variável option

        do {
            System.out.println("Menu:");
            System.out.println("1. Importar Contatos");
            System.out.println("2. Exportar Contatos");
            System.out.println("3. Inserir Contato");
            System.out.println("4. Remover Contato por Telefone");
            System.out.println("5. Remover Contato por Nome");
            System.out.println("6. Localizar Contato por Nome");
            System.out.println("7. Localizar Contato por Telefone");
            System.out.println("8. Listar Todos os Contatos");
            System.out.println("9. Realizar Chamada");
            System.out.println("10. Limpar Agenda");
            System.out.println("11. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        contactsManager.importContacts();
                        break;
                    case 2:
                        contactsManager.exportContacts();
                        break;
                    case 3:
                        System.out.print("Digite o nome: ");
                        String name = scanner.nextLine();
                        System.out.print("Digite o telefone: ");
                        String phone = scanner.nextLine();
                        System.out.print("Digite o endereço: ");
                        String address = scanner.nextLine();
                        contactsManager.insertContact(name, phone, address);
                        break;
                    case 4:
                        System.out.print("Digite o telefone do contato a ser removido: ");
                        String phoneToRemove = scanner.nextLine();
                        contactsManager.removeContactByPhone(phoneToRemove);
                        break;
                    case 5:
                        System.out.print("Digite o nome do contato a ser removido: ");
                        String nameToRemove = scanner.nextLine();
                        contactsManager.removeContactByName(nameToRemove);
                        break;
                    case 6:
                        System.out.print("Digite o nome do contato a ser localizado: ");
                        String nameToFind = scanner.nextLine();
                        contactsManager.findContactByName(nameToFind);
                        break;
                    case 7:
                        System.out.print("Digite o telefone do contato a ser localizado: ");
                        String phoneToFind = scanner.nextLine();
                        contactsManager.findContactByPhone(phoneToFind);
                        break;
                    case 8:
                        contactsManager.listContacts();
                        break;
                    case 9:
                        System.out.print("Digite o telefone para realizar a chamada: ");
                        String phoneToCall = scanner.nextLine();
                        contactsManager.makeCall(phoneToCall);
                        break;
                    case 10:
                        contactsManager.clearAgenda();
                        break;
                    case 11:
                        System.out.println("Saindo da agenda...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); 
            }
        } while (option != 11);

        scanner.close();
    }
}
