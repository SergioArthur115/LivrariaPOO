/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 182120042
 */
public class Livro {

    private int idLivro;
    private Editora idEditora;
    private int estoque;
    private float preco;
    private String titulo;
    private String autor;
    private String assunto;
    private String isbn;

    public Livro() {
    }

    public Livro(int idLivro, Editora idEditora, int estoque, float preco, String titulo, String autor, String assunto, String isbn) {
        this.idLivro = idLivro;
        this.idEditora = idEditora;
        this.estoque = estoque;
        this.preco = preco;
        this.titulo = titulo;
        this.autor = autor;
        this.assunto = assunto;
        this.isbn = isbn;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public Editora getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Editora idEditora) {
        this.idEditora = idEditora;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Livro{\n" + "\nidLivro=" + idLivro + ", \nidEditora=" + idEditora + ", \nestoque=" + estoque + ", \npreco=" + preco + ", \ntitulo=" + titulo + ", \nautor=" + autor  + '}';
    }

}
