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
        if (instance == null) {
            instance = new Box(value);
        }
        return instance;
    }

}
