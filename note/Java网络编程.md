# Java网络编程

1. TCP/IP
2. URL
3. UDP
4. http
5. Json

## 计算机网络
所谓计算机网络，是指将地理信息位置不同具有独立功能的多台计算机及其外部设备，



一个计算机网络组成包括传输介质和通信设备。
网络类型划分：局域网、城域网、广域网、互联网
网络分层：
	应用层
	表示层               应用层
	会话层
	传输层               传输层
	网络层               网络层
	数据链路层
	物理层               物理和链路层

网络编程三要素：协议、IP地址、端口号
IP地址：网协地址
	192.168.10.1：IP V4   32位
	127.0.0.1：指代本机的ip地址
	localhost：指代本机的ip地址
	Tomcat

	6c:40:08:b1:c8:48       IP V6  128位   V----version
	在Java中用InetAdress类来表示

端口：设备与外界通信交流的接口
协议：
	http:超文本传输协议
	https：用安全套接字层传达的超文本传输协议
	TCP：面向连接，传输可靠(三次握手，四次挥手)
		ServerSocket
		Socket
	UDP：面向非连接，传输不可靠，易掉包，用于传输少量数据，速度快
	发送包                               接收端
	DatagramSocket
	DatagramPackte  数据报包
	URLConnection
		URL：统一资源定位符，更多用于互联网
		URI：统一资源标识符，

Json/Gson、FastJson