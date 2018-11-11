# 初始HTML(超文本标记语言，数据的展示，网页)
## 开发前准备
### WWW, Internet, W3C, ip, 域名
1. WWW：(world wide web)

        万维网，是基于Internet的信息服务系统，官方定义为"WWW is a wide-area hypermedia information retrieval initiative aiming to give universal access to a large universe of documents",简而言之，WWW是一个以Internet为基础的计算机网络，它允许用户在一台计算机上通过Internet访问另一台计算机上的信息。从技术上讲，万维网是Internet上那些支持WWW协议和超文本传送协议的客户机与服务器的集合，通过它可以访问世界各地的超文本文件，包括文字，图形，声音，动画，资料库以及各种内容。
2. Internet:

		互联网/因特网
		是由计算机连接起来的物理网络，它们依靠标准和固定的规则进行通信。
		OSI/RM 开放系统互联参考模型   七层模型
		TCP/IP协议簇     四层模型
3. W3C:(world wide web consortium)

		万维网联盟（xml），创建于1994年，是Web技术领域最具权威和影响力的国际中立性技术标准机构。到目前为止，W3C已发布了200多项影响深远的Web技术标准及实施指南，如广为业界采用的超文本标记语言（标准通用标记语言下的一个应用）、可扩展标记语言（标准通用标记语言下的一个子集）
		w3cschool

4. ip地址：

        HTTP TCP/IP
		IP地址是指互联网协议地址
		（英语：Internet Protocol(协议) Address，又译为网际协议地址），是IP Address的缩写。IP地址是IP协议提供的一种统一的地址格式，它为互联网上的每一个网络和每一台主机分配一个逻辑地址。
		IPv4
		例如：192.168.189.1 点分十进制


5. 域名：

		www.baidu.com
		给IP起一个名字
		IP地址是Internet主机的作为路由寻址用的数字型标识，人不容易记忆。因而产生了域名（domain name）这一种字符型标识。

			com:商业组织公司
			edu:教研机构
			gov:政府部门
			net:网络服务商
			org:非盈利组织
			cn:中国国家顶级域名

### 网站(B/S架构项目)

	    是构成web的基础，指在万维网上根据一定的规则，使用html,css,java等语言制作的用于展示特定内容的相关网页的集合。
	    百度，京东，天猫

### 网页
	    是网站中的一个页面，是构成网站的基础，网页是纯文本文件，但是具有一定的格式，也就是HTML语言定义的格式，由于HTML被翻译为超文本标记语言，因此网页也被称为超文本文件，用于展示文本，图片，影音等内容。

### 互联网产业分类
	行业服务类：
		新闻资讯（网易）
		信息搜索（百度，Google）
		邮箱	（163）
		购票类	（12306）
	商务应用类：
		Estore杰普电子商务系统
		电子商务	（天猫，京东）
		人才招聘	（赶集网，智联招聘）
		网络教育	（极客学院）
		第三方支付	（支付宝）
	其他类
	由于"互联网+"概念的提出，互联网将渗入到医疗，教育，农业等传统行业

### 网站制作流程
	需求分析->原型图（Axure）
		|
	前端设计->效果图（psd）
		|
	前端开发->静态页面（html）
		|
	后台开发->接口服务（java）
		|
	部署运行（将网站部署到服务器上）


### 网站的访问方式

	    通过浏览器来读取网页的内容，浏览器可以将信息的格式进行处理，将内容以一定的方式呈现到屏幕上。我们可以通过URL地址进行网站的访问。
	    每个网页在Internet中都有一个唯一的URL地址，URL是Internet上用来指定一个位置或一个网页的标准方式，URL的语法格式如下：
	        协议名称://主机名称[:端口号/存放目录/文件名称]
		    http://127.0.0.1:8888/sg/index.jsp
		    http://www.baidu.com:80/xin/a.html
	        协议名称：浏览器默认协议为http协议
	        主机名称：网站所在的主机地址
	        端口号：  主机上存放该网站的服务器软件
	        存放目录：要访问网页的存放目录
	        文件名称：要访问的网页的名称
	    查看端口号：netstat -ano(cmd)
