package ua.nure.skrypnyk.practice7.entity;

public class Type {

    private TypeOfCard typeOfCard;
    private boolean isPosted;

    public TypeOfCard getTypeOfCard() {
        return typeOfCard;
    }

    public void setTypeOfCard(String typeOfCard) {
        for (TypeOfCard type : TypeOfCard.values()) {
            if (type.equalsTo(typeOfCard))
                this.typeOfCard = type;
        }
    }

    public boolean isPosted() {
        return isPosted;
    }

    public void setPosted(boolean posted) {
        isPosted = posted;
    }

    @Override
    public String toString() {
        return "{Type of card: " + typeOfCard + ", is Posted: " + isPosted;
    }
}
