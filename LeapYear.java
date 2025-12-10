package exercisetwo;


/**
 * The LeapYear program implements an application that returns True
 * if the year is a leap year and false if it isn't.
 *
 * @author KDLPro
 * @version 1.0
 */
public class LeapYear {
    /** The field values.
     * year: contains the year to be evaluated
     */
    private int year;


    /** The LeapYear constructor.
     * @param inputYear   contains the year to be evaluated
     */
    public LeapYear(final int inputYear) {
        this.year = inputYear;
    }

    /** Checks if the year field is a leap year.
     * @return true if the year is a leap year.
     */
    public final boolean isLeapYear() {
        final int fourHundred = 400;
        final int hundred = 100;
        final int four = 4;

        if (this.year % fourHundred == 0) {
            return true;
        } else if (this.year % hundred == 0){
            return false;
        } else if (this.year % four == 0) {
            return true;
        }
        return false;
    }

    /** Getter functions.
     * @return the value of the year field.
     */
    public final int getYear() {
        return year;
    }

    /** The main function.
     * @param args
     */
    public static void main(final String[] args) {
        final int year1 = 2001;
        final int year2 = 1900;
        final int year3 = 2016;
        final int year4 = 2017;

        LeapYear newMillenium = new LeapYear(year1);
        System.out.println(newMillenium.isLeapYear());

        LeapYear nineteenHundred = new LeapYear(year2);
        System.out.println(nineteenHundred.isLeapYear());

        LeapYear twentySixteen = new LeapYear(year3);
        System.out.println(twentySixteen.isLeapYear());

        LeapYear twentySeventeen = new LeapYear(year4);
        System.out.println(twentySeventeen.isLeapYear());
    }

}
