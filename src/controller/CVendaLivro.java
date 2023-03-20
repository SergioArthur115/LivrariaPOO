/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.VendaLivro;
import java.time.LocalDate;
import livrariapoo.LivrariaPOO;
import model.Livro;

/**
 *
 * @author 182120042
 */
public class CVendaLivro {

    ArrayList<VendaLivro> vendaLivros = new ArrayList<>();
    int idVendaLivro = 1;

    /**
     * geraID gerencia a geração de id's para vendaLivro
     *
     * @return
     */
    public int geraID() {
        return this.idVendaLivro++;
    }

    /**
     *
     * addvendaLivro adiciona uma vendaLivro na lista de vendaLivros
     *
     * @param vl
     */
    public void addVendaLivro(VendaLivro vl) {
        this.vendaLivros.add(vl);
    }

    /**
     * getvendaLivros retorna a lista de vendaLivro
     *
     * @return
     */
    public ArrayList<VendaLivro> getVendaLivros() {
        return this.vendaLivros;
    }

    /**
     * removeVendaLivro remove VendaLivro da lista de vendaLivros
     *
     * @param vl
     */
    public void removeVendaLivro(VendaLivro vl) {
        this.vendaLivros.remove(vl);
    }

    /**
     * mockVendaLivros inicializa a aplicação com vendaLivros
     */
    public void mockVendaLivros() {
        VendaLivro vl1 = new VendaLivro();
        vl1.setIdVendaLivro(this.geraID());

        vl1.setIdCliente(LivrariaPOO.cadCliente.getClienteCPF("123456789"));

        ArrayList<Livro> livros1 = new ArrayList<>();
        livros1.add(LivrariaPOO.cadLivro.getLivroISBN("172204932"));
        livros1.add(LivrariaPOO.cadLivro.getLivroISBN("608604936"));
        vl1.setLivros(livros1);

        vl1.setSubTotal((float) 65.87);
        vl1.setDataVenda(LocalDate.parse("2023-05-22"));
        this.addVendaLivro(vl1);

    }

}
