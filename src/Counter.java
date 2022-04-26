/**
 * a counter class.
 */
public class Counter {
    private int counter;

    /**
     * counter constructor.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * increasing the counter.
     * @param number is the increasing number to the counter.
     */
    void increase(int number) {
        this.counter = this.counter + number;
    }

    /**
     * decreasing the counter.
     * @param number is the decreasing number to the counter.
     */
    void decrease(int number) {
        this.counter = this.counter - number;
    }

    /**
     * getting the counter value.
     * @return the size of the counter.
     */
    public int getValue() {
        return this.counter;
    }
}
