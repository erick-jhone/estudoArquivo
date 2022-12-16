import java.util.*;
import java.io.*;
import java.util.Arrays;

public class ExemploMatriz {


    public static void main(String[] args) throws IOException {



        if (args.length == 0){

            System.out.println("\nVoce devera informar o nome do arquivo para manipular apos o nome do programa executado");
            System.out.println("Por exemplo: java nome_programa nome_arquivo.txt");
            System.out.println("Se o arquivo nao existir, ocorrera erro\n");
            System.exit(0);
        }
            File meuArquivo = new File(args[0]);

        if(!meuArquivo.exists()){

            System.out.println("\nO arquivo informado nao foi encontrado.");
            System.out.println("Voce devera informar o nome do arquivo para manipular apos o nome do programa executado");
            System.out.println("Por exemplo: java nome_programa nome_arquivo.txt");
            System.out.println("Se o arquivo nao existir, ocorrera erro\n");
            System.exit(0);

        }


        int totalDeLinhas = contarLinhas(meuArquivo); // Chama metodo contarLinhas e persiste dado na variavel totalDeLinhas

        BufferedReader br = new BufferedReader(new FileReader(meuArquivo));







        int sizeMatriz[] = new int[2]; //Criando/incializando com valores padrões - Duas posições, uma para linhas, outra colunas

        while(true){ //chamando o método para definir o tamanho da matriz a ser criada /
            gerarTamanhoMatriz(sizeMatriz, totalDeLinhas); // Passa como parâmetro, o tamanho da matriz e o total de linhas

            if(sizeMatriz[0] == 0 || sizeMatriz[1] == 0)
                totalDeLinhas++;
            else
                break;
        }


        System.out.println("Matriz a ser criada sera de: " +sizeMatriz[0]+" x " + sizeMatriz[1]);
        String matrizDoArquivo[][] = new String[sizeMatriz[0]][sizeMatriz[1]]; //crinado a matriz
        cParaMatriz(matrizDoArquivo, meuArquivo); //copiar aquivo para matriz
        //ordenar(matrizDoArquivo);
        Arrays.sort(matrizDoArquivo, (a, b) -> a[0].compareTo(b[0]));



        cParaArquivo(matrizDoArquivo,meuArquivo); //copiar dados da matriz para o arquivo
    }


    public static void cParaMatriz(String mat[][], File meuArquivo) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(meuArquivo)); //abrindo o arquivo para leitura
        String linha;
        for(int i=0; i < mat.length; i++){
            for(int j=0; j < mat[0].length; j++){
                //lendo uma linha do e transformando para maisuscula e gravando na matriz
                linha = br.readLine();
                if(linha != null)
                    mat[i][j] = linha;
            }
        }
        br.close(); //fechando o arquivo

    }
    public static void cParaArquivo(String mat[][], File arq)throws IOException{
        FileWriter fw = new FileWriter(arq); //abrindo o arquivo para escrever, se já existir sobrescreve
        for(String x[]: mat) //lendo a linha da matriz
            for(String y: x) //lendo a coluna da matriz
                if(y != null)
                    fw.write(y+"\n"); //escrevendo dentro do arquivo
        fw.close(); //fecha e salva o arquivo
    }
    /**public static void ordenar(String mat[][]){
        String vet[] = new String[mat.length * mat[0].length];
        int id=0;
        for(int i=0; i < mat.length; i++)
            for(int j=0; j< mat[0].length; j++){
                vet[id] = mat[i][j];
                id++;
            }
        Arrays.sort(vet);
        id=0;
        for(int i=0; i < mat.length; i++)
            for(int j=0; j< mat[0].length; j++){
                mat[i][j] = vet[id];
                id++;
            }*/


    }

    private static void gerarTamanhoMatriz(int sizeMatriz[], int linhas){ //definir o tamanho da matriz a ser criada
      //  sizeMatriz[0]=2;
     //   sizeMatriz[1]=0;
      //  linhas=12;

        for(int i=2; i <= linhas/2; i++){  //4 < 12/2
            if(linhas % i ==0){ //12 %4 ==0
                if(i * i == linhas){ //4*4 == 12
                    sizeMatriz[0] = i;
                    sizeMatriz[1] = i;
                    return; //encerrar método
                }
                if(sizeMatriz[0] == 0)
                    sizeMatriz[0] = i;
                else
                    sizeMatriz[1] = i;
            }
            if(sizeMatriz[0] != 0 && sizeMatriz[1]!= 0)
                if(sizeMatriz[0]*sizeMatriz[1] != linhas) //2*3 == 12
                    sizeMatriz[1] =0;
                else
                    return;

        }
    }
    private static int contarLinhas(File meuArquivo) throws IOException{//Qual o total de linhas? Retorno do metodo dira


        BufferedReader br = new BufferedReader(new FileReader(meuArquivo));
        String linha;
        int totalDeLinhas=0;
        while((linha = br.readLine()) != null)
            totalDeLinhas++;
        br.close();
        System.out.println("No arquivo existem "+ totalDeLinhas + " linhas.");
        return totalDeLinhas;
    }
}