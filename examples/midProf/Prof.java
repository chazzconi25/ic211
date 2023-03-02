import java.util.*;
public class Prof {
  private String first, last, uname, grade, dept;


  public Prof(String f, String l, String u, String g, String d) {
    first = f;
    last  = l;
    grade = g;
    uname = u;
    dept  = d;
  }

  public boolean before(Prof m) {
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
    if (grade.equals("full")) {
      return "Professor";
    } else if (grade.equals("assoc")) {
      return "Associate Professor";
    } else {
      return "Assistant Professor";
    }
  }

  public String getDept() {
    return dept;
  }

  public static Prof read(Scanner sc) {
    return new Prof(sc.next(), sc.next(), sc.next(),
                    sc.next(), sc.nextLine());
  }

  public String toString() {
    return fullName() + ", " + getDept();
  }
}
