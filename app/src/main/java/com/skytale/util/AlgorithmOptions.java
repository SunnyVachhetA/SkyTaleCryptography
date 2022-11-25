package com.skytale.util;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmOptions {
    private static List<String> algoOptions;
    public static List<String> getAlgorithmOptionsList(){
        if( algoOptions == null )
        {
            algoOptions = new ArrayList<>(2);
            algoOptions.add("AES");
            algoOptions.add("DES");
        }
        return algoOptions;
    }
}
