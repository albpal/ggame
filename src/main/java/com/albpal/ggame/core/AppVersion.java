package com.albpal.ggame.core;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.albpal.ggame.versions.*;

@JsonDeserialize(as = AppVersionImpl.class)
public interface AppVersion
{
  public abstract String getAppId();
  public abstract List<Bundle> getBundles();
  public abstract String toString();
}
