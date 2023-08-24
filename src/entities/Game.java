package entities;

public class Game {

    private int count;

    private int count_cards;

    private int true_count;

    private Hand player_hand;

    private Hand dealer_hand;

    public Game() {
        this.count = 0;
        this.count_cards = 0;
        this.true_count = 0;
        this.player_hand = new Hand(new String[] {});
        this.dealer_hand = new Hand(new String[] {});
    }

    public Game(int count, int count_cards, int true_count, Hand player_hand, Hand dealer_hand) {
        this.count = count;
        this.count_cards = count_cards;
        this.true_count = true_count;
        this.player_hand = player_hand;
        this.dealer_hand = dealer_hand;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_cards() {
        return this.count_cards;
    }

    public void setCount_cards(int count_cards) {
        this.count_cards = count_cards;
    }

    public int getTrue_count() {
        return this.true_count;
    }

    public void setTrue_count(int true_count) {
        this.true_count = true_count;
    }

    public Hand getPlayer_hand() {
        return this.player_hand;
    }

    public void setPlayer_hand(Hand player_hand) {
        this.player_hand = player_hand;
    }

    public Hand getDealer_hand() {
        return this.dealer_hand;
    }

    public void setDealer_hand(Hand dealer_hand) {
        this.dealer_hand = dealer_hand;
    }
    public String strategy(){
        if (this.player_hand.getCards().length < 3) {
            switch (this.player_hand.toString()) {
                case "A,A", "8,8" -> {
                    return "split";
                }
                case "K,K", "Q,Q", "J,J", "10,10" -> {
                    if ((this.dealer_hand.value() == 5) || (this.dealer_hand.value() == 4) && this.getTrue_count() >= 5) {
                        return "split";
                    } else if (this.dealer_hand.value() == 6 && this.getTrue_count() >= 4) {
                        return "split";
                    } else {
                        return "stand";
                    }
                }
                case "9,9" -> {
                    if (this.dealer_hand.value() == 7 && this.dealer_hand.value() > 9) {
                        return "stand";
                    } else {
                        return "split";
                    }
                }
                case "7,7" -> {
                    if (this.dealer_hand.value() > 7) {
                        return "hit";
                    } else {
                        return "split";
                    }
                }
                case "6,6" -> {
                    if (this.dealer_hand.value() > 6) {
                        return "hit";
                    } else {
                        return "split";
                    }
                }
                case "3,3", "2,2" -> {
                    if (this.dealer_hand.value() > 7 || this.dealer_hand.value() < 4) {
                        return "hit";
                    } else {
                        return "split";
                    }
                }
                case "A,9" -> {
                    return "stand";
                }
                case "A,8" -> {
                    if ((this.dealer_hand.value() == 4 && this.getTrue_count() >= 3) || (this.dealer_hand.value() == 5 && this.getTrue_count() >= 1) || (this.dealer_hand.value() == 6 && this.getTrue_count() >= 1)) {
                        return "double";
                    } else {
                        return "stand";
                    }
                }
                case "A,7" -> {
                    if (this.dealer_hand.value() > 8) {
                        return "hit";
                    } else if (this.dealer_hand.value() > 6) {
                        return "stand";
                    } else {
                        return "double";
                    }
                }
                case "A,6" -> {
                    if (this.dealer_hand.value() > 6 || this.dealer_hand.value() < 3) {
                        return "hit";
                    } else if (this.dealer_hand.value() == 2 && this.getTrue_count() >= 1) {
                        return "double";
                    } else {
                        return "double";
                    }
                }
                case "A,5", "A,4" -> {
                    if (this.dealer_hand.value() > 6 || this.dealer_hand.value() < 4) {
                        return "hit";
                    } else {
                        return "double";
                    }
                }
                case "A,3", "A,2" -> {
                    if (this.dealer_hand.value() > 6 || this.dealer_hand.value() < 5) {
                        return "hit";
                    } else {
                        return "double";
                    }
                }
            }
        }
        switch (this.player_hand.value()) {
            case 17 -> {
                return "stand";
            }
            case 16 -> {
                if (this.dealer_hand.value() > 6) {
                    return "hit";
                } else if (this.dealer_hand.value() == 9 && this.getTrue_count() >= 4) {
                    return "stand";
                } else if (this.dealer_hand.value() == 10 && this.getTrue_count() >= 0) {
                    return "stand";
                } else {
                    return "stand";
                }
            }
            case 15 -> {
                if (this.dealer_hand.value() > 6) {
                    return "hit";
                } else if (this.dealer_hand.value() == 10 && this.getTrue_count() >= 4) {
                    return "stand";
                } else {
                    return "stand";
                }
            }
            case 14 -> {
                if (this.dealer_hand.value() > 6) {
                    return "hit";
                } else {
                    return "stand";
                }
            }
            case 13 -> {
                if (this.dealer_hand.value() > 6) {
                    return "hit";
                } else if (this.dealer_hand.value() == 2 && this.getTrue_count() <= -1) {
                    return "hit";
                } else {
                    return "stand";
                }
            }
            case 12 -> {
                if (this.dealer_hand.value() > 6 || this.dealer_hand.value() < 4) {
                    return "hit";
                } else if (this.dealer_hand.value() == 4 && this.getTrue_count() <= 0) {
                    return "hit";
                } else if ((this.dealer_hand.value() == 2 && this.getTrue_count() >= 3) || (this.dealer_hand.value() == 3 && this.getTrue_count() >= 2)) {
                    return "stand";
                } else {
                    return "stand";
                }
            }
            case 11 -> {
                if (this.dealer_hand.value() == 11) {
                    return "hit";
                } else if (this.dealer_hand.value() == 11 && this.getTrue_count() >= 1) {
                    return "double";
                } else {
                    return "double";
                }
            }
            case 10 -> {
                if (this.dealer_hand.value() > 9) {
                    return "hit";
                } else if (this.dealer_hand.value() > 9 && this.getTrue_count() >= 4) {
                    return "double";
                } else {
                    return "double";
                }
            }
            case 9 -> {
                if (this.dealer_hand.value() > 6 || this.dealer_hand.value() < 3) {
                    return "hit";
                } else if ((this.dealer_hand.value() == 7 && this.getTrue_count() >= 3) && (this.dealer_hand.value() == 2 && this.getTrue_count() >= 1)) {
                    return "double";
                } else {
                    return "double";
                }
            }
            case 8 -> {
                if (this.dealer_hand.value() == 6 && this.getTrue_count() >= 2) {
                    return "double";
                } else {
                    return "hit";
                }
            }
            default -> {
                return "hit";
            }
        }
    }

}
