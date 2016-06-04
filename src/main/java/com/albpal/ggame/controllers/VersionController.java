package com.albpal.ggame.controllers;

import com.albpal.ggame.core.Version;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class VersionController
{
    @RequestMapping("/version")
    public Version version(@RequestParam(value="appId", defaultValue="0001") String version)
    {
      ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });

      Version versionInfo = (Version) appContext.getBean("Version" + version);

      return versionInfo;
    }
}
