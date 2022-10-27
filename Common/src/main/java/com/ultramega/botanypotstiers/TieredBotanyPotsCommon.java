package com.ultramega.botanypotstiers;

import com.ultramega.botanypotstiers.block.TieredBotanyPotVariantGenerator;
import com.ultramega.botanypotstiers.data.displaystate.DisplayState;
import net.darkhax.bookshelf.api.Services;

public class TieredBotanyPotsCommon {
    public final Content content;

    public TieredBotanyPotsCommon() {
        //TieredBotanyPotVariantGenerator.generate();
        DisplayState.init();
        this.content = new Content();
        Services.REGISTRIES.loadContent(content);
    }
}