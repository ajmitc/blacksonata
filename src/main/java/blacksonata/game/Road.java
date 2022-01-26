package blacksonata.game;

public class Road {
    private Location location1;
    private Location location2;
    
    public Road(Location location1, Location location2){
        this.location1 = location1;
        this.location2 = location2;
    }

    public Location getLocation1() {
        return this.location1;
    }

    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    public Location getLocation2() {
        return this.location2;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }
}
