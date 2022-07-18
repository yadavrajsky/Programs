interface Constants {
  int KM_TO_M = 1000;
  int M_TO_CM = 100;
  int CM_TO_MM = 10;

}

class Converter implements Constants {
  public void getMeter(int km) {

    System.out.println(km + " km " + KM_TO_M * km + " m ");
  }

  public void getCentiMeter(int m) {

    System.out.println(m + " m " + M_TO_CM * m + " cm ");
  }

  public void getMilliMeter(int cm) {

    System.out.println(cm + " cm " + CM_TO_MM * cm + " mm ");
  }

}

class InterfacesConstantsDemo {

  public static void main(String[] args) {
    Converter c = new Converter();
    c.getMeter(10);
    c.getCentiMeter(10);
    c.getMilliMeter(10);
  }
}
