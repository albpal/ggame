package com.albpal.ggame.bundles;

import com.albpal.ggame.core.*;

import java.util.List;

public class BundleImpl extends Bundle
{
  BundleImpl() { }

  public BundleImpl(List<Asset> assets)
  {
    super(assets);
  }

  @Override
  public String toString()
  {
    String bundleInformation = "";
    for (Asset asset : assets)
    {
      if (bundleInformation == "")
        bundleInformation = asset.toString();
      else
        bundleInformation = bundleInformation + "&" + asset.toString();
    }
    return bundleInformation;
  }
}
