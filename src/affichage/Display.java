package affichage;

import constante.ConstanteInt;
import init.Init;
import object.expedition.Expedition;
import object.item.Item;
import object.monster.Monster;
import object.player.Player;
import object.quest.Quest;
import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    private static Scanner sc = new Scanner(System.in);

    public static void launch(){
        System.out.println("\n¤¤Bienvenue à toi jeune héros¤¤");
        while (true){
            System.out.println("\nQue souhaites-tu faire ?");
            System.out.println("\nVous avez actuellement : " + Player.getInstance().getGold() + " Gold et " + Player.getInstance().getNbFragmentStone() + "fragments de pierre");
            System.out.println("\n0. Fermer le jeu\n\n1. Partir pour une quête\n2. Autel d'invocation\n3. Afficher votre ménagerie\n4. Inventaire\n5. Améliorer un objet\n6. Expéditions");
            switch (sc.nextInt()){
                case 0:
                    System.out.println("Fermer le jeu");
                    System.exit(1);
                    break;

                case 1:
                    if (Player.getInstance().isHasBegin()){
                        System.out.println("Vous ne possédez pas encore de monstre, allez faire un tour à l'autel d'invocation pour rencontrer vos premiers alliés");
                    }
                    else if (Player.getInstance().getMonsters().size() == 0)
                        System.out.println("Gueux, vous n'avez pas de monstres disponibles");
                    else {
                        quest();
                    }
                    break;

                case 2:
                    if (Player.getInstance().isHasBegin()) {
                        System.out.println("Vous êtes nouveau ? Tenez, nous vous offrons 20 fragments de pierre d'invocation");
                    }
                    altarOfInvocation();
                    break;

                case 3: Player.getInstance().showMonsters();
                    break;

                case 4:
                    int choice;
                    Player.getInstance().showItems();
                    System.out.println("-1. Retour");
                    System.out.println("Selectionnez un item pour l'équiper sur un de vos monstre");
                    if ((choice = sc.nextInt()) == -1)break;
                    Item item = Player.getInstance().getItems().get(choice);
                    Player.getInstance().showMonsters();
                    System.out.println("Sur qui voulez-vous equiper cet item");
                    Player.getInstance().getMonsters().get(sc.nextInt()).equip(item);
                    break;

                case 5: upItem();
                    break;

                case 6:
                    if (Player.getInstance().isHasBegin()) {
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
        for (int i = 0; i < Player.getInstance().getMonsters().size(); ++i) {
            System.out.println(i+1 + ". " + Player.getInstance().getMonsters().get(i));
        }
        return Player.getInstance().getMonsters().get(sc.nextInt()-1);
    }

    private static ArrayList<Monster> chooseMonster(){
        System.out.println("Choisissez vos monstres pour votre quête");
        for (int i = 0; i < Player.getInstance().getMonsters().size(); ++i) {
            System.out.println(i+1 + ". " + Player.getInstance().getMonsters().get(i));
        }
        ArrayList<Monster> ints = new ArrayList<>();
        ints.add(Player.getInstance().getMonsters().get(sc.nextInt()-1));
        ints.add(Player.getInstance().getMonsters().get(sc.nextInt()-1));
        ints.add(Player.getInstance().getMonsters().get(sc.nextInt()-1));
        return ints;
    }

    private static void expedition(){
        System.out.println("\n0. Retour\n1. Partir en expédition\n2. Statut de mes expéditions");
        int choiceExpe = sc.nextInt();
        switch (choiceExpe){
            case 1:
                if (Player.getInstance().getMonsters().size() > 0){
                    int difficulty = chooseExpeditionDifficulty();
                    Monster playerMonster = chooseMonsterExpe();
                    System.out.println("Départ pour l'expédition");
                    Thread thread = new Thread(new Expedition(difficulty, playerMonster));
                    Init.listThread.add(thread);
                    Init.listMonster.add(playerMonster);
                    thread.start();
                }
                else{
                    System.out.println("Gueux, vous n'avez pas de monstres disponibles");
                }
                break;

            case 2:
                if (Init.listThread.size() == 0){
                    System.out.println("Vous n'avez pas encore entammé d'expédition");
                }
                else{
                    for (int i = 0; i < Init.listThread.size(); ++i) {
                        System.out.println("\n" + (i+1) + " " + Init.listMonster.get(i));
                    }
                    int choice = sc.nextInt();
                    if (choice > 0 && choice <= Init.listMonster.size())
                        cancelExpedition(choice-1);
                }
                break;
            default: break;
        }
    }

    private static void cancelExpedition(int choiceCancel){
        System.out.println("Voulez vous faire rentrer " + Init.listMonster.get(choiceCancel) + "\n1. Oui   2.Non");
        switch (sc.nextInt()){
            case 1:
                Init.listThread.get(choiceCancel).interrupt();
                Init.listThread.remove(choiceCancel);
                Init.listMonster.remove(choiceCancel);
                break;
            default: break;
        }
    }

    private static int chooseExpeditionDifficulty(){
        int choice = 0;
        while (choice <= 0 || choice > 3){
            System.out.println("Choisissez la difficulté de l'expédition\n1   2   3");
            choice = sc.nextInt();
        }
        return choice;
    }

    private static void altarOfInvocation(){
        System.out.println("Bienvenue dans l'autel d'invocation!\n");
        System.out.println("Vous avez actuellement " + Player.getInstance().getNbFragmentStone() + " fragments de pierre d'invocation.");
        System.out.println("Nombre d'invocations disponibles : " +Player.getInstance().getNbFragmentStone()/ConstanteInt.SUMMON_COST.getValeur());
        System.out.println("Combien d'invocation voulez-vous réaliser ? (0. Retour)");
        int count = sc.nextInt();
        if (Player.getInstance().getNbFragmentStone() >= Player.getInstance().getNbFragmentStone()/ConstanteInt.SUMMON_COST.getValeur() * count) {
            while (count > 0) {
                Player.getInstance().summon();
                --count;
            }
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
        int item = 0;
        ArrayList<Item> items = new ArrayList<>(Player.getInstance().getItems());
        for (int i = 0; i < Player.getInstance().getMonsters().size(); i++) {
            items.addAll(Player.getInstance().getMonsters().get(i).getItems());
        }
        if (items.size() <= 0) {
            System.out.println("\nVous ne possédez pas d'objet à améliorer");
        }
        else{
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + ". " + items.get(i));
            }
            System.out.println("Sélectionnez un objet à améliorer :");
            item = sc.nextInt();
            while (item >= items.size() || item < 0) {
                System.out.println("Sélectionnez un objet à améliorer :");
                item = sc.nextInt();
            }
            System.out.println("Vous avez sélectionné cet objet :\n" + items.get(item));
            System.out.println("Améliorer ? (cout: "+ ConstanteInt.ITEM_PRICE_UP.getValeur() * (items.get(item).getLevel()+1) +")1. oui  2. non");
            if (sc.nextInt() == 1 && Player.getInstance().getGold() >= ConstanteInt.ITEM_PRICE_UP.getValeur() * (items.get(item).getLevel()+1)){
                if (Player.getInstance().getItems().contains(items.get(item)))
                    Player.getInstance().getItems().get(Player.getInstance().getItems().indexOf(items.get(item))).lvlup();
                else{
                    for (Monster monster: Player.getInstance().getMonsters()) {
                        if(monster.getItems().contains(items.get(item))) {
                            monster.getItems().get(monster.getItems().indexOf(items.get(item))).lvlup();
                            monster.updateItemStats(items.get(item));
                        }
                    }
                }
            }
            else
                System.out.println("Vous n'avez pas assez de pièce d'or!");
        }
    }
}