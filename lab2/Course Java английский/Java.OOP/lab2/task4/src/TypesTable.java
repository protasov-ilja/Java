class TypesTable {

  public static void main(String[] args) {
    System.out.printf("%s%10s%28s%28s", "Type", "Min", "Max", "Size");
    System.out.println();
    System.out.printf("%s%15d%27d%18d", "Integer", Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.BYTES);
    System.out.println();
    System.out.printf("%s%27d%27d%9d", "Long", Long.MIN_VALUE, Long.MAX_VALUE, Long.BYTES);
    System.out.println();
    System.out.printf("%s%12d%27d%23d", "Short", Short.MIN_VALUE, Short.MAX_VALUE, Short.BYTES);
    System.out.println();
    System.out.printf("%s%11d%27d%25d", "Byte", Byte.MIN_VALUE, Byte.MAX_VALUE, Byte.BYTES);
    System.out.println();
    System.out.printf("%s%13s%28s%20d", "Double", Double.toString(Double.MIN_VALUE), Double.toString(Double.MAX_VALUE), Double.BYTES);
    System.out.println();
    System.out.printf("%s%13s%28s%21d", "Float", Float.toString(Float.MIN_VALUE), Float.toString(Float.MAX_VALUE), Float.BYTES);
    System.out.println();
    System.out.printf("%s%3d%32d%23d", "Character", (int)Character.MIN_VALUE, (int)Character.MAX_VALUE, Character.BYTES);
    System.out.println();
  }
}