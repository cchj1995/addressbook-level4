package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESC;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.description.Description;
import seedu.address.model.patient.Patient;
import seedu.address.model.record.Record;
import seedu.address.ui.MainWindow;

/**
 * Adds a patient to the address book.
 */
public class RecordAddCommand extends Command {

    public static final String COMMAND_WORD = "recordadd";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a new dental record to a patient. "
            + "Parameters: "
            + PREFIX_DESC + "Description \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DESC + "Patient went through all four wisdom tooth extraction today ";

    public static final String MESSAGE_SUCCESS = "New record added to %1$s";

    public static final String MESSAGE_ERROR = "Please specify the patient using the goto command first";

    private final Patient toAdd;
    private final Description description;

    /**
     * Creates an RecordAddCommand to add a new dental record to a specified {@code Patient}
     * @param description the description of the record to be added.
     */
    public RecordAddCommand(Description description) {
        requireNonNull(description);
        toAdd = MainWindow.getRecordPatient();
        this.description = description;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        if (MainWindow.isGoToMode() && toAdd != null) {
            requireNonNull(model);

            Record record = new Record(description);
            model.addRecord(record);

            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd.getName()));
        } else {
            throw new CommandException(MESSAGE_ERROR);
        }
    }

    /**
     * Checks if both commands are equal.
     * True only if both are the same instance.
     * Duplicate description and patient is okay.
     * @param other the other command to check if equals.
     * @return true if equals, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this;
    }
}