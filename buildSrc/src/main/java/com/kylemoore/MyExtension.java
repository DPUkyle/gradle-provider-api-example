package com.kylemoore;

public class MyExtension {

  public static final String NAME = "myExtension";

  private String _gav;

  public String getGAV() {
    return _gav;
  }

  @SuppressWarnings("unused")
  public void setGAV(String gav) {
    _gav = gav;
  }

}
