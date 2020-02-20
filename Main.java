public class Main {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Box box = Box.getInstance("FOO");
            System.out.println(box.value.toString());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Box box = Box.getInstance("BAR");
            System.out.println(box.value.toString());
        }
    }
}
