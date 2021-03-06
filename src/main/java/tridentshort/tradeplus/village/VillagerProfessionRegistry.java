package tridentshort.tradeplus.village;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import tridentshort.tradeplus.tradeplus.TradePlus;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface VillagerProfessionRegistry {

    static VillagerProfession register(String name, PointOfInterestType workStation, ImmutableSet<Item> gatherableItems, ImmutableSet<Block> secondaryJobSites) {
        return register(new Identifier("tradeplus", name).toString(), workStation, gatherableItems, secondaryJobSites, null);
    }

    static VillagerProfession register(Identifier name, PointOfInterestType workStation, ImmutableSet<Item> gatherableItems, ImmutableSet<Block> secondaryJobSites) {
        return register(name.toString(), workStation, gatherableItems, secondaryJobSites, null);
    }

    static VillagerProfession register(String name, PointOfInterestType workStation, ImmutableSet<Item> gatherableItems, ImmutableSet<Block> secondaryJobSites, SoundEvent workSound) {
        VillagerProfession profession = null;
        try {
            Constructor<VillagerProfession> professionConstructor = VillagerProfession.class.getDeclaredConstructor(String.class, PointOfInterestType.class, ImmutableSet.class, ImmutableSet.class, SoundEvent.class);
            professionConstructor.setAccessible(true);
            profession = professionConstructor.newInstance(name, workStation, gatherableItems, secondaryJobSites, workSound);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return Registry.register(Registry.VILLAGER_PROFESSION, name, profession);
    }

}