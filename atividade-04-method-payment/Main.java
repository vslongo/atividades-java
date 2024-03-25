// Interface para todos os métodos de pagamento
interface PaymentMethod {
  void processPayment(double amount);
}

// Classes concretas que implementam PaymentMethod
class CreditCardPayment implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
      System.out.println("Pagamento de R$" + amount + " processado com cartão de crédito.");
  }
}

class BoletoPayment implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
      System.out.println("Boleto de R$" + amount + " gerado.");
  }
}

class TransferPayment implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
      System.out.println("Pagamento de R$" + amount + " processado por transferência bancária.");
  }
}

class PixPayment implements PaymentMethod {
  @Override
  public void processPayment(double amount) {
      System.out.println("Pagamento de R$" + amount + " processado por Pix.");
  }
}

// Interface para fábricas de métodos de pagamento
interface PaymentFactory {
  PaymentMethod createPayment();
}

// Fábricas concretas para cada método de pagamento
class CreditCardPaymentFactory implements PaymentFactory {
  @Override
  public PaymentMethod createPayment() {
      return new CreditCardPayment();
  }
}

class BoletoPaymentFactory implements PaymentFactory {
  @Override
  public PaymentMethod createPayment() {
      return new BoletoPayment();
  }
}

class TransferPaymentFactory implements PaymentFactory {
  @Override
  public PaymentMethod createPayment() {
      return new TransferPayment();
  }
}

class PixPaymentFactory implements PaymentFactory {
  @Override
  public PaymentMethod createPayment() {
      return new PixPayment();
  }
}

// Processador de pagamentos
class PaymentProcessor {
  private PaymentFactory paymentFactory;

  public PaymentProcessor(PaymentFactory paymentFactory) {
      this.paymentFactory = paymentFactory;
  }

  public void processPayment(double amount) {
      PaymentMethod paymentMethod = paymentFactory.createPayment();
      paymentMethod.processPayment(amount);
  }
}

// Exemplo de uso
public class Main {
  public static void main(String[] args) {
      // Exemplo de processamento de pagamento com Pix
      PaymentFactory pixPaymentFactory = new PixPaymentFactory();
      PaymentProcessor pixPaymentProcessor = new PaymentProcessor(pixPaymentFactory);
      pixPaymentProcessor.processPayment(100.50);

      // Exemplo de processamento de pagamento com boleto
      PaymentFactory boletoPaymentFactory = new BoletoPaymentFactory();
      PaymentProcessor boletoPaymentProcessor = new PaymentProcessor(boletoPaymentFactory);
      boletoPaymentProcessor.processPayment(250.75);
  }
}
