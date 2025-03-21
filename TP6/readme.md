# Memory Game 
### Auteur : Enrik Pashaj, groupe TP1A
### Statut du rendu : <b>Complet

### Compiler et executer le projet 
<p>
En utilisant cette suite d'instructions, vous pouvez compiler et exécuter directement le jeu depuis la <b>racine du projet</b> : 
</p>


```javac -d bin -cp src:bin src/*.java; cd bin; jar cfe  memory.jar Main *.class  images/ ; java -jar memory.jar``` <br>
Or, pour executer le jeu directement (tant que le jar a été compilé biensûr) depuis le fichier <b>bin:
``` java -jar memory.jar```
### Generer la documentation :
```javadoc -sourcepath src src/*.java -d docs```

### Description du rendu 
<p> J'ai decidé d'organiser le rendu en utilisant le type de Model-View controleur, dont : 
<br> - ModeleMemory.java est utilisé pour le bon déroulement du jeu 
<br> - ViewMemory qui est responsable pour l'affichage du jeu
<br> les trois autres classes (hors la classe <b>Carte.java qui représente les cartes et la classe main qui sert comme manifest) servent à  donner des informations par rapport au jeu, recommencer la partie et quitter la partie
</p>

### Les images (DISCLAIMER)

Les images utilisées dans ce jeu de memory sont issues du League of Legends Wiki et sont utilisées conformément à la licence Creative Commons Attribution-NonCommercial-ShareAlike. Ces images sont la propriété de Riot Games.
<p>Ce jeu est strictement non-commercial et a été créé uniquement à des fins éducatives et de divertissement personnel.</p> 
<p>Crédits d'images :<br>
© League of Legends Wiki - 
<a href='https://leagueoflegends.fandom.com'>https://leagueoflegends.fandom.com</a><br>

Licence : CC BY-NC-SA 3.0

### A propos
Ce disclaimer est aussi disponible dans le menu "A propos" integre dans le jeu



