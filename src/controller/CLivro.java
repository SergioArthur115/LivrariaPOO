/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import livrariapoo.LivrariaPOO;
import model.Livro;

/**
 *
 * @author 182120042
 */
public class CLivro {

    ArrayList<Livro> livros = new ArrayList<>();
    int idLivro = 1;

    /**
     * geraID gerencia a geração de id's para livro
     *
     * @return
     */
    public int geraID() {
        return this.idLivro++;
    }

    /**
     *
     * addLivro adiciona um Livro na lista de livros
     *
     * @param l
     */
    public void addLivro(Livro l) {
        this.livros.add(l);
    }

    /**
     * getlivros retorna a lista de livro
     *
     * @return
     */
    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    /**
     * removeLivro remove Livro da lista de livros
     *
     * @param l
     */
    public void removeLivro(Livro l) {
        this.livros.remove(l);
    }

    /**
     * mockLivros inicializa a aplicação com livros
     */
    public void mockLivros() {
        Livro l1 = new Livro();
        l1.setIdLivro(this.geraID());
        l1.setIdEditora(LivrariaPOO.cadEditora.getEditoraCNPJ("99183018000133"));
        l1.setTitulo("Conhecimentos e utilizações do ChatGPT");
        l1.setAutor("Sérgio Arthur");
        l1.setIsbn("172204932");
        l1.setAssunto("um livro que detalha,ensina e analisa detalhes sobre o ChatGPT");
        l1.setEstoque(42);
        l1.setPreco((float) 19.90);
        this.addLivro(l1);

        Livro l2 = new Livro();
        l2.setIdLivro(this.geraID());
        l2.setIdEditora(LivrariaPOO.cadEditora.getEditoraCNPJ("36363055000103"));
        l2.setTitulo("A Bela e a Fera");
        l2.setAutor("Gabrielle-Suzanne Barbot de Villeneuve");
        l2.setIsbn("608604936");
        l2.setAssunto("Um livro que conta a história sobre a bela e a fera");
        l2.setEstoque(18);
        l2.setPreco((float) 68.18);
        this.addLivro(l2);
    }

    /**
     * getLivroISBN pesquisa e retorna livro pelo ISBN l caso não encontre
     * retorna nulo podendo cadastrar
     *
     * @param isbn
     * @return
     */
    public Livro getLivroISBN(String isbn) {
        Livro l = null;
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                l = livro;
                break;
            }
        }
        return l;
    }

    /**
     * attEstoqueLivro pesquisa e atualiza o livro pelo ISBN caso tenha estoque
     * do contrário retorna false
     *
     * @param isbn
     */
    public boolean attEstoqueLivro(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn) && livro.getEstoque() > 0) {
                livro.setEstoque(livro.getEstoque() - 1);
                return true;

            }
        }
        return false;
    }
}
