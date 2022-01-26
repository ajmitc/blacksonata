package blacksonata.game;
import java.util.ArrayList;
import java.util.List;

public class StealthDeck extends Deck<Card>{
    public StealthDeck(){

    }

    public void load(char startingLetter, int index, int countdownValue){
        List<StealthCard> scards = getAllCards();

        clear();
        for (int i = 0; i < 26; ++i){
            char letter = (char) (startingLetter + i);
            StealthCard card = find("" + letter, index, scards);
            if (card == null){
                System.err.println("Unable to find Stealth Card with code '" + letter + "' at index " + index);
                System.exit(1);
            }
            add(card);
        }

        // TODO Cut deck at random card

        CountdownCard countdownCard = new CountdownCard();
        countdownCard.setRound(countdownValue);
        add(countdownCard);
    }

    private List<StealthCard> getAllCards(){
        List<StealthCard> scards = new ArrayList<>();
        scards.add(new StealthCard(new String[]{"A", "G", "Q", "F", "A", "D", "-", "Y"}, "stealth-A-front.jpg", "stealth-A-back.jpg", Location.EASTCHEAP));
        scards.add(new StealthCard(new String[]{"B", "H", "D", "A", "F", "Y", "H", "T"}, "stealth-B-front.jpg", "stealth-B-back.jpg", Location.BISHOPSGATE));
        scards.add(new StealthCard(new String[]{"C", "E", "C", "Y", "E", "R", "Q", "A"}, "stealth-C-front.jpg", "stealth-C-back.jpg", Location.CORNHILL));
        scards.add(new StealthCard(new String[]{"D", "Q", "-", "X", "N", "K", "W", "E"}, "stealth-D-front.jpg", "stealth-D-back.jpg", Location.ST_PAULS));
        scards.add(new StealthCard(new String[]{"E", "P", "U", "S", "J", "P", "X", "O"}, "stealth-E-front.jpg", "stealth-E-back.jpg", Location.BLACKFRIARS));
        scards.add(new StealthCard(new String[]{"F", "O", "V", "P", "K", "I", "Y", "G"}, "stealth-F-front.jpg", "stealth-F-back.jpg", Location.CLERKENWELL));
        scards.add(new StealthCard(new String[]{"G", "V", "A", "W", "M", "H", "Z", "K"}, "stealth-G-front.jpg", "stealth-G-back.jpg", Location.BLACKFRIARS));
        scards.add(new StealthCard(new String[]{"H", "-", "N", "T", "X", "G", "D", "-"}, "stealth-H-front.jpg", "stealth-H-back.jpg", Location.LIBERTY_CLINK));
        scards.add(new StealthCard(new String[]{"I", "-", "O", "H", "W", "-", "-", "-"}, "stealth-I-front.jpg", "stealth-I-back.jpg", Location.SOUTHWARK));
        scards.add(new StealthCard(new String[]{"J", "-", "R", "G", "Z", "-", "-", "-"}, "stealth-J-front.jpg", "stealth-J-back.jpg", Location.LONDON_BRIDGE));
        scards.add(new StealthCard(new String[]{"K", "B", "I", "Z", "C", "S", "G", "S"}, "stealth-K-front.jpg", "stealth-K-back.jpg", Location.EASTCHEAP));
        scards.add(new StealthCard(new String[]{"L", "F", "H", "M", "D", "A", "K", "V"}, "stealth-L-front.jpg", "stealth-L-back.jpg", Location.BISHOPSGATE));
        scards.add(new StealthCard(new String[]{"M", "R", "-", "-", "T", "C", "P", "C"}, "stealth-M-front.jpg", "stealth-M-back.jpg", Location.CORNHILL));
        scards.add(new StealthCard(new String[]{"N", "J", "F", "C", "Q", "W", "N", "F"}, "stealth-N-front.jpg", "stealth-N-back.jpg", Location.CRIPPLEGATE));
        scards.add(new StealthCard(new String[]{"O", "-", "G", "-", "-", "V", "M", "-"}, "stealth-O-front.jpg", "stealth-O-back.jpg", Location.SHOREDITCH));
        scards.add(new StealthCard(new String[]{"P", "N", "W", "Q", "S", "L", "T", "D"}, "stealth-P-front.jpg", "stealth-P-back.jpg", Location.CRIPPLEGATE));
        scards.add(new StealthCard(new String[]{"Q", "M", "Z", "-", "L", "M", "U", "H"}, "stealth-Q-front.jpg", "stealth-Q-back.jpg", Location.CLERKENWELL));
        scards.add(new StealthCard(new String[]{"R", "T", "M", "U", "O", "N", "V", "M"}, "stealth-R-front.jpg", "stealth-R-back.jpg", Location.BLACKFRIARS));
        scards.add(new StealthCard(new String[]{"S", "W", "T", "V", "-", "-", "A", "L"}, "stealth-S-front.jpg", "stealth-S-back.jpg", Location.LIBERTY_CLINK));
        scards.add(new StealthCard(new String[]{"T", "X", "S", "-", "-", "F", "B", "Q"}, "stealth-T-front.jpg", "stealth-T-back.jpg", Location.SOUTHWARK));
        scards.add(new StealthCard(new String[]{"U", "-", "L", "I", "-", "-", "C", "P"}, "stealth-U-front.jpg", "stealth-U-back.jpg", Location.LIBERTY_CLINK));
        scards.add(new StealthCard(new String[]{"V", "Z", "K", "J", "Y", "-", "E", "-"}, "stealth-V-front.jpg", "stealth-V-back.jpg", Location.SOUTHWARK));
        scards.add(new StealthCard(new String[]{"W", "Y", "J", "K", "-", "E", "F", "X"}, "stealth-W-front.jpg", "stealth-W-back.jpg", Location.LONDON_BRIDGE));
        scards.add(new StealthCard(new String[]{"X", "D", "-", "L", "U", "Z", "J", "W"}, "stealth-X-front.jpg", "stealth-X-back.jpg", Location.EASTCHEAP));
        scards.add(new StealthCard(new String[]{"Y", "C", "-", "-", "B", "T", "L", "B"}, "stealth-Y-front.jpg", "stealth-Y-back.jpg", Location.BISHOPSGATE));
        scards.add(new StealthCard(new String[]{"Z", "I", "E", "E", "G", "B", "I", "Z"}, "stealth-Z-front.jpg", "stealth-Z-back.jpg", Location.CORNHILL));
        scards.add(new StealthCard(new String[]{"-", "A", "P", "-", "V", "-", "-", "R"}, "stealth--A-front.jpg", "stealth--A-back.jpg", Location.LONDON_BRIDGE));
        scards.add(new StealthCard(new String[]{"-", "K", "-", "N", "R", "X", "-", "-"}, "stealth--K-front.jpg", "stealth--K-back.jpg", Location.SHOREDITCH));
        scards.add(new StealthCard(new String[]{"-", "L", "Y", "O", "H", "J", "R", "I"}, "stealth--L-front.jpg", "stealth--L-back.jpg", Location.CRIPPLEGATE));
        scards.add(new StealthCard(new String[]{"-", "S", "B", "D", "P", "Q", "O", "J"}, "stealth--S-front.jpg", "stealth--S-back.jpg", Location.ST_PAULS));
        scards.add(new StealthCard(new String[]{"-", "U", "-", "R", "I", "O", "-", "N"}, "stealth--U-front.jpg", "stealth--U-back.jpg", Location.CLERKENWELL));
        scards.add(new StealthCard(new String[]{"-", "-", "X", "B", "-", "U", "S", "U"}, "stealth---X-front.jpg", "stealth---X-back.jpg", Location.SHOREDITCH));
        return scards;
    }

    private static StealthCard find(String code, int index, List<StealthCard> allcards){
        for (StealthCard c: allcards){
            if (c.getCode(index).equals(code))
                return c;
        }
        return null;
    }
}
