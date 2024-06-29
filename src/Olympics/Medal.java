package Olympics;



public class Medal {
    public enum MedalType { BRONZE, SILVER, GOLD }
    private MedalType type;
    private String tournament;
    private int year;

    public Medal(){
        type=MedalType.BRONZE;
        tournament="Olympics";
        year=2024;
    }
    public Medal(MedalType type, String tournament, int year) {
        this.type = type;
        this.tournament = tournament;
        this.year = year;
    }

    public MedalType getType() {
        return type;
    }

    public boolean setType(MedalType type) {
        this.type = type;
        return true;
    }

    public String getTournament() {
        return tournament;
    }

    public boolean setTournament(String tournament) {
        if (tournament != null) {
            this.tournament = tournament;
            return true;
        }
        return false;
    }

    public int getYear() {
        return year;
    }

    public boolean setYear(int year) {
        this.year = Math.max(0, year);
        return year > 0;
    }


    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Medal))
            return false;
        Medal medal = (Medal) obj;
        return type == medal.type && year == medal.year && tournament.equals(medal.tournament);
    }


    public String toString() {
        return "Type= " + type + "," +
                "Tournament= " + tournament + "," +
                "Year= " + year + "\n";
    }
}