## 了解html
### html概念
1. xml：可扩展标记语言

	    超文本(超级文本)标记语言(Hyper Text Markup Language)，是一种解释执行的文本类标记语言，用来描述网页,是Internet上用于编写网页的主要语言。“超文本”就是指页面内可以包含图片、链接，甚至音乐、程序等非文字元素。

	    html也是一种规范，一种标准，它通过标记符号来标记要显示的网页中的各个部分。网页文件本身是一种文本文件，通过在文本文件中添加标记符，可以告诉浏览器如何显示其中的内容（如：文字如何处理，画面如何安排，图片如何显示等）。浏览器按顺序阅读网页文件，然后根据标记符解释和显示其标记的内容，对书写出错的标记将不指出其错误，且不停止其解释执行过程，编制者只能通过显示效果来分析出错原因和出错部位。

* 分析简单的HTML结构
```html
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
	<html>
		<head>
				<!-- 此部分信息是给浏览器、搜索引擎看的 -->
		</head>
		<body>
				<!-- 此部分内容为正文，显示 -->
		</body>
	</html>
```
	xml:自定义:<body><html></html></body>
		<student></student>
		<teacher></teacher>
	html：预定义(必须使用人家定义好的)

2. html发展历程
* 超文本标记语言(第一版) -- 在1993年6月发为互联网工程工作小组(IETF)工作草案发布(并非标准)
* HTML 2.0 -- 1995年11月作为RFC 1866发布,在RFC 2854于2000年6月发布之后被宣布已经过时
* HTML 3.2 -- 1996年1月14日,W3C推荐标准
* HTML 4.0 -- 1997年12月18日,W3C推荐标准
* HTML 4.01(微小改进) -- 1999年12月24日,W3C推荐标准，常见的标准。
* HTML 5--2008年1月22日公布第一份草案，2014年10月28日，W3C推荐标准

