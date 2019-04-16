/**
 * ManDecoratorA
 */
public class ManDecoratorA extends Decorator{
    
    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA Class");
    }

    public void reEat() {
        System.out.println("eat another one");
    }
}