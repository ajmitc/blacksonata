package blacksonata.game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Location> locations = new ArrayList<>();
    private List<Road> roads = new ArrayList<>();

    public Board(){
        locations.add(new Location(Location.BISHOPSGATE, "location-bishopsgate-front.jpg", "location-bishopsgate-back.jpg", LocationSymbol.HOUSE, LocationSymbol.CHURCH));
        locations.add(new Location(Location.BLACKFRIARS, "location-blackfriars-front.jpg", "location-blackfriars-back.jpg", LocationSymbol.HOUSE, LocationSymbol.THEATER, LocationSymbol.FERRY));
        locations.add(new Location(Location.CLERKENWELL, "location-clerkenwell-front.jpg", "location-clerkenwell-back.jpg", LocationSymbol.PARK, LocationSymbol.CHURCH));
        locations.add(new Location(Location.LIBERTY_CLINK, "location-clink-front.jpg", "location-clink-back.jpg", LocationSymbol.HOUSE, LocationSymbol.THEATER, LocationSymbol.FERRY));
        locations.add(new Location(Location.CORNHILL, "location-cornhill-front.jpg", "location-cornhill-back.jpg", LocationSymbol.MONEY));
        locations.add(new Location(Location.CRIPPLEGATE, "location-cripplegate-front.jpg", "location-cripplegate-back.jpg", LocationSymbol.HOUSE));
        locations.add(new Location(Location.EASTCHEAP, "location-eastcheap-front.jpg", "location-eastcheap-back.jpg", LocationSymbol.PUB));
        locations.add(new Location(Location.LONDON_BRIDGE, "location-londonbridge-front.jpg", "location-londonbridge-back.jpg", LocationSymbol.MONEY, LocationSymbol.FERRY));
        locations.add(new Location(Location.SHOREDITCH, "location-shoreditch-front.jpg", "location-shoreditch-back.jpg", LocationSymbol.PARK, LocationSymbol.THEATER));
        locations.add(new Location(Location.SOUTHWARK, "location-southwark-front.jpg", "location-southwark-back.jpg", LocationSymbol.CHURCH, LocationSymbol.PUB));
        locations.add(new Location(Location.ST_PAULS, "location-stpauls-front.jpg", "location-stpauls-back.jpg", LocationSymbol.CHURCH));

        roads.add(new Road(getLocation(Location.CLERKENWELL), getLocation(Location.CRIPPLEGATE)));
        roads.add(new Road(getLocation(Location.CRIPPLEGATE), getLocation(Location.SHOREDITCH)));
        roads.add(new Road(getLocation(Location.BISHOPSGATE), getLocation(Location.SHOREDITCH)));
        roads.add(new Road(getLocation(Location.BISHOPSGATE), getLocation(Location.EASTCHEAP)));
        roads.add(new Road(getLocation(Location.EASTCHEAP), getLocation(Location.LONDON_BRIDGE)));
        roads.add(new Road(getLocation(Location.LONDON_BRIDGE), getLocation(Location.SOUTHWARK)));
        roads.add(new Road(getLocation(Location.SOUTHWARK), getLocation(Location.LIBERTY_CLINK)));
        roads.add(new Road(getLocation(Location.LIBERTY_CLINK), getLocation(Location.BLACKFRIARS)));
        roads.add(new Road(getLocation(Location.CLERKENWELL), getLocation(Location.BLACKFRIARS)));
        roads.add(new Road(getLocation(Location.CRIPPLEGATE), getLocation(Location.ST_PAULS)));
        roads.add(new Road(getLocation(Location.CRIPPLEGATE), getLocation(Location.CORNHILL)));
        roads.add(new Road(getLocation(Location.ST_PAULS), getLocation(Location.CORNHILL)));
        roads.add(new Road(getLocation(Location.CORNHILL), getLocation(Location.BISHOPSGATE)));
        roads.add(new Road(getLocation(Location.CORNHILL), getLocation(Location.EASTCHEAP)));
        roads.add(new Road(getLocation(Location.ST_PAULS), getLocation(Location.BLACKFRIARS)));
    }

    public Location getLocation(String name){
        for(Location loc: locations){
            if (loc.getName().equalsIgnoreCase(name))
                return loc;
        }
        return null;
    }

    public boolean isConnected(String location1, String location2){
        for (Road road: roads){
            if ((road.getLocation1().equals(location1) && road.getLocation2().equals(location2)) ||
                 ((road.getLocation1().equals(location2) && road.getLocation2().equals(location1))))
                return true;
        }
        return false;
    }
}
