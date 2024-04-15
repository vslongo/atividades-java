public class Main {
  public static void main(String[] args) {
      String xmlFileName = "nota_fiscal.xml";
      XMLHandler.processXML(xmlFileName);
      DatabaseSimulator.showDatabaseContent();
  }
}
