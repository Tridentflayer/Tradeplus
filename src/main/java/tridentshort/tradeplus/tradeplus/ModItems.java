package tridentshort.tradeplus.tradeplus;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems
{

    public static Item testItem; //Item variable


    public static void init()
    {
        testItem = registerItem("test_item", new Item(new Item.Settings().group(ItemGroup.MISC))); //Copy this line and change testItem to the item variable name and name to item name
    }


    public static Item registerItem(String name, Item item) //No touch
    {
        return Registry.register(Registry.ITEM, new Identifier("tradeplus", name), item);
    }

}