# locadora

<h3 align="center">
  Sistema de Controle da locadora - BackEnd - Spring Boot
</h3>

<p align="center">Exemplo de um Sistema para Gerenciamento de Locadora</p>

<p align="center">
  <a href="#-sobre">Sobre o projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-instalacao">Instalação e execução</a>&nbsp;&nbsp;&nbsp;
</p>

## :page_with_curl: Sobre o projeto <a name="-sobre"/></a>

> É proposto o desenvolvimento de um Sistema de Controle de Videolocadora, que vai informatizar as funções de empréstimo, devolução e reserva de fitas.

O objetivo do sistema é agilizar o processo de empréstimo e garantir maior segurança, ao mesmo tempo possibilitar um melhor controle das informações por parte da gerência. Deverão ser gerados relatórios de relacionados aos cadastros básicos, bem como aos eventos de empréstimos, devoluções e reservas. O sistema deverá calcular automaticamente o valor dos pagamentos a serem efetuados em cada empréstimo, inclusive multas e descontos devidos. A cada devolução de fitas corresponderá um pagamento, não sendo possível trabalhar com sistema de créditos. A impossibilidade de efetuar um pagamento deve deixar o cliente suspenso, ou seja, impossibilitado de tomar emprestadas novas fitas até saldar a dívida. O cliente poderá reservar fitas para pegar emprestadas. No entanto, de acordo com a política da empresa, pode ficar impossibilitado de realizar novas reservas, caso se torne recorrente a não efetivação de reservas em empréstimos.

### Manutenção de Cadastros

```
* Gerente
* Funcionário
* Cliente
* UF
* Cidade
* Bairro
* Tipo de Filme
* Filme
* Fita
* Artista
* Diretor
```

### Processos de Negócio

```
* Empréstimo de Fita
* Devolução de Fita
* Reserva de Fita
* Pagamento de Multa
```

### Relatórios

```
* Listar Empréstimos (Por Cliente, Data Início e Data Término)
* Listar Reservas (Por Cliente, Status, Data Início e Data Término)
* Listar Devoluções (Por Cliente, Filme, Data Início e Data Término)
* Listar Totais e Quantidades de Empréstimos de Clientes (Por Início e Término)
* Listar Quantidades de Empréstimos nos Bairros (Por Início e Término)
* Listar Quantidades de Reservas de Clientes (Por Status, Início e Término)
* Listar Quantidades de Devoluções de Clientes (Por Filme, Data Início e Data Término)	
```

## :computer: Instalação e execução <a name="-instalacao"/></a>

0. Instale o gerenciador de dependências [Maven](https://maven.apache.org/download.cgi);
1. Faça um clone desse repositório;
2. Entre na pasta rodando `cd target`;
3. Rode `mvn spring-boot:run` para iniciar o servidor de desenvolvimento;
4. Abra `http://localhost:9090` para ver o projeto no navegador, verifique a porta configurada.

