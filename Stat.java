package sample;

 final class Stat {


    private final int rank, level, xp;


    public Stat(final int rank, final int level, final int xp) {

        this.rank = rank;

        this.level = level;

        this.xp = xp;

    }


    public final int getRank() { return rank; }


    public final int getLevel() { return level; }


    public final int getXp() { return xp; }


    @Override

    public final String toString() {

        return String.format("Rank: %d, Level: %d, XP: %d", rank, level, xp);

    }

}