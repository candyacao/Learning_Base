# 注释
### 类注释
```javadoc
/**
 * 一句话功能描述
 * 功能详细描述
 * @author [作者] 必须
 * @see [相关类/方法] (可选)
 * @since [产品/模块版本] (必须)
 * @deprecated 可选
 */
```

### 注释的位置
	类成员变量、共有和保护方法需要些注释，写在被注释元素的上面，并与其上面的代码用空行隔开，注释与所描述内容进行同样的缩排。
```javadoc
/**
 * 一句话功能描述
 * 功能详细描述
 *
 * @author [作者] 必须
 * @see [相关类/方法] (可选)
 * @since [产品/模块版本] (必须)
 * @deprecated 可选
 */
public class Test {
    /**
     * 字段注释
     */
    private String logType;

    /**
     * 函数注解
     */
    public void write() {

    }
}
```


## 函数的注释

	公有和保护方法注释需要列出方法的一句话功能简述、功能详情描述、输入参数、输出参数、返回值、异常等。
* @param [参数1] 参数1说明
* @return [返回类型说明]
* @exception/throws [异常类型] [异常说明]
* @see [类、类#方法、类#成员]
* @since [起始版本]
* @author [作者] 必须
```javadoc
/**
 * 登陆
 * 账号的登陆，登陆成功后保存token到本地。
 *
 * @param name 用户名
 * @param pwd  密码
 * @return 登陆是否成功
 * @since 1.0
 */
public boolean login(String name, String pwd) {

}
```

### 异常注释
	对于方法内部用throws语句抛出的异常，必须在方法的注释中表明。 
	异常注释用@exception或@throws表示，在JavaDoc中两者等价，但推荐用@exception表示Runtime异常，@throw标注非Runtime异常。
```javadoc Exception
/**
 * 关闭当前数据流
 * @throws IOException 当关闭流失败时抛出该异常
 */
public void close() throws IOException {

}
```

# javadoc使用格式
javadoc [ options ] [ packagenames ] [ sourcefilenames ] [ -subpackages pkg1:pkg2:... ] [ @argfiles ]
注意：Arguments can be in any order.（理解：参数没有顺序要求是指的是options的参数，但是包名，以及源文件名等的顺序还是要与上述相同的。）

## 编码问题
* 设置源码编码方式：-encoding UTF-8
* 指定输出的字符编码：-charset UTF-8
* 自定输出的路径：-d
* 使用的语言环境：-locale zh_CN
* 指定标题栏标题文字：-windowtitle  <text>
* 包含概览页面的标题：-doctitle <html-code> 
* 包含每个页面的页眉文本：-header <html-code> 
* 包含每个页面的页脚文本：-footer  <html-code>
* 包含每个页面的顶部文本：-top  <html-code>
* 包含每个页面的底部文本：-bottom  <html-code>
* 指定查找源文件的位置：-sourcepath <pathlist> 
* 指定要递归加载的子程序包：-subpackages <subpkglist> 