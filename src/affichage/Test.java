package affichage;

import object.monster.Monster;
import init.Init;
import constante.ConstanteInt;
import object.quest.Quest;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        //menu();
        System.out.println("Bienvenue à toi jeune héros !");
        System.out.println("Que souhaites-tu faire ?");
        System.out.println("1. Partir pour une quête de niveau 1");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                Quest questlvl1 = new Quest("Une petite promenande", 1);
                System.out.println("souhaitez vous partir pour la quête : " + questlvl1.getName() + " ?");

                questlvl1.goOnQuest();
                break;
            case 2:
                Quest questlvl2 = new Quest("Une plus grande promenade", 2);
                questlvl2.goOnQuest();
                break;
            case 55:
                Init.Initialise();
                System.out.println(Init.dragonet);
                System.out.println(Init.succubus);
                System.out.println(Init.slime);
                break;
        }
    }

    private static int validation(){
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
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
