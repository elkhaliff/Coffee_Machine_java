package machine;

/**
 *  класс ингредиентов
 *  @author Andrey Zotov aka OldFox
 */
public final class Ingredients {
    int water;
    int milk;
    int coffee;
    int dispcup;
    int money;

    public Ingredients(int water, int milk, int coffee, int dispcup, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.dispcup = dispcup;
        this.money = money;
    }

    // minus (add money)
    public void minus (Ingredients ing) {
        water -= ing.water;
        milk -= ing.milk;
        coffee -= ing.coffee;
        dispcup -= ing.dispcup;
        money += ing.money;
    }
    // plus (add money)
    public void plus (Ingredients ing) {
        water += ing.water;
        milk += ing.milk;
        coffee += ing.coffee;
        dispcup += ing.dispcup;
        money += ing.money;
    }

    public int compareTo(Ingredients ing) {
        if (water < ing.water) return -1;
        else if (milk < ing.milk) return -2;
        else if (coffee < ing.coffee) return -3;
        else if (dispcup < ing.dispcup) return -4;
        else return 1;
    }

    @Override
    public String toString() {
        return water + " ml of water\n"+
                milk + " ml of milk\n"+
                coffee + " g of coffee beans\n"+
                dispcup + " disposable cups\n"+
                "$" + money + " of money\n";
    }
}
