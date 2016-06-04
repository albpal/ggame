package com.albpal.ggame.core;

import java.util.List;

public abstract class Bundle
{
  List<Asset> assets;

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
}
