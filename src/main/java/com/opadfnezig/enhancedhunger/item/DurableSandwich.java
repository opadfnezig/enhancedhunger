package com.opadfnezig.enhancedhunger.item;

import com.opadfnezig.enhancedhunger.item.base.DurableFood;

public class DurableSandwich extends DurableFood {

    public DurableSandwich(Properties properties) {
        super(properties,(short)10);
        MAX_DURABILITY = 10;
    }
}
