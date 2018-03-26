# Android Calculator
Primeira prática do curso de Android. Roteiro consiste em desenvolver dois aplicativos: calculadora básica e uma avançada. 
Projeto foi zipado com comando:
```sh
$ gradlew clean
```
### Instalação no Android Studio
> Vá para pasta de C:\Users\username\AndroidStudioProjects :

>$ git clone https://github.com/cacaudev/android-calculator.git

>"Make Project" para gerar os arquivos executáveis (CTRL+F9)

>"Run app" para rodar aplicativo em um emulador(AVD) ou smartphone pessoal (SHIFT+F10)

## Calculadora Básica
Aplicativo espera que o usuário digite dois valores numéricos e escolha
uma das quatro operações matemáticas básicas representadas por botões. Quando o
usuário pressionar um desses botões, a respectiva operação matemática será
executada e o resultado da mesma será exibido em uma TextView na parte inferior da
tela.

> Local código fonte: app/src/main/java/com/example/cacau2/pratica1/calculadoraSimples.java

## Calculadora Avançada
Este aplicativo possui um visor representado por um EditText. Esse visor não
deverá ser editável, ou seja, todas as informações exibidas no mesmo serão oriundas do pressionamento dos botões presentes no aplicativo.

Como se pode observar, esse aplicativo terá comportamento muito similar às
calculadoras tradicionais, sendo assim, para que a informação “10 - 5” exibida no
exemplo seja apresentada no visor, o usuário deverá pressionar os botões “1”, “0”, “-”
e “5” exatamente nesta ordem. Neste momento, se o usuário pressionar o botão “=”,
o resultado da operação será apresentado no visor, podendo este ser reutilizado em
novas operações matemáticas.

O botão “<<” representa a operação de backspace, excluindo então o último
dígito informado quando é pressionado. O botão “C” deve limpar o visor quando
pressionado. Por fim, o botão “.” deve ser utilizado para especificar valores decimais.

OBS: Nessa prática não era obrigatório o cálculo de uma expressão completa, apenas de uma operação por vez.

> Local código fonte: app/src/main/java/com/example/cacau2/pratica1/calculadoraAvancada.java
