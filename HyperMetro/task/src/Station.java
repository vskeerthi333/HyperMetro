public class Station {

    private String name;
    private Station nextStation;

    private Station(String name, Station nextStation) {
        this.name = name;
        this.nextStation = nextStation;
    }

    public static Station from(String name, Station nextStation) {
        return new Station(name, nextStation);
    }

    public Station getNextStation() {
        return nextStation;
    }

    public void setNextStation(Station nextStation) {
        this.nextStation = nextStation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
