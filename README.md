# Game of life
   Game of life de John Horton Conway  se trata de um modelo automático de célula e tem como base algumas regras simples, que são, qualquer célula viva com menos de dois vizinhos vivos morre de solidão, qualquer célula viva com mais de três vizinhos vivos morre de superpopulação, qualquer célula morta com exatamente três vizinhos vivos se torna uma célula viva, qualquer célula viva com dois ou três vizinhos vivos continua no mesmo estado para a próxima geração.<br><br>
### O codigo
   Neste projeto não iremos considerar os lados opostos a celula na contagem de vizinhos.<br>
![grade](https://github.com/elimarmacena/gameoflife/blob/master/image/grid_exemple.png "exemplo")
<br>   Mostrando que foi dito através do exemplo acima, a célula [0,0] não sofre influência da [0,4] e assim por diante.<br><br>
   O ambiente da célula, o mundo, é gerado aleatoriamente, sendo assim toda vez que se inicia o ambiente é diferente do anterior. O tamanho da célula é um tamanho quadrado, sendo assim, o número de linha e colunas são sempre o mesmo. <br><br>
   Por ser um ambiente aleatório, é feita uma verificação toda vez que uma nova geração surge, essa verificação se trata de verificar se ainda existe vida na célula ou nao, caso nao exista mais vida o programa é terminado.<br><br>
   
### Falhas
   O codigo não possui um comando de limpar a tela, esse comando pode variar de sistemas operacional, por conta disso apenas fiz a simulação de animação atraves do uso de quebra linhas, que funciono atraves das dimensões usadas em minha maquina.<br><br>
#### <br><br>Este projeto teve como base apenas treino da linguagem java

