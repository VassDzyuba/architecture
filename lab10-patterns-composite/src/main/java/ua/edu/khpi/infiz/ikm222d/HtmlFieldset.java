package ua.edu.khpi.infiz.ikm222d;

public class HtmlFieldset implements HtmlComponent {

  private String internalHtml;

  public HtmlFieldset(String internalHtml) {
    this.internalHtml = internalHtml;
  }

  @Override
  public String generateHtml() {
    return "<fieldset>" + internalHtml + "</fieldset>";
  }

}
