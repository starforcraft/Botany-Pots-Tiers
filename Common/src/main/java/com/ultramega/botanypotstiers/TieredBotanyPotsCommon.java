package com.ultramega.botanypotstiers;

import net.darkhax.bookshelf.api.Services;

public class TieredBotanyPotsCommon {
    public static Content content;

    public TieredBotanyPotsCommon() {
        //TieredBotanyPotVariantGenerator.generate();
        content = new Content();
        Services.REGISTRIES.loadContent(content);
    }
}