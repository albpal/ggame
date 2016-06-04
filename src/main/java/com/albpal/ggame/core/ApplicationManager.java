package com.albpal.ggame.core;

import com.albpal.ggame.exceptions.*;

public interface ApplicationManager
{
  public abstract void addAppVersion(String id, AppVersion v);
  public abstract AppVersion getAppVersion(String appIdentifier) throws Exception;
}
