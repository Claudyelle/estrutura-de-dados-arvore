
package arvore;

public class RubroNegra {
    
    No raiz, nulo;
    
    public RubroNegra(){
        nulo = new No();
        
        raiz = nulo;
    }
    
    void rotacaoEsquerda(No x){
        No y = x.dir;
        
        x.dir = y.esq;
        if(y.esq != nulo){
            y.esq.pai = x;
        }
        
        y.pai = x.pai;
        if(x.pai == nulo){
            raiz = y;
        }else{
            if(x == x.pai.esq)
                x.pai.esq = y;
            else
                x.pai.dir = y;
        }
        
        y.esq = x;
        x.pai = y;
    }
    
    void rotacaoDireita(No y){

        No x = y.esq;
        y.esq = x.dir;
        
        if(x.dir != nulo){
            x.dir.pai = y;
        }
        
        x.pai = y.pai;
        if(y.pai == nulo)
            raiz = x;
        else{
            if(y == y.pai.esq)
                y.pai.esq = x;
            else
                y.pai.dir = x;
        }
        
        x.dir = y;
        y.pai = x;
               
    }
    
    void insere(int info){
        No anterior,p;
        anterior = nulo;
        p = raiz;
        
        while(p != nulo){
            anterior = p;
            if(info < p.info)
                p = p.esq;
            else if(info > p.info)
                p = p.dir;
            else if(info == p.info)
                return;
        }
        
        No novo = new No(info);
        novo.pai =  anterior;
        novo.esq = novo.dir = nulo;
        novo.cor = Cor.vermelho;
        
        if(raiz == nulo)
            raiz = novo;
        else{
            if(info < anterior.info)
                anterior.esq = novo;
            else anterior.dir = novo;
        }
       InsereRestaPropRn(novo); 
    }
    
    public void InsereRestaPropRn(No x){
        
        No y;
        
        while(x.pai.cor == Cor.vermelho){
            
            if(x.pai == x.pai.pai.esq){
                y = x.pai.pai.dir;
                if(y.cor == Cor.vermelho){ // Caso 1: x tem um tio Y VERMELHO;
                    y.cor = Cor.preto;
                    x.pai.cor = Cor.preto;
                    x.pai.pai.cor = Cor.vermelho;
                    x = x.pai.pai;
                }else{
                    if(x == x.pai.dir){ // Caso 2:
                        x = x.pai;
                        rotacaoEsquerda(x);
                    }
                    
                    x.pai.cor = Cor.preto; // Caso 3:
                    x.pai.pai.cor = Cor.vermelho;
                    rotacaoDireita(x.pai.pai);
                    
                }
                    
            }else {
                y = x.pai.pai.esq;
                if(y.cor == Cor.vermelho){ // Caso 1: x tem um tio Y VERMELHO;
                    y.cor = Cor.preto;
                    x.pai.cor = Cor.preto;
                    x.pai.pai.cor = Cor.vermelho;
                    x = x.pai.pai;
                }else {
                    if(x == x.pai.esq){ //Caso 2: Espelhamento
                        x = x.pai;
                        rotacaoDireita(x);
                    }
                    
                    x.pai.cor = Cor.preto; // Caso 3: Espelhamento
                    x.pai.pai.cor = Cor.vermelho;
                    rotacaoEsquerda(x.pai.pai);
                    
                }
            }
        
        } // While;
        raiz.cor = Cor.preto;
    }
    
    
    void imprime(){
        inOrdem(raiz, "  ");
    }
    
    private void inOrdem(No p, String espaco){
        if(p != nulo){
            inOrdem(p.esq, "      " + espaco);
            System.out.println(espaco + p.info + "," + p.cor);
            inOrdem(p.dir, "      " + espaco);
        }
    }
    
}
