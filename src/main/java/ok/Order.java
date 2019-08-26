package ok;


@FunctionalInterface
interface Order {
    boolean authorize(int val);

    default boolean authorize(String value) {
        return true;
    }
}