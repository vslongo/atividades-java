"use strict";
// src/index.ts
// Implementação da classe Usuario
class Usuario {
    constructor(nome) {
        this.nome = nome;
    }
    atualizar(mensagem) {
        console.log(`Usuário ${this.nome} recebeu notificação: ${mensagem}`);
    }
}
// Implementação da classe Canal
class Canal {
    constructor(nome) {
        this.nome = nome;
        this.inscritos = [];
    }
    adicionarInscrito(observer) {
        this.inscritos.push(observer);
    }
    removerInscrito(observer) {
        const index = this.inscritos.indexOf(observer);
        if (index !== -1) {
            this.inscritos.splice(index, 1);
        }
    }
    notificarInscritos() {
        for (const inscrito of this.inscritos) {
            inscrito.atualizar(`Novo vídeo no canal ${this.nome}!`);
        }
    }
    publicarVideo(titulo) {
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
