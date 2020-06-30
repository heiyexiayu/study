package designmode.singleton;

/**
 * @Author WYMY
 * @Date 2019/5/13 18:53
 */
public class Singleton {
    // 在内部产生本类的实例化对象
    private static Singleton instance = new Singleton();
    // 通过静态方法返回instance对象
    public static Singleton getInstance() {
        return instance;
    }
    // 将构造方法封装为私有化
    private Singleton() {
    }

    public void print() {
        System.out.println("Hello World!!!");
    }

}
