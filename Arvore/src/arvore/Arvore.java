/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvore;

public class Arvore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        RubroNegra rn = new RubroNegra();
        
        rn.insere(34);
        rn.insere(3);
        rn.insere(50);
        rn.insere(20);
        rn.insere(15);
        rn.insere(16);
        rn.insere(25);
        rn.insere(27);
        rn.imprime();
        
    }
    
}
