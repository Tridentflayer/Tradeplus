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
                                new TradeOfferFactories.BuyForOneEmeraldFactory(Items.HONEYCOMB, 2, 12, 1), //Trades in each level. If there's more than 2 per level it will randomly choose two
                                new TradeOfferFactories.BuyForOneEmeraldFactory(Items.HONEY_BOTTLE, 4, 16, 2),
                        },
                2, new TradeOffers.Factory[]
                        {
                                new TradeOfferFactories.SellItemFactory(Blocks.BEEHIVE, 6, 12, 5),
                                new TradeOfferFactories.SellItemFactory(Blocks.HONEY_BLOCK, 2, 12, 2),
                                new TradeOfferFactories.SellItemFactory(Blocks.HONEYCOMB_BLOCK, 2, 12, 2),

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
