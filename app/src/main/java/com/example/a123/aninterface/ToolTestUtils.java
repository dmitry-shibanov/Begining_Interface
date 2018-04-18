package com.example.a123.aninterface;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class ToolTestUtils {

    private static final String[] BRANDS = {"Бренд1", "Бренд2", "Бренд3", "Бренд4", "Бренд5", "Бренд6"};

    private static final String[] DETAILS_CLAMP_TYPE = {
            "Тип 1", "Тип 2", "Тип 3", "Тип 4", "Тип 5",
    };

    private static final String[] DETAILS_INCHES = {
            "2\"", "5\"", "12\"", "18\"", "24\"", "36\"", "48\"",
    };

    private static final String[] DETAILS_BLADE_SIZE = {
            "7.25\" Blade", "10\" Blade", "12\" Blade"
    };

    private static final String[] PRICE_LOW = {
            "$2", "$5", "$12", "$15", "$20", "$22", "$25",
    };

    private static final String[] PRICE_MEDIUM = {
            "$75", "$100", "$120", "$150", "$160", "$200", "$225",
    };

    private static final String[] PRICE_HIGH = {
            "$375", "$400", "$420", "$450", "$535", "$570", "$625",
    };


    private final Random mRandom;

    public ToolTestUtils() {
        this(0);
    }

    public ToolTestUtils(long seed) {
        mRandom = new Random(seed);
    }

    public Tool getNewTool(ToolType toolType, ToolPagerAdapter.Tab tab) {
        final String brand = getRandom(BRANDS);
        String name = brand + " ";
        String price = null;
        final String[] details = new String[3];

        if (price == null) {
            if (tab == ToolPagerAdapter.Tab.STATIONARY) {
                price = getRandom(PRICE_HIGH);
            } else {
                price = getRandom(PRICE_MEDIUM);
            }
        }

        String description = "The latest and greatest from " + brand + " takes " + toolType.name().toLowerCase(Locale.getDefault()) + " to a whole new level. Tenderloin corned beef tail, tongue landjaeger boudin kevin ham pig pork loin short loin shoulder prosciutto ground round. Alcatra salami sausage short ribs t-bone, tongue spare ribs kevin meatball tenderloin. Prosciutto tail meatloaf, chuck pancetta kielbasa leberkas tenderloin drumstick meatball alcatra cow sausage corned beef pork belly. Shoulder swine hamburger tail ham hock bacon pork belly leberkas beef ribs jowl spare ribs.";

        return new Tool(name, price, details, description);
    };

    public ArrayList<Tool> getNewTools(ToolType toolType, ToolPagerAdapter.Tab tab, int count) {
        final ArrayList<Tool> results = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            results.add(getNewTool(toolType, tab));
        }
        return results;
    };

    private String getRandom(String[] strings) {
        return strings[mRandom.nextInt(strings.length)];
    }

}