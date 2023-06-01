package ua.edu.khpi.infiz.ikm222d;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HtmlFieldsetComposite implements HtmlComponent {

  private List<HtmlComponent> internalComponents = new ArrayList<>();

  @Override
  public String generateHtml() {
    return new HtmlFieldset(internalHtml()).generateHtml();
  }

  private String internalHtml() {
    return internalComponents.stream().map(HtmlComponent::generateHtml).collect(Collectors.joining());
  }

  public boolean add(HtmlComponent component) {
    return internalComponents.add(component);
  }

  public boolean remove(HtmlComponent component) {
    return internalComponents.remove(component);
  }

}
