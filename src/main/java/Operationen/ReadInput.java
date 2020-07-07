package Operationen;

import Bank.Bank;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadInput {

    static  private List<Bank> ListBank = new ArrayList<Bank>();



   static public List<Bank> RetunListBank(){

        try {
            File fXmlFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("account");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Bank bank = new Bank();
                    bank.setIban( eElement.getAttribute("iban"));
                    bank.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    bank.setCurrency(eElement.getElementsByTagName("currency").item(0).getTextContent());
                    bank.setBalance(Double.valueOf(eElement.getElementsByTagName("balance").item(0).getTextContent()));
                    bank.setClosingDate(eElement.getElementsByTagName("closingDate").item(0).getTextContent());
                    ListBank.add(bank); }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ListBank.isEmpty()) return null;
        else return ListBank;
    }


}
