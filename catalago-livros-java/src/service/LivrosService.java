package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import objects.Livros;

public class LivrosService {

    private List<Livros> livros = new ArrayList<>();

    // Adicionar livro
    public void addBook(Livros livro) {
        livros.add(livro);
    }

    // Listar todos os livros
    public List<Livros> listarLivros() {
        return livros;
    }

    // Procurar livro por título
    public Livros searchTitle(String t) {
        for (Livros l : livros) {
            if (l.getTitle().equalsIgnoreCase(t)) {
                return l;
            }
        }
        return null;
    }

    // Remover livro por título
    public boolean removeByTitle(String title) {
        return livros.removeIf(l -> l.getTitle().equalsIgnoreCase(title));
    }

    // Realizar backup
    public void saveBackup(String caminhoArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Livros l : livros) {
                writer.write(l.getTitle() + ";" + l.getAuthor() + ";" + l.getYear());
                writer.newLine();
            }
        }
    }

    // Carregar backup
    public void loadBackup(String caminhoArquivo) throws IOException {
        livros.clear(); // limpa a lista atual
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    livros.add(new Livros(partes[0], partes[1], Integer.parseInt(partes[2])));
                }
            }
        }
    }
}
