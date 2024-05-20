// src/index.ts

// Definição das interfaces
interface Observer {
    atualizar(mensagem: string): void;
}

interface Observable {
    adicionarInscrito(observer: Observer): void;
    removerInscrito(observer: Observer): void;
    notificarInscritos(): void;
}

// Implementação da classe Usuario
class Usuario implements Observer {
    private nome: string;

    constructor(nome: string) {
        this.nome = nome;
    }

    atualizar(mensagem: string): void {
        console.log(`Usuário ${this.nome} recebeu notificação: ${mensagem}`);
    }
}

// Implementação da classe Canal
class Canal implements Observable {
    private nome: string;
    private inscritos: Observer[];

    constructor(nome: string) {
        this.nome = nome;
        this.inscritos = [];
    }

    adicionarInscrito(observer: Observer): void {
        this.inscritos.push(observer);
    }

    removerInscrito(observer: Observer): void {
        const index = this.inscritos.indexOf(observer);
        if (index !== -1) {
            this.inscritos.splice(index, 1);
        }
    }

    notificarInscritos(): void {
        for (const inscrito of this.inscritos) {
            inscrito.atualizar(`Novo vídeo no canal ${this.nome}!`);
        }
    }

    publicarVideo(titulo: string): void {
        console.log(`Canal ${this.nome} publicou um novo vídeo: ${titulo}`);
        this.notificarInscritos();
    }
}

// Demonstração do funcionamento
const canalPython = new Canal('Python Channel');
const usuario1 = new Usuario('Alice');
const usuario2 = new Usuario('Bob');

canalPython.adicionarInscrito(usuario1);
canalPython.adicionarInscrito(usuario2);

canalPython.publicarVideo('Introdução ao Padrão Observer');
