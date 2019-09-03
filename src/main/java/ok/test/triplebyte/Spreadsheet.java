package ok.test.triplebyte;

import java.util.ArrayList;
import java.util.List;

public class Spreadsheet {

  Integer row = 0;
  Integer col = 0;
  String[][] newSheetStrings;
  List<List<String>> sheet;

  public Spreadsheet(Integer row, Integer col) {
    super();
    this.row = row;
    this.col = col;
    this.sheet = new ArrayList<List<String>>();
    newSheetStrings = new String[row][col];
    for (int i = 0; i < row; i++) {
      List<String> column = new ArrayList<String>();
      for (int j = 0; j < col; j++) {
        column.add("");
      }
      sheet.add(column);
    }
  }

  private void update(int r, int c, String value) {
    sheet.get(r).set(c, value);
  }

  private void print() {

    for (List<String> col : sheet) {
      for (int i = 0; i < col.size(); i++) {
        System.out.print(col.get(i));
        if (i < (col.size() - 1)) {
          System.out.print("|");
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Spreadsheet test = new Spreadsheet(4, 3);
    test.update(0, 0, "bob");
    test.update(0, 1, "10");
    test.update(0, 2, "foo");

    test.update(1, 0, "alice");
    test.update(1, 1, "5");

    test.print();
  }
}
