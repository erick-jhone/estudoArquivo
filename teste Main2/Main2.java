import java.io.*;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {

        String nomeArquivo = args[0];
        // Nome do arquivo a ser aberto

        // Matriz para armazenar os dados do arquivo
        String[][] dadosArquivo;


            // Abrir o arquivo e ler os dados
            BufferedReader leitorArquivo = new BufferedReader(new FileReader(new File (nomeArquivo));

            // Obter o número de linhas no arquivo
            int numLinhas = 0;
            while (leitorArquivo.readLine() != null) numLinhas++;

            // Obter o número de colunas no arquivo (assumindo que todas as linhas têm o mesmo número de colunas)
            int numColunas = leitorArquivo.readLine().split("\t").length;

            // Inicializar a matriz com o número correto de linhas e colunas
            dadosArquivo = new String[numLinhas][numColunas];

            // Voltar para o início do arquivo
            leitorArquivo = new BufferedReader(new FileReader(nomeArquivo));

            // Lendo os dados do arquivo e armazenando-os na matriz
            for (int i = 0; i < numLinhas; i++) {
                String[] linha = leitorArquivo.readLine().split("\t");
                for (int j = 0; j < numColunas; j++) {
                    dadosArquivo[i][j] = linha[j];
                }
            }

            // Fechar o leitor de arquivos
            leitorArquivo.close();

            // Ordenar os dados em ordem alfabética
              Arrays.sort(dadosArquivo, (a, b) -> a[0].compareTo(b[0]));

         /**   // Gravar os dados ordenados no arquivo
            FileWriter escritorArquivo = new FileWriter(nomeArquivo);

                for (int i = 0; i < numLinhas; i++) {
                    for (int j = 0; j < numColunas; j++){
                       escritorArquivo.write(dadosArquivo[i][j] + "\n");}
                }*/





}



    public static void copiarParaArquivo(String dadosArquivo[][], File nomeArquivo)throws IOException{
        FileWriter fw = new FileWriter(nomeArquivo); //abrindo o arquivo para escrever, se já existir sobrescreve
        for(String x[]: dadosArquivo) //lendo a linha da matriz
            for(String y: x) //lendo a coluna da matriz
                if(y != null)
                    fw.write(y+"\n"); //escrevendo dentro do arquivo
        fw.close(); //fecha e salva o arquivo
    }

}