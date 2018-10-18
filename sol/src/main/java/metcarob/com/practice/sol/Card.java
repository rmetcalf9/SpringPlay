package metcarob.com.practice.sol;

public class Card implements Comparable<Card>{

    public static enum SUITE {
        HEARTS("H"),DIAMONDS("D"),CLUBS("C"),SPADES("S"),SPECIAL("_");

        String let = "";
        SUITE(String let) {
            this.let = let;
        }
        public String getLet() {
            return let;
        }

        public static SUITE[] normalValues() {
            SUITE[] normalValues = {HEARTS,DIAMONDS,CLUBS,SPADES};
            return normalValues;
        }
    };
    public static enum CARDVALUE {
        ACE("A",1),
        TWO("2",2),THREE("3",3),FOUR("4",4),FIVE("5",5),SIX("6",6),
        SEVEN("7",7),
        EIGHT("8",8),
        NINE("9",9),
        TEN("10",10),
        JACK("J",11),
        QUEEN("Q",12),
        KING("K",13),
        JOKER("J",99);

        private String let = "";
        private int value = 0;
        CARDVALUE(String let, int value) {
            this.let = let;
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }

        public String getLet() {
            return let;
        }

        public static CARDVALUE[] normalValues() {
            CARDVALUE[] v = {ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING};
            return v;
        }
    }

    public static Card constructJokerCard() {
        return new Card(SUITE.SPECIAL, CARDVALUE.JOKER);
    }

    public static CARDVALUE getCARDVALUEFromVal(int val) {
        for (CARDVALUE v : CARDVALUE.values()) {
            if (v.value==val) return v;
        }
        return null;
    }

    private CARDVALUE value = null;
    private SUITE suite = null;

    public CARDVALUE getValue() {
        return value;
    }

    public SUITE getSuite() {
        return suite;
    }

    public Card(SUITE suite, int value) throws Exception {
        this.value = this.getCARDVALUEFromVal(value);
        this.suite = suite;
        if (this.value==null) throw new Exception("Invalid card value");
    }
    public Card(SUITE suite, CARDVALUE value) {
        this.value = value;
        this.suite = suite;
    }

    public String toString() {
        return String.format("%d of %s",value, suite.name());
    }
    public String boardString() {
        return String.format("%s%s             ", suite.getLet(), value.getLet()).substring(0,5);
    }

    @Override
    public int compareTo(Card o) {
        if (o.getValue()==this.value) {
            if (o.getSuite()==this.suite) {
                return 0;
            }
        }

        int suiteComp = o.getSuite().compareTo(this.suite);
        if (suiteComp != 0) return suiteComp;

        Integer I = new Integer(o.value.getValue());
        return I.compareTo(this.value.getValue());
    }


}
