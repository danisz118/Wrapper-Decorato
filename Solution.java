package com.javarush.task.task18.task1811;

/* 
Wrapper (Decorator)
Если мы хотим «обернуть» вызовы методов какого-то объекта своим кодом, то нам нужно:
1) Создать свой класс-обертку и унаследоваться от того же класса/интерфейса что и оборачиваемый объект.
2) Передать оборачиваемый объект в конструктор нашего класса.
3) Переопределить все методы в нашем новом классе, и вызвать в них методы оборачиваемого объекта.
4) Внести свои изменения «по вкусу»: менять результаты вызовов, параметры или делать что-то еще.
*/

public class Solution {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run()
        {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component)
        {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorRunnableImpl body ");
            component.run();
        }
    }

    public static class DecoratorMyRunnableImpl implements Runnable{

        private Runnable component;

        public DecoratorMyRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.print("DecoratorMyRunnableImpl body ");
            component.run();
        }
    }

}
