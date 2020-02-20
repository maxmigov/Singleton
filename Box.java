public class Box {

    private static volatile Box instance;

    protected Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    private Box(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box { " +
                "value = " + value +
                '}';
    }

    public static Box getInstance(Object value) {
        // Техника, которую мы здесь применяем называется «блокировка с двойной
        // проверкой» (Double-Checked Locking). Она применяется, чтобы
        // предотвратить создание нескольких объектов-одиночек, если метод будет
        // вызван из нескольких потоков одновременно.
        //
        // Хотя переменная `result` вполне оправданно кажется здесь лишней, она
        // помогает избежать подводных камней реализации DCL в Java.
        //
        // Больше об этой проблеме можно почитать здесь:
        // https://refactoring.guru/ru/java-dcl-issue
        Box result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Box.class) {
            if (instance == null) {
                instance = new Box(value);
            }
            return instance;
        }
    }
}
