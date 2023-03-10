# 机器人

## 主程序
- [ ] http服务
- [ ] websocket服务
- [ ] grpc服务
- [ ] dll调用管理器

## 插件
- [ ] 签到插件
- [ ] 淘宝返利插件
- [ ] 京东返利插件
- [ ] 拼多多返利插件

---
# 细节
- http服务 处理商城接口和后台管理接口
- ws服务 处理平台connector传入消息
- grpc 互调
- dll 管理器 需要每个dll有一个公开方法 每个dll返回固定配置(优先级/是否监听某些事件)


## 1.dll管理器与dll
> 每个dll有自己的生命周期(预创建 prepare,创建 create,销毁 destroy,收到消息 onmessage) ,每个dll可以有自己的暴露方法供外部调用,整个dll只有一个入口 收到固定外层消息 `{"code":xxx,"data":xxx}`    

`以下是dll收到消息`
```
prepare 返回优先级/监听的事件
{
    "code":0,
    "data":{
        //runtime or other
    }
}
```
```
create 启动自身定时器等
{
    "code":100,
    "data":{
        //runtime or other
    }
}
```
```
onmessage 处理消息
{
    "code":200,
    "data":{
        //any body
    }
}
```
```
destroy 关闭连接等
{
    "code":300,
    "data":{}
}
```

```
other 暴露外部接口
{
    "code":1000,
    "data":{

    }
}
```
`以下是dll返回消息`
```
{
    "code":200,//一般200为成功
    "data":{

    }
}
```
## 2.connector与主程序
### 消息
#### 文本消息
```
{
    "platform":"wx/qq/shop/qywx",
    "account":"平台账号",
    "type":"text",
    "data":{
        "content":"hello"
    }
}
```
#### 图片消息
```
{
    "platform":"wx/qq/shop/qywx",
    "account":"平台账号",
    "type":"img",
    "data":{
        "url":"https://xxx.xxx/xxx.jpg"
    }
}
```
#### 语音消息
```
{
    "platform":"wx/qq/shop/qywx",
    "account":"平台账号",
    "type":"voice",
    "data":{
        "data":"base64后的mp3格式文本"
    }
}
```
#### 分享消息
```
{
    "platform":"wx/qq/shop/qywx",
    "account":"平台账号",
    "type":"share",
    "data":{
        "title":"我是标题",
        "desc":"我是描述",
        "img":"我是图片地址",
        "url":"我是点击跳转链接"
    }
}
```
### 事件
#### 被添加好友事件
```
{
    "platform":"wx/qq",
    "account":"平台账号",
    "type":"friendRequest"
    "data":{
        "id":"对应平台id"
    }
}
```
### 方法
#### 删除好友
```
{
    "platform":"wx/qq",
    "account":"平台账号",
    "type":"delFriend",
    "data":{
        "list":["id1","id2"]
    }
}
```