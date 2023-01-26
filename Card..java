public class Card {
    private String cardName;
    private int power = 0;

    Card(String cardName, int power){
        setCardName(cardName);
        setPower(power);
    }

    private void setPower(int power){
        if(power > 0){
            this.power = power;
        }
    }
    private void setCardName(String cardName){
        if(!cardName.equals("")){
            this.cardName = cardName;
        }else {
            this.cardName = "Invalid card name.";
        }

    }

    public String getCardName() {
        return cardName;
    }

    public int getPower() {
        return power;
    }
}
