package datamanager;

import datamanager.Exceptions.AttributeAlreadyExistsException;
import datamanager.Exceptions.TableAlreadyExistsException;
import java.io.IOException;
import java.util.Scanner;

/**
 * The main class.
 * @author Thiago
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws datamanager.Exceptions.AttributeAlreadyExistsException
     * @throws datamanager.Exceptions.TableAlreadyExistsException
     */
    public static void main(String[] args) throws AttributeAlreadyExistsException, TableAlreadyExistsException, IOException {
        Database db = Catalog.getInstance().buildDatabaseFromCatalog();
        
        /*
        Table a = db.addTable("PESSOA");
        a.addAttribute("COD", "int");
        a.addAttribute("NOME", "string");
        a.addAttribute("IDADE", "int");
        
        Table b = db.addTable("CARRO");
        b.addAttribute("COD", "int");
        b.addAttribute("MARCA", "string");
        b.addAttribute("ANO", "int");
        
        Table c = db.addTable("POSSUI_CARRO");
        c.addAttribute("COD_PESSOA", "int");
        c.addAttribute("COD_CARRO", "int");
        c.addAttribute("ANO", "int");
        */
        Scanner teclado = new Scanner(System.in);
        int opc=1, opc2=1, opc3=1;
        Table tabela;
        System.out.println("#####Sistema de Gerenciamento de Dados#####");
        do {
            System.out.println("1- Adicionar nova Tabela");
            System.out.println("2- Inserir Registro em uma Tabela");
            System.out.println("0- Sair");
            System.out.print("OPC:");
            opc= teclado.nextInt();
            
            if(opc==1){
                System.out.print("\nNome da Tabela:");
                String nomeTabela = teclado.next();  
                tabela = db.addTable(nomeTabela);
            
            while (opc2!=0){
                System.out.println("1-Novo Atributo");
                System.out.println("0- Sair");
                System.out.print("OPC: ");
                opc2=teclado.nextInt();
                
                if (opc2==1){
                    System.out.println("Nome do Atributo");
                    String nomeAtributo = teclado.next();
                    System.out.println("Tipo do Atributo");
                    String tipoAtributo = teclado.next();
                    tabela.addAttribute(nomeAtributo, tipoAtributo);
                    System.out.println("Atributo Adicionado");
                    tabela.addAttribute(nomeAtributo, tipoAtributo);
                    
                }
                
                
                                
            }
            }
            
            if (opc==2){
                System.out.print("\nNome da Tabela:");
                String nomeTabela = teclado.next();  
                tabela = db.getTable (nomeTabela);
                System.out.println("#####TABELA: "+ tabela.getName()+"#####");
                System.out.println("qtd de atributos: "+tabela.getAttributes().size());
                for (int i=0; i<tabela.getAttributes().size(); i++){
                    System.out.print("Valor para "+tabela.getAttribute(i).getName().toUpperCase());
                    System.out.println(" "+tabela.getAttribute(i).getType().toLowerCase());
                }
                
                
            }
            System.out.println("#########################");
            
        }while(opc!=0);
        
    }
}
