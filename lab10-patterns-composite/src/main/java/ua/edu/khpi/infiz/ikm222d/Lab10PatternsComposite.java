package ua.edu.khpi.infiz.ikm222d;

public class Lab10PatternsComposite {

  public static void main(final String[] args) {
    new Lab10PatternsComposite().demo();
  }

  private void demo() {
    final HtmlLabel label1 = new HtmlLabel("Label1");
    final HtmlLabel label2 = new HtmlLabel("Label2");
    final HtmlInput input1 = new HtmlInput("Input1");
    final HtmlInput input2 = new HtmlInput("Input2");

    final HtmlFieldsetComposite fieldsetComposite = new HtmlFieldsetComposite();
    fieldsetComposite.add(label1);
    fieldsetComposite.add(input1);
    System.out.println(fieldsetComposite.generateHtml());

    fieldsetComposite.add(label2);
    System.out.println(fieldsetComposite.generateHtml());

    fieldsetComposite.add(input2);
    System.out.println(fieldsetComposite.generateHtml());

    fieldsetComposite.remove(input1);
    System.out.println(fieldsetComposite.generateHtml());

    fieldsetComposite.remove(label1);
    System.out.println(fieldsetComposite.generateHtml());
  }

}
