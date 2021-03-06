package tridentshort.tradeplus.tradeplus;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Blocks;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import tridentshort.tradeplus.village.PointOfInterestRegistry;
import tridentshort.tradeplus.village.PointOfInterestTypeCustom;
import tridentshort.tradeplus.village.VillagerProfessionRegistry;

public class ModVillagerProfessions
{
    //Profession type name variable
    public static VillagerProfession BeeKeeper;


    //Point of Interest for professions
    public static PointOfInterestType BeeKeeperPOI;


    public static void init()
    {
        //Register POI of profession
        BeeKeeperPOI = PointOfInterestRegistry.register(new PointOfInterestTypeCustom("beekeeper_poi", PointOfInterestTypeCustom.getAllStatesOf(Blocks.BEEHIVE),1,48));



        //Register Profession
        BeeKeeper = VillagerProfessionRegistry.register("beekeeper", BeeKeeperPOI, ImmutableSet.of(), ImmutableSet.of());
    }


}
