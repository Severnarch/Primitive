package io.github.severnarch.primitive;

import net.fabricmc.api.ModInitializer;

public class Primitive implements ModInitializer {
    @Override
    public void onInitialize() {
        PrimitiveItems.registerAllItems();
        PrimitiveItems.registerAllItemGroups();
    }

}
