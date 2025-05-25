package app;

import service.LivrosService;
import java.util.Scanner;
import objects.Livros;
import java.io.IOException;

public class Main {

    private static final Scanner scan = new Scanner(System.in);
    private static final LivrosService livrosService = new LivrosService();

    public static void main(String[] args) {
        int option = -1;
        while (option != 0) {
            showMenu();
            option = Integer.parseInt(scan.nextLine()); // melhor pra evitar bug do \n
            choose(option);
        }
        scan.close();
    }

    public static void showMenu() {
        System.out.println("Welcome to my book catalog management project");
        System.out.println("---------------------------------------------");
        System.out.println("Choose your option");
        System.out.println("---------------------------------------------");
        System.out.println("1 - Show books");
        System.out.println("2 - Add a book");
        System.out.println("3 - Search a book");
        System.out.println("4 - Delete a book");
        System.out.println("5 - Save a backup catalog");
        System.out.println("6 - Load backup");
        System.out.println("0 - Exit");
        System.out.println("---------------------------------------------");
        System.out.print("Please, enter your option: ");
    }

    private static void choose(int option) {
        switch (option) {
            case 1:
                System.out.println("Showing books:");
                for (Livros l : livrosService.listarLivros()) {
                    System.out.println(l.getTitle() + " - " + l.getAuthor() + " - " + l.getYear());
                }
                break;

            case 2:
                System.out.println("Enter book title:");
                String title = scan.nextLine();
                System.out.println("Enter author:");
                String author = scan.nextLine();
                System.out.println("Enter year:");
                int year = Integer.parseInt(scan.nextLine());
                Livros newBook = new Livros(title, author, year);
                livrosService.addBook(newBook);
                System.out.println("Book added!");
                //TODO: Inserir num arquivo binário
                break;

            case 3:
                System.out.println("Type the book title:");
                String searchTitle = scan.nextLine();
                Livros found = livrosService.searchTitle(searchTitle);
                if (found != null) {
                    System.out.println("Book found:");
                    System.out.println(found.getTitle() + " - " + found.getAuthor() + " - " + found.getYear());
                } else {
                    System.out.println("Book not found.");
                }
                //TODO: Ler no arquivo binário
                break;

            case 4:
                System.out.print("Type the book title to remove: ");
                String tituloRemover = scan.nextLine();
                boolean removido = livrosService.removeByTitle(tituloRemover);
                if (removido) {
                    System.out.println("Book removed successfully!");
                } else {
                    System.out.println("Book not found.");
                }
                //TODO: Remover do arquivo binario
                break;

            case 5:
                System.out.print("Digite o caminho do arquivo para salvar backup: ");
                String caminhoSalvar = scan.nextLine();
                try {
                    livrosService.saveBackup(caminhoSalvar);
                    System.out.println("Backup salvo com sucesso!");
                } catch (IOException e) {
                    System.out.println("Erro ao salvar backup: " + e.getMessage());
                }
                break;

            case 6:
                System.out.print("Digite o caminho do arquivo para carregar backup: ");
                String caminhoCarregar = scan.nextLine();
                try {
                    livrosService.loadBackup(caminhoCarregar);
                    System.out.println("Backup carregado com sucesso!");
                } catch (IOException e) {
                    System.out.println("Erro ao carregar backup: " + e.getMessage());
                }
                break;

            case 0:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Please enter a valid option!!");
        }
    }
}
