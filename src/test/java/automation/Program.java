package automation;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) throws IOException {

        List<String> sites = new ArrayList<String>();
        Scanner readPathFile = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String name = readPathFile.nextLine();

        FileReader file = new FileReader(name);
        BufferedReader lerArq = new BufferedReader(file);
        
        String control = lerArq.readLine();
        sites.add(control);
        while (control != null) {
            control = lerArq.readLine();
            sites.add(control);
        }
        
        file.close();
        readPathFile.close();

        FileWriter arq = new FileWriter("c:\\data_adv\\result.csv");
        PrintWriter recordFile = new PrintWriter(arq);


        recordFile.println("Site;Score Mobile;Score Desktop");

        
        for(String site: sites) {
            Modelo modelo = AutomationOne.searchScoreSite(site);
            recordFile.println(modelo.getSite() + ";" + modelo.getResultMobile() + ";" + modelo.getResultDesktop());            
        }

        recordFile.close();

        
    }

}
