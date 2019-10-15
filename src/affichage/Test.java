package affichage;

import constante.ConstanteInt;
import init.Init;
import object.expedition.Expedition;
import object.monster.Monster;
import object.player.Player;
import object.quest.Quest;
import object.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    private static Scanner sc = new Scanner(System.in);
    private static int choice;
    private static ArrayList<Thread> listThread = new ArrayList<>();
    private static ArrayList<Monster> listMonster = new ArrayList<>();

    public static void main(String[] args){
        Init.initialise();
        System.out.println("\n¤¤Bienvenue à toi jeune héros¤¤");
        while (true){
            System.out.println("\nQue souhaites-tu faire ?");
            System.out.println("\n0. Fermer le jeu\n\n1. Partir pour une quête\n2. Autel d'invocation\n3. Afficher votre ménagerie\n4. Améliorer un objet\n6. Expéditions");
            choice = sc.nextInt();
            switch (choice){
                case 0:
                    System.out.println("Fermer le jeu");
                    System.exit(1);
                    break;

                case 1:
                    if (Init.player.getMonsters().size() == 0){
                        System.out.println("Vous ne possédez pas encore de monstre, allez faire un tour à l'autel d'invocation pour rencontrer vos premiers alliés");
                    }
                    else {
                        quest();
                    }
                    break;

                case 2:
                    if (Init.player.getMonsters().size() == 0) {
                        System.out.println("Vous êtes nouveau ? Tenez, nous vous offrons 20 fragments de pierre d'invocation");
                    }
                    altarOfInvocation();
                    break;

                case 3: Init.player.showMonsters();
                    break;

                case 4: upItem();
                    break;

                case 5: Init.player.showItems();
                    break;

                case 6:
                    if (Init.player.getMonsters().size() == 0){
                        System.out.println("Vous ne possédez pas encore de monstre, allez faire un tour à l'autel d'invocation pour rencontrer vos premiers alliés");
                    }
                    else {
                        expedition();
                    }
                    break;

                default: break;
            }
        }
    }

    private static int questRank(){
        System.out.println("Sur quelle île souhaitez-vous vous rendre ?\n1. Le bois perdu    2.La colline dorée    3.Le sanctuaire    4.Le void    5. ?");
        return sc.nextInt();
    }

    private static int questDifficulty(){
        System.out.println("Quel niveau de difficulté souhaitez-vous affronter ?\n1   2   3   4   5   6   7   8   9");
        return sc.nextInt();
    }

    private static Monster chooseMonsterExpe(){
        System.out.println("Choisissez votre monstre pour l'expédition");
        for (int i = 0; i < Init.player.getMonsters().size(); ++i) {
            System.out.println(i+1 + ". " + Init.player.getMonsters().get(i));
        }
        return Init.player.getMonsters().get(sc.nextInt()-1);
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

    private static void expedition(){
        System.out.println("\n1. Partir en expédition\n2. Statut de mes expéditions");
        int choiceExpe = sc.nextInt();
        switch (choiceExpe){
            case 1:
                int difficulty = chooseExpeditionDifficulty();
                Monster playerMonster = chooseMonsterExpe();
                Thread thread = new Thread(new Expedition("Expedition lvl " + difficulty, difficulty, playerMonster));
                listThread.add(thread);
                listMonster.add(playerMonster);
                thread.start();
                break;

            case 2:
                if (listThread.size() == 0){
                    System.out.println("Vous n'avez pas encore entammé d'expédition");
                }
                else{
                    for (int i = 0; i < listThread.size(); ++i) {
                        System.out.println("\n" + (i+1) + " " + listMonster.get(i));
                    }
                    cancelExpedition();
                }
                break;
        }
    }

    private static void cancelExpedition(){
        System.out.println("Voulez vous faire rentrer " + listMonster.get(sc.nextInt()-1) + "\n1. Oui   2.Non");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                listThread.get(choice-1).interrupt();
                listThread.remove(choice -1);
                listMonster.remove(choice-1);
                break;

            case 2:
                System.out.println("trololol");
                break;
        }
    }

    private static int chooseExpeditionDifficulty(){
        System.out.println("Choisissez la difficulté de l'expédition\n1   2   3");
        return sc.nextInt();
    }

    private static void altarOfInvocation(){
        System.out.println("Bienvenue dans l'autel d'invocation!\n");
        System.out.println("Vous avez actuellement " + Init.player.getNbFragmentStone() + " fragments de pierre d'invocation.");
        System.out.println("Nombre d'invocations disponibles : " +Init.player.getNbFragmentStone()/ConstanteInt.SUMMON_COST.getValeur());
        System.out.println("Combien d'invocation voulez-vous réaliser ? (0. Retour)");
        int count = sc.nextInt();
        if (Init.player.getGold() >= Init.player.getNbFragmentStone()/ConstanteInt.SUMMON_COST.getValeur() * count) {
            while (count > 0) {
                Init.player.summon();
                --count;
            }
        }
        while (count > 0) {
            Init.player.summon();
            --count;
        }
    }

    private static void quest(){
        int rank = questRank();
        int difficulty = questDifficulty();
        Quest quest = new Quest("Quête de rang " + rank, rank, difficulty);
        System.out.println("Départ pour la quête !\n");
        quest.setPlayerMonsters(chooseMonster());
        quest.goOnQuest();
        System.out.println("\n");
    }

    private static void upItem(){
        Init.player.showItems();
        int item= Init.player.getItems().size();
        if (item <= 0) {
            System.out.println("\nVous ne possédez pas d'objet à améliorer");
        }
        else{
            while (item >= Init.player.getItems().size()) {
                System.out.println("Sélectionnez un objet à améliorer :");
                item = sc.nextInt();
            }
            System.out.println("Vous avez sélectionné cet objet :\n" + Init.player.getItems().get(item));
            System.out.println("Améliorer ? (cout: "+ ConstanteInt.ITEM_PRICE_UP.getValeur() * (Init.player.getItems().get(item).getLevel()+1) +")1. oui  2. non");
            if (sc.nextInt() == 1){
                if (Init.player.getGold() >= ConstanteInt.ITEM_PRICE_UP.getValeur() * (Init.player.getItems().get(item).getLevel()+1))
                    Init.player.getItems().get(item).lvlup();
                else
                    System.out.println("Vous n'avez pas assez de pièce d'or!");
            }
        }
    }


}
