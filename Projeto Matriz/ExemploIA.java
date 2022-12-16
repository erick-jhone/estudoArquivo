import java.io.*;
import java.util.*;

public class ExemploIA {

                public static void main(String[] args) {
                    try {
                        // Lê o arquivo e armazena os dados em uma lista dinâmica
                        File file = new File("teste.txt");
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        ArrayList<String> data = new ArrayList<String>();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            data.add(line);
                        }
                        reader.close();

                        // Altera os dados da lista para letras maiúsculas
                        for (int i = 0; i < data.size(); i++) {
                            data.set(i, data.get(i).toUpperCase());
                        }

                        // Escreve os dados da lista no arquivo
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        for (int i = 0; i < data.size(); i++) {
                            writer.write(data.get(i) + "\n");
                        }
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
