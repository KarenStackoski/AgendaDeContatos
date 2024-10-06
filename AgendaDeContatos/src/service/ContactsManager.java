package service;

import java.util.HashMap;
import models.ContatosModel; 
import files.FileManager;

public class ContactsManager { 
    private HashMap<String, ContatosModel> contacts;
    private FileManager fileManager;

    public ContactsManager() { 
        contacts = new HashMap<>();
        fileManager = new FileManager();
    }

    public void importContacts() {
        HashMap<String, ContatosModel> imported = fileManager.importContacts();
        contacts.putAll(imported);
    }

    public void exportContacts() {
        fileManager.exportContacts(contacts);
    }

    public void insertContact(String name, String phone, String address) {
        if (name.length() > 30) {
            System.out.println("Erro: O nome deve ter no maximo 30 caractere.");
            return; 
        }
        
        if (phone.length() != 11) {
            System.out.println("Erro: O numero de telefone é invalido, lembre de adionar seu DDD.");
            return;
        }
        
        if (address.length() > 100) {
            System.out.println("Erro: O endereço deve ter 100 caracteres ou menos.");
            return;
        }
        
        ContatosModel contact = new ContatosModel(name, phone, address);
        contacts.put(phone, contact);
        System.out.println("Contato adicionado com sucesso.");
    }
    

    public void removeContactByPhone(String phone) {
        if (contacts.remove(phone) != null) {
            System.out.println("Contato removido com sucesso.");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void removeContactByName(String name) {

    }

    public void findContactByName(String name) {

    }

    public void findContactByPhone(String phone) {

    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Nenhum contato na agenda.");
        } else {
            for (ContatosModel contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    public void makeCall(String phone) {

    }

    public void clearAgenda() {

    }
}
