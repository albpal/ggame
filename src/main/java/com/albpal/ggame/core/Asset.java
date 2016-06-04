package com.albpal.ggame.core;

public abstract class Asset
{
  String packageURL;
  String version;

  public Asset(String p, String v)
  {
    packageURL = p;
    version = v;
  }

  public void setPackage(String urlPackage)
  {
    packageURL = urlPackage;
  }
  public void setVersion(String v)
  {
    version = version;
  }

  public String getPackage() { return packageURL; }
  public String getVersion() { return version; }
}