3. 基本语法

    1. 创建和编辑html文件

	        可以使用.html或.htm作为html文件的后缀名（因为过去的很多软件只允许三个字母的文件后缀）

    2. 文档结构

	    1. 文档类型声明:

		    版本和文档类型声明，版本和文档类型声明是对应的。

		    <!DOCTYPE>声明位于文档中的最前面的位置，此标签可告知浏览器文档使用哪种HTML规范。

		     DTD 类型，分别表示严格版本、过渡版本以及基于框架的 HTML 文档。

		     4.01 规定了三种文档类型：Strict、Transitional 以及 Frameset框架集(被div+css替代)

		    1. 严格的文档类型
            ```html
			    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
            ```
		    2. 过渡版本(宽松)的文档类型
            ```html
			    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            ```
		    3. frameset:用来做布局，比如左侧导航栏，右侧内容栏，已被div+css取代
            ```html
			    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
            ```
	    2. html：
            ```
		        标识HTML文档
		        此元素可告知浏览器其自身是一个 HTML 文档。
		        <html> 与 </html> 标签限定了文档的开始点和结束点，在它们之间是文档的头部和主体。文档的头部由<head> 标签定义，而主体由 <body> 标签定义。
            ```
	    3. head	

                头部负责配置，体部负责显示
		        html文档中的头部标签
		        定义元数据 文档的属性、全局参数、作者、版权、日期、刷新方式
		        head中定义的内容不向用户直接展示		        		
		        可以包含该文档的标题，文档使用的脚本，样式定义，元数据等信息
		    ```html	
                <head> 标签用于定义文档的头部，它是所有头部元素的容器。<head> 中的元素可以引用脚本、指示浏览器在哪里找到样式表、提供元信息等,描述了文档的各种属性和信息。绝大多数文档头部包含的数据都不会真正作为内容显示给读者。
        
		        下面这些标签可用在 head 部分：
		        <base>, <link>, <meta>, <script>, <style>, 以及 <title>。
		        <title> 定义文档的标题，它是 head 部分中唯一必需的元素。
		        <title>标签：在<title>和</title>标签之间的文字内容是网页的标题信息，它会出现在浏览器的标题栏中。网页的title标签用于告诉用户和搜索引擎这个网页的主要内容是什么，搜索引擎可以通过网页标题，迅速的判断出网页的主题。每个网页的内容都是不同的，每个网页都应该有一个独一无二的title
            ```
	    4. body

		        体部标签，真正显示内容的主体部分
		        body 元素定义文档的主体。
		        body 元素包含文档的所有内容（比如文本、超链接、图像、表格和列表等)。
		        body中的内容可以显示到浏览器中。

            ```html
	        例如：
		        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		        <html lang="en">
		            <head>
			            <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
			        <   title>标题</title>
		            </head>
		            <body>

		            </body>
		        </html>
        ```
    3. 基本概念

	    1. 标签：

		        标签用来标记内容，也是用标签表名文本的意义。标签使用"<",">"包围。

		        HTML 文档和 HTML 元素是通过 HTML 标签进行标记的

		        HTML 标签由开始标签和结束标签组成

		        开始标签是被括号包围的元素名,如<html>

		        结束标签是被括号包围的斜杠和元素名 ,如</html>

		        某些 HTML 元素没有结束标签，比如 <br />
		    
                标签分为成对标签和单标签:
		        开始标签常被称为开放标签（opening tag），结束标签常称为闭合标签（closing tag）。

	    2. 元素：
            ```xml
	        <!-- xml -->
            <classroom>
	            <group>
	                <student id="1001" name="tom></student>
	            </group>
	        </classroom>
            ```
		        一个元素通常是由一个开始标签，内容，其他元素以及一个结束标签组成的
		        开始标签（start tag）到结束标签（end tag）的所有代码
	    3. 属性：

		        与元素相关的特性称为属性，属性由键值对组成，写在开始标签中，属性和属性值对大小写不敏感，推荐小写，属性值被包括在双引号或者单引号内，在某些个别的情况下，比如属性值本身就含有双引号，那么必须使用单引号。
             ```
		        <元素名 属性1=“值1” 属性2=‘值2’></元素名>
		        xml中的元素属性：
			        <stu stuId="1001" name="tom"></stu>
		        html中的元素属性：
		            <h1 align="center">
		            name='Bill "HelloWorld" Gates'</h1>
            ```
		        html中的元素属性和标签名一样,都是预定义的。
		        核心属性 (Core Attributes):
			        大多数元素都可以使用的属性。
			        id     	唯一标识
			        class	标识一类元素
			        style	样式
			        title	描述信息
					    当鼠标悬停在组件上的时候
				
	    4. 规范：
         ```
	        <html>  <HTML> 
	        元素名和属性都不区分大小写。
	        注：HTML标签对大小写不敏感：<P> 等同于 <p>。许多网站都使用大写的 HTML 标签。W3School 使用的是小写标签，因为万维网联盟（W3C）在 HTML 4 中推荐使用小写，而在未来 (X)HTML 版本中强制使用小写。
	        不要忘记结束标签，虽然即使忘记了使用结束标签，大多数浏览器也会正确地显示 HTML，忘记使用结束标签会产生不可预料的结果或错误，未来的 HTML 版本不允许省略结束标签
	        空的 HTML 元素，没有内容的 HTML 内容被称为空元素。空元素是在开始标签中关闭的。<br /> 就是没有关闭标签的空元素（<br /> 标签定义换行）。
	        <div></div>
        ```
    4. 注释

	            代码注释的作用是帮助程序员标注代码的用途，过一段时间后再看你所编写的代码，就能很快想起这段代码的用途。代码注释不仅方便程序员自己回忆起以前代码的用途，还可以帮助其他程序员很快的读懂你的程序的功能，方便多人合作开发网页代码，注释代码是不会在结果窗口中显示出来的。
	            <!-- 注释内容 --> 

    5. meta元素
    ```
        <meta> 元素可提供有关页面的元信息/元数据（meta-information），比如针对搜索引擎和更新频度的描述和关键词。
        <meta> 标签位于文档的头部（head），不包含任何内容。<meta>
    ```
        标签的属性定义了与文档相关联的名称-值 对
	    大多数情况下，meta 元素用来提供与浏览器或者搜索引擎相关的信息，比方说描述文档的内容等。
	        1. 定义元数据关键字
		        <meta name="Author" content="张三">
		        <meta name="Copyright" content="版权信息">
		        <meta name="Description" content="描述信息">
		        <meta name="keywords" lang="zh-cn" content="精品图书">
		        <meta name="keywords" lang="en-us" content="good book">
	        2. 报头规范
		        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
			        将会创建如下的消息头
				        Content-Type:text/html;charset=utf-8
		        <meta http-equiv="Content-Language" content="zh-CN">
			        将会创建如下的消息头
				        Content-Language:zh-CN
		        <meta http-equiv="Refresh" content="n;url=http://yourlink">
			        定时让网页在指定的时间n后跳转到页面http://yourlink
		    .....
