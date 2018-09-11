package at.happynev.rimio;

import generated.GameData;
import generated.MapDataType;
import generated.PawnDataType;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataController {
    private static final Map<Class, JAXBContext> jaxbContextCache = new HashMap<>();
    private static DataController instance;
    public final StringProperty currentGameData = new SimpleStringProperty();
    public final StringProperty worldSeed = new SimpleStringProperty();
    public final LongProperty tick = new SimpleLongProperty();
    public final ObservableList<PawnInstance> pawns = FXCollections.observableArrayList();
    public final ObservableList<MapInstance> maps = FXCollections.observableArrayList();

    private DataController() {
        currentGameData.addListener((observable, oldValue, newValue) -> repopulateGameData(newValue));
    }

    public static DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
        }
        return instance;
    }

    private void repopulateGameData(String xmlData) {
        long start = System.currentTimeMillis();
        GameData gameData = unmarshalXml(xmlData, GameData.class);
        assert gameData != null;
        if (!worldSeed.getValueSafe().isEmpty() && !gameData.getWorldSeed().equals(worldSeed.get())) {
            //other save?
            pawns.clear();
            maps.clear();
        }
        worldSeed.set(gameData.getWorldSeed());
        if (gameData.isIncludesMaps()) {
            Set<MapInstance> oldMaps = new HashSet<>(maps);
            for (MapDataType mapdata : gameData.getMaps().getMapData()) {
                MapInstance found = null;
                for (MapInstance mi : oldMaps) { //i know its stupid. i couldn't get observableMap to work properly, so now this is a list
                    if (mi.getId() == mapdata.getId()) {
                        found = mi;
                        break;
                    }
                }
                if (found != null) {
                    found.update(mapdata);
                    oldMaps.remove(found);
                } else {
                    maps.add(new MapInstance(mapdata));
                }
            }
            //delete any leftovers
            oldMaps.forEach(maps::remove);
        }

        if (gameData.isIncludesPawns()) {
            Set<PawnInstance> oldPawns = new HashSet<>(pawns);
            for (PawnDataType pawndata : gameData.getColonists().getPawnData()) {
                PawnInstance found = null;
                for (PawnInstance pi : oldPawns) { //i know its stupid. i couldn't get observableMap to work properly, so now this is a list
                    if (pi.getPawnId().equals(pawndata.getId())) {
                        found = pi;
                        break;
                    }
                }
                if (found != null) {
                    found.update(pawndata);
                    oldPawns.remove(found);
                } else {
                    pawns.add(new PawnInstance(pawndata));
                }
            }
            //delete any leftovers
            oldPawns.forEach(pawns::remove);
        }
        tick.setValue(gameData.getTick());//update last to indicate finish
        long end = System.currentTimeMillis();
        System.out.println("xml took " + (end - start) + "ms");
    }

    @SuppressWarnings("unchecked")
    private <T> T unmarshalXml(String xml, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = jaxbContextCache.get(clazz);
            if (jaxbContext == null) {
                jaxbContext = JAXBContext.newInstance(clazz);
                jaxbContextCache.put(clazz, jaxbContext);
            }
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (T) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
