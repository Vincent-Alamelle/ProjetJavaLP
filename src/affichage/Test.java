package affichage;

import init.Init;
import object.quest.Quest;

import java.util.Scanner;

public class Test {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        //menu();
        Init.initialise();
        System.out.println("\n¤¤Bienvenue à toi jeune héros¤¤");




        while (true){
            System.out.println("Que souhaites-tu faire ?");
            System.out.println("\n0. Fermer le jeu\n\n1. Partir pour une quête\n2. Autel d'invocation");
            int choice = sc.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Fermer le jeu");
                    System.exit(1);
                    break;

                case 1:
                    int difficulty = questDifficulty();
                    Quest quest = new Quest("Quête lvl " + difficulty, difficulty);
                    System.out.println("Souhaitez vous partir pour une quête de niveau " + quest.getLvl() + " ?\n" + "1. Oui \t 2. Non");
                    int valid = sc.nextInt();
                    if (valid == 1){
                        System.out.println("Départ pour la quête !\n");
                        quest.goOnQuest();
                        System.out.println("\n");
                    }
                    break;

                case 2:
                    System.out.println("L'autel d'invocation n'est pas encore disponible\n");
                    break;

                case 55:
                    Init.initialise();
                    System.out.println(Init.dragonet);
                    System.out.println(Init.succubus);
                    System.out.println(Init.slime);
                    break;
            }

        }

    }

    private static int questDifficulty(){
        System.out.println("Choisissez la difficulté de votre quête : \n 1. Niveau 1 \t 2. Niveau 2 \t 3. Niveau 3 \t 4. Niveau 4 \t 5. Niveau 5");
        return sc.nextInt();
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
