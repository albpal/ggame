package com.albpal.ggame.appmanagers;

import java.util.HashMap;

import com.albpal.ggame.core.*;
import com.albpal.ggame.exceptions.NotAppVersionFound;

public class ApplicationManagerTextBased implements ApplicationManager
{
  private static HashMap<String, AppVersion> availableVersions = null;

  ApplicationManagerTextBased(HashMap<String, AppVersion> appVersions)
  {
      if (availableVersions == null)
        availableVersions = appVersions;
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
    }
  }
}
