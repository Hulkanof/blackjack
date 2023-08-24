package entities;

public class hand {
    private String[] cards;

    public hand(String[] cards) {
        this.cards = cards;
    }

    public String[] getCards() {
        return this.cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }
    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < this.cards.length; i++) {
            output += this.cards[i] + ",";
        }
        return output;
    }

    public int value() {
        int value = 0;
        for (int i = 0; i < this.cards.length; i++) {
            String card = this.cards[i];
            if (card.equals("A")) {
                value += 11;
            } else if (card.equals("K") || card.equals("Q") || card.equals("J")) {
                value += 10;
            } else {
                value += Integer.parseInt(card);
            }
        }
        return value;
    }
}
