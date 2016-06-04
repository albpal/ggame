package com.albpal.ggame.appmanagers;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

import com.albpal.ggame.core.*;
import com.albpal.ggame.exceptions.NotAppVersionFound;

import com.albpal.ggame.assets.*;
import com.albpal.ggame.bundles.*;
import com.albpal.ggame.versions.*;

public class ApplicationManagerFileBased implements ApplicationManager
{
  private static HashMap<String, AppVersion> availableVersions = null;
  private final String file = "/opt/jboss/appVersions/appData.in";
  ApplicationManagerFileBased()
  {
      if (availableVersions == null)
      {
        availableVersions = new HashMap<String, AppVersion>();
        try{
          BufferedReader in = new BufferedReader(new FileReader(file));

          String line = "";
          while  ((line = in.readLine()) != null)
          {
            String versionId = line.split("\\$")[0];
            List<Bundle> versionBundles = new ArrayList<Bundle>();
            for (String bundle : line.split("\\$")[1].split("\\;"))
            {
              List<Asset> bundleAssets = new ArrayList<Asset>();
              for (String asset : bundle.split("\\&"))
              {
                String assetPackage = bundle.split("\\,")[0];
                String assetVersion = bundle.split("\\,")[1];
                Asset newAsset = new AssetImpl(assetPackage, assetVersion);
                bundleAssets.add(newAsset);
              }
              Bundle newBundle = new BundleImpl(bundleAssets);
              versionBundles.add(newBundle);
            }
            availableVersions.put(versionId, new AppVersionImpl(versionId, versionBundles));
          }
          in.close();
        }catch(Exception e)
        {
          e.printStackTrace();
        }
      }
  }

  @Override
  public AppVersion getAppVersion(String appIdentifier) throws NotAppVersionFound
  {
    synchronized(availableVersions)
    {
      if (! availableVersions.containsKey(appIdentifier))
        throw new NotAppVersionFound("There is no application version with identifier " + appIdentifier);

      return availableVersions.get(appIdentifier);
    }
  }

  @Override
  public void addAppVersion(String id, AppVersion v)
  {
    synchronized(availableVersions)
    {
      availableVersions.put(id, v);
      PrintWriter writer = null;
      try
      {
        writer = new PrintWriter(file, "UTF-8");

        for (AppVersion appVersion : availableVersions.values())
          writer.println(appVersion.toString());

          writer.close();
      }catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
