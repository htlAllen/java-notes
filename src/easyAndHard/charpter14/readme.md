## java之collection
#### collection中接口常见方法

1. 接口：collection

方法 | 描述
------------ | -------------
size() | 返回集合的大小
isEmpty() | 判断集合是否为空
contains(object o) | 判断是否包含某个对象
iterator() | 返回迭代器
add(E e) | 向集合中添加元素
remove(object o) | 向集合中删除元素
Object[] toArray() | 不知道
> 注：一个类要实现一个接口，则是实现接口中所声明的所有方法。那重载呢？

2. 接口： set

set接口中方法几乎与collection中的相同

3. 接口： list

方法 | 描述
------------ | -------------
get(int index) | 返回索引处的对象
set(int index, E element)| 给索引处添加值
int  indexOf(Object o) | 获取对象所在的索引
List<E> subList(int fromIndex, int toIndex) | 略
int lastIndexOf(Object o) | 略
default void sort(Comparator<? super E> c)  | 略

> 注： 与collection接口对比，最重要的是多出了索引的概念

4. 接口： queue

方法 | 描述
------------ | -------------
E element() |  返回队头元素，若空，则异常
E peek() | 返回队头元素，若空，则返回null
boolean offer(E e) | 添加一个元素，返回true，若满，则返回false
E poll() | 移除并且返回队列头元素，若空，则返回null

> 注： queue中通常用offer，poll方法来增减元素，而不用add, remove方法来添加或减少元素，因为前者不
> 抛出异常，而后者抛出异常。 queue的方法很具有迭列的特征

5. 接口： map

方法 | 描述
------------ | -------------
int size() |  略
boolean isEmpty() | 略
boolean containsKey(Object key) |  略
boolean containsValue(Object value) | 略
V get(Object key) |  略
V put(K key V value ) | 略
V remove(Object key) | 略
Set<K> keySet(); |  略
Set<Map.Entry<K, V>> entrySet() | 略

>注：同理， map接口又很具有hash的特征

#### 集合中常见的实现类

1.List

1.1 ArrayList:对数据进行了封装

1.2 LinkedList:实现了链表的数据结构


---
#### 小结:
1. 理解了集合中常见的接口及其对应的方法
2. 理解的ArrayList和LinkedList的实现原理，前者基于数组，后者基于链表
#### 问题：
1. 内部类（接口）？？
2. HashMap,TreeMap,HashSet,TreeSet还不理解
3. ArrayList,LinkedList,HashMap,TreeMap,HashSet,TreeSet这几个方法的总结
