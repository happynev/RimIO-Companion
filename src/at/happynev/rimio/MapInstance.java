package at.happynev.rimio;

import generated.MapDataType;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class MapInstance {
    public final FloatProperty wealthFloors = new SimpleFloatProperty();
    public final FloatProperty wealthBuildings = new SimpleFloatProperty();
    public final FloatProperty wealthItems = new SimpleFloatProperty();
    public final FloatProperty wealthPawns = new SimpleFloatProperty();
    public final FloatProperty wealthTotal = new SimpleFloatProperty();
    private final long id;
    private final boolean colony;
    private final int sizeX;
    private final int sizeY;

    public MapInstance(MapDataType mapdata) {
        System.out.println("created new map: " + mapdata.getId());
        id = mapdata.getId();
        colony = mapdata.isColony();
        sizeX = mapdata.getSizeX();
        sizeY = mapdata.getSizeY();
        update(mapdata);
    }

    public long getId() {
        return id;
    }

    public boolean isColony() {
        return colony;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapInstance that = (MapInstance) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public void update(MapDataType mapdata) {
        wealthFloors.setValue(mapdata.getWealthFloors());
        wealthBuildings.setValue(mapdata.getWealthBuildings());
        wealthItems.setValue(mapdata.getWealthItems());
        wealthPawns.setValue(mapdata.getWealthPawns());
        wealthTotal.setValue(mapdata.getWealthTotal());
    }
}
