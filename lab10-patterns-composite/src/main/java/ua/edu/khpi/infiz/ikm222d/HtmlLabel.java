package ua.edu.khpi.infiz.ikm222d;

public class HtmlLabel implements HtmlComponent {

  private String value;

  public HtmlLabel(String value) {
    this.value = value;
  }

  @Override
  public String generateHtml() {
    return "<label>" + value + "</label>";
  }

}
