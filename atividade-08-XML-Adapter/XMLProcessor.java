import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;

public class XMLProcessor {
    public static void main(String[] args) {
        try {
            // Carregar o arquivo XML de entrada
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Criar um novo documento XML
            Document newDoc = dBuilder.newDocument();
            Element rootElement = newDoc.createElement("itens");
            newDoc.appendChild(rootElement);

            // Extrair os itens do documento de entrada e adicioná-los ao novo documento
            NodeList itemList = doc.getElementsByTagName("item");
            for (int i = 0; i < itemList.getLength(); i++) {
                Element item = (Element) itemList.item(i);
                String nome = item.getElementsByTagName("nome").item(0).getTextContent();
                double preco = Double.parseDouble(item.getElementsByTagName("preco").item(0).getTextContent());

                // Adicionar o item ao novo documento
                Element newItem = newDoc.createElement("item");
                Element nomeElement = newDoc.createElement("nome");
                nomeElement.appendChild(newDoc.createTextNode(nome));
                newItem.appendChild(nomeElement);
                Element precoElement = newDoc.createElement("preco");
                precoElement.appendChild(newDoc.createTextNode(String.valueOf(preco)));
                newItem.appendChild(precoElement);
                rootElement.appendChild(newItem);
            }

            // Escrever o novo documento XML em um arquivo
            FileWriter writer = new FileWriter("output.xml");
            writer.write(convertDocumentToString(newDoc));
            writer.close();

            System.out.println("Novo arquivo XML gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String convertDocumentToString(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            java.io.StringWriter writer = new java.io.StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            return writer.getBuffer().toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
