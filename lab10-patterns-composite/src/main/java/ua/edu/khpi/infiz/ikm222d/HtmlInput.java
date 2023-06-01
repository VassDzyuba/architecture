package ua.edu.khpi.infiz.ikm222d;

public class HtmlInput implements HtmlComponent {

  private String name;

  public HtmlInput(String name) {
    this.name = name;
  }

  @Override
  public String generateHtml() {
    return "<input type=\"text\" name=\"" + name + "\"/>";
  }

}
