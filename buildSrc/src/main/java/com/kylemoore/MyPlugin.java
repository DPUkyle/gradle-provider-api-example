package com.kylemoore;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;

/**
 * Created by kmoore on 2018-06-19.
 */
public class MyPlugin implements Plugin<Project> {

  private static Logger LOGGER = Logging.getLogger(MyPlugin.class);

  @Override
  public void apply(Project project) {
    LOGGER.quiet("Applying {} to {}", getClass().getName(), project.getName());

    MyExtension myExtension = project.getExtensions().create(MyExtension.NAME, MyExtension.class);

    MyTask myTask = project.getTasks().create("myTask", MyTask.class, task -> {
      task.setGroup("Example");
      task.setDescription("Example of a task which doesn't resolve its properties until invoked");
    });
  }

}
