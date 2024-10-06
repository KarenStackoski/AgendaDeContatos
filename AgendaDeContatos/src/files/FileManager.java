package files;

import models.ContatosModel;
import java.io.*;
import java.util.HashMap;

public class FileManager {
    private static final String SEPARATOR = "@";
    private static final String FILE_PATH = "C:\\Users\\User\\Documents\\GitHub\\AgendaDeContatos\\AgendaDeContatos\\src\\files\\file.txt"; 


    public HashMap<String, ContatosModel> importContacts() {
        HashMap<String, ContatosModel> contacts = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {  
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(SEPARATOR);
                if (parts.length == 3) {
                    ContatosModel contact = new ContatosModel(parts[0], parts[1], parts[2]);
                    contacts.put(contact.getTelefone(), contact);
                }
            }
            System.out.println("Contatos importados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao importar contatos: " + e.getMessage());
        }
        return contacts;
    }

    public void exportContacts(HashMap<String, ContatosModel> contacts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (ContatosModel contact : contacts.values()) {
                bw.write(contact.getNome() + SEPARATOR + contact.getTelefone() + SEPARATOR + contact.getEndereco());
                bw.newLine();
            }
            System.out.println("Contatos exportados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao exportar contatos: " + e.getMessage());
        }
    }
}
