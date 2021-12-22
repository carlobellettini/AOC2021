package day00;

public enum Direzione {
  N(0, 1),
  E(1, 0),
  S(0, -1),
  W(-1, 0);

  final public int x;
  final public int y;

  Direzione(int x, int y) {
    this.x = x;
    this.y = y;
  }

  static public Direzione of(int i) {
    assert i >= 0 && i < 4;
    return Direzione.values()[i];
  }

  static public Direzione of(char c) {
    return Direzione.valueOf(String.valueOf(c));
  }
}
