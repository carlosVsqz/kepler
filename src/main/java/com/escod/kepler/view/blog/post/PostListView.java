package com.escod.kepler.view.blog.post;

import com.escod.kepler.entity.blog.Post;
import com.escod.kepler.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "posts", layout = MainView.class)
@ViewController("Post.list")
@ViewDescriptor("post-list-view.xml")
@LookupComponent("postsDataGrid")
@DialogMode(width = "64em")
public class PostListView extends StandardListView<Post> {
}