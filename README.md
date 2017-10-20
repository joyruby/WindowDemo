# WindowDemo
## 简介
一个实现类似微博下面加号功能的demo（模仿https://github.com/MjCodeTinker/WindowMenuDemo）：

- recycleview实现的首页
- 点击+，出现浮层页面

## 布局

-  首页：
    1. 使用recyview实现顶部一个大照片加下面多个列表
    2. 底导5个tag，其中中间是加号。使用android:layout_weight="1"是的5个tag的宽度平均分布

- 浮层：
   1. 从上往下，一个图片，一个texview，然后是8个tag，下面一个加号。
   2. 加号的位置和首页加号的位置重叠。

## 动画效果：
  1. 加号旋转：点击首页的加号，浮层出现，浮层的加号旋转成×。
  2. 点击浮层的×，旋转成加号，浮层消失。
  3. 8个tag动画，从顶部浮出。

## 坑：
  1. getActionBar()报空，改成getSupportActionBar();
  2. WindowManager.LayoutParams，设置了MATCH_PARENT或者WRAP_CONTENT,浮层会覆盖actionabr。这里希望浮层只覆盖内容区域。设置高度是ID_ANDROID_CONTENT区域的高度就ok。
    
