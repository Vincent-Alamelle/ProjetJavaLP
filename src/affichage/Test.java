package affichage;

import constante.ConstanteInt;
import init.Init;
import object.monster.Monster;
import object.player.Player;
import object.quest.Quest;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Init.initialise();
        System.out.println("\n¤¤Bienvenue à toi jeune héros¤¤");

        while (true){
            if (Init.player.getMonsters().size() == 0)
                System.out.println("Vous êtes nouveau ? Tenez nous vous offrons 20 fragments de pierre d'invocation, allez les utiliser dans l'autel d'invocation en tapant 2!");
            else {
                System.out.println("\nQue souhaites-tu faire ?");
                System.out.println("\n0. Fermer le jeu\n\n1. Partir pour une quête\n2. Autel d'invocation\n3. Afficher votre ménagerie");
            }
            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Fermer le jeu");
                    System.exit(1);
                    break;

                case 1: quest();
                    break;

                case 2: altarOfInvocation();
                    break;

                case 3: Init.player.showMonsters();
                    break;
            }
        }

    }

    private static int questDifficulty(){
        System.out.println("Choisissez la difficulté de votre quête : \n 1. Niveau 1 \t 2. Niveau 2 \t 3. Niveau 3 \t 4. Niveau 4 \t 5. Niveau 5");
        return sc.nextInt();
    }

    private static ArrayList<Monster> chooseMonster(){
        System.out.println("Choisissez vos monstres pour votre quête");
        for (int i = 0; i < Init.player.getMonsters().size(); ++i) {
            System.out.println(i+1 + ". " + Init.player.getMonsters().get(i));
        }
        ArrayList<Monster> ints = new ArrayList<>();
        ints.add(Init.player.getMonsters().get(sc.nextInt()-1));
        ints.add(Init.player.getMonsters().get(sc.nextInt()-1));
        ints.add(Init.player.getMonsters().get(sc.nextInt()-1));
        return ints;
    }

    private static void altarOfInvocation(){
        System.out.println("Bienvenue dans l'autel d'invocation!\n");
        System.out.println("Vous avez actuellement " + Init.player.getNbFragmentStone() + " fragments de pierre d'invocation.");
        System.out.println("Nombre d'invocations disponibles : " +Init.player.getNbFragmentStone()/ConstanteInt.SUMMON_COST.getValeur());
        System.out.println("Combien d'invocation voulez-vous réaliser ? (0. Retour)");
        int count = sc.nextInt();
        while (count > 0){
            Init.player.summon();
            --count;
        }
    }

    private static void quest(){
        int difficulty = questDifficulty();
        Quest quest = new Quest("Quête lvl " + difficulty, difficulty);
        System.out.println("Souhaitez vous partir pour une quête de niveau " + quest.getLvl() + " ?\n" + "1. Oui \t 2. Non");
        int valid = sc.nextInt();
        if (valid == 1){
            System.out.println("Départ pour la quête !\n");
            quest.setPlayerMonsters(chooseMonster());
            quest.goOnQuest();
            System.out.println("\n");
        }
    }

    /*private static void menu(){
        Scanner scanner = new Scanner(System.in);
        String message;
        while (true) {
            System.out.println("fonctionnalités : ajouter animal | enlever animal | quitter");
            if ((message = scanner.nextLine()) != null) {
                switch (message) {
                    case "ajouter animal":
                        addAnimal();
                        break;
                    case "enlever animal":
                        removeAnimal();
                        break;
                    default: System.exit(0);
                }
            }
        }
    }

    private static void addAnimal(){
        Scanner scanner = new Scanner(System.in);
        String message;
        System.out.println("liste des espèces disponibles : aigle | pingouin | baleine | poisson rouge | requin | loup | ours | tigre");
        if ((message = scanner.nextLine()) != null){
            switch (message){
                case "aigle": setAnimal(Init.fabriqueAigle.getAnimal());break;
                case "pingouin": setAnimal(Init.fabriquePingouin.getAnimal());break;
                case "baleine": setAnimal(Init.fabriqueBaleine.getAnimal());break;
                case "poisson rouge": setAnimal(Init.fabriquePoisson.getAnimal());break;
                case "requin": setAnimal(Init.fabriqueRequin.getAnimal());break;
                case "loup": setAnimal(Init.fabriqueLoup.getAnimal());break;
                case "ours": setAnimal(Init.fabriqueOurs.getAnimal());break;
                case "tigre": setAnimal(Init.fabriqueTigre.getAnimal());break;
                default:
                    System.out.println("Entrez une espèce d'animal de la liste");break;
            }
        }
    }

    private static void setAnimal(Monster animal){
        Scanner scanner = new Scanner(System.in);
        String message = "";
        int compteur = 0;
        while (compteur !=10) {
            switch (compteur) {
                case 0:
                    System.out.println("Donner un nom à l'animal");
                    if ((message = scanner.nextLine()) != null)
                        animal.setName(message);
                    break;
                case 1:
                    System.out.println("Donner un sexe à l'animal");
                    if ((message = scanner.nextLine()) != null)
                        animal.setSexe(message);
                    break;
                case 2:
                    System.out.println("Donner un poids à l'animal");
                    if ((message = scanner.nextLine()) != null)
                        animal.setWeight(Double.parseDouble(message));
                    break;
                case 3:
                    System.out.println("Donner une taille à l'animal");
                    if ((message = scanner.nextLine()) != null)
                        animal.setHeight(Integer.parseInt(message));
                    break;
                case 4:
                    System.out.println("Donner un age à l'animal");
                    if ((message = scanner.nextLine()) != null)
                        animal.setAge(Integer.parseInt(message));
                    break;
                case 5: animal.setHungerIndicator(ConstanteInt.MAX_HUNGER.getValeur());
                    break;
                case 6: animal.setHealthIndicator(ConstanteInt.MAX_HEALTH.getValeur());
                    break;
                case 7:
                    while (!message.equals("true") || !message.equals("false")) {
                        System.out.println("l'animal dort-il? (true / false)");
                        if ((message = scanner.nextLine()) != null)
                            animal.setSleepIndicator(Boolean.parseBoolean(message));
                    }
                    break;
                default:
                    break;
            }
            ++compteur;
        }
    }

    private static void removeAnimal(){

    }*/
}
