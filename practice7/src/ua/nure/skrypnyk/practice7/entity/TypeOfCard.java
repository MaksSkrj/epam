package ua.nure.skrypnyk.practice7.entity;

public enum TypeOfCard {
  CONGRATULATORY("Поздравительная"), ADVERTISING("Рекламная"), COMMON("Обычная");

  private String value;

    TypeOfCard(String value) {
        this.value = value;
    }

    public boolean equalsTo(String name) {
        return value.equals(name);
    }

    public String value() {
        return value;
    }
}
