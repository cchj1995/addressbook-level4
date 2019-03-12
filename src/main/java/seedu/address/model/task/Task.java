package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.datetime.DateCustom;


/**
 * Represents a Task in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    protected final Title title;

    // Data fields
    protected final DateCustom startDate;
    protected final DateCustom endDate;


    /**
     * Every field must be present and not null.
     */
    public Task(Title title, DateCustom startDate, DateCustom endDate) {
        requireAllNonNull(title,startDate,endDate);
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public Title getTitle() {
        return title;
    }

    public DateCustom getStartDate() {
        return startDate;
    }

    public DateCustom getEndDate() {
        return endDate;
    }

    /**
     * Returns true if both tasks have the exact same title and data fields (subject to change)
     * This defines a weaker notion of equality between two tasks.
     */
    public boolean isSameTask(Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getTitle().equals(getTitle())
                && otherTask.getStartDate().equals(getStartDate())
                && otherTask.getEndDate().equals(getEndDate());
    }

    /**
     * Returns true if both tasks have the exact same title and data fields.
     * This defines a stronger notion of equality between two tasks.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return otherTask.getTitle().equals(getTitle())
                && otherTask.getStartDate().equals(getStartDate())
                && otherTask.getEndDate().equals(getEndDate());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title,startDate,endDate);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTitle())
                .append(" Title: ")
                .append(getStartDate())
                .append(" Start Date: ")
                .append(getEndDate())
                .append(" End Date: ");
        return builder.toString();
    }

}