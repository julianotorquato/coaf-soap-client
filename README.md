# Client Soap

## Tabela de Índice

1.  [Descrição](#id-descricao)
2.  [Pré-requisitos](#id-requisitos)
4.  [Tecnologias](#id-tecnologias)
5.  [SOAP](#id-soap)
6.  [Instalação](#id-instalacao)
6.  [Links de Ajuda](#id-links)
9.  [Autor](#id-autor)

<div id='id-descricao'/>

## Descrição

**Client Soap** é um applicação gerada pelo [String Initializr](https://start.spring.io/). É um projeto de exemplo Client Soap com base no COAF. 
Contempla Assinatura digital de xml, Webservice SOAP e Comunicação com SISCOAF. 

---

<div id='id-requisitos'/>

## ✋🏻 Pré-requisitos

- Java (1.8)
- Maven (3.3.9)

---

<div id='id-tecnologias'/>

### 🚀 Tecnologias

- [SpringBoot](https://spring.io/) - facilita a criação de aplicações Spring com poucas configurações e não faz uso de XML, usa anotações.
- [MapsStruct](https://mapstruct.org/) - realiza a conversão dos DTO para os domains e vise versa.
- [Maven](https://maven.apache.org/) - ferramenta de building para: testar e executar.
- [XML](https://www.w3.org/TR/2001/REC-xml-c14n-20010315) - especificação do conteúdo de comunição entre os serviços.
- [Lacuna WebPKI](https://webpki.lacunasoftware.com/#/) - unidade certificadora para logar com certificado digital (E-CPF).

---

<div id='id-soap'/>

## Soap

Abaixo segue as intruções usadas para fazer o download das classes Pojos java a partir dos xml


Instalar os pacotes do JDK  headless
```
    sudo apt install openjdk-8-jdk-headless
```   
   
Com a classe Download_Stubs foi possível baixar o wsdl e criar o arquivo "COAF.ComunicacaoService.wsdl"
  

Comando usado para importar os pojos: 
```
 wsimport src/main/resources/wsdl/COAF.ComunicacaoService.wsdl -keep -d src/main/java
```
    cd src/main/java/br/gov/fazenda/coaf
    
Remoção dos .class
```
  rm *.class
```

---

<div id='id-instalacao'/>

## 🔥 Instalação e execução

1. Faça o clone desse repositório e entre na pasta

```
cd coaf-soap-client
```

2. Instalar as dependências

```
mvn install -DskipTests
```

3. Após subir a aplicação, acesse as API's disponiveis:

* [EnviarLoteComunicacao](http://localhost:7029/api/coaf/send-communication)
* [ReciboLoteComunicacao](http://localhost:7029/api/coaf/receipt)


---

<div id='id-links'/>

## Links de Ajuda

- [Gerar PFX Demo](https://demos.lacunasoftware.com/en/demos/generate-certificate) - Link usado para gerar o .pfx no teste de assinatura digital.
- [Gerar chave de Desenvolvedor](https://pki.rest/app/#/getting-started) - Caso necessite conhecer os recursos da Lacuna Software para assinatura clique [aqui](https://github.com/LacunaSoftware/SignerSamples).
- [COAF](http://fazenda.gov.br/orgaos/coaf) - Para acessar ambiente de [Homologação](https://treina.siscoaf2.fazenda.gov.br/) e/ou [Produção](https://siscoaf.fazenda.gov.br).
- [Skipar Validação SSL](https://stackoverflow.com/questions/12473576/how-to-disable-certificate-validation-in-jax-ws-client/24586928) Link usado para desabilitar validação ssl client SOAP. 

---

<div id='id-autor'/>

## Autor

From **[VHL Sistemas](https://vhlsistemas.com.br/)** By **[@Juliano Torquato](https://github.com/julianotorquato)** **[@Jonathan Alves](https://github.com/jonathanalves)**

---



