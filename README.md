# ggame
Personal project related with games

## How to use it

### Data Model

AppVersion:
  + appId
  + List<Bundle>

Bundle:
  + List<Asset>

Asset:
  + urlToDownloadTheAsset
  + assetVersion

Every App Version has an unique identifier and a list of bundles representing groups of assets. In a card game, for example, every bundle can be an specific group of cards.
Every bundle has its own asset. Following the example of a card game, the assets are the cards.

### Operations
Get the last version:

```
GET <URL>/ggame-0.1.0/version
 -- response --
200 OK
Connection:  keep-alive
X-Powered-By:  Undertow/1
Server:  WildFly/10
Transfer-Encoding:  chunked
Content-Type:  application/json;charset=UTF-8
Date:  Sat, 04 Jun 2016 18:01:22 GMT

{"appId":"0001","bundles":[{"assets":[{"version":"v0002","package":"http://route_to_the_asset/EarthSoldier.zip"}]},{"assets":[{"version":"v0004","package":"http://route_to_the_asset/WaterSoldier.zip"}]}]}
```

Add a new version (passing it in a JSON format as shown):
```
PUT <URL>/ggame-0.1.0/version?id=0002&password=XXXXX
Content-Type: application/json
{
      "appId":"0002",
       "bundles":[{
               "assets":[{
                       "version":"v0002",
                       "package":"http://route_to_the_asset/EarthSoldier.zip"
                }]
         },{
                "assets":[{
                        "version":"v0004",
                        "package":"http://route_to_the_asset/WaterSoldier.zip"
               }]
          }]
}
 -- response --
200 OK
Connection:  keep-alive
X-Powered-By:  Undertow/1
Server:  WildFly/10
Transfer-Encoding:  chunked
Content-Type:  application/json;charset=UTF-8
Date:  Sat, 04 Jun 2016 18:04:34 GMT

{"appId":"0002","bundles":[{"assets":[{"version":"v0002","package":"http://route_to_the_asset/EarthSoldier.zip"}]},{"assets":[{"version":"v0004","package":"http://route_to_the_asset/WaterSoldier.zip"}]}]}
```

Get specific version:
```
GET <URL>:8080/ggame-0.1.0/version?id=0001

 -- response --
200 OK
Connection:  keep-alive
X-Powered-By:  Undertow/1
Server:  WildFly/10
Transfer-Encoding:  chunked
Content-Type:  application/json;charset=UTF-8
Date:  Sat, 04 Jun 2016 18:09:36 GMT

{"appId":"0001","bundles":[{"assets":[{"version":"v0002","package":"http://route_to_the_asset/EarthSoldier.zip"}]},{"assets":[{"version":"v0004","package":"http://route_to_the_asset/WaterSoldier.zip"}]}]}
```

For the above to work you  have to change <URL> and the password parameter for POST operations.
