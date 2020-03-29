package designmode.adapter;

/**
 * @Author WYMY
 * @Date 2019/5/13 19:10
 */

interface Target {
   void simpleFunction();
}

class NBTarget{
    void nbFunciton(){
        System.out.println("nb========");
    }
}

class TargetImp implements Target{

    public void simpleFunction() {
        System.out.println("simple------");
    }
}

//适配器//类适配器demo
class Adapter extends NBTarget implements Target{

    public void simpleFunction() {
        this.nbFunciton();
    }
}

//对象适配器
class AdapterClass implements Target{
    private NBTarget nbTarget;
    public AdapterClass(NBTarget nbTarget){
        this.nbTarget=nbTarget;
    }
    public void simpleFunction() {
        nbTarget.nbFunciton();
    }
}

public class AdapterDemo {
    public static void main(String args[]) {
        Target target=new AdapterClass(new NBTarget());
        target.simpleFunction();


        Target target1=new TargetImp();
        target1.simpleFunction();
    }
}