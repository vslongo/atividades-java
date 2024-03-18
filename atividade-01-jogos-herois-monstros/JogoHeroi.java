// Definição da interface Coletável
interface Coletável {
  void usar();
  void descartar();
}

// Definição da classe abstrata Personagem
abstract class Personagem {
  String nome;
  int vida;
  int forca;

  public Personagem(String nome, int vida, int forca) {
      this.nome = nome;
      this.vida = vida;
      this.forca = forca;
  }

  abstract void atacar(Personagem alvo);
  abstract void defender(int dano);

  void receberDano(int dano) {
      vida -= dano;
      if (vida <= 0) {
          System.out.println(nome + " foi derrotado!");
      }
  }
}

// Implementação da classe Herói
class Herói extends Personagem {
  int mana;

  public Herói(String nome, int vida, int forca, int mana) {
      super(nome, vida, forca);
      this.mana = mana;
  }

  @Override
  void atacar(Personagem alvo) {
      System.out.println(nome + " atacou " + alvo.nome);
      alvo.defender(forca);
  }

  @Override
  void defender(int dano) {
      int danoReal = dano / 2; // Heróis recebem metade do dano
      receberDano(danoReal);
  }

  void habilidadeEspecial() {
      if (mana >= 10) {
          mana -= 10;
          System.out.println(nome + " usou habilidade especial!");
          // Implementação da habilidade especial
          System.out.println("Habilidade especial ativada: Regeneração de Vida");
          vida += 30; // A habilidade especial regenera 30 pontos de vida
          System.out.println("Vida de " + nome + " aumentada para " + vida);
      } else {
          System.out.println("Mana insuficiente para usar habilidade especial.");
      }
  }
}

// Implementação da classe Monstro
class Monstro extends Personagem {
  int ataque;

  public Monstro(String nome, int vida, int forca, int ataque) {
      super(nome, vida, forca);
      this.ataque = ataque;
  }

  @Override
  void atacar(Personagem alvo) {
      System.out.println(nome + " atacou " + alvo.nome);
      alvo.defender(calcularDano());
  }

  @Override
  void defender(int dano) {
      receberDano(dano);
  }

  int calcularDano() {
      // Cálculo de dano do monstro, que pode incluir sua força e ataque
      return forca + ataque;
  }
}

// Implementação da classe Arma
class Arma implements Coletável {
  String nome;
  int poder;

  public Arma(String nome, int poder) {
      this.nome = nome;
      this.poder = poder;
  }

  @Override
  public void usar() {
      System.out.println("Usando arma " + nome);
  }

  @Override
  public void descartar() {
      System.out.println("Descartando arma " + nome);
  }

  void atacar(Personagem alvo) {
      System.out.println("Atacando com arma " + nome);
      alvo.receberDano(poder);
  }
}

// Implementação da classe Poção
class Poção implements Coletável {
  String nome;
  int cura;

  public Poção(String nome, int cura) {
      this.nome = nome;
      this.cura = cura;
  }

  @Override
  public void usar() {
      System.out.println("Usando poção " + nome);
  }

  @Override
  public void descartar() {
      System.out.println("Descartando poção " + nome);
  }

  void tomar(Herói herói) {
      System.out.println("Tomando poção " + nome);
      herói.vida += cura;
      System.out.println("Vida de " + herói.nome + " aumentada para " + herói.vida);
  }
}

// Classe de teste
public class JogoHeroi {
  public static void main(String[] args) {
      // Criando personagens
      Herói herói = new Herói("Herói", 100, 20, 50);
      Monstro monstro = new Monstro("Monstro", 80, 15, 10);

      // Criando itens
      Arma espada = new Arma("Espada", 30);
      Poção poçãoCura = new Poção("Poção de Cura", 20);

      // Interagindo no jogo
      herói.atacar(monstro);
      monstro.atacar(herói);

      espada.atacar(monstro);
      poçãoCura.tomar(herói);

      herói.habilidadeEspecial();
  }
}
