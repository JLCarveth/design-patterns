package mvc;

/**
 * SquareModel holds the data needed by the view and controller 
 */
public class SquareModel {

    private long value;

    /**
     * Initialize the SquareModel with a value to store
     * @param value
     */
    public SquareModel(long value) {
	    this.value = value;
    }

    /**
     * @return the value held by SquareModel
     */
    public long getValue() {
	    return value;
    }

    /**
     * Assigns a new value to SquareModel
     * @param value the new value
     */
    public void setValue(long value) {
	    this.value = value;
    }

    /**
     * Squares value and stores the result
     */
    public void square() {
	    value = value * value;
    }
    
}
