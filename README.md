# W16 Warker App - API JAVA

## Desenvolvedor

Olá! Muito obrigado por participar da avalição técnica para integrar a equipe de desenvolvimento da W16.

Criamos esta avaliação para avaliar seu conhecimento em lógica de programação, capacidade de investigar e conhecer novas ferramentas, organização e qualidade de código e especialmente, sua criatividade.

## Especificação
No mundo pós-apocaliptico de 2021, o combustível tem um valor inestimável. Gangues bárbaras lutam até a morte pelo controle desse valioso recurso e a W16 está desenvolvendo o aplicativo WARKER, que é a última esperança da humanidade em trazer um pouco de paz e ordem à esse mundo devastado.
Esse aplicativo deve produzir uma API REST construída em **Java** que indica os postos de gasolina das diversas cidades, sua localização, preço do combustível e o nível dos seus reservatórios. Lembre-se de que não há mais lei e a sua vida depende do sucesso desse backend. Marcopoc não fica feliz quando o seu app falha devido a erros no backend e você não quer deixar o Marcopoc irritado...

## Regras
- Não há regras, não há lei, apenas a sobrevivência importa! 

## Recomendações
- Faça bom uso dos recursos do framework (migrations, factories, estrutura MVC, rotas...)
- D.R.Y. = "Don't Repeat Yourself"
- Mantenha o código limpo e organizado
- Utilize comentários pois alguém irá ler o seu código. Nosso último dev esqueceu um comentário importante. RIP :(
- Utilize o README.md do seu projeto para explicar instalação, funcionamento, o processo que usou para o desenvolvimento ou implorar por misericórdia.

## Importante
- Utilize Java Springboot
- Busque informação do site da ANP ou outras fontes de dados
- Utilize Java Springboot
- Lembre-se de usar os métodos GET,PUT,POST e DELETE
- Já mencionei que deve usar Java Springboot?

## Pontos Extras
Pode contar pontos extras
- CRUD Web
- Autenticação
- Teste automatizado
- Seeder e uso de fakers (mas nao para o preço!)

### Exemplo de tabelas:

Cidades
```
|id |nome_da_cidade|latitude|longitude|created_at|updated_at|
|int|string        |double  |double   |timestamp |timestamp |
```

Postos
```
|id |cidade_id|reservatorio|latitude|longitude|created_at|updated_at|gas_price|
|int|int(fk)  |int(1-100%) |double  |double   |timestamp |timestamp |double   |
```

### Endpoints esperados
/api/cidade/id
```
{
    id : id,
    cidade : nome_da_cidade,
    coords : {
            latitude : latitude,
            longitude : longitude
        },
    postos : {
        id : id,
        reservatorio : reservatorio,
        coords : {
            latitude : latitude,
            longitude : longitude
        },
        updated_at : updated_at,
        created_at : created_at
    }
}
```

/api/posto/id
```
{
    id : id,
    reservatorio : reservatorio,
    coords : {
        latitude : latitude,
        longitude : longitude
    },
    updated_at : updated_at,
    created_at : created_at
}
```

## Entrega
Crie um FORK deste repositório e faça um Pull-Request. Commite no repositório todo o código do backend, juntamente com instruções, se necessário. O prazo para entrega será de 7 horas - ou melhor, 7 dias.

Qualquer dúvida, crie um issue neste projeto ou entre em contato com o nosso time pelo instagram: @w16.softwarehouse

2 DEVS ENTRAM, 1 DEV SAI!
