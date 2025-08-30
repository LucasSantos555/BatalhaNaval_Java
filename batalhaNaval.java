package Exercicios;
import java.util.Random;
import java.util.Scanner;
public class batalhaNaval {
    static public void main(String[] args){
        char[][] matriz = new char[4][4];
        char[][] matrizCopia = new char[4][4];
        Random rand = new Random();
        int barcX = rand.nextInt(5); 
        int barcY = rand.nextInt(5);
        int tentativa =9;
        boolean acertou = false;
        boolean jaBombardeado = false;
        Scanner input = new Scanner(System.in);
        int inpuY=0, inpuX=0;
        for(int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                matriz[i][j] = '~';
                matrizCopia[i][j] = '~';
            }
        }
                  matriz[barcX][barcY] = 'b';
                System.out.println("Encontre o barco: ");
               
        while(!acertou){
           jaBombardeado = false;
           ExibeMatriz(matrizCopia);
        
            System.out.println("Qtd: "+tentativa);
            System.out.println("Digite de 0 a 3 a localização no eixo x: ");
            inpuX = input.nextInt();
            System.out.println("Digite de 0 a 3  a localização no eixo y: ");
            inpuY = input.nextInt();

            if((inpuX >= 4) ||(inpuY >= 4)|| (inpuX < 0) ||(inpuY < 0)){    //Verifica se os indices são validos para que o jogo rode
                System.out.println("Localização inexistente\nTente novamente");
                continue;
            
            }else{

            if(matriz[inpuX][inpuY] == 'X'){//Verifica se a posição já foi bombardeada
                System.out.println("Vc já atirou nessa posição");
                jaBombardeado =true;
            }else if(matriz[inpuX][inpuY] == 'b'){ //Verifica se o barco esta na posição escolhida 
                acertou = true;
            }else{
                matrizCopia[inpuX][inpuY] = 'X'; //Caso o barco não esteja na posição escolhida, desenha um X
                matriz[inpuX][inpuY] ='X';
                System.out.println("Agua!Tente novamente");
            }
            
            if(jaBombardeado == true){  //Se a posição já foi bombardeada e o usuário digita novamente a mesma posição não é descontado de tentativas
                continue;
            }else{
                tentativa --;
                
            }
            
            if(tentativa == 0)break;
            }
            
        }//fimWhile
        if(acertou) System.out.println("Parabens, vc acertou");
        if(!acertou) System.out.println("Vc perdeu");
        ExibeMatriz(matriz);
            input.close();
       
    }
     static public void ExibeMatriz(char[][] matriz){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++)
                    System.out.print(" "+matriz[i][j]);
                    System.out.println();
        }

     }
}
