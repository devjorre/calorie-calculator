# 🍔 Calorie Calculator (Calculadora de Calorias em Clojure)

Uma aplicação completa para gerenciamento e cálculo de saldo calórico diário, desenvolvida em **Clojure**. O projeto foi estruturado seguindo rigorosamente os princípios da **Programação Funcional**, separando a interface do usuário (CLI) da inteligência de negócio e armazenamento (API HTTP).

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Clojure 1.11.1
* **Gerenciador de Dependências:** Leiningen (`lein`)
* **Servidor HTTP:** Ring & Jetty Adapter
* **Roteamento:** Compojure
* **Manipulação de JSON:** Cheshire & Ring-JSON
* **Cliente HTTP:** clj-http

---

## 📂 Estrutura do Projeto

```text
calorie-calculator/
│
├── project.clj                # Configurações e dependências do projeto
├── README.md                  # Documentação do projeto
│
└── src/
    └── calorie_calculator/
        ├── core.clj           # Inicialização do servidor Jetty e do Menu CLI
        ├── db.clj             # Definição do Estado Global (Atom)
        ├── calories.clj       # Funções puras de cálculo de calorias
        ├── handlers.clj       # Lógica de negócio e manipulação do banco de dados
        ├── routes.clj         # Definição dos Endpoints da API e Middlewares
        └── cli.clj            # Interface de terminal (Front-end/Client)
