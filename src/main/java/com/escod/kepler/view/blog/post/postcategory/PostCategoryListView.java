package com.escod.kepler.view.blog.post.postcategory;

import com.escod.kepler.entity.blog.PostCategory;
import com.escod.kepler.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "postCategories", layout = MainView.class)
@ViewController("PostCategory.list")
@ViewDescriptor("post-category-list-view.xml")
@LookupComponent("postCategoriesDataGrid")
@DialogMode(width = "64em")
public class PostCategoryListView extends StandardListView<PostCategory> {
}