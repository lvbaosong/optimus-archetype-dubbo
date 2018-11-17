# optimus-archetype-dubbo
a maven archetype for optimus service.

## generate project from archetype

[使用案例](http://git.oschina.net/gdesign/grand-design/blob/master/dubbox-archetype-userguide.mdhttp://git.oschina.net/gdesign/grand-design/blob/master/dubbox-archetype-userguide.md)

with interactive mode

```
mvn archetype:generate                             \
  -DarchetypeGroupId=com.github.deepexi             \
  -DarchetypeArtifactId=optimus-archetype-dubbo   \
  -DarchetypeVersion=1.0.0
```


you will required to input groupId, artifactId for your new project.


without interactive mode

```
mvn archetype:generate                             \
  -DarchetypeGroupId=com.github.deepexi             \
  -DarchetypeArtifactId=optimus-archetype-dubbo   \
  -DarchetypeVersion=1.0.0                         \
  -DgroupId=x.y                                    \
  -DartifactId=a                                   \
  -DarchetypeCatalog=local
```

this process should be slow, but if you had already run once successfully, to speed up, add this param:


or using the LaunchRocket GUI.

## run

```
mvn spring-boot:run
```

deploy artifact:

```
mvn deploy
```

## reference

* [Introduction to Archetypes](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)
* [Guide to Creating Archetypes](https://maven.apache.org/guides/mini/guide-creating-archetypes.html)
