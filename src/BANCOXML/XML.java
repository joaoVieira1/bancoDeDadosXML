package BANCOXML;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {
   
    public static void main(String[] args) {
        
        ArrayList<Pessoa> listaPessoas = new ArrayList();
        Scanner leitor = new Scanner(System.in);
        
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = (Document) docBuilder.newDocument(); //criando uma estrutura hierarquica nova
            
            //determinando raiz
            Element pessoas = doc.createElement( "pessoas" );
            doc.appendChild(pessoas);
            String resp = "S";
            
            while("S".equals(resp) || "s".equals(resp)){
                System.out.println("CADASTRAR PESSOA: ");
                
                System.out.println("Nome: ");
                String nome = leitor.nextLine();
                
                System.out.println("CPF: ");
                String cpf = leitor.nextLine();
                
                System.out.println("Idade: ");
                String sIdade = leitor.nextLine();
                int idade = Integer.valueOf(sIdade);
                
                System.out.println("Peso: ");
                String sPeso = leitor.nextLine();
                double peso = Double.valueOf(sPeso);
                
                System.out.println("Altura: ");
                String sAltura = leitor.nextLine();
                double altura = Double.valueOf(sAltura);
                
                listaPessoas.add(new Pessoa(nome, idade, peso, altura, cpf));
                
                System.out.println("Deseja cadastrar outra pessoa? [S/N]: ");
                resp = leitor.nextLine();
                
                System.out.println(listaPessoas.get(0));
            }
            
            //criando elemento pessoa, declarando ele como filho e setando seus atributos
            for(int i = 0; i < listaPessoas.size(); i++){
                Element pessoa = doc.createElement("pessoa");
                pessoas.appendChild(pessoa);
                
                pessoa.setAttribute("Nome", listaPessoas.get(i).getNome());
                pessoa.setAttribute("Idade", Integer.toString(listaPessoas.get(i).getIdade()));
                pessoa.setAttribute("Peso", Double.toString(listaPessoas.get(i).getPeso()));
                pessoa.setAttribute("Altura", Double.toString(listaPessoas.get(i).getAltura()));
                pessoa.setAttribute("CPF", listaPessoas.get(i).getCPF());
            }
                
            
            
            
            
            
            
            
            
            
            FileOutputStream output = new FileOutputStream("BancoPessoas.xml");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource( doc );
            StreamResult result = new StreamResult( output );

            transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "yes" );
            transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
            transformer.transform( source, result );
            
        }catch(Exception ex){
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
