# Relógio Digital ⏰
> Autora: Luiza Kuze <br>
> Data: 24/10/2023 <br>
> Projeto de POO

## Descrição 📌

É uma aplicação de um relógio digital, composto por 6 displays de 7 segmentos. Cada display de 7 segmentos é um dispositivo eletrônico acessível que pode representar informações alfanuméricas, ativando ou desativando individualmente seus 7 segmentos. 
Para ilustrar, se quisermos mostrar o número 2 em um display de 7 segmentos, ativamos os segmentos A, B, G, E e D.

<div align="center">
  
![Alt text](imagens/display.png)

_Display 7 segmentos_

</div>

Esse projeto foi desenvolvido na parte inicial das aulas de Programação Orientada a Objetos (POO) na faculdade. Durante esse período, o foco principal foi compreender a divisão de responsabilidades entre as classes envolvidas, a fim de criar uma aplicação funcional e eficiente.

## Demonstração 📷

<div align="center">
  

<img src="https://github.com/luizakuze/Digital-Clock/assets/111708035/3087f62f-9f72-49ed-a141-c8a6a898ce2c" width="50%">

</div>

## Objetivos 🎯

- [x] Criar um relógio digital em Java que utilize 6 displays de 7 segmentos.

- [x] Permitir que o usuário defina as coordenadas de posicionamento do relógio.

- [x] Oferecer a opção de escolher o tamanho do relógio, variando de 1 a 3. Caso seja informado um tamanho inválido, coloca um relógio de tamanho 2 por padrão.

- [x] Personalizar a cor do relógio digital. Caso sejam cores não implementadas no desenvolvimento, desenha um relógio branco por padrão.

- [x] Inicializar o relógio com a hora, minutos e segundos especificados pelo usuário. Caso valores inválidos sejam fornecidos, o relógio começará às 00:00:00.

- [x] Interface gráfica, o programa deve criar uma tela de desenho para visualizar o relógio. 

## Funcionamento 💻

### Opção 1 - Linux 👩🏻‍💻

```Bash
# Clonar o repositório do projeto 
git clone https://github.com/luizakuze/Digital-Clock

# Acessar o diretório 
cd Digital-Clock

# Compilar e executar o projeto
./gradlew run
```


### Opção 2 - Windows 👨🏻‍💻

```Bash
# Clonar o repositório do projeto 
git clone https://github.com/luizakuze/Digital-Clock

# Acessar o diretório 
cd Digital-Clock

# Compilar e executar o projeto
gradle run
```

## Implementação 📚

### Gradle 📘

Este projeto utiliza o sistema de construção Gradle para gerenciar as dependências e compilar o código-fonte!

### Diagrama UML 📕

O projeto respeita o encapsulamento de dados, responsabilidade única e divisão de responsabilidades! 

<div align="center">

![Alt text](imagens/diagrama.png)

_Diagrama UML feito em [mermaid](mermaid.md)_

</div>

### Representação Gráfica 📗

Funciona por meio da biblioteca **_Algs4_**, uma biblioteca que oferece suporte para gráficos em 2D. Um grande suporte para o projeto ao utilizar a sua classe _**Draw**_! 

Na classe principal, um dos seus atributos é do tipo _**Draw**_ e ao instanciar um objeto dessa classe principal, criamos uma "tela de desenho" que será passada ao longo das classes e métodos do projeto.

Ok, então é o seguinte passo a passo:

1. Relógios são criados no método main da classe Principal.
2. Esses relógios tem horários definidos pelo usuário, que são responsabilidade da classe Horario.
3. Um relógio tem 6 displays, para representar horas, minutos e segundos. Assim, a responsabilidade de conectar o horário com os segmentos que aparecem é da classe Display.
4. Um display tem 7 segmentos, podem acender e apagar, além disso também são desenhados na tela para representar um relógio!

Ao chegar na classe _**Segmento**_, cada segmento do display é desenhado como um polígono preenchido, utilizando o método _**filledPolygon**_ da classe _**Draw**_. Nessa etapa, é necessário um array de coordenadas x e y para desenhar um polígono.

<div align="center">

![Alt text](imagens/algs4.png)

_documentação do método filledPolygon_
</div>

É feito um cálculo das coordenadas, tendo como referência um ponto de partida definido pelo usuário, especificado por uma coordenada x e y iniciais. Além disso, o cálculo leva em consideração o tamanho do relógio escolhido, que pode variar entre 1, 2 ou 3. A maior dificuldade encontrada para o cálculo foi em manter uma proporção adequada ao desenhar relógios de diferentes tamanhos na tela, garante que a representação gráfica seja consistente, independentemente do tamanho do relógio selecionado.

## Licença 📜

Este projeto é licenciado sob a [MIT License](https://github.com/luizakuze/Contabilizador-Financeiro/blob/main/license)
