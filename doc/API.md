### 基本情况

数据库：mysql

端口：3007

baseUrl：/ar/api

### 数据库结构

**building**(building_id,latitude,longitude,range,name,description)

**event**(event_id,build_id,user_id,title,content,time)

**user**(user_id,username,...)

满足如上结构的基础上自行设计，最终给大家一个完整的描述，包括

表名：

| 名称 | 类型 | 约束 | 描述 |
| ---- | ---- | ---- | ---- |
|      |      |      |      |

> 另外自行编入若干数据以用来测试用

### 识别建筑

#### URL

GET /building/where?latitude=latitude&longitude=longitude&range=range

#### 说明

此接口用来通过用户位置判断要识别的建筑，返回建筑ID。若不能准确判断是哪个建筑，返回一个列表，按可信度排序

#### Request

##### Header:

```json
{
  "content-type": "application/json"
}
```

#### Response

##### Body:

```json
{
    [
    	"building_id": 0,
    	"name": 0,
    	"description": "",
    ]

}
```

##### 属性说明：

暂无

### 获取建筑信息

#### URL

GET /building/content?building_id=building_id

#### 说明

此接口通过建筑id获取建筑的信息，与上一接口是否合并成一个接口自行决定并修改此文件

#### Request

##### Header:

```json
{
  "content-type": "application/json"
}
```

#### Response

##### Body:

```json
{
    "building_id": 0,
    "name": 0,
    "description": "",
}
```

##### 属性说明：

暂无

### 获取与用户相关的建筑信息

### Login

#### url

POST /auth/login

#### Request
##### header
```json
{
  "content-type": "application/json"
}
```
#### body
```json
{
  "username": "xxx",
  "password": "xxx"
}
```
### Response
#### body
```json
{
  "message": "xxx",
  "token": ""
}
```
### Register

#### url

POST /auth/register

#### Request
##### header
```json
{
  "content-type": "application/json"
}
```
##### body
```json
{
  "username": "xxx",
  "password": "xxx",
  "student_id": "xxx"
}
```
#### Response
##### body
```json
{
  "message": "xxx",
}
```

