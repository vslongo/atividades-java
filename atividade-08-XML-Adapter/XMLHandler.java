import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class XMLHandler {
    public static void processXML(String xmlFileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFileName));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element item = (Element) nodeList.item(i);
                String nome = item.getElementsByTagName("nome").item(0).getTextContent();
                double preco = Double.parseDouble(item.getElementsByTagName("preco").item(0).getTextContent());
                // Chama o método insertData da classe DatabaseSimulator para simular a inserção no banco de dados
                DatabaseSimulator.insertData(nome, preco);
            }
            System.out.println("Dados da nota fiscal processados com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
