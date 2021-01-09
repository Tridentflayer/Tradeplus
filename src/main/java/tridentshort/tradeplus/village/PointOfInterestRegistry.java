package tridentshort.tradeplus.village;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.poi.PointOfInterestType;

public interface PointOfInterestRegistry {

    static PointOfInterestType register(PointOfInterestTypeCustom pointOfInterestTypeCustom) {
        if (!Registry.POINT_OF_INTEREST_TYPE.containsId(new Identifier(pointOfInterestTypeCustom.id)) &&
                !pointOfInterestTypeCustom.workStationStates.isEmpty())
            return Registry.register(Registry.POINT_OF_INTEREST_TYPE, new Identifier(pointOfInterestTypeCustom.id), pointOfInterestTypeCustom.register());
        else return PointOfInterestType.UNEMPLOYED;
    }

    static PointOfInterestType register(Identifier name, PointOfInterestType pointOfInterestType) {
        if (!Registry.POINT_OF_INTEREST_TYPE.containsId(name))
            return Registry.register(Registry.POINT_OF_INTEREST_TYPE, name, pointOfInterestType);
        else return Registry.POINT_OF_INTEREST_TYPE.get(name);
    }

}
