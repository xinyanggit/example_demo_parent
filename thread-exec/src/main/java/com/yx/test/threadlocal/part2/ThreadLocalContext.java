package com.yx.test.threadlocal.part2;

/**
 * @author yangxin
 * @date 2021年02月03日
 * @time 2:13 下午
 * @since JDK1.8
 */
public class ThreadLocalContext {

    public static void main(String[] args) {
        Filter filter = new Filter();
        filter.process();
        // 需要调用 remove方法，防止内存泄漏
        UserHoldContext.userContext.remove();
        UserHoldContext.personContext.remove();
    }
}
class Filter{
    public void process(){
        User user = new User();
        user.setName("this is yx do thing ,");
        UserHoldContext.userContext.set(user);
        System.out.println("process");
        // 可以查看 ThreadLocal Thread ThreadLocalMap 对象之间的关系
        Person person = new Person(1);
        UserHoldContext.personContext.set(person);
        Service1 service1 = new Service1();
        service1.test1();
    }
}
class Service1 {
    public void test1() {
        User user = UserHoldContext.userContext.get();
        System.out.println("test1"+user.getName());
        Service2 service2 = new Service2();
        service2.test2();
    }
}

class Service2 {
    public void test2() {
        Service3 service3 = new Service3();
        User user = UserHoldContext.userContext.get();
        System.out.println("test2"+user.getName());
        service3.test3();
    }
}

class Service3 {
    public void test3() {
        User user = UserHoldContext.userContext.get();
        System.out.println(" test3"+user.getName());
        System.out.println("test3");
    }
}

class UserHoldContext {
    public  static ThreadLocal<User> userContext = ThreadLocal.withInitial(() -> {
        System.out.println("创建user对象");
        return new User();
    });
    public static ThreadLocal<Person> personContext = new ThreadLocal<Person>();
}
class Person{
    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }
}
