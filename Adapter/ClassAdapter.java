/**
 * ClassAdapter
 *
 * 适配器角色：把要适配的接口转换成目标接口
 * 类适配器：实现目标接口，继承或实现待适配的类或接口
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void targetMethod() {
        this.adapteeMethod();
    }
}