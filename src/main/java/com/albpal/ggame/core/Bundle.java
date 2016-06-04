package com.albpal.ggame.core;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.albpal.ggame.bundles.*;

@JsonDeserialize(as = BundleImpl.class)
public abstract class Bundle
{
  protected List<Asset> assets;

  public Bundle() { }

  public Bundle(List<Asset> a)
  {
    assets = a;
  }
  public void setAssets(List<Asset> a)
  {
    assets = a;
  }

  public List<Asset> getAssets()
  {
    return assets;
  }

  public abstract String toString();
}
