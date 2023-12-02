package io.github.severnarch.primitive;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;
import java.util.Map;

public class PrimitiveItems {
    // Tier 1 Items (Prehistoric Items)
    public static final Item BARK = new Item(new FabricItemSettings().rarity(Rarity.COMMON));

    // Item Lists
    public static final List<Item> TIER_1_ITEMS = List.of(
            // Minecraft Items
            Items.STICK,
            // Primitive Items
            BARK
    );

    public static final Map<Item, String> PRIMITIVE_ITEMS = Map.of(
            BARK, "bark"
    );
    public static final Map<Item, Integer> PRIMITIVE_FUEL_ITEMS = Map.of(
            BARK, 100
    );

     // Item Groups
    public static final ItemGroup TIER_1_GROUP = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.primitive.tier1"))
            .icon(() -> new ItemStack(BARK))
            .entries((context, entries) -> {
                for (Item tier1Item : TIER_1_ITEMS) {
                    entries.add(tier1Item);
                }
            })
            .build();

    // Functions
    public static void registerAllItems() {
        for (int i = 0; i < PRIMITIVE_ITEMS.size(); i++) {
            Item item = PRIMITIVE_ITEMS.keySet().stream().toList().get(i);
            Registry.register(Registries.ITEM, new Identifier("primitive", PRIMITIVE_ITEMS.values().stream().toList().get(i)), item);
            if (PRIMITIVE_FUEL_ITEMS.keySet().stream().toList().contains(item)) {
                FuelRegistry.INSTANCE.add(item, PRIMITIVE_FUEL_ITEMS.get(item));
            }
        }
    }

    public static void registerAllItemGroups() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("primitive", "tier1"), TIER_1_GROUP);
    }

}
