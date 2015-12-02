# Cheese
一个符合material design的app by android，练习了design包的各种控件。

###结合之前写的那个知乎日报，练习了design包中的很多控件。
>这个app使用了：
1.CoordinatorLayout
2.AppBarLayout
3.CollapsingToolbarLayout
4.NestedScrollView
5.CardView
6.FloatingActionButton
7.SnakeBar
8.NavigationView
9.DrawerLayout
10.TabLayout

写的过程中，因为加载的图片特别大，最开始使用fresco加载，界面卡的爆炸。后来改用参考代码的glide来加载图片才使界面正常。算是遇到了一个坑吧。

###依赖：
```
    compile 'com.android.support:appcompat-v7:23.1.0'
    compile 'com.android.support:design:23.1.0'
    compile 'com.android.support:cardview-v7:23.1.0'
    compile 'com.android.support:recyclerview-v7:23.1.0'
    compile 'com.jakewharton:butterknife:7.0.1'
    compile 'com.github.bumptech.glide:glide:3.6.1'
    compile 'de.hdodenhof:circleimageview:2.0.0'
```
