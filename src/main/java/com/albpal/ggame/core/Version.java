package com.albpal.ggame.core;

import java.util.List;

public interface Version
{
    public abstract String getAppId();
    public abstract List<Bundle> getBundles();
}
