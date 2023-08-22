# automacao-calculadoraandroid-java-mobile
Scripts de automação de testes de software na Calculadora do Android usando Java, Appium, jUnit e Selenium.

### Cobertura dos testes:  ###
*Descricao: 

Realizar calculos basicos na calculadora do Android no emulador.

Realizar calculos basicos na calculadora do Android no smartphone.

## Tecnologias:
* [Java JDK 8+](https://www.oracle.com/br/java/technologies/javase-downloads.html)
* [Maven](https://maven.apache.org)
* [Maven dependencias](https://mvnrepository.com)
* [Appium 2.0+](http://appium.io)
* [Selenium](https://www.selenium.dev/projects/)
* [Intellij Idea](https://www.jetbrains.com/pt-br/idea/)
* [jUnit 4](https://junit.org/junit4/)
* [Apk Info](https://play.google.com/store/apps/details?id=com.wt.apkinfo&hl=pt_BR)
* [Android Studio](https://developer.android.com/studio)

## Dependências:
* Selenium-java
* jUnit 4
* Commons-io
* Cucumber-junit
* Cucumber-java
* Jxl
* Poi-ooxml

## Instruções de execução:

###  - App
*Importante: 

Nao e necessario fazer o download da calculadora, ela ja vem por padrao, apesar que dependera de qual versao do Android voce ira testar, pois ha versoes que nao vem a calculadora.

Eu recomendo usar o Apk Info para verificar as informacoes do "appPackage" e "appActivity" para inserir no metodo de capabilities. Nao tem problema em usar outro.

Utilize a versão 2 do Appium, pois as anteriores foram depreciadas e não possuem suporte do Desenvolvedor.

###  - Plataforma
*Importante:

O projeto foi criado para executar no MacOS. Mas pode receber adaptacoes para executar no Windows e Linux caso nao execute bem fora do MacOS.

Recomendado utilizar o Intellij Idea, mas pode usar o Eclipse IDE, Visual Studio Code ou Spring Tools Suite.

###  - Fluxo
*Descricao: Este script ira executar calculos simples como Soma, Subtracao, Multiplicacao e Divisao.

###  - Massas
*Descricao: 
Nao e necessario criar massas.

###  - Evidencias
*Descricao:
Apos a execucao as imagens de evidencias sao armazenadas na pasta screenshots..

Para visualizar as evidencias no documento pode usar o MS Office Word ou o LibreOffice

###  - Inicializar a automação
*Descricao:

Execute o Appium.

Abrir uma das classes ***Test.java no Intellij Idea ou no Eclipse.

No caso para executar num smartphone, abra a classe Mobile Driver e altere o valor no campo "DeviceId".