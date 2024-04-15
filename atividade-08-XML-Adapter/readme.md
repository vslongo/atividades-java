# Processamento de Arquivo XML e Geração de XML

Este projeto consiste em um sistema simples em Java que consome um arquivo XML contendo dados de uma nota fiscal, processa esses dados e, em seguida, gera um novo arquivo XML com base nas informações extraídas.

## Requisitos

Para executar este projeto, você precisará ter o Java Development Kit (JDK) instalado em seu sistema.

## Como Usar

1. **Clone o Repositório**: Clone este repositório em sua máquina local usando o seguinte comando:

    ```bash
    git clone https://github.com/seu-usuario/processamento-xml.git
    ```

2. **Adicione o Arquivo XML de Entrada**: Coloque o arquivo XML contendo os dados da nota fiscal na raiz do projeto e nomeie-o como `input.xml`.

3. **Execute o Projeto**: Execute o arquivo `Main.java` para iniciar o processamento do arquivo XML e a geração do novo arquivo XML. Isso pode ser feito através da linha de comando:

    ```bash
    javac Main.java
    java Main
    ```

## Estrutura do Projeto

- **XMLProcessor.java**: Contém o código para processar o arquivo XML de entrada, extrair os dados e gerar um novo arquivo XML.
- **XMLHandler.java**: Classe auxiliar para manipular a leitura e processamento do arquivo XML.
- **DatabaseSimulator.java**: Classe que simula um banco de dados para armazenar os dados da nota fiscal.
- **Main.java**: Arquivo principal que coordena o processo, inicializando o processamento do arquivo XML.

## Exemplo de Código

Aqui está um trecho do código responsável por processar o arquivo XML e extrair os dados:

```java
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
                DatabaseSimulator.insertData(nome, preco);
            }
            System.out.println("Dados da nota fiscal processados com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
