package model.player;

public class Player {

    private final int ID;

    public Player(int id) {
        ID = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Player other = (Player) object;

        return ID == other.ID;
    }

    @Override
    public int hashCode() {
        return ID;
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }
}
