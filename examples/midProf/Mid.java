import java.util.*;
public class Mid {
  private String first, last, uname;
  private int    rank, co;

  public Mid(String f, String l, String u, int r, int c) {
    first = f;
    last  = l;
    uname = u;
    rank  = r;
    co    = c;
  }

  public boolean before(Mid m) {
    if( !last.equals(m.last) )
      return last.compareTo(m.last) < 0;

    if( !first.equals(m.first) )
      return first.compareTo(m.first) < 0;

    return uname.compareTo(m.uname) < 0;
  }

  public String email() {
    return uname + "@usna.edu";
  }

  public String fullName() {
    return title() + " " + first +  " " + last;
  }

  public String title() {
    return "Midshipman " + rank + "/C";
  }

  public String getCo() {
    return co + ending(co) + " Co";
  }

  public static Mid read(Scanner sc) {
    return new Mid(sc.next(), sc.next(), sc.next(), sc.nextInt(),
                   sc.nextInt());
  }

  public String toString() {
    return fullName() + ", " + getCo();
  }

  private String ending(int i) {
    String[] e = {
      "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"
    };
    return (i / 10 == 1) ? "th" : e[i % 10];
  }
}
