package org.eu.zhuiyue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Genericity {

    /**
     * 泛型方法
     */
    private static <T extends Number> double add(T a, T b) { //<T> 声明持有泛型类型T，声明该方法为泛型方法
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    /**
     *泛型类
     */
    static class A <T> { // <T> T是type简写，可随意，声明该类持有泛型T的类型
        private T var; //var 类型有T指定，即外部指定；
        public T getVar() { //返回值有外部指定
            return var;
        }
        public void setVar(T var) { //参数类型有外部指定
            this.var = var;
        }
    }

    /**
     * 多元泛型
     */
    static class MyMap<K,V>{       // 此处指定了两个泛型类型
        private K key ;     // 此变量的类型由外部决定
        private V value ;   // 此变量的类型由外部决定
        public K getKey(){
            return this.key ;
        }
        public V getValue(){
            return this.value ;
        }
        public void setKey(K key){
            this.key = key ;
        }
        public void setValue(V value){
            this.value = value ;
        }
    }

    /**
     * 泛型接口
     */
    interface IMap<K,V>{
        public K getKey();
        public V getValue();
        public void setKey(K key);
        public void setValue(V value);
    }

    /**
     * 泛型接口实现类
     */
    static class MyMap2<K,V> implements IMap<K,V>{

        private K key ;
        private V value ;
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * 泛型方法
     * <T> 声明持有泛型类型T，声明该方法为泛型方法
     * Class<T> 声明泛型T的具体类型，泛型的传递，传递给了 Class<T> 类
     * c 泛型T代表的类的对象
     * T 泛型类型代表的类型 T
     */

    public static <T> T getObject(Class<T> c) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        T t = c.getDeclaredConstructor().newInstance();
        return t;
    }



    /**
     * 泛型类的上限
     */
    static class Info<T extends Number>{    // 此处泛型只能是Number的子类
        private T var ;
        public void setVar(T var){
            this.var = var ;
        }
        public T getVar(){
            return this.var ;
        }
        public String toString(){
            return this.var.toString() ;
        }
    }

    /**
     * 泛型类的下限 ,限制只能是Float或者其子类
     */
    static void fun(Info<? super Float> test){
        System.out.println(test.getVar() + ",,,");
    }





    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        add(1,2);
        add(1.0,2.0);

        List<String> list = new ArrayList<String>();
        //list.add(1);//泛型提供类型的约束，提供编译前的检查
        list.add("a");

        A<String> a = new A<String>();
        a.setVar("hello");
        // a.setVar(1);//泛型提供类型的约束，提供编译前的检查
        System.out.println(a.getVar());

        MyMap<String,Integer> map = new MyMap<String,Integer>();
        map.setKey("Jame");
        map.setValue(1);
        System.out.println(map.getKey()+" "+map.getValue());

        MyMap2<String,Integer> map2 = new MyMap2<String,Integer>();
        map2.setKey("Tom");
        map2.setValue(2);
        System.out.println(map2.getKey()+" "+map2.getValue());

        // Object o = getObject( Class.forName("java.util.ArrayList"));
        Object o = getObject(ArrayList.class);

        Info<Integer> integerInfo = new Info<Integer>();
        integerInfo.setVar(1);
        System.out.println(integerInfo.toString());

        //fun(integerInfo);
        Info<Float> floatInfo = new Info<Float>();
        floatInfo.setVar(1.0f);
        fun(floatInfo);


    }

}
