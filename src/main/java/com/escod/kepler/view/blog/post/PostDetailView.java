package com.escod.kepler.view.blog.post;

import com.escod.kepler.entity.blog.Post;
import com.escod.kepler.view.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.richtexteditor.RichTextEditor;
import io.jmix.flowui.component.tabsheet.JmixTabSheet;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "post/:id", layout = MainView.class)
@ViewController("Post.detail")
@ViewDescriptor("post-detail-view.xml")
@EditedEntityContainer("postDc")
public class PostDetailView extends StandardDetailView<Post> {

  private static final String TAB_3 = "tab3";
  private static final String INNER_HTML = "innerHTML";

  @Autowired
  protected UiComponents uiComponents;

  @ViewComponent
  private VerticalLayout content;

  @ViewComponent
  protected JmixTabSheet tabSheet;

  @ViewComponent
  private RichTextEditor htmlContentField;

  @Subscribe
  public void onInit(final InitEvent event) {
  }

  @Subscribe("tabSheet")
  public void onTabSheetSelectedChange(final JmixTabSheet.SelectedChangeEvent event) {

    Tab currentTab = event.getSelectedTab();
    currentTab.getId().ifPresent(id -> {
      if (id.equals(TAB_3)){
        content.removeAll();
        Component component = getComponent();
        content.add(component);
      }
    });
  }

  private Component getComponent() {

    String value = htmlContentField.getValue();
    Div span = uiComponents.create(Div.class);
    span.getElement().setProperty(INNER_HTML, value);

    return span;
  }
}