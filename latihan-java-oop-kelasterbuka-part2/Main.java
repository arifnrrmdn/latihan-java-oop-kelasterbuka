package man2lebak.belajarjava.application;

//player
class Player{
    String name;
    double health;
    String school;
    //object member
    Weapon weapon;
    Armor armor;

    Player(String name, double health, String school){
        this.name = name;
        this.health = health;
        this.school = school;
    }

    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;
        System.out.println(this.name + " attacking " + opponent.name + " with power " + attackPower);
        opponent.defends(attackPower);
    }

    void defends(double attackPower){
        double damage;
        if(this.armor.defendsPower < attackPower){
            damage = attackPower - this.armor.defendsPower;
        } else {
            damage = 0;
        }

        this.health -= damage;
        System.out.println(this.name + " gets demage " + damage + "\n");
    }

    void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    void equipArmor(Armor armor){
        this.armor = armor;
    }

    //display
    void display(){
        System.out.println("Name: " + this.name + " from " + this.school);
        System.out.println("Health: " + this.health);
        weapon.display();
        armor.display();
        System.out.println("\n");
    }
    
}

//weapon
class Weapon{
    String name;
    double attackPower;
    Weapon(String name, double attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }
    void display(){
        System.out.println("Weapon: " + this.name + ", AttackPower: " + this.attackPower);
    }

}

//armor
class Armor{
    String name;
    double defendsPower;
    Armor(String name, double defendsPower){
        this.name = name;
        this.defendsPower = defendsPower;
    }
    void display(){
        System.out.println("Armor: " + this.name + ", DefendsPower: " + this.defendsPower);
    }
}


public class Main {
 
    public static void main(String[] args){

    //membuat object player
    Player player1 = new Player("Muhayar", 100, "MTX BAZRN 714");
    Player player2 = new Player("Obin", 85, "SMV SAK 703 ");

    //membuat object weapon
    Weapon celurit = new Weapon("Celurit", 25);

    //membuat object armor
    Armor bajuOlahraga = new Armor("Baju Olahraga", 0);
    Armor batikSekolah = new Armor("Batik Sekolah", 0);


    //equip weapon & armor
    player1.equipWeapon(celurit);
    player1.equipArmor(bajuOlahraga);
    player2.equipWeapon(celurit);
    player2.equipArmor(batikSekolah);

    //display
    player1.display();
    player2.display();
    
    System.out.println("PERTEMPURAN");
    System.out.println("Episode - 1\n");
    player1.attack(player2);
    player1.display();
    player2.display();
    System.out.println("Episode - 2");
    player2.attack(player1);
    player1.display();
    player2.display();
    

    }

}
