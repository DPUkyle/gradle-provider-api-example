package com.kylemoore;

import org.gradle.api.DefaultTask;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.file.FileCollection;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.TaskAction;

import java.io.File;

public class MyTask extends DefaultTask {

  @InputFiles
  final Property<FileCollection> inputFiles = getProject().getObjects().property(FileCollection.class);

  @TaskAction
  public void go() {
    getLogger().quiet("Executing {}", this.getPath());

    MyExtension myExtension = getProject().getExtensions().getByType(MyExtension.class);

    Configuration lol = getProject().getConfigurations().create("lol");
    Dependency dependency = getProject().getDependencies().create(myExtension.getGAV() + "@pom");
    lol.getDependencies().add(dependency);

    inputFiles.set(lol);

    if(inputFiles.isPresent()) {
      getLogger().quiet("inputFiles contains: ");
      for(File f : inputFiles.get().getFiles()) {
        getLogger().quiet(f.getAbsolutePath());
      }
    } else {
      getLogger().quiet("You forgot to set inputFiles");
    }
  }

}
