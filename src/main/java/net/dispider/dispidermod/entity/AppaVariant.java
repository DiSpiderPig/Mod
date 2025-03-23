package net.dispider.dispidermod.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum AppaVariant {
    BROWN(0),
    BLUE(1);

    private static final AppaVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(AppaVariant::getId)).toArray(AppaVariant[]::new);

    private final int id;

    AppaVariant(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static AppaVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }
}
