# Linux에서 Thread 설정

Linux에서 Open File Descriptors, Max User Processes, Thread의 차이에 대한 실험


![ulimit](./images/ulimit.png)


## 1. Thread

## 2. Socket

### Tomcat 설정

> Tomcat은 다음 두 가지 모드로 작동 할 수 있습니다.  
BIO (연결 당 하나의 스레드) 또는 NIO (스레드보다 더 많은 연결).  
Tomcat7은 기본적으로 BIO(Blocking IO)이지만, "모든면에서 NIO (NonBlocking IO)가 더 뛰어나므로 Bio를 사용하지 마십시오"라고 생각됩니다.  
만약 BIO를 사용한다면, 2개 설정은 동일해야합니다.  
NIO를 사용한다면 실제로 "maxConnections = 1000"과 "maxThreads = 10"이 합리적 일 수 있습니다.  
기본값은 maxConnections = 10,000 및 maxThreads = 200입니다.  
NIO를 사용하면 각 스레드는 원하는 수만큼의 연결을 처리 할 수 있습니다.  
앞뒤로 전환하면서 연결을 유지하므로 HTTPS의 경우 특히 많은 시간이 소요되는 일반적인 핸드 셰이 킹을 수행 할 필요가 없으며 HTTP의 경우에도 문제가 발생합니다.  
"keepAlive"매개 변수를 조정하여 연결을 오래 유지하면 모든 작업의 속도가 빨라집니다.