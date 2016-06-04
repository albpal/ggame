package com.albpal.ggame.core;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.albpal.ggame.assets.*;

@JsonDeserialize(as = AssetImpl.class)
public abstract class Asset
{
  String packageURL;
  String version;

  public Asset() { }

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
    version = v;
  }

  public String getPackage() { return packageURL; }
  public String getVersion() { return version; }

  public String toString()
  {
    return packageURL + "," + version;
  }
}
