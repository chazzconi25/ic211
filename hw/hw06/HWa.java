public class HWa {

  public static void
    main(String[] args) {
    Foo f = new Foo();
    Bar b = new Bar();

    f.func1(38);
    b.func1(38);
    f.func2('A');
    b.func2('A');
    b.func2(1.8);
    f.func3();
    b.func3();
    b.func5();
    Bar.func5();



  }
}
