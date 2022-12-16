import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // Nome do arquivo a ser aberto
        String nomeArquivo = "dados.txt";

        // Matriz para armazenar os dados do arquivo
        String[][] dadosArquivo;


            // Abrir o arquivo e ler os dados
            BufferedReader leitorArquivo = new BufferedReader(new FileReader(nomeArquivo));

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
            for (int j = 0; j < numColunas; j++) {
                Arrays.sort(dadosArquivo, new Comparator<String[]>() {
                    @Override
                    public int compare(final String[] entry1, final String[] entry2) {
                        final String valor1 = entry1[j];
                        final String valor2 = entry2[j];
                        return valor1.compareTo(valor2);
                    }
                });
            }

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