package blacksonata.game;

import java.awt.Image;

import blacksonata.view.ImageUtil;
import java.util.HashSet;
import java.util.Set;

public class Location {
    public static final String BISHOPSGATE = "Bishopsgate";
    public static final String BLACKFRIARS = "Blackfriars";
    public static final String CLERKENWELL = "Clerkenwell";
    public static final String LIBERTY_CLINK = "Liberty of the Clink";
    public static final String CORNHILL = "Cornhill";
    public static final String CRIPPLEGATE = "Cripplegate";
    public static final String EASTCHEAP = "Eastcheap";
    public static final String LONDON_BRIDGE = "London Bridge";
    public static final String SHOREDITCH = "Shoreditch";
    public static final String SOUTHWARK = "Southwark";
    public static final String ST_PAULS = "St Pauls";

    private String name;
    private Image cardFrontImage;
    private Image cardBackImage;
    private Set<LocationSymbol> symbols = new HashSet<>();

    public Location(String name, String cardFrontImageName, String cardBackImageName, LocationSymbol ... symbols){
        this.name = name;
        this.cardFrontImage = ImageUtil.get(cardFrontImageName);
        this.cardBackImage  = ImageUtil.get(cardBackImageName);
        for (LocationSymbol symbol: symbols){
            this.symbols.add(symbol);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getCardFrontImage() {
        return this.cardFrontImage;
    }

    public void setCardFrontImage(Image cardFrontImage) {
        this.cardFrontImage = cardFrontImage;
    }

    public Image getCardBackImage() {
        return this.cardBackImage;
    }

    public void setCardBackImage(Image cardBackImage) {
        this.cardBackImage = cardBackImage;
    }

    public Set<LocationSymbol> getSymbols() {
        return this.symbols;
    }

    public boolean hasSymbol(LocationSymbol symbol) {
        return this.symbols.contains(symbol);
    }
}
