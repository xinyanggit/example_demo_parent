# ThreadLocal的应用场景-有两个
- 场景1：保存每个线程独享的对象，为每个线程创建一个副本，这样每个线程可以修改自己所拥有的副本了
- 场景2：每个线程内的需要独立保存信息，以便其他方法可以方便的获取

场景1：
 典型的用法就是 SimpleDateFormat 对象
 在多线程中，没有必要每次都创建一个新的SimpleDateFormat，只需要为每个线程分配一个即可。可以引入threadLocal创建副本对象
 `com.yx.test.threadlocal.part1.ThreadLocalDemo04 ` 可以查看实现
场景2:
 保存每个线程分配的对象、类似于全局对象一样。比如我们在拦截器里面获取的userId,userType 
在后面的方法中也是需要调用，一般的处理方式，是直接透传、封装成一个map参数传递
其实这时候我们可以采用threadLocal进行透传,demo 如下
com.yx.test.threadlocal.part2.ThreadLocalContext

# Thread、ThreadLocalMap、ThreadLocal
每个Thread中都有一个ThreadLocalMap对象，一个ThreadLocalMap对象中有多个ThreadLocal,
key: ThreadLocal value 为存储的对象， 比如 User、Option

