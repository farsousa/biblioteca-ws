# Biblioteca-ws
Este projeto de gerenciamento de biblioteca visa ser referência de estudo para o assunto de arquitetura hexagonal, pois esse conceito é utilizado neste webservice.

## Arquitetura Hexagonal
A Arquitetura Hexagonal, também conhecida como Arquitetura de Portas e Adaptadores, busca isolar o domínio da aplicação de elementos externos (bibliotecas, frameworks, ...). Tudo isso na intenção de reaproveitar o _core_ da aplicação nos casos de troca de tecnologia, biblioteca, frameworks. Além disso, a arquitetura busca facilitar e otimizar a manutenção do sistema.

Assim, cria-se um _core_ com a modelagem, os serviços, e as portas de acesso da regra de negócio que independe de bibliotecas e frameworks. 

Além disso, criam-se os adaptadores com capacidades de acionar as portas a fim da execução de alguma funcionalidade do _core_.

A figura a seguir mostra uma ilustração da arquitetura:
![Arquitetura Hexagonal](https://miro.medium.com/v2/resize:fit:1400/format:webp/0*Ujx7saeqJVjXvybC)

Para mais informações, acesse este artigo: https://medium.com/@marcio.kgr/arquitetura-hexagonal-8958fb3e5507

## Organização do Projeto
A estrutura do projeto ficou da seguinte forma:

![image](https://github.com/farsousa/biblioteca-ws/assets/52000592/892932ad-e982-46f5-8587-65beecc69d94)

## Conceitos e Bibliotecas usadas
* Arquitetura Hexagonal
* Spring Data JPA + H2
* Swagger
* Flyway
* Lombok
* Actuator
* Prometheus

## Swagger
Para verificar os serviços oferecidos, após rodar o projeto localmente, acesse: http://localhost:8080/swagger-ui/index.html


