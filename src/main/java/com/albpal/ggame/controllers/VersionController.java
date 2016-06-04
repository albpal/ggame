package com.albpal.ggame.controllers;

import com.albpal.ggame.core.*;
import com.albpal.ggame.versions.AppVersionImpl;
import com.albpal.ggame.exceptions.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class VersionController
{
    @RequestMapping(value="/version", method=RequestMethod.GET)
    public AppVersion getVersion(@RequestParam(value="appId", defaultValue="0001") String appIdentifier)
    {
      ApplicationContext springAppContext = new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });

      ApplicationManager appManager = (ApplicationManager) springAppContext.getBean("ApplicationManager");

      AppVersion appVersion = null;
      try
      {
        appVersion = appManager.getAppVersion(appIdentifier);
      }catch(Exception e)
      {
        e.printStackTrace();
      }
      return appVersion;
    }

    @RequestMapping(value="/version", method=RequestMethod.PUT)
    public AppVersion putVersion(@RequestParam(value="id", required = true) String id, @RequestParam(value="password", required = true) String password, @RequestBody AppVersion newAppVersion) throws Exception
    {
      if (! password.equals("XXX"))
      {
        throw new PutForbidden("Password incorrect in order to perform the PUT operation!");
      }
      ApplicationContext springAppContext = new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });

      ApplicationManager appManager = (ApplicationManager) springAppContext.getBean("ApplicationManager");

      appManager.addAppVersion(id, newAppVersion);

      return appManager.getAppVersion(id);
    }
}
