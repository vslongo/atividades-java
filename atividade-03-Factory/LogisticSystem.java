// Interface para os diferentes tipos de transporte
interface Transport {
  void deliver();
}

// Classes concretas que implementam Transport
class Truck implements Transport {
  @Override
  public void deliver() {
      System.out.println("Entrega por caminhão.");
  }
}

class Ship implements Transport {
  @Override
  public void deliver() {
      System.out.println("Entrega por navio.");
  }
}

class Airplane implements Transport {
  @Override
  public void deliver() {
      System.out.println("Entrega por avião.");
  }
}

// Interface para a fábrica de transporte
interface TransportFactory {
  Transport createTransport();
}

// Fábricas concretas para cada tipo de transporte
class TruckFactory implements TransportFactory {
  @Override
  public Transport createTransport() {
      return new Truck();
  }
}

class ShipFactory implements TransportFactory {
  @Override
  public Transport createTransport() {
      return new Ship();
  }
}

class AirplaneFactory implements TransportFactory {
  @Override
  public Transport createTransport() {
      return new Airplane();
  }
}

// Cliente que utiliza o padrão Factory Method
public class LogisticSystem {
  public static void main(String[] args) {
      // Criando uma fábrica de caminhões e entregando
      TransportFactory truckFactory = new TruckFactory();
      Transport truck = truckFactory.createTransport();
      truck.deliver();

      // Criando uma fábrica de navios e entregando
      TransportFactory shipFactory = new ShipFactory();
      Transport ship = shipFactory.createTransport();
      ship.deliver();

      // Criando uma fábrica de aviões e entregando
      TransportFactory airplaneFactory = new AirplaneFactory();
      Transport airplane = airplaneFactory.createTransport();
      airplane.deliver();
  }
}
