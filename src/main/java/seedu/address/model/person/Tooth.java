package seedu.address.model.person;

/**
 * Represents a tooth of a Person.
 */
public class Tooth {
    private boolean isPresent;
    private boolean hasStatus;

    public Tooth() {
        this.hasStatus = false;
    }

    public Tooth(boolean hasStatus) {
        this.hasStatus = hasStatus;
    }

    public boolean isPresent() {
        return isPresent;
    }
}
