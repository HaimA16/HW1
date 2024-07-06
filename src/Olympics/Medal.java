/**
 * Name: Haim Armias 315569061
 * Name: Yeuda Baza
 */
package Olympics;

/**
 * Represents a Medal awarded in a tournament.
 */
public class Medal {
    /**
     * Enum defining the types of medals.
     */
    public enum MedalType { BRONZE, SILVER, GOLD }

    private MedalType type;
    private String tournament;
    private int year;

    /**
     * Default constructor initializing the medal as bronze in the 2024 Olympics.
     */
    public Medal() {
        type = MedalType.BRONZE;
        tournament = "Olympics";
        year = 2024;
    }

    /**
     * Constructor initializing the medal with specific type, tournament, and year.
     *
     * @param type the type of the medal (BRONZE, SILVER, GOLD)
     * @param tournament the name of the tournament
     * @param year the year of the tournament
     */
    public Medal(MedalType type, String tournament, int year) {
        this.type = type;
        this.tournament = tournament;
        this.year = year;
    }

    /**
     * Checks if this medal is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the medals are equal (same type, tournament, and year), false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Medal))
            return false;
        Medal medal = (Medal) obj;
        return type == medal.type && year == medal.year && tournament.equals(medal.tournament);
    }

    /**
     * Returns a string representation of the medal.
     *
     * @return a string representing the type, tournament, and year of the medal
     */
    @Override
    public String toString() {
        return "Type= " + type + "," +
                "Tournament= " + tournament + "," +
                "Year= " + year + "\n";
    }
}
