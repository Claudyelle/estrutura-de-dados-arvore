package arvore;

public class No {
    
    int info;
    No esq, dir, pai; // Esquerdo, Direito, Pai
    Cor cor;
    
    public No(){
        info = 0;
        esq = dir = pai = null;
        cor = Cor.preto;
    }
    
    public No(int info){
        this.info = info;
        esq = dir = pai = null;
        cor = Cor.preto;
    }
    
}
