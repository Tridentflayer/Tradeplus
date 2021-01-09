package tridentshort.tradeplus.tradeplus;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;
import tridentshort.tradeplus.village.TradeOfferFactories;

public class ModTradeBuilder
{
    public static void addTrades()
    {
        //Setting up trade offers for villager types
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(ModVillagerProfessions.BeeKeeper, copyToFastUtilMap(ImmutableMap.of(
                1, new TradeOffers.Factory[] //Number (in this case, 1) represents villager levels from lowest to highest.
                        {
                                new TradeOfferFactories.BuyForOneEmeraldFactory(Items.HONEYCOMB, 1, 10, 10),
                                new TradeOfferFactories.BuyForOneEmeraldFactory(Blocks.BEE_NEST, 4, 4, 10)    //Trades in each level
                        },
                2, new TradeOffers.Factory[]
                        {

                        },
                3, new TradeOffers.Factory[]
                        {

                        }


                )));

    }


   //Don't touch
    private static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> immutableMap_1) {
        return new Int2ObjectOpenHashMap<>(immutableMap_1);
    }
}
