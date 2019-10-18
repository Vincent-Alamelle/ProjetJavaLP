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
            System.out.println("Vous avez actuellement : " + Player.getInstance().getGold() + " Gold et " + Player.getInstance().getNbFragmentStone() + "fragments de pierre");
            System.out.println("\n0. Fermer le jeu\n1. Partir pour une quête    2. Autel d'invocation    3. Afficher votre ménagerie    4. Inventaire" +
                    "\n5. Améliorer un objet    6. Expéditions    7. Equipement de vos monstres    8. Enlever un objet d'un monstre");
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

                case 4:inventory();
                    break;

                case 5:
                    boolean hasItem = false;
                    for (Monster monster: Player.getInstance().getMonsters()) {
                        if (monster.getItems().size() > 0) {
                            hasItem = true;
                            break;
                        }
                    }
                    if (Player.getInstance().getItems().size() == 0 && !hasItem)
                        System.out.println("Vous n'avez pas d'objets, vous pouvez en récupérer en faisant des quêtes cependant ils sont rare");
                    else
                        upItem();
                    break;

                case 6:
                    if (Player.getInstance().isHasBegin()) {
                        System.out.println("Vous ne possédez pas encore de monstre, allez faire un tour à l'autel d'invocation pour rencontrer vos premiers alliés");
                    }
                    else {
                        expedition();
                    }
                    break;
                case 7:monsterEquipment();
                    break;

                case 8:removeMonsterEquipment();
                    break;
                default: break;
            }
        }
    }

    private static void removeMonsterEquipment(){
        boolean hasItem = false;
        for (Monster monster: Player.getInstance().getMonsters()) {
            if (monster.getItems().size() > 0) {
                hasItem = true;
                break;
            }
        }
        if (!hasItem)
            System.out.println("Vos monstres ne possèdent pas d'objets");
        else
            removeItemFromMonster();
    }

    private static void monsterEquipment(){
        boolean hasItem = false;
        for (Monster monster: Player.getInstance().getMonsters()) {
            if (monster.getItems().size() > 0) {
                hasItem = true;
                break;
            }
        }
        if (Player.getInstance().getMonsters().size() == 0 && Player.getInstance().isHasBegin())
            System.out.println("Allez invoquer des monstres à l'autel d'invocation!");
        else if (Player.getInstance().getMonsters().size() == 0)
            System.out.println("Il faut que vos monstres soient rentrés de l'expédition pour pouvoir inspecter leurs équipements");
        else if (!hasItem)
            System.out.println("Vos monstres n'ont pas d'objets équipés");
        else
            displayMonstersItems();
    }

    private static void inventory(){
        if(Player.getInstance().getItems().size() == 0){
            System.out.println("Votre inventaire est vide :(\n");
            return;
        }
        int choice;
        String chaine = "-1. Retour\nSelectionnez un item pour l'équiper sur un de vos monstre";
        Player.getInstance().showItems();
        System.out.println(chaine);
        if ((choice = sc.nextInt()) == -1)return;
        while (choice < -1 || choice > Player.getInstance().getItems().size()){
            Player.getInstance().showItems();
            System.out.println(chaine);
            choice = sc.nextInt();
        }
        Item item = Player.getInstance().getItems().get(choice);
        Player.getInstance().showMonsters();
        System.out.println("Sur qui voulez-vous equiper cet item");
        Player.getInstance().getMonsters().get(sc.nextInt()).equip(item);
    }

    private static void removeItemFromMonster(){
        Monster monster;
        ArrayList<Monster> monstersList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < Player.getInstance().getMonsters().size(); ++i) {
            if (Player.getInstance().getMonsters().get(i).getItems().size() > 0) {
                System.out.println(count + ". " + Player.getInstance().getMonsters().get(i));
                monstersList.add(Player.getInstance().getMonsters().get(i));
                ++count;
            }
        }
        int choice = sc.nextInt();
        while (true){
            if (choice >= 0 && choice < monstersList.size()) {
                monster = monstersList.get(choice);
                for (int i = 0; i < monster.getItems().size(); ++i) {
                    System.out.println(i + ". " + monster.getItems().get(i));
                }
                choice = sc.nextInt();
                while (choice < 0 || choice >= monster.getItems().size())
                    choice = sc.nextInt();
                monster.unequip(monster.getItems().get(choice));
                break;
            }
        }
    }

    private static void displayMonstersItems(){
        for (Monster monster: Player.getInstance().getMonsters()) {
            if (monster.getItems().size() > 0) {
                System.out.println(monster);
                monster.showItems();
            }
        }
    }

    private static int questRank(){
        int choice;
        String chaine = "Sur quelle île souhaitez-vous vous rendre ?\n-1. Retour     1. Le bois perdu    2.La colline dorée    3.Le sanctuaire    4.Le void    5.La palais pas laid";
        System.out.println(chaine);
        while ((choice = sc.nextInt()) < 1 || choice > 5) {
            System.out.println(chaine);
            if (choice == -1)break;
        }
        return choice;
    }

    private static int questDifficulty(){
        int choice;
        String chaine = "Quel niveau de difficulté souhaitez-vous affronter ?\n-1. Retour    1   2   3   4   5   6   7   8   9";
        System.out.println(chaine);
        while ((choice = sc.nextInt()) < 1 || choice > 9) {
            System.out.println(chaine);
            if (choice == -1)break;
        }
        return choice;
    }

    private static Monster chooseMonsterExpe(){
        int choice;
        String chaine = "Choisissez votre monstre pour l'expédition\n-1. Retour";
        System.out.println(chaine);
        for (int i = 0; i < Player.getInstance().getMonsters().size(); ++i) {
            System.out.println(i + ". " + Player.getInstance().getMonsters().get(i));
        }
        while ((choice = sc.nextInt()) < 0 || choice >=  Player.getInstance().getMonsters().size()){
            if(choice == -1) return null;
            System.out.println(chaine);
            for (int i = 0; i < Player.getInstance().getMonsters().size(); ++i) {
                System.out.println(i + ". " + Player.getInstance().getMonsters().get(i));
            }
        }
        return Player.getInstance().getMonsters().get(choice);
    }

    private static ArrayList<Monster> chooseMonster(){
        int choice;
        int count = 3;
        ArrayList<Monster> ints = new ArrayList<>();
        System.out.println("Choisissez vos monstres pour votre quête");
        for (int i = 0; i < Player.getInstance().getMonsters().size(); ++i) {
            System.out.println(i + 1 + ". " + Player.getInstance().getMonsters().get(i));
        }
        while (count > 0) {
            if ((choice = sc.nextInt()-1) >= 0 && choice < Player.getInstance().getMonsters().size() && !ints.contains(Player.getInstance().getMonsters().get(choice))) {
                ints.add(Player.getInstance().getMonsters().get(choice));
                --count;
            }
        }
        for (Monster monster: ints) {
            Player.getInstance().getMonsters().remove(monster);
        }
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
                    if (playerMonster == null) return;
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
        if(sc.nextInt() == 1){
            Init.listThread.get(choiceCancel).interrupt();
            Init.listThread.remove(choiceCancel);
            Init.listMonster.remove(choiceCancel);
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
        System.out.println("Combien d'invocation voulez-vous réaliser ? (-1. Retour)");
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
        if (rank == -1)return;
        int difficulty = questDifficulty();
        if (difficulty == -1)return;
        Quest quest = new Quest("Quête de rang " + rank, rank, difficulty);
        System.out.println("Départ pour la quête !\n");
        quest.setPlayerMonsters(chooseMonster());
        quest.goOnQuest();
        System.out.println("\n");
    }

    private static void upItem(){
        int item;
        String chaine = "Sélectionnez un objet à améliorer :";
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
            System.out.println(chaine);
            item = sc.nextInt();
            while (item >= items.size() || item < 0) {
                System.out.println(chaine);
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
