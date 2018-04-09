/**
 * 
 * Print the first index and last index of m where matrix contained m and s strings {
 * m','s','s','s','s','s','s','s','s s','s','s','s','s','m','m','s',' s','s','s','s','s','s','s','ms}
 * 
 * author: Javed Attar
 */


public class IdentifyMatrix {
  public static void main(String[] args) {
    // char[][] inputArray =
    // { {'m','s','s','s','s','s','s','s','s'},
    // {'s','s','s','s','s','m','m','s','s'},
    // {'s','s','s','s','s','s','s','m','s'}
    // };
    char[][] inputArray = {
        {
            's',
            's',
            'm',
            's',
            's',
            's',
            's',
            's',
            's'
        }, {
            's',
            's',
            's',
            's',
            's',
            'm',
            'm',
            's',
            's'
        }, {
            's',
            's',
            's',
            's',
            's',
            's',
            's',
            'm',
            's'
        }
    };
    findMatrix(inputArray);
  }

  private static void findMatrix(char[][] inputArray) {
    ElementCoordinates start = null, end = null;
    boolean bFound = false;
    for (int i = 0; i < inputArray.length; i++) {
      if (bFound == false) {
        for (int j = 0; j < inputArray[i].length; j++) {
          if (start == null && inputArray[i][j] == 'm') {
            start = new ElementCoordinates(inputArray[i][j], i, j);
          }
          if (end == null && inputArray[i][j] == 'm') {
            end = new ElementCoordinates(inputArray[i][j], i, j);
          }
          if (inputArray[i][j] == 'm' && isMatrix(start, end)) {
            bFound = true;
            break;
          } else if (inputArray[i][j] == 'm') {
            start = end;
            end = null;
          }
        }
      }
    }
    if (bFound) {
      System.out.println(String.format("Start Index => %s & End Index => %s", start.toString(), end.toString()));
    } else {
      System.out.println("Matrix not found for given input");
    }
  }

  private static boolean isMatrix(ElementCoordinates start, ElementCoordinates end) {
    if (end == null || start == null) {
      return false;
    }
    if (end.y - start.y > 1 || end.x - start.x > 1) {
      return true;
    }
    return false;
  }

  static class ElementCoordinates {
    int x, y;
    char element;

    public ElementCoordinates(char _element, int _x, int _y) {
      element = _element;
      x = _x;
      y = _y;
    }

    @Override
    public String toString() {
      return String.format("x=%d,y=%d", x, y);
    }
  }

}
