package com.albpal.ggame.versions;

import com.albpal.ggame.core.*;

import java.util.List;

public class Version0001 implements Version {

    private final String appId;
    private final List<Bundle> bundles;

    public Version0001(String appId, List<Bundle> bundles)
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
}
