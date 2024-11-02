## Introduction

If you are using [Debezium Connect JDBC](https://debezium.io/documentation/reference/stable/connectors/jdbc.html) and trying to write on Snowflake database, you 
might notice there is no dialect provider to write straight to Snowflake. So this project aims to enable the use of Snowflake database with this awesome JDBC connector 
developed by Debezium Team.

## Why not Snowflake native connector ?

You might ask Why not use [Snowflake Native connector](https://docs.snowflake.com/en/user-guide/kafka-connector). Because it uses Snowpipe and it costs money and nowadays
there is no parameter option to write straight to Snowflake tables without using Stages + Snowpipe, like we do with pure Debezium JDBC Sink Connector. 

## How to use it ?

Follow steps below:

1- Download latest release version from github.   
2- Add this jar to plugins folder, in your Kafka Connect cluster.   
3- Add this property on your connector config:
```json
"hibernate.dialect": "br.com.datastreambrasil.connect.dialect.snowflake.SnowflakeDialect"
```
4- Don´t forget to add [Snowflake JDBC driver](https://mvnrepository.com/artifact/net.snowflake/snowflake-jdbc) to same plugins folder.