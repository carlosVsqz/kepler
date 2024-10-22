package com.escod.kepler.view.blog.post;

import com.escod.kepler.entity.blog.Post;
import com.escod.kepler.view.main.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.richtexteditor.RichTextEditor;
import io.jmix.flowui.view.*;

@Route(value = "post/:id", layout = MainView.class)
@ViewController("Post.detail")
@ViewDescriptor("post-detail-view.xml")
@EditedEntityContainer("postDc")
public class PostDetailView extends StandardDetailView<Post> {

  @ViewComponent
  private VerticalLayout content;

  @Subscribe
  public void onInit(final InitEvent event) {
  }

  @Subscribe("htmlContentField")
  public void onHtmlContentFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<RichTextEditor, ?> event) {
    String value = (String) event.getValue();

    content.removeAll();
    Div span = new Div();
    span.getElement().setProperty("innerHTML", value);
    content.add(span);
  }
}