4.  颜色与大小

    1. 颜色

	            颜色由红(R)、绿(G)、蓝(B)组成，每个颜色的最低值为0(十六进制为00)，最高值为255(十六进制为FF)。十六进制值的写法为#号后跟三个或六个十六进制字符。

	        3位十六进制	6位16进制	rgb
	        #000		#000000		rgb(0,0,0)
	        #F00 		#FF0000 	rgb(255,0,0)
	        #FFF 		#FFFFFF 	rgb(255,255,255)
	            如果设置的颜色是16进制的色彩值时，如果每两位的值相同，可以缩写一半
	            如：p{color: #336611;} 写为p{color: #361;}
            rgba:a代表透明度
	        还可以使用颜色名：如：color:yellow
	        大多数的浏览器都支持颜色名集合。

		    提示：仅仅有 16 种颜色名被 W3C 的 HTML4.0 标准所支持。它们是：aqua, black, blue, fuchsia, gray, green, lime, maroon, navy, olive, purple, red, silver, teal, white, yellow。

    2. 大小

	        px 		像素
	        定义一个图片高度：  height="100px'

5. 标签介绍

	    标签的用途：我们学习网页制作时，常常会听到一个词，语义化。那么什么叫做语义化呢，说的通俗点就是：明白每个标签的用途（在什么情况下使用此标签合理）比如，网页上的文章的标题就可以用标题标签，网页上的各个栏目的栏目名称也可以使用标题标签。文章中内容的段落就得放在段落标签中，在文章中有想强调的文本，就可以使用 em 标签表示强调等等。这样容易被搜索引擎收录。

	    语义化网页结构有助于搜索引擎的收录。同一个效果可以用很多钟方式实现，但这只方便了浏览者，而搜索引擎不知道这里到底是什么内容。
	
	1. 块级(block)标签:独占一行
        1. \<div>\</div>
	    ```
            特点：
	            1)独占一行
	            2)相当于一个容器，包含其他标签或内容，比如包含页面上的栏目版块
	    ```   
        2. h1~h6 标题
        ```
            <h1> 定义最大的标题，最高等级。<h6> 定义最小的标题。重要性依次递减。
	        特点:
	            1)有字体大小的设置
	            2)文本有加粗强调设置
	            3)上下文之间有较大间距
	            4)请确保将 HTML heading标签只用于标题,不要仅仅是为了产生粗体或大号的文本而使用标题
        ```
	    3. p 段落
        ```
	        特点：
	            1)独占一行
	            2)上下文之间（段前段后）具有距离，可用css样式来删除或者改变
        ```
	    4. hr 水平线
        ```
	        特点：
                hr元素可用于分隔内容，显示一条灰色的横线。
	            单（空）标签：没有html内容的标签，只需写开始标签后加/即可。
	            如<hr/>，<br/>,<img/>
        ```
	    5. br 换行
        ```
	        当显示页面时，浏览器会移除源代码中多余的空格和空行。所有连续的空格或空行都会被算作一个空格。需要注意的是，HTML 代码中的所有连续的空行（换行）也被显示为一个空格，可采用br输出换行

	        特点：
                在不产生一个新段落的情况下进行换行（新行），使用单标签<br />
	            空格需使用实体：&nbsp;
        ```
	    6. ul li 无序列表：
        ```
            无序列表是一个项目的列表，此列项目使用粗体圆点（典型的小黑圆圈）进行标记。
	        无序列表始于 <ul> 标签。每个列表项始于 <li>。
	        特点：
	            1) ul li都独占一行空间
                2) ul 上下文之间有很大空间
                3) li与列表的样式显示(默认点状)，并且有文本缩进
                4）列表项内部可以使用段落、换行符、图片、链接以及其他列表等等

                <ul>
                    <li>列表1</li>
                    <li>列表2</li>
                </ul>

                改变样式使用ul或li的属性type
                ul:可选值为disc，square，circle
                li:可选值为disc，square，circle，1，A,a，i，I
	    ```					
        7. ol  li 有序列表：
        ```
            有序列表也是一列项目，列表项目使用数字进行标记
            有序列表始于 <ol> 标签。每个列表项始于 <li> 标签。
                改变样式使用ol或li的属性type
                ol:可选值为1，A,a，i，I
                li:可选值为1，A,a，i，I,disc，square，circle
                    <ol>
                        <li>Coffee</li>
                        <li>Milk</li>
                    </ol>
        ```
	2. 行内（内联inline）标签

		1. span

			    特点：没有语义，作用就是为了设置其他单独的样式。

				1)最干净的内联标签,本身没有固定的格式表现（没有任何修饰）
				2)不独占一行
			
		2. decoration	文本修饰标签
        ```
            <i>斜体修饰</i>
            <b>粗体文本</b>
            <em>强调</em> 浏览器中是斜体表示
            <strong>加重/更强烈的强调</strong> 浏览器中用粗体表示
            <s>删除线</s>  //<del>
            <u>下划线修饰</u>
            <sup>上标</sup>
            <sub>下标</sub>
            <q>引用</q>引用的文本不用加双引号，浏览器会自动添加双引号
        ```
		3. a超链接
        ```
        <a>标签有两个作用：
            1.定义超链接，可以创建指向了另外一个文档的连接。
                通过href属性指定跳转路径。
                例如：
                    <a href="http://www.baidu.com" title="百度一下，你就知道">点击打开百度</a>

            2. 通过使用 name 或 id 属性，创建一个文档内部的书签(锚点),锚点可以让用户在文档中设置标记，这些标记通常放在文档的特定主题处或顶部，然后创建到这些锚点的连接，指向网页中的特点位置。
            
            如：使用a标签命名锚：<a name="top" >第一章</a>
                即可通过超链接跳转至该锚点。
                <a href="#top">跳转至第一章</a>
                锚点也可通过其他标签的id属性创建
                <h1 id="hh1">第一节</h1>
                <p id="p1">第一段</p>
        ```
		4. img	图片（内联块状元素）

			1. 图片类型常见有：

				GIF（graphics interchange format,图形交换格式）

				JPEG（joint photographic experts group,联合图像专家组）

				PNG（portable network graphics,可移植网络图形）

			2. 链入图片文件
            ```html
			<img src="图片地址" alt="下载失败时的替换文本" title="提示文本">
            ```
			    属性：
				    src:图片的源地址，可以使用相对或绝对路径
				    title:对图片的文字说明，当用户把鼠标放在图片上稍作停留，title属性的值就会以浮动的形式显示出来。
				    alt:当图片文件找不到的时候显示的文本信息
				    width:图片的宽度
				    height:图片的高度
				    border:图片的边框
				    align:图片和文字的对齐

			    为图片添加链接
				    <a href=""><img src="" alt=""></a>
