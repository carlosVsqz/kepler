package com.escod.kepler.view.blog.post.postcategory;

import com.escod.kepler.entity.blog.PostCategory;
import com.escod.kepler.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "postCategory/:id", layout = MainView.class)
@ViewController("PostCategory.detail")
@ViewDescriptor("post-category-detail-view.xml")
@EditedEntityContainer("postCategoryDc")
public class PostCategoryDetailView extends StandardDetailView<PostCategory> {
}