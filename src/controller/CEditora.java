/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Editora;

/**
 *
 * @author 182120042
 */
public class CEditora {

    ArrayList<Editora> editoras = new ArrayList<>();
    int idEditora = 1;

    /**
     * geraID gerencia a geração de id's para editora
     *
     * @return
     */
    public int geraID() {
        return this.idEditora++;
    }

    /**
     *
     * addeditora adiciona uma editora na lista de editoras
     *
     * @param e
     */
    public void addEditora(Editora e) {
        this.editoras.add(e);
    }

    /**
     * geteditoras retorna a lista de editora
     *
     * @return
     */
    public ArrayList<Editora> getEditoras() {
        return this.editoras;
    }

    /**
     * removeEditora remove Editora da lista de editoras
     *
     * @param e
     */
    public void removeEditora(Editora e) {
        this.editoras.remove(e);
    }

    /**
     * mockEditoras inicializa a aplicação com editoras
     */
    public void mockEditoras() {
        Editora e1 = new Editora();
        e1.setNomeEditora("Jovens Letras");
        e1.setCnpj("99183018000133");
        e1.setEndereco("Av. João Obino 300");
        e1.setTelefone("51291626718");
        e1.setGerente("Roberval da Silva");
        this.addEditora(e1);

        Editora e2 = new Editora();
        e2.setIdEditora(this.geraID());
        e2.setNomeEditora("Jair e Javoltar");
        e2.setCnpj("36363055000103");
        e2.setEndereco("Av. Bento Gonçalves 4169");
        e2.setTelefone("51201848048");
        e2.setGerente("Jair Ferraz");
        this.addEditora(e2);
    }

    /**
     * getEditoraCNPJ pesquisa e retorna editora pelo CNPJ e caso não encontre
     * retorna nulo podendo cadastrar
     *
     * @param cnpj
     * @return
     */
    public Editora getEditoraCNPJ(String cnpj) {
        Editora e = null;
        for (Editora editora : editoras) {//Editora==Classe Model  editora==objeto da classe Editora  editoras==ArrayList
            if (editora.getCnpj().equals(cnpj)) {
                e = editora;
                break;
            }
        }
        return e;
    }
}
