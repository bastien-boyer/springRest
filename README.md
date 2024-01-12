# springRest

## API  
**A**pplication **P**rogramming **I**nterface  

## REST  
**RE**presentational **S**tate **T**ransfer

## CRUD  
- **C**reate  -> POST
- **R**ead    -> GET
- **U**pdate  -> PUT
- **D**elete  -> DELETE

## Hypertext Transfer Protocol  
### Request  
- Method (= verbe : Get, Post, Delete etc...)  
- URI (= endpoint)  
- Body
### Response  
- Status Code (ok : 200, not found : 404 etc...)
- Body


# Spring  
## Spring Core
Base de l'écosystème Spring. Core contient l'Inversion de Controle conteneur qui permet d'implémenter le pattern d'injection de dépendances.
## Spring Data  
Permet de communiquer avec la BDD
## Spring Security  
Permet de gérer l’authentification, l’autorisation ainsi que la sécurité des API

## Inversion Of Control (IOC)  
L’inversion de contrôle est un principe d’architecture conduisant à inverser le flux de contrôle par rapport au développement traditionnel.  
Le Framework (ici Spring) fourni une ossature et le développeur fourni le code spécifique attendu par le framework.

### Inversion Of Control Container  
L'IOC container s'occupe de la création des objets et des dépendances entre eux. Au sens large l'IOC container gère le cyle de vie des objets de l'application.

## Spring Bean  
Un bean est un objet instancié. Il est créé par Spring par le IOC Container (Inversion of Control) lors de la phase de scan

# Spring Initializr
[Spring Initializr](https://start.spring.io/) est la première étape lors de la création d'un projet Spring. Il permet de générer une archive contenant la base de l'application.  
Cela permet de facilement configurer le projet notament pour gérer les dépendances requises à l'application (Spring Web, Spring Security, H2 Database etc...)

## Spring Controller:
@RestController
@RequestMapping("/path")
