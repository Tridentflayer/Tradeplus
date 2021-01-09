package tridentshort.tradeplus.village;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerType;
import net.minecraft.world.biome.Biome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

public interface VillagerTypeRegistry {
    HashMap<RegistryKey<Biome>, ArrayList<VillagerType>> customVillagerTypes = new HashMap<>();

    @SafeVarargs
    static VillagerType register(String id, RegistryKey<Biome>... biomes) {
        VillagerType villagerType = Registry.register(Registry.VILLAGER_TYPE, new Identifier("tradeplus", id), new VillagerType(id));
        for (RegistryKey<Biome> biome : biomes) {
            if (customVillagerTypes.containsKey(biome))
                customVillagerTypes.get(biome).add(villagerType);
            else {
                customVillagerTypes.put(biome, new ArrayList<>(Collections.singleton(villagerType)));
            }
            if(VillagerType.BIOME_TO_TYPE.containsKey(biome)) {
                VillagerType.BIOME_TO_TYPE.replace(biome, villagerType);
            }
        }
        return villagerType;
    }

    static VillagerType getVillagerTypeForBiome(RegistryKey<Biome> biome) {
        ArrayList<VillagerType> villagerTypes = customVillagerTypes.get(biome);
        if (customVillagerTypes.containsKey(biome)) {
            return villagerTypes.get(MathHelper.floor(villagerTypes.size() * Math.random()));
        } else {
            return VillagerType.forBiome(Optional.ofNullable(biome));
        }
    }
}