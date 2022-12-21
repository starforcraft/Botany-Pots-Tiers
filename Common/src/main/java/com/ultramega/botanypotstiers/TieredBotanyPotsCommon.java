package com.ultramega.botanypotstiers;

import net.darkhax.bookshelf.api.Services;

public class TieredBotanyPotsCommon {
    public final Content content;

    public TieredBotanyPotsCommon() {
        //TieredBotanyPotVariantGenerator.generate();
        this.content = new Content();
        Services.REGISTRIES.loadContent(content);
    }
}