6. 其他常用的标签

    1. 表格相关标签：

	    1. table (块级标签)
        ```html
            <table></table> 
            <table></table>
            定义表格，默认没有表格线。
        ```
		
		    属性：
                border:	设置表格边框线条宽度（设置了table以及td的边框，可配合cellspaceing使用）
                width:	设置表格宽度
                height: 设置表格高度
			
                align:	表格在页面中对齐
                    left 左对齐表格。
                    right 右对齐表格。
                    center 居中对齐表格。

                bgcolor:表格背景色
                background:背景图片
                cellspacing:单元格之间的间距，规定单元格之间的空间
                cellpadding:单元格之间的衬距，规定单元边沿与其内容之间的空白
                frame:表格中边框线的显示，规定外侧边框的哪个部分是可见的
                    void	不显示边框(默认)
                    above	上边框
                    below	下边框
                    hsides	上下边框
                    vsides	左右边框
                    lhs 	左边框
                    rhs 	右边框
                    box	四个边框
                    border：四个边框

                rules:表格中分割线的显示，规定内侧边框的哪个部分是可见的
                    none	无分割线显示
                    rows	仅在行间显示分割线
                    cols	仅在列间显示分割线
                    all	在所有行列间显示分割线
                summary：摘要
                    摘要的内容是不会在浏览器中显示出来的。它的作用是增加表格的可读性(语义化)，使搜索引擎更好的读懂表格内容。
                    语法：<table summary="XXXX">
	    2. tr

                定义表格行
	    3. th/td

                th 定义单元格:表头，居中加粗
                td 定义内容单元格
                属性：
                    colspan	跨列
                    rowspan	跨行
                    align 	单元格水平对齐
                        left,center,right,justify两端对其@
                    valign	单元格垂直对齐
                        top,middle,bottom
                对齐的继承：同一级别根据大的来
                    1）内容自身的设置具有最高优先级
                    2）th,td元素的对齐设置
                    3）tr,thead,tfoot,tbody元素的对齐设置
                    4）table元素的对齐设置具有全局性
                    5）默认的设置
	    4. caption

                表格的标题
        5. 表格的分组显示

                thead	表格头
                tbody 	表格主体
                tfoot	表格尾：声明的内容始终在最末端

	
	2. 表单相关标签

	        主要用于收集来自用户的信息，并将收集的信息发送给服务器端处理程序处理。表单是客户端和服务器端传递数据的桥梁，是实现用于与服务器互动的最主要方式。（比如：文本域、下拉列表、单选框、复选框等等）
	    1. form   
        ```
            <form></form>
		    表单控件的容器
		    <form action=""></form>
		    属性
                action 	设定处理表单数据URI的地址,当提交表单时，向何处发送表单数据
                method	设定数据传送到服务器的方式
                get	 将输入的数据追加到action地址后面
                适用于少量数据的提交	
                post  将输入的数据保存到HTTP协议的报文中
                name	设定表单的名称
                enctype	设定表单数据的内容类型

                application/x-www-form-urlencoded	在发送到服务器之前，所有字符都会进行编码（默认）

                multipart/form-data		不对字符编码。在使用包含文件上传控件的表单时，必须使用该值。
        ```

	    2. input	基本表单控件（内联块状元素）
        ```html
            <input type="text">
        ```    
            1. 属性：
                |---type---|-----控件类型-----|
		        |---text---|----单行文本框----|
		        |---password--|---密码-----|
		        |----radio---|----单选按钮,同一组的选项，name取值一定要一致---|
		        |---checkbox---|----复选框-----|
		        |----file----|----文件-----|
		        |----hidden----|----隐藏域-----|
		        |----image-----|------图像提交按钮----|
		        |----button---|----普通按钮----|
		        |----submit----|----提交按钮----|
		        |----reset----|---重置按钮----|

	        2. name

                控件名称，这个名称将与控件的当前值形参"名称/值"对 一同随表单提交，后台会使用到
            3. value

                为文本输入框设置默认值（一般起到提示作用）
            4. checked
                单选框，复选框默认选中，设置checked="checked"
            5. size
                当前控件的初始宽度，这个宽度以像素为单位。除非控件类型是text,password，这时宽度是整数值，表示可以看到的字符的数目
            6. maxlength
                指定可以输入的字符的最大值。适用于控件类型为text,password。
    
	   3. button	按钮控件
        ```html
        <button></button>
        ```
		    属性
		    name	控件名称
		    value	控件初始值
		    type	控件类型
			    button	普通按钮
			    submit	提交按钮
			    reset	重置按钮		
         ```html
            图片按钮
                <button><img src="" alt=""></button>
        ```
	    4. select	下拉列表
        ```html
            <select name="" id="">
                <option value="向服务器提交的值">显示的值</option>
                <option>如果没有value属性，提交本段文本</option>
            </select>
        ```
		    属性
		    name:		控件名称
		    size:		列表框中行的显示数量
		    multiple:	是否允许多选
                multiple="multiple"
                如果select元素不包含属性size和属性multiple时，表单类型显示为菜单（组合框）
                如果使用了属性size和属性multiple中的任意一个，则表单类型显示为列表框
            selected:	默认选中

            option	下拉列表选项
            属性：
            value:	定义控件的初始值。提交表单时，初始值会被提交给服务器。
            selected="selected"：默认选中。
            optgroup	分组选项
        ```html
            <select name="" id="">
                <optgroup label="大洋">
                    <option value="">太平洋</option>
                    <option value="">大西洋</option>
                    <option value="">印度洋</option>
                </optgroup>
                <optgroup label="大海">
                    <option value="">东海</option>
                    <option value="">南海</option>
                    <option value="">渤海</option>
                </optgroup>
            </select>
        ```
	    5. textarea	多行文本框

		    属性
		    name:	控件名称
		    rows:	定义文本框行数
		    cols:	定义文本框列数
            ```html
		    <textarea>这里输入默认值</textarea>
            ```
	    6. label	为表单控件定义标签
        ```
	        label 元素不会向用户呈现任何特殊效果。不过，它为鼠标用户改进了可用性。如果您在 label 元素内点击文本，就会触发此控件。就是说，当用户选择该标签时，浏览器就会自动将焦点转到和标签相关的表单控件上。<label> 标签的 for 属性应当与相关元素的 id 属性相同。<label for="控件id名称">

        <table>
            <tr>
                <td><label for="username">用户名：</label></td>
                <td><input type="text" id="username" name="username"></td>
            </tr>
            <tr>
                <td><label for="passwold">密码：</label></td>
                <td><input type="password" id="password" name="password"></td>
            </tr>
        </table>
        ```
	    7. fieldset	为表单添加结构

            一般与legend元素配合使用，fieldset元素可以包含其他的表单控件，在这些表单控件周围画一个方框，而legend元素可以显示一个标签说明被包含的这些表单控件。
        ```html
        <fieldset>
            <legend>健康信息：</legend>
            <form>
                <label>身高：<input type="text" /></label>
                <label>体重：<input type="text" /></label>
            </form>
        </fieldset>
        ```
	    8. 其他控件特性
        
                disabled	禁用

                支持该属性的控件：
                    button,input,optgroup,option,select,textarea
			        1）禁止的元素不接受焦点
			        2）禁止的控件的值不与表单一起被提交
		        readonly	只读

			    支持该属性的控件：
                    input,textarea
			        1）可以接受焦点，但是不能被用户修改
			        2）只读元素的值可以与表单一起被提交。