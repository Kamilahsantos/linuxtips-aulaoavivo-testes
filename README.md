# piramide de teste

base da piramide - tipo de teste mais simples e mais rapido de executar 
teste de unidade
meio da piramide - teste de integracao
como os componentes se integram
principalmente componentes externos
test container
topo - e2e/ teste de interface
teste de contrato - rest assured


## test doubles
test doubles - viablizam a realização de testes, um objeto em produção substitui o outro
fakes - test doubles que tem implementações reais diferentes aquelas do ambiente produtivo
mocks - os mocks só funcionam se forem chamados de uma determinada forma (muito usado pata mockar outras classes)
spies - age como um espião de implementação, verifica a integração entre os métodos
stubs - consegue alterar seu comportamento com base em como ele foi chamado
dummy - substituem dados reais mas não chegam a ser utilizados



## first
F- fast -  execução rapida (principalmente testes unitários)
I - independents- um teste não deve depende do outro
R- repeatable -  deve sempre dar o mesmo resultado (não deve ser flaky)
S - self validating - deve ser simples de entender se passou ou não
T - timely - escreva o quanto antes


## como implementar cultura de testes
- comece com testes unitários
- apresente quais os ganhos financeiros
- comece com a cobertura baixa
- aos poucos aumente a cobertura
- inclua teste de integracao e e2e