# Runnable 和 Callable 区别
- Runnabled 没有返回值
- Runnabled 不能进行checked Exception
|对比内容          | Runnabled  | Callable |
|  -------------  | ------------- |
| 方法名   |   run   |     call  |
| 返回值   |   无   |       有   |
| 返回异常 |   无   |       有   |

# Future类的主要功能
Future future = executionService.submit(Callable)
future.get() ==> 获取对应的返回结果
isDone() 方法，判断是否执行完毕(包含异常也会返回true)


# 线程的几种状态
- NEW
- Runnable
- Terminated
- wait
- TimeWait
- Blocked





