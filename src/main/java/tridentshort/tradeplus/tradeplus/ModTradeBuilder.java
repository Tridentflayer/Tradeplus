package tridentshort.tradeplus.tradeplus;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
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
                                new TradeOfferFactories.BuyForOneEmeraldFactory(Items.HONEYCOMB, 3, 12, 1), //Trades in each level. If there's more than 2 per level it will randomly choose two
                                new TradeOfferFactories.BuyForOneEmeraldFactory(Items.HONEY_BOTTLE, 4, 16, 2),
                        },
                2, new TradeOffers.Factory[]
                        {
                                new TradeOfferFactories.SellItemFactory2(Items.BEEHIVE, 10, 1, 12, 5),
                                new TradeOfferFactories.SellItemFactory2(Items.HONEY_BLOCK, 2, 1, 12, 2),
                                new TradeOfferFactories.SellItemFactory2(Items.HONEYCOMB_BLOCK, 2, 1, 12, 2),
                                new TradeOfferFactories.BuyForOneEmeraldFactory(Items.BEE_NEST, 1, 8, 10)

                        },
                3, new TradeOffers.Factory[]
                        {
                                new TradeOfferFactories.SellItemFactory2(Items.LILY_PAD, 1, 4, 12, 5),
                                new TradeOfferFactories.SellItemFactory2(Items.DANDELION, 1, 8, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.FERN, 1, 6, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.POPPY, 1, 8, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.AZURE_BLUET, 1, 8, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.OXEYE_DAISY, 1, 8, 12, 4),

                        },
                4, new TradeOffers.Factory[]
                        {
                                new TradeOfferFactories.SellItemFactory2(Items.RED_TULIP, 1, 6, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.ORANGE_TULIP, 1, 6, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.WHITE_TULIP, 1, 6, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.PINK_TULIP, 1, 6, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.ALLIUM, 1, 6, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.BLUE_ORCHID, 1, 6, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.LILY_OF_THE_VALLEY, 1, 4, 12, 4),
                                new TradeOfferFactories.SellItemFactory2(Items.SUNFLOWER, 1, 4, 12, 8),
                                new TradeOfferFactories.SellItemFactory2(Items.LILAC, 1, 4, 12, 8),
                                new TradeOfferFactories.SellItemFactory2(Items.ROSE_BUSH, 1, 4, 12, 8),
                                new TradeOfferFactories.SellItemFactory2(Items.PEONY, 1, 4, 12, 8),
                        },
                5, new TradeOffers.Factory[]
                        {
                                new TradeOfferFactories.SellItemFactory(Items.CAMPFIRE, 4, 8, 10),
                                new TradeOfferFactories.SellItemFactory2(Items.GLASS_BOTTLE, 1, 4, 16, 10)
                        }


                )));

    }


   //Don't touch
    private static Int2ObjectMap<TradeOffers.Factory[]> copyToFastUtilMap(ImmutableMap<Integer, TradeOffers.Factory[]> immutableMap_1) {
        return new Int2ObjectOpenHashMap<>(immutableMap_1);
    }
}
