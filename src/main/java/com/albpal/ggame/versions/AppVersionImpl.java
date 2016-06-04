package com.albpal.ggame.versions;

import com.albpal.ggame.core.*;

import java.util.List;

public class AppVersionImpl implements AppVersion {
    private String appId;
    private List<Bundle> bundles;

    public AppVersionImpl() { }

    public AppVersionImpl(String appId, List<Bundle> bundles)
    {
        this.appId = appId;
        this.bundles = bundles;
    }

    @Override
    public String getAppId()
    {
      return appId;
    }

    @Override
    public List<Bundle> getBundles()
    {
      return bundles;
    }

    @Override
    public String toString()
    {
      String versionInformation = appId + "$";
      String bundleInformation = "";
      for (Bundle bundle : bundles)
      {
        if (bundleInformation == "")
          bundleInformation = bundle.toString();
        else
          bundleInformation = bundleInformation + ";" + bundle.toString();
      }
      versionInformation = versionInformation + bundleInformation;
      return versionInformation;
    }
}
