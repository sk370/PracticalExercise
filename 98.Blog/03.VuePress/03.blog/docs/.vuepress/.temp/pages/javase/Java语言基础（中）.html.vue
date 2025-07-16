<template><div><h2 id="第8章-多线程基础" tabindex="-1"><a class="header-anchor" href="#第8章-多线程基础" aria-hidden="true">#</a> 第8章 多线程基础</h2>
<h3 id="_8-1-基本概念" tabindex="-1"><a class="header-anchor" href="#_8-1-基本概念" aria-hidden="true">#</a> 8.1 基本概念</h3>
<h4 id="_8-1-1-程序、进程、线程" tabindex="-1"><a class="header-anchor" href="#_8-1-1-程序、进程、线程" aria-hidden="true">#</a> 8.1.1 程序、进程、线程</h4>
<ol>
<li>程序（program）：完成特定任务、用某种语言编写的指令集合。是一段静态的代码。</li>
<li>进程（process）：程序的一次执行过程，或者正在运行的一个程序。
<ul>
<li>进程是系统分配资源的基本单位，根据进程执行的生命周期，系统会为不同时期的进程分配不同的内存空间。</li>
</ul>
</li>
<li>线程（thread）：程序内部的一条执行路径，一个进程可以含有多个进程。
<ul>
<li>如果一个进程可以<strong>并行</strong>执行多个线程，则进程支持多线程。</li>
<li>每个线程拥有独立的运行栈和程序计数器。</li>
<li>同一进程的多个线程共享相同的堆空间（对象、属性共享）、方法区，优点是线程间通信更便捷、高效，但多个线程同时操作公共资源会有安全隐患。</li>
</ul>
</li>
<li>Java中线程的分类（区别在于JVM何时离开）：
<ul>
<li>守护线程：服务用户线程，通过在start()方法前调用<code v-pre>thread.setDaemon(true)</code>可以把一个用户线程变成守护线程。
<ul>
<li>垃圾回收是一个典型的守护线程</li>
<li>JVM中都是守护线程时，JVM就会退出。</li>
</ul>
</li>
<li>用户线程：</li>
</ul>
</li>
</ol>
<h4 id="_8-1-2-单核、多核" tabindex="-1"><a class="header-anchor" href="#_8-1-2-单核、多核" aria-hidden="true">#</a> 8.1.2 单核、多核</h4>
<ol>
<li>单核：CPU仅有一个核心数，同一时间内，只能执行一个线程任务。执行多个线程时，采取的是不断切换线程的方式。
<ul>
<li>由于CPU频率高、线程切换时间短，让人感觉”同时“执行了多个线程</li>
</ul>
</li>
<li>多核：CPU有多个核心，每个核心可以执行一个线程。</li>
<li>java.exe：一个Java运行程序至少有3个线程：
<ul>
<li>main()：主线程</li>
<li>gc()：垃圾回收线程</li>
<li>异常处理线程：发生异常时，会影响主线程。</li>
</ul>
</li>
</ol>
<h4 id="_8-1-3-并行、并发" tabindex="-1"><a class="header-anchor" href="#_8-1-3-并行、并发" aria-hidden="true">#</a> 8.1.3 并行、并发</h4>
<ol>
<li>并行：多个CPU执行多个任务。</li>
<li>并发：一个CPU同时执行多个任务。</li>
</ol>
<h3 id="_8-2-创建多线程" tabindex="-1"><a class="header-anchor" href="#_8-2-创建多线程" aria-hidden="true">#</a> 8.2 创建多线程</h3>
<h4 id="_8-1-方式一-继承thread类" tabindex="-1"><a class="header-anchor" href="#_8-1-方式一-继承thread类" aria-hidden="true">#</a> 8.1 方式一：继承Thread类</h4>
<ol>
<li>创建步骤：
<ul>
<li>定义子类继承Thread类</li>
<li>子类中重写Thread类中run()方法</li>
<li>创建Thread子类对象
<ul>
<li>创建一个对象即代表开启一个线程，要开启多个该线程，需要创建多个该对象。</li>
</ul>
</li>
<li>调用子类对象的start()方法。</li>
</ul>
</li>
<li>注意点：
<ul>
<li>使用Tread子类对象直接调用<code v-pre>run()</code>方法不会开启分支线程，它表示在main线程内，调用了Thread子类对象的方法。</li>
<li>使用Thread子类对象调用<code v-pre>start()</code>方法会开启一个线程，开启线程后<code v-pre>run()</code>方法何时执行全由CPU调度决定，即main线程和分支线程中的语句执行具有随机性。</li>
<li>一个实例化的Thread子类对象只能调用一次<code v-pre>star()</code>方法，重复调用时，会抛出异常：IllegalThreadStateException。</li>
</ul>
</li>
<li>常用方法：
<ul>
<li><code v-pre>start()</code>：启动当前线程；调用当前线程的run()方法</li>
<li><code v-pre>run()</code>：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中</li>
<li><code v-pre>currentThread()</code>：静态方法，返回执行当前代码的线程</li>
<li><code v-pre>getName()</code>：获取当前线程的名字</li>
<li><code v-pre>setName(&quot;str&quot;)</code>：设置当前线程的名字</li>
<li><code v-pre>yield()</code>：释放调用线程在cpu中的执行权，后续执行哪个线程由CPU确定，有可能还是这个线程。当前进程进入就绪状态。</li>
<li><code v-pre>join()</code>：在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
<ul>
<li>有异常问题，可以根据使用位置进行throws或try-catch处理。</li>
</ul>
</li>
<li><code v-pre>~~stop()~~</code><s>：已过时。当执行此方法时，强制结束当前线程。</s></li>
<li><code v-pre>sleep(long millitime)</code>：让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
<ul>
<li>有异常问题，由于该方法使用在<code v-pre>run()</code>方法中，而<code v-pre>run()</code>方法是对父类Thread中<code v-pre>run()</code>方法的重写，且Thread中<code v-pre>run()</code>方法没有抛出异常，根据继承的特性（子类的异常不大于父类），所以子类的<code v-pre>run()</code>方法不能抛出异常，只能由try-catch处置。</li>
</ul>
</li>
<li><code v-pre>isAlive()</code>：判断当前线程是否存活。</li>
</ul>
</li>
<li>线程优先级：
<ul>
<li>等级：
<ul>
<li><code v-pre>MAX_PRIORITY</code>：10</li>
<li><code v-pre>MIN _PRIORITY</code>：1</li>
<li><code v-pre>NORM_PRIORITY</code>：5 （默认等级）</li>
</ul>
</li>
<li>方法：
<ul>
<li><code v-pre>getPriority()</code>：返回线程优先等级</li>
<li><code v-pre>setPriority(int num)</code>：设置有限等级</li>
</ul>
</li>
<li>注意点：设置了高等级的优先级，并不代表一定执行完该线程后执行其他线程，而是提高了CPU执行该线程的概率而已。</li>
</ul>
</li>
<li>Thread类构造器
<ul>
<li><code v-pre>Thread()</code>：</li>
<li><code v-pre>Thread(String threadname</code>)：创建指定名称的线程
<ul>
<li>搭配<code v-pre>super(threadname)</code>才能在getName()时获得名字</li>
</ul>
</li>
<li><code v-pre>Thread(Runnable target)</code>：</li>
<li><code v-pre>Thread(Runnable target, String name)</code>：</li>
</ul>
</li>
</ol>
<h4 id="_8-2-2-方式二-实现runnable接口" tabindex="-1"><a class="header-anchor" href="#_8-2-2-方式二-实现runnable接口" aria-hidden="true">#</a> 8.2.2 方式二：实现Runnable接口</h4>
<ol>
<li>创建步骤：
<ul>
<li>定义类，实现Runnable接口。</li>
<li>实现类中实现Runnable接口中的run方法</li>
<li>创建实现类对象</li>
<li>创建Thread类对象，将实现类对象作为参数传入。</li>
<li>使用Thread类的对象调用<code v-pre>start()</code>方法。</li>
</ul>
</li>
<li>两种方式比较：
<ul>
<li>相同点：
<ul>
<li>实现类（继承类）都需要重写<code v-pre>run()</code></li>
<li>都具有线程安全问题</li>
</ul>
</li>
<li>不同点：
<ul>
<li>方式二没有单继承的局限性</li>
<li>方式二更适合多个线程共享数据（数据只有一份）的情况</li>
</ul>
</li>
<li>开发中优先选择方式二</li>
</ul>
</li>
</ol>
<h4 id="_8-2-3-方式三-实现callable接口" tabindex="-1"><a class="header-anchor" href="#_8-2-3-方式三-实现callable接口" aria-hidden="true">#</a> 8.2.3 方式三：实现Callable接口</h4>
<ol>
<li>创建步骤：
<ul>
<li>创建一个实现Callable的实现类</li>
<li>实现call方法，将此线程需要执行的操作声明在call()中</li>
<li>创建Callable接口实现类的对象</li>
<li>创建FutureTask的对象，将此Callable接口实现类的对象作为传递到FutureTask构造器中</li>
<li>创建Thread对象，将FutureTask的对象作为参数传递到Thread类的构造器中，Thread的对象调用start()</li>
<li>FutureTask的实例对象调用get()方法，获取重写call方法的返回值。</li>
</ul>
</li>
<li>Callable的优点：
<ul>
<li>call()可以返回值的。</li>
<li>call()可以抛出异常，被外面的操作捕获，获取异常的信息。</li>
<li>Callable是支持泛型</li>
</ul>
</li>
</ol>
<h4 id="_8-2-4-方式四-使用线程池-threadpool" tabindex="-1"><a class="header-anchor" href="#_8-2-4-方式四-使用线程池-threadpool" aria-hidden="true">#</a> 8.2.4 方式四：使用线程池（ThreadPool）</h4>
<ol>
<li>创建步骤：
<ul>
<li>提供指定线程数量的线程池：<code v-pre>ExecutorService service = Executors.newFixedThreadPool(10);</code>
<ul>
<li><code v-pre>service1.setCorePoolSize(15)</code></li>
<li><code v-pre>service1.setKeepAliveTime()</code></li>
</ul>
</li>
<li>执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
<ul>
<li><code v-pre>service.execute(Runnable runable)</code></li>
<li><code v-pre>service.submit(Callable callable)</code></li>
</ul>
</li>
<li>关闭连接池：<code v-pre>service.shutdown()</code></li>
</ul>
</li>
<li>优点：
<ul>
<li>提高响应速度（减少了创建新线程的时间）</li>
<li>降低资源消耗（重复利用线程池中线程，不需要每次都创建）</li>
<li>便于线程管理：
<ul>
<li>corePoolSize：核心池的大小</li>
<li>maximumPoolSize：最大线程数</li>
<li>keepAliveTime：线程没任务时最多保持多长时间后会终止</li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_8-3-线程的生命周期" tabindex="-1"><a class="header-anchor" href="#_8-3-线程的生命周期" aria-hidden="true">#</a> 8.3 线程的生命周期</h3>
<ol>
<li>新建：
<ul>
<li>继承方式（方式一）：Thread类子类的对象被创建。</li>
<li>实现方式（方式二）：Thread类声明并创建。</li>
</ul>
</li>
<li>就绪：处于新建状态的线程调用start()后，将进入线程队列等待CPU时间片，此时它已具备了运行的条件，只是没分配到CPU资源</li>
<li>运行：当就绪的线程被调度并获得CPU资源时,便进入运行状态。</li>
<li>阻塞：线程被人为挂起或执行输入输出操作时，会让出 CPU资源，并临时中止自己的执行，即进入阻塞状态。
<ul>
<li>阻塞时临时状态，不可以作为最终状态。</li>
</ul>
</li>
<li>死亡：线程完成了它的全部工作、线程被提前强制性地中止、出现异常导致结束。
<ul>
<li>死亡是线程的最终状态。</li>
</ul>
</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1653836015171-901ca9fc-4ab6-47b3-a596-856ce3160386.png#clientId=uaef2fce3-b61a-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=229&amp;id=u7883449d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=286&amp;originWidth=607&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=59033&amp;status=done&amp;style=none&amp;taskId=u879ed1da-c9ab-4446-b06a-af6b7f4f62a&amp;title=&amp;width=485.6" alt="image.png" loading="lazy"></p>
<h3 id="_8-4-线程安全" tabindex="-1"><a class="header-anchor" href="#_8-4-线程安全" aria-hidden="true">#</a> 8.4 线程安全</h3>
<h4 id="_5-4-1-线程安全问题——同步机制" tabindex="-1"><a class="header-anchor" href="#_5-4-1-线程安全问题——同步机制" aria-hidden="true">#</a> 5.4.1 线程安全问题——同步机制</h4>
<ol>
<li>线程安全问题：未处理的多线程任务在处理共享数据时，会造成数据破坏（重复数据、缺失数据、数据超范围等）。
<ul>
<li>原因：处理共享数据的情况时，一个线程多条语句只执行了一部分，未处理完时，另一个线程参与进来，也要处理共享数据，造成共享数据错误。</li>
<li>解决办法：单线程处理数据，执行完后再让其他线程参与——<strong>同步机制</strong>。</li>
<li>解决原理：给共享资源加锁，第一个访问资源的线程进行资源锁定，在解锁之前其他线程无法访问，解锁之后，其他线程可以锁定并使用。</li>
</ul>
</li>
</ol>
<h4 id="_8-4-2-synchronized处理线程安全问题" tabindex="-1"><a class="header-anchor" href="#_8-4-2-synchronized处理线程安全问题" aria-hidden="true">#</a> 8.4.2 Synchronized处理线程安全问题</h4>
<ol>
<li>Synchronized（同步）语法：
<ul>
<li>同步代码块：<code v-pre>synchronized(同步监视器){}</code></li>
<li>同步方法：<code v-pre>public synchronized void show(){}</code></li>
</ul>
</li>
<li>Synchronized细节：
<ul>
<li>同步监视器必须唯一。</li>
<li>同步代码块：同步监视器可设置为<code v-pre>类名.class</code>、<code v-pre>this</code>、任一对象（静态或非静态），取决于是否唯一。</li>
<li>同步方法：静态方法同步监视器默认为<code v-pre>类名.class</code>，非静态方法同步监视器默认为<code v-pre>this</code></li>
</ul>
</li>
<li>同步监视器一般情况：
<ul>
<li>在实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器。</li>
<li>在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。</li>
</ul>
</li>
</ol>
<h4 id="_8-4-3-死锁及lock处理线程安全问题" tabindex="-1"><a class="header-anchor" href="#_8-4-3-死锁及lock处理线程安全问题" aria-hidden="true">#</a> 8.4.3 死锁及lock处理线程安全问题</h4>
<ol>
<li>死锁：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源。
<ul>
<li>出现死锁后，不会出现异常、不会出现提示、程序也不会运行，处于阻塞状态，无法继续。</li>
</ul>
</li>
<li>Lock（JDK5.0新增）：
<ul>
<li>引入<code v-pre>java.util.concurrent.locks.ReentrantLock;</code>包
<ul>
<li><code v-pre>java.util.concurrent.locks.Lock</code>接口是控制多个线程对共享资源进行访问的工具。</li>
<li><code v-pre>ReentrantLock</code>类实现了 Lock。</li>
</ul>
</li>
<li>创建<code v-pre>ReentrantLock</code>对象：<code v-pre>private ReentrantLock lock = new ReenTrantLock();</code>
<ul>
<li>根据对象是否唯一（lock是否唯一），可以在声明时使用static、或static final修饰。</li>
</ul>
</li>
<li>在出现共享资源操作的代码前调用<code v-pre>lock()</code>方法</li>
<li>在结束共享资源操作的代码后调用<code v-pre>unlock()</code>方法
<ul>
<li>如果操作资源共享的代码需要使用try包裹，则必须把<code v-pre>unlock()</code>写入finally语句块，<code v-pre>lock()</code>则不是必须要写入try中</li>
</ul>
</li>
</ul>
</li>
<li>synchronized与Lock的异同：
<ul>
<li>相同：二者都可以解决线程安全问题</li>
<li>不同：
<ul>
<li>synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器。</li>
<li>Lock需要手动的启动同步，同时结束同步也需要手动的实现。</li>
</ul>
</li>
</ul>
</li>
<li>使用的优先顺序：Lock ---&gt; 同步代码块（已经进入了方法体，分配了相应资源 ) ---&gt;同步方法（在方法体之外)
<ul>
<li>同步代码块包裹的共享资源操作代码可以更小。</li>
</ul>
</li>
</ol>
<h4 id="_8-4-4-同步的深入理解" tabindex="-1"><a class="header-anchor" href="#_8-4-4-同步的深入理解" aria-hidden="true">#</a> 8.4.4 同步的深入理解</h4>
<ol>
<li>同步的范围：
<ul>
<li>确定同步代码范围时，要将所有操作共享数据的语句包裹在内。</li>
<li>范围太大：操作数据的语句变为单线程的，没有发挥多线程的功能。</li>
<li>范围太小：操作共享数据的语句由遗漏，同步不起作用。</li>
</ul>
</li>
<li>同步的问题：
<ul>
<li>优点：解决了线程安全的问题。</li>
<li>缺点：操作同步代码时，只有一个线程运行，其他线程等待，相当于单线程过程，效率低。</li>
</ul>
</li>
<li>释放锁的操作：
<ul>
<li>同步方法、同步代码块执行结束</li>
<li>同步方法、同步代码块中遇到break、return</li>
<li>同步方法、同步代码块中出现未处理的Error或Exception</li>
<li>同步方法、同步代码块中执行了线程对象的<code v-pre>wait()</code></li>
</ul>
</li>
<li>不会释放锁的操作:
<ul>
<li>同步方法、同步代码块中调用<code v-pre>Thread.sleep()</code>、<code v-pre>Thread.yield()</code>方法暂停当前线程的执行</li>
<li>其他线程调用了当前执行线程的<code v-pre>suspend()</code>方法将该线程挂起。
<ul>
<li>应尽量避免使用<code v-pre>suspend()</code>和<code v-pre>resume()</code>控制线程。</li>
</ul>
</li>
</ul>
</li>
<li>线程安全的懒汉式单例模式</li>
</ol>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">class</span> <span class="token class-name">Singleton</span> <span class="token punctuation">{</span>
    <span class="token keyword">private</span> <span class="token keyword">static</span> <span class="token class-name">Singleton</span> instance <span class="token operator">=</span> <span class="token keyword">null</span><span class="token punctuation">;</span>
    <span class="token keyword">private</span> <span class="token class-name">Singleton</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>    <span class="token punctuation">}</span>
    <span class="token comment">//  1. 方式一</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token class-name">Singleton</span> <span class="token function">getInstance</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">if</span> <span class="token punctuation">(</span>instance <span class="token operator">==</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">synchronized</span> <span class="token punctuation">(</span><span class="token class-name">Singleton</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                <span class="token keyword">if</span> <span class="token punctuation">(</span>instance <span class="token operator">==</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                    instance <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Singleton</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
                <span class="token punctuation">}</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">return</span> instance<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
    <span class="token comment">//  2. 方式二</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token class-name">Singleton</span> <span class="token function">getInstance</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
        <span class="token keyword">synchronized</span> <span class="token punctuation">(</span><span class="token class-name">Singleton</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
            <span class="token keyword">if</span> <span class="token punctuation">(</span>instance <span class="token operator">==</span> <span class="token keyword">null</span><span class="token punctuation">)</span> <span class="token punctuation">{</span>
                instance <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Singleton</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
            <span class="token punctuation">}</span>
        <span class="token punctuation">}</span>
        <span class="token keyword">return</span> instance<span class="token punctuation">;</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>
</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><ul>
<li>方式一效率优于方式二，假如有n个线程需要创建当前对象，多核CPU让k个线程运行到<code v-pre>getInstance()</code>：
<ul>
<li>方式一中共有k个线程判断对象是否等于null，1个线程执行同步代码块并创建对象，k-1个线程执行同步代码块结束判断，后续n-k个线程不会再进入同步代码块。</li>
<li>方式二中共有1个线程执行同步代码块并创建对象，k-1个线程执行同步代码块结束判断，后续n-k个线程还会执行同步代码块进行判断。</li>
</ul>
</li>
</ul>
<h3 id="_8-5-线程通信" tabindex="-1"><a class="header-anchor" href="#_8-5-线程通信" aria-hidden="true">#</a> 8.5 线程通信</h3>
<ol>
<li><code v-pre>wait()</code>：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。</li>
<li><code v-pre>notify()</code>：一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，由JVM决定执行哪个。</li>
<li><code v-pre>notifyAll()</code>：一旦执行此方法，就会唤醒所有被wait的线程。</li>
<li>说明：
<ul>
<li>三个方法必须使用在同步代码块或同步方法中。</li>
<li>三个方法的调用者必须是同步代码块或同步方法中的同步监视器。否则，会出现IllegalMonitorStateException异常</li>
<li>三个方法是定义在java.lang.Object类中。</li>
</ul>
</li>
<li>sleep() 和 wait()的异同
<ul>
<li>相同点：
<ul>
<li>都可以使当前进程进入阻塞状态</li>
</ul>
</li>
<li>不同点：
<ul>
<li>声明位置不同：<code v-pre>slee()</code>声明在Thread类中，<code v-pre>wait()</code>声明在Object类中。</li>
<li>调用要求不同：<code v-pre>slee()</code>可以在任何需要的场景下调用，<code v-pre>wait()</code>必须在同步方法、同步代码块中调用。</li>
<li><code v-pre>sleep()</code>不会释放同步监视器、<code v-pre>wait()</code>会释放同步监视器。</li>
</ul>
</li>
</ul>
</li>
</ol>
<h2 id="第9章-集合" tabindex="-1"><a class="header-anchor" href="#第9章-集合" aria-hidden="true">#</a> 第9章 集合</h2>
<h3 id="_9-1-概念" tabindex="-1"><a class="header-anchor" href="#_9-1-概念" aria-hidden="true">#</a> 9.1 概念</h3>
<ul>
<li>用于存储数量不等的多个对象、具有映射关系的关联数组。</li>
</ul>
<h3 id="_9-2-集合框架体系" tabindex="-1"><a class="header-anchor" href="#_9-2-集合框架体系" aria-hidden="true">#</a> 9.2 集合框架体系</h3>
<ol>
<li>单列集合（Collection）：存放单个对象，有两个重要的子接口，其实现子类都是单列集合。
<ul>
<li>List：
<ul>
<li>ArrayList</li>
<li>Vector</li>
<li>LinkedList</li>
</ul>
</li>
<li>Set：
<ul>
<li>HashSet
<ul>
<li>LinkedHashSet</li>
</ul>
</li>
<li>TreeSet</li>
</ul>
</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654514251701-7d7f63b3-98ef-441d-95e0-07d7c40712a7.png#clientId=u429de258-15ff-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=283&amp;id=u3b2e39b4&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=750&amp;originWidth=2408&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=45621&amp;status=done&amp;style=stroke&amp;taskId=ud1d94e4b-7aeb-46a9-8be8-2f1eeac7b68&amp;title=&amp;width=909" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>双列集合（Map）：存放k-v形式的数据
<ul>
<li>Hashtable
<ul>
<li>Properties</li>
</ul>
</li>
<li>HashMap
<ul>
<li>LinkedHashMap</li>
</ul>
</li>
<li>TreeMap</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654426587220-d86bc8d2-df48-4599-ad3e-47710c1c8a7d.png#clientId=u15a6678f-ac90-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=0.5142&amp;from=paste&amp;height=340&amp;id=u13a00508&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=668&amp;originWidth=1366&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=20885&amp;status=done&amp;style=none&amp;taskId=u03ade233-7cef-485f-8770-2525f781a73&amp;title=&amp;width=695" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h3 id="_9-3-collection" tabindex="-1"><a class="header-anchor" href="#_9-3-collection" aria-hidden="true">#</a> 9.3 Collection</h3>
<h4 id="_9-3-1-collection接口的特点" tabindex="-1"><a class="header-anchor" href="#_9-3-1-collection接口的特点" aria-hidden="true">#</a> 9.3.1 Collection接口的特点</h4>
<ol>
<li>Collection接口没有直接的实现子类，是通过它的子接口Set和List实现的。</li>
<li>Collection实现子类可以存放多个元素，每个元素可以是Object</li>
<li>Collection的实现类，List是有序的，Set不是有序的</li>
<li>Collection的实现类，有的可以存放重复的元素，有的不可以</li>
</ol>
<h4 id="_9-3-2-collection接口实现类遍历元素方式" tabindex="-1"><a class="header-anchor" href="#_9-3-2-collection接口实现类遍历元素方式" aria-hidden="true">#</a> 9.3.2 Collection接口实现类遍历元素方式</h4>
<ol>
<li>Tterator（迭代器）：
<ul>
<li>所有实现了Collection接口的集合类都有一个<code v-pre>iterator()</code>方法，用以返回一个迭代器</li>
<li>Iterator仅用于集合遍历，本身并不存放对象。</li>
<li>使用流程：
<ul>
<li>创建迭代器：<code v-pre>Iterator it = 集合对象.iterator()</code></li>
<li>遍历对象：<code v-pre>while(it.hasNext()){it.next()}</code>
<ul>
<li>使用<code v-pre>it.next()</code>之前必须使用<code v-pre>hasNext()</code>方法进行判断，否则在调用完最后一条时会抛出<code v-pre>NoSuchElementException</code>异常。</li>
<li>while循环结束后，迭代器指向集合中最后一个元素，如果再调用<code v-pre>next()</code>方法，会抛出异常，如果希望再次遍历，则需要重置迭代器：<code v-pre>it = 集合对象.iterator()</code></li>
</ul>
</li>
<li>IDEA快捷模板：<code v-pre>itit</code>，<code v-pre>Ctrl+j</code>显示所有的快捷模板</li>
</ul>
</li>
</ul>
</li>
<li>增强for循环：
<ul>
<li>语法：<code v-pre>for( 元素类型 元素名 : 集合名或数组名){ 访问元素 }</code></li>
<li>只能用于遍历集合和数组。</li>
<li>本质就是简化版的迭代器（底层代码）。</li>
</ul>
</li>
<li>不可用普通for循环，因为子接口Set不支持索引</li>
</ol>
<h3 id="_9-4-list" tabindex="-1"><a class="header-anchor" href="#_9-4-list" aria-hidden="true">#</a> 9.4 List</h3>
<h4 id="_9-4-1-特点" tabindex="-1"><a class="header-anchor" href="#_9-4-1-特点" aria-hidden="true">#</a> 9.4.1 特点</h4>
<ol>
<li>List集合类的元素有序（添加和取出顺序一致），且可重复。</li>
<li>List集合类每个元素都有器对应的顺序索引，可通过索引取出元素——使用<code v-pre>get()</code></li>
<li>List接口实现类常用的有<code v-pre>ArrayList</code>、<code v-pre>LinkedList</code>、<code v-pre>Vector</code>
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654478357647-f06f7716-f91e-48ac-aee5-0c7ac1698ca3.png#clientId=u15a6678f-ac90-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=41&amp;id=u3f8d53d3&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=51&amp;originWidth=1501&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=5445&amp;status=done&amp;style=none&amp;taskId=uf76d4cd6-8416-499c-b022-710c2186417&amp;title=&amp;width=1200.8" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_9-4-2-常用方法" tabindex="-1"><a class="header-anchor" href="#_9-4-2-常用方法" aria-hidden="true">#</a> 9.4.2 常用方法</h4>
<table>
<thead>
<tr>
<th>变量和类型</th>
<th>方法</th>
<th>描述</th>
</tr>
</thead>
<tbody>
<tr>
<td>void</td>
<td>add(int index, E element)</td>
<td>将指定元素插入此列表中的指定位置（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td>add(E e)</td>
<td>将指定的元素追加到此列表的末尾（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td>addAll(int index, Collection&lt;? extends E&gt; c)</td>
<td>将指定集合中的所有元素插入到指定位置的此列表中（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td>addAll(Collection&lt;? extends E&gt; c)</td>
<td>将指定集合中的所有元素按指定集合的迭代器（可选操作）返回的顺序追加到此列表的末尾。</td>
</tr>
<tr>
<td>void</td>
<td>clear()</td>
<td>从此列表中删除所有元素（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#contains(java.lang.Object)" target="_blank" rel="noopener noreferrer">contains<ExternalLinkIcon/></a>(<a href="https://www.apiref.com/java11-zh/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> o)</td>
<td>如果此列表包含指定的元素，则返回 true 。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#containsAll(java.util.Collection)" target="_blank" rel="noopener noreferrer">containsAll<ExternalLinkIcon/></a>(<a href="https://www.apiref.com/java11-zh/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;?&gt; c)</td>
<td>如果此列表包含指定集合的所有元素，则返回 true 。</td>
</tr>
<tr>
<td>static <E> <a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">List<ExternalLinkIcon/></a><E></td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#copyOf(java.util.Collection)" target="_blank" rel="noopener noreferrer">copyOf<ExternalLinkIcon/></a>(<a href="https://www.apiref.com/java11-zh/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;? extends E&gt; coll)</td>
<td>以迭代顺序返回包含给定Collection的元素的 unmodifiable List 。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#equals(java.lang.Object)" target="_blank" rel="noopener noreferrer">equals<ExternalLinkIcon/></a>(<a href="https://www.apiref.com/java11-zh/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> o)</td>
<td>将指定对象与此列表进行比较以获得相等性。</td>
</tr>
<tr>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a></td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#get(int)" target="_blank" rel="noopener noreferrer">get<ExternalLinkIcon/></a>(int index)</td>
<td>返回此列表中指定位置的元素。</td>
</tr>
<tr>
<td>int</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#indexOf(java.lang.Object)" target="_blank" rel="noopener noreferrer">indexOf<ExternalLinkIcon/></a>(Object o)</td>
<td>返回此列表中第一次出现的指定元素的索引，如果此列表不包含该元素，则返回-1。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#isEmpty()" target="_blank" rel="noopener noreferrer">isEmpty<ExternalLinkIcon/></a>()</td>
<td>如果此列表不包含任何元素，则返回 true 。</td>
</tr>
<tr>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/Iterator.html" target="_blank" rel="noopener noreferrer">Iterator<ExternalLinkIcon/></a>&lt;<a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a>&gt;</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#iterator()" target="_blank" rel="noopener noreferrer">iterator<ExternalLinkIcon/></a>()</td>
<td>以适当的顺序返回此列表中元素的迭代器。</td>
</tr>
<tr>
<td>int</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#lastIndexOf(java.lang.Object)" target="_blank" rel="noopener noreferrer">lastIndexOf<ExternalLinkIcon/></a>(<a href="https://www.apiref.com/java11-zh/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> o)</td>
<td>返回此列表中指定元素最后一次出现的索引，如果此列表不包含该元素，则返回-1。</td>
</tr>
<tr>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a></td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#remove(int)" target="_blank" rel="noopener noreferrer">remove<ExternalLinkIcon/></a>(int index)</td>
<td>删除此列表中指定位置的元素（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#remove(java.lang.Object)" target="_blank" rel="noopener noreferrer">remove<ExternalLinkIcon/></a>(<a href="https://www.apiref.com/java11-zh/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> o)</td>
<td>从该列表中删除指定元素的第一个匹配项（如果存在）（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#removeAll(java.util.Collection)" target="_blank" rel="noopener noreferrer">removeAll<ExternalLinkIcon/></a>(<a href="https://www.apiref.com/java11-zh/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;?&gt; c)</td>
<td>从此列表中删除指定集合中包含的所有元素（可选操作）。</td>
</tr>
<tr>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a></td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#set(int,E)" target="_blank" rel="noopener noreferrer">set<ExternalLinkIcon/></a>(int index, <a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a> element)</td>
<td>用指定的元素替换此列表中指定位置的元素（可选操作）。</td>
</tr>
<tr>
<td>int</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#size()" target="_blank" rel="noopener noreferrer">size<ExternalLinkIcon/></a>()</td>
<td>返回此列表中的元素数。</td>
</tr>
<tr>
<td>default void</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#sort(java.util.Comparator)" target="_blank" rel="noopener noreferrer">sort<ExternalLinkIcon/></a>(<a href="https://www.apiref.com/java11-zh/java.base/java/util/Comparator.html" target="_blank" rel="noopener noreferrer">Comparator<ExternalLinkIcon/></a>&lt;? super <a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a>&gt; c)</td>
<td>根据指定的<a href="https://www.apiref.com/java11-zh/java.base/java/util/Comparator.html" target="_blank" rel="noopener noreferrer">Comparator<ExternalLinkIcon/></a>引发的顺序对此列表进行排序。</td>
</tr>
<tr>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">List<ExternalLinkIcon/></a>&lt;<a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a>&gt;</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#subList(int,int)" target="_blank" rel="noopener noreferrer">subList<ExternalLinkIcon/></a>(int fromIndex, int toIndex)</td>
<td>返回指定的 fromIndex （包含）和 toIndex （不包括）之间的此列表部分的视图。</td>
</tr>
<tr>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a>[]</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#toArray()" target="_blank" rel="noopener noreferrer">toArray<ExternalLinkIcon/></a>()</td>
<td>以适当的顺序（从第一个元素到最后一个元素）返回包含此列表中所有元素的数组。</td>
</tr>
<tr>
<td><T> T[]</td>
<td><a href="https://www.apiref.com/java11-zh/java.base/java/util/List.html#toArray(T%5B%5D)" target="_blank" rel="noopener noreferrer">toArray<ExternalLinkIcon/></a>(T[] a)</td>
<td>以适当的顺序返回包含此列表中所有元素的数组（从第一个元素到最后一个元素）; 返回数组的运行时类型是指定数组的运行时类型。</td>
</tr>
</tbody>
</table>
<h4 id="_9-4-3-遍历方式" tabindex="-1"><a class="header-anchor" href="#_9-4-3-遍历方式" aria-hidden="true">#</a> 9.4.3 遍历方式</h4>
<ol>
<li>使用Iterator迭代器：迭代器的<code v-pre>next()</code>取出的就是每个对象</li>
<li>使用增强for循环</li>
<li>使用普通for循环</li>
</ol>
<h4 id="_9-4-4-arraylist" tabindex="-1"><a class="header-anchor" href="#_9-4-4-arraylist" aria-hidden="true">#</a> 9.4.4 ArrayList</h4>
<ol>
<li>特点：
<ul>
<li>可以存放null，且可存放多个</li>
<li>基本等同于Vector，但ArrayList线程不安全。</li>
</ul>
</li>
<li>底层：
<ul>
<li>ArrayList的数据由一个<code v-pre>transient</code>修饰的<code v-pre>Object[]</code> 存储。可变数组
<ul>
<li><code v-pre>transient</code>表示不可被序列化</li>
</ul>
</li>
<li><code v-pre>ArrayList()</code>：初始容量为0，第一次添加元素容量变为10，后续扩容按照当前容量的1.5倍增大</li>
<li><code v-pre>ArrayList(int initialCapacity)</code>：初始容量为initialCapacity，后续扩容按照当前容量的1.5倍增大</li>
</ul>
</li>
</ol>
<blockquote>
<ol start="3">
<li>IDEA补充知识：
<ul>
<li>IDEA在debug时，会阉割数据</li>
<li>解决方式：（去掉下列两个红框的勾选）。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654482455006-5695b515-1af1-4a0e-9875-42a5bc354095.png#clientId=u15a6678f-ac90-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=498&amp;id=aXi50&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=891&amp;originWidth=1227&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=91500&amp;status=done&amp;style=none&amp;taskId=u189dcbe5-2ac3-4992-b8ee-517000c759b&amp;title=&amp;width=685.6000366210938" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
</blockquote>
<h4 id="_9-4-5-vector" tabindex="-1"><a class="header-anchor" href="#_9-4-5-vector" aria-hidden="true">#</a> 9.4.5 Vector</h4>
<ol>
<li>特点：
<ul>
<li>可以存放null，且可存放多个</li>
<li>Vector类的操作方法带有<code v-pre>synchronized</code>，所以是线程安全的。</li>
</ul>
</li>
<li>底层：
<ul>
<li>底层使用<code v-pre>Object[]</code>存放数据</li>
<li><code v-pre>Vector()</code>：初始容量0，第一次添加后10，不足时按当前容量的2倍扩容。</li>
<li><code v-pre>Vector(int initialCapacity)</code>：初始容量为initialCapacity，不足时按当前容量的2倍扩容。</li>
</ul>
</li>
</ol>
<h4 id="_9-4-6-linkedlist" tabindex="-1"><a class="header-anchor" href="#_9-4-6-linkedlist" aria-hidden="true">#</a> 9.4.6 LinkedList</h4>
<ol>
<li>特点：
<ul>
<li>可以存放null，且可存放多个</li>
<li>线程不安全，添加删除效率比数组高，查找效率较低</li>
</ul>
</li>
<li>底层：
<ul>
<li>底层维护了一个双向链表
<ul>
<li>LinkedeList中有两个属性first、last，分别指向链表中第一个和最后一个节点</li>
<li>每个节点都含有3个属性：prev、next、item</li>
<li>只有无参构造器<code v-pre>LinkedList()</code>，默认容量0，添加一个数组，容量+1。</li>
</ul>
</li>
</ul>
</li>
<li>LinkedList和ArrayList的选择
<ul>
<li>改查较多，选择ArrayList</li>
<li>增删较多，选择LinkedList
<ul>
<li>业务中，一般查询较多、增删较少，建议使用ArrayList</li>
</ul>
</li>
</ul>
</li>
</ol>
<h3 id="_9-5-set" tabindex="-1"><a class="header-anchor" href="#_9-5-set" aria-hidden="true">#</a> 9.5 Set</h3>
<h4 id="_9-5-1-特点" tabindex="-1"><a class="header-anchor" href="#_9-5-1-特点" aria-hidden="true">#</a> 9.5.1 特点</h4>
<ol>
<li>无序（添加和取出顺序不一定一致），元素不可重复，最多只可包含一个null。
<ul>
<li>元素不可重复按照equals是否相等理解。（基本数据类型会自动装箱，但包装类重写了equals方法，比较的还是具体值；字面量字符串在常量池；构造器创建的字符串比较的也是具体内容（equals））</li>
<li>但一旦数据确定，每次的取出顺序一致</li>
<li>hashcode是根据对象的地址值确定的</li>
</ul>
</li>
<li>没有索引</li>
<li>常用实现类有：<code v-pre>HashSet</code>、<code v-pre>LinkedHashSet</code>、<code v-pre>TreeSet</code>
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654496607623-25c6b284-e726-46da-a5ad-0236be848f22.png#clientId=u15a6678f-ac90-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=26&amp;id=u3c98d10b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=33&amp;originWidth=1599&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8361&amp;status=done&amp;style=stroke&amp;taskId=u92ac2f0b-1476-4806-848a-8ff99ab3520&amp;title=&amp;width=1279.2" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_9-5-2-常用方法" tabindex="-1"><a class="header-anchor" href="#_9-5-2-常用方法" aria-hidden="true">#</a> 9.5.2 常用方法</h4>
<table>
<thead>
<tr>
<th><strong>变量和类型</strong></th>
<th><strong>方法</strong></th>
<th><strong>描述</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td>boolean</td>
<td>add(E e)</td>
<td>如果指定的元素尚不存在，则将其添加到此集合（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td>addAll(Collection&lt;? extends E&gt; c)</td>
<td>如果指定集合中的所有元素尚未存在（可选操作），则将其添加到此集合中。</td>
</tr>
<tr>
<td>void</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#clear()" target="_blank" rel="noopener noreferrer">clear<ExternalLinkIcon/></a>()</td>
<td>从该集合中删除所有元素（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#contains(java.lang.Object)" target="_blank" rel="noopener noreferrer">contains<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> o)</td>
<td>如果此set包含指定的元素，则返回 true 。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#containsAll(java.util.Collection)" target="_blank" rel="noopener noreferrer">containsAll<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;?&gt; c)</td>
<td>如果此集合包含指定集合的所有元素，则返回 true 。</td>
</tr>
<tr>
<td>static <E> <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html" target="_blank" rel="noopener noreferrer">Set<ExternalLinkIcon/></a><E></td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#copyOf(java.util.Collection)" target="_blank" rel="noopener noreferrer">copyOf<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;? extends E&gt; coll)</td>
<td>返回包含给定Collection的元素的 <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#unmodifiable" target="_blank" rel="noopener noreferrer">unmodifiable   Set<ExternalLinkIcon/></a> 。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#equals(java.lang.Object)" target="_blank" rel="noopener noreferrer">equals<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> o)</td>
<td>将指定对象与此set进行相等性比较。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#isEmpty()" target="_blank" rel="noopener noreferrer">isEmpty<ExternalLinkIcon/></a>()</td>
<td>如果此集合不包含任何元素，则返回 true 。</td>
</tr>
<tr>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Iterator.html" target="_blank" rel="noopener noreferrer">Iterator<ExternalLinkIcon/></a>&lt;<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a>&gt;</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#iterator()" target="_blank" rel="noopener noreferrer">iterator<ExternalLinkIcon/></a>()</td>
<td>返回此set中元素的迭代器。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#remove(java.lang.Object)" target="_blank" rel="noopener noreferrer">remove<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> o)</td>
<td>如果存在，则从该集合中移除指定的元素（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#removeAll(java.util.Collection)" target="_blank" rel="noopener noreferrer">removeAll<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;?&gt; c)</td>
<td>从此集合中删除指定集合中包含的所有元素（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#retainAll(java.util.Collection)" target="_blank" rel="noopener noreferrer">retainAll<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;?&gt; c)</td>
<td>仅保留此集合中包含在指定集合中的元素（可选操作）。</td>
</tr>
<tr>
<td>int</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#size()" target="_blank" rel="noopener noreferrer">size<ExternalLinkIcon/></a>()</td>
<td>返回此集合中的元素数（基数）。</td>
</tr>
<tr>
<td>default <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Spliterator.html" target="_blank" rel="noopener noreferrer">Spliterator<ExternalLinkIcon/></a>&lt;<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html" target="_blank" rel="noopener noreferrer">E<ExternalLinkIcon/></a>&gt;</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#spliterator()" target="_blank" rel="noopener noreferrer">spliterator<ExternalLinkIcon/></a>()</td>
<td>在此集合中的元素上创建 Spliterator 。</td>
</tr>
<tr>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a>[]</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#toArray()" target="_blank" rel="noopener noreferrer">toArray<ExternalLinkIcon/></a>()</td>
<td>返回包含此set中所有元素的数组。</td>
</tr>
<tr>
<td><T> T[]</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html#toArray(T%5B%5D)" target="_blank" rel="noopener noreferrer">toArray<ExternalLinkIcon/></a>(T[] a)</td>
<td>返回一个包含此set中所有元素的数组; 返回数组的运行时类型是指定数组的运行时类型。</td>
</tr>
</tbody>
</table>
<h4 id="_9-5-3-遍历方式" tabindex="-1"><a class="header-anchor" href="#_9-5-3-遍历方式" aria-hidden="true">#</a> 9.5.3 遍历方式</h4>
<ol>
<li>迭代器</li>
<li>增强for循环</li>
<li>不能使用普通for循环</li>
</ol>
<h4 id="_9-5-4-hashset" tabindex="-1"><a class="header-anchor" href="#_9-5-4-hashset" aria-hidden="true">#</a> 9.5.4 HashSet</h4>
<ol>
<li>特点：
<ul>
<li>可以存放null，但只能存放一个。</li>
<li>相同数据只能存放一个
<ul>
<li>注意字符串的特殊性（面试题）：<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654499279254-bf41c0bc-d45a-4d1d-a14a-a40baae7c1c1.png#clientId=u15a6678f-ac90-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=58&amp;id=u9bbcae3b&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=72&amp;originWidth=615&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=57374&amp;status=done&amp;style=stroke&amp;taskId=uebec9f15-7fdf-46a6-9908-c5acd0e6962&amp;title=&amp;width=492" alt="image.png" loading="lazy"></li>
<li>其他对象可以添加成功：<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654499389219-c11c843b-4abb-4455-9587-e7c9d8d8fda0.png#clientId=u15a6678f-ac90-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=56&amp;id=u8b1e8083&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=70&amp;originWidth=496&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=46865&amp;status=done&amp;style=stroke&amp;taskId=u4db04168-063f-4dc7-9d24-0a07a72c6c7&amp;title=&amp;width=396.8" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>数据存入与取出顺序不一定一致</li>
</ul>
</li>
</ol>
<blockquote>
<ol start="2">
<li>底层（数据结构）：
<ul>
<li>底层实际上是HashMap，而HashMap的底层是数组+链表+红黑树
<ul>
<li>调用HashSet构造器后，会先执行HashMap()构造器，并创建table表（数组），初始容量为0，再取得加载因子0.75</li>
<li>添加元素时，先计算得到该元素的hash值，并转换得到索引值</li>
<li>第一次添加时，将table扩容到16，并把第一次添加的元素放到表中的指定位置</li>
<li>后续添加时，比较索引值，如果表中该索引已有值，则在该值后的数据链中比较，添加到最后
<ul>
<li>注意：这里比较元素内容是否相同，取决于加入元素的<code v-pre>equals()</code>方法，通过重写<code v-pre>equals()</code>和<code v-pre>hasCode()</code>可以控制元素能否加入</li>
</ul>
</li>
<li>JAVA8中，如果数据链的数据已有8个，先对表按2倍进行扩容，如果表已经扩容过，并且表到了64，则将该表转换为红黑树</li>
<li>平时链表数据没到8个，但表到达12个（16*0.75），就会对表按照2倍进行扩容，并以此类推</li>
</ul>
</li>
<li>数组类型为<code v-pre>HashMap$Node</code>，数据类型为<code v-pre>HashMap$Node</code>。</li>
</ul>
</li>
</ol>
</blockquote>
<h4 id="_9-5-5-linkedhashset" tabindex="-1"><a class="header-anchor" href="#_9-5-5-linkedhashset" aria-hidden="true">#</a> 9.5.5 LinkedHashSet</h4>
<ol>
<li>特点：
<ul>
<li>HashSet的子类、并实现了Set接口</li>
<li>可以存放null、但只能存放一个</li>
<li>相同数据只能添加一个</li>
<li>元素取出顺序固定，且与加入顺序一致。</li>
</ul>
</li>
<li>底层：
<ul>
<li>底层使用了一个hashtable（数组） 和双向链表存储数据，
<ul>
<li>数组是<code v-pre>HashMap$Node</code>类型
<ul>
<li>数组有head和tail</li>
</ul>
</li>
<li>数据类型为<code v-pre>LinkedHashMap$Entry</code>类型，LinkedHashMap是HashMap的子类。
<ul>
<li>每个元素有before和after</li>
</ul>
</li>
</ul>
</li>
<li>初始容量为0，第一次添加时，直接将数组table 扩容到16，再添加一个元素时，先求hash值，再求索引，确定在表中的位置，然后再将元素添加到链表中【机制同HashSet】</li>
</ul>
</li>
</ol>
<h4 id="_9-5-6-treeset" tabindex="-1"><a class="header-anchor" href="#_9-5-6-treeset" aria-hidden="true">#</a> 9.5.6 TreeSet</h4>
<ol>
<li>特点：
<ul>
<li>使用无参构造器时，仍然是无序的（输出顺序与输入顺序不一致）。</li>
<li>使用带比较器的构造器<code v-pre>TreeSet(Comparator&lt;? super E&gt; comparator)</code>：可以设定指定的添加规则及顺序。
<ul>
<li>添加规则：取决于比较器中比较的属性，比较器返回0时则不能加入</li>
<li>顺序：根据比较器指定的顺序或者逆序确定。</li>
<li>匿名内部类的比较器规则会被创建时底层的compare()调用</li>
</ul>
</li>
</ul>
</li>
<li>底层：
<ul>
<li>底层就是TreeMap，TreeMap底层就是Entry</li>
<li>存放的数据类型是TreeMap$Entry</li>
<li>初始化大小是0，添加一个容量+1</li>
</ul>
</li>
</ol>
<h3 id="_9-6-map" tabindex="-1"><a class="header-anchor" href="#_9-6-map" aria-hidden="true">#</a> 9.6 Map</h3>
<h4 id="_9-6-1-map接口的特点" tabindex="-1"><a class="header-anchor" href="#_9-6-1-map接口的特点" aria-hidden="true">#</a> 9.6.1 Map接口的特点</h4>
<ol>
<li>Map与Collection并列存在，用于保存具有映射关系的数据。key-value（双列元素）。</li>
<li>Map中的key和value可以时任意数类型，会封装到<code v-pre>HashMap$Node</code>对象中，数据类型为<code v-pre>HashMap$Node</code>。</li>
<li>Map中的key不允许重复，原因同HashSet（key相同则hashcode和索引值相同，在table表（数组）的位置相同），相同的key等价于替换元素。</li>
<li>Map中的value可以重复</li>
<li>Map中的key可以为null，value也可以为null，key为null时只能添加一个（等价于替换），value可以多个为null</li>
<li>Map中常用String作为key，实际上key只要是Object就都可以（包含基本数据类型）</li>
<li>Map中的key和value存在一一对应关系，使用<code v-pre>get(key)</code>，就可以得到唯一的一个value</li>
</ol>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<ol start="8">
<li>Map中的数据存储：一对k-v是存放在<code v-pre>HashMap$Node</code>中的，由于Node实现了Entry接口，所以在一定理解上，可以说一对k-v就是一个Entry
<ul>
<li>源码韩顺平分析：
<ul>
<li>k-v 最后是 <code v-pre>HashMap$Node node = newNode(hash, key, value, null)</code></li>
<li>k-v 为了方便程序员的遍历，还会创建 EntrySet 集合 ，该集合存放的元素的类型 Entry, 而一个Entry对象就有k,v EntrySet&lt;Entry&lt;K,V&gt;&gt; 即： <code v-pre>transient Set&lt;Map.Entry&lt;K,V&gt;&gt; entrySet;</code></li>
<li>entrySet 中， 定义的类型是 Map.Entry ，但是实际上存放的还是 HashMap$Node这是因为 <code v-pre>static class Node&lt;K,V&gt; implements Map.Entry&lt;K,V&gt;</code></li>
<li>当把 HashMap$Node 对象 存放到 entrySet 就方便我们的遍历, 因为 Map.Entry 提供了重要方法K getKey(); V getValue();</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654551640310-dd08d1f1-93a5-4ec7-9393-e168b94162e6.png#clientId=u429de258-15ff-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=229&amp;id=uc80b95ef&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=286&amp;originWidth=857&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=195553&amp;status=done&amp;style=stroke&amp;taskId=ud13997fe-3fa2-4bac-8cdd-f68c4d8c610&amp;title=&amp;width=685.6" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>源码个人理解：
<ul>
<li>k-v在创建时执行的是<code v-pre>HashMap$Node node = newNode(hash, key, value, null)</code>，所以k-v的数据类型就是<code v-pre>HashMap$Node</code>，数组类型也是<code v-pre>HashMap$Node</code>。</li>
<li>Map.Entry有重要的<code v-pre>getKey()</code>、<code v-pre>getValue()</code>可以获取元素的k-v值，有了这两个方法，就大大方便了使用（遍历）。<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654550940218-7a271096-597a-4e45-8031-1398290bb150.png#clientId=u429de258-15ff-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=79&amp;id=u48525815&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=99&amp;originWidth=262&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=4195&amp;status=done&amp;style=stroke&amp;taskId=uc1df04b9-3cf9-405a-8aeb-a8c97cb911d&amp;title=&amp;width=209.6" alt="image.png" loading="lazy">
<ul>
<li>而在Map中，通过<code v-pre>keySet()</code>获取<code v-pre>Set</code>类型的所有key，<code v-pre>values()</code>获取<code v-pre>Collection</code>类型的所有vaule，将这二者存放在了一个Set表中。</li>
<li>这个Set表就是EntrySet集合，集合中每一个元素是Entry类型，拥有key和value：<code v-pre>transient Set&lt;Map.Entry&lt;K,V&gt;&gt; entrySet;</code>
<ul>
<li>EntrySet和Node都是HashMap的内部类<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654573029161-4c10bc96-f8e9-4f5d-898a-9ff9f1072f77.png#clientId=uc2d66382-7a15-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=104&amp;id=u2ace59bb&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=104&amp;originWidth=193&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=4452&amp;status=done&amp;style=stroke&amp;taskId=ucacfd6a2-abf9-4e83-bd8e-121e1282401&amp;title=&amp;width=193" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
<li>为了使<code v-pre>HashMap$Node</code>类型的数据能够用上面两个方法，HashMap$Node类实现了Map.Entry：<code v-pre>static class Node&lt;K,V&gt; implements Map.Entry&lt;K,V&gt;</code></li>
</ul>
</li>
</ul>
</li>
</ol>
</div>
<ol start="9">
<li>常用实现类：<code v-pre>HashMap</code>（使用率最高）、<code v-pre>Hashtable</code>、<code v-pre>Properties</code>
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654564561753-06ab160c-2e2e-490e-a58e-82395fcebb4e.png#clientId=uc2d66382-7a15-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=42&amp;id=u1613febf&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=53&amp;originWidth=1673&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=14821&amp;status=done&amp;style=stroke&amp;taskId=u054b2025-0234-4de2-ba60-5d3e57e95e9&amp;title=&amp;width=1338.4" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ol>
<h4 id="_9-6-2-map接口常用方法" tabindex="-1"><a class="header-anchor" href="#_9-6-2-map接口常用方法" aria-hidden="true">#</a> 9.6.2 Map接口常用方法</h4>
<table>
<thead>
<tr>
<th><strong>变量和类型</strong></th>
<th><strong>方法</strong></th>
<th><strong>描述</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td>void</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#clear()" target="_blank" rel="noopener noreferrer">clear<ExternalLinkIcon/></a>()</td>
<td>从此映射中删除所有映射（可选操作）。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#containsKey(java.lang.Object)" target="_blank" rel="noopener noreferrer">containsKey<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> key)</td>
<td>如果此映射包含指定键的映射，则返回 true 。</td>
</tr>
<tr>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html" target="_blank" rel="noopener noreferrer">Set<ExternalLinkIcon/></a>&lt;<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.Entry.html" target="_blank" rel="noopener noreferrer">Map.Entry<ExternalLinkIcon/></a>&lt;<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">K<ExternalLinkIcon/></a>,<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">V<ExternalLinkIcon/></a>&gt;&gt;</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#entrySet()" target="_blank" rel="noopener noreferrer">entrySet<ExternalLinkIcon/></a>()</td>
<td>返回此映射中包含的映射的<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html" target="_blank" rel="noopener noreferrer">Set<ExternalLinkIcon/></a>视图。</td>
</tr>
<tr>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">V<ExternalLinkIcon/></a></td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#get(java.lang.Object)" target="_blank" rel="noopener noreferrer">get<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> key)</td>
<td>返回指定键映射到的值，如果此映射不包含键的映射，则返回 null 。</td>
</tr>
<tr>
<td>boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#isEmpty()" target="_blank" rel="noopener noreferrer">isEmpty<ExternalLinkIcon/></a>()</td>
<td>如果此映射不包含键 - 值映射，则返回 true 。</td>
</tr>
<tr>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html" target="_blank" rel="noopener noreferrer">Set<ExternalLinkIcon/></a>&lt;<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">K<ExternalLinkIcon/></a>&gt;</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#keySet()" target="_blank" rel="noopener noreferrer">keySet<ExternalLinkIcon/></a>()</td>
<td>返回此映射中包含的键的<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Set.html" target="_blank" rel="noopener noreferrer">Set<ExternalLinkIcon/></a>视图。</td>
</tr>
<tr>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">V<ExternalLinkIcon/></a></td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#put(K,V)" target="_blank" rel="noopener noreferrer">put<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">K<ExternalLinkIcon/></a> key, <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">V<ExternalLinkIcon/></a> value)</td>
<td>将指定的值与此映射中的指定键相关联（可选操作）。</td>
</tr>
<tr>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">V<ExternalLinkIcon/></a></td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#remove(java.lang.Object)" target="_blank" rel="noopener noreferrer">remove<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> key)</td>
<td>如果存在，则从该映射中移除键的映射（可选操作）。</td>
</tr>
<tr>
<td>int</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#size()" target="_blank" rel="noopener noreferrer">size<ExternalLinkIcon/></a>()</td>
<td>返回此映射中键 - 值映射的数量。</td>
</tr>
<tr>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html" target="_blank" rel="noopener noreferrer">V<ExternalLinkIcon/></a>&gt;</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Map.html#values()" target="_blank" rel="noopener noreferrer">values<ExternalLinkIcon/></a>()</td>
<td>返回此映射中包含的值的<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>视图。</td>
</tr>
</tbody>
</table>
<h4 id="_9-6-3-map接口遍历方法" tabindex="-1"><a class="header-anchor" href="#_9-6-3-map接口遍历方法" aria-hidden="true">#</a> 9.6.3 Map接口遍历方法</h4>
<ol>
<li>方式一：使用Map的<code v-pre>keySet()</code>方法取出所有的key，而取出的key类型为Set，因此可以使用两种方式：
<ul>
<li>增强for循环：</li>
<li>使用迭代器：
<ul>
<li>迭代器的<code v-pre>next()</code>取出的是key</li>
</ul>
</li>
</ul>
</li>
<li>方式二：使用Map的<code v-pre>values()</code>方法取出所有的value，而取出的value类型为Collection，因此可以使用两种方式：
<ul>
<li>增强for循环：</li>
<li>使用迭代器：
<ul>
<li>迭代器的<code v-pre>next()</code>取出的是value</li>
</ul>
</li>
</ul>
</li>
<li>方式三：使用Map的<code v-pre>entrySet()</code>方法取出所有的entry，而取出的entry类型为HashMap<span class="katex"><span class="katex-mathml"><math xmlns="http://www.w3.org/1998/Math/MathML"><semantics><mrow><mi>N</mi><mi>o</mi><mi>d</mi><mi>e</mi><mtext>，</mtext><mi>H</mi><mi>a</mi><mi>s</mi><mi>h</mi><mi>M</mi><mi>a</mi><mi>p</mi></mrow><annotation encoding="application/x-tex">Node，HashMap</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height:0.8889em;vertical-align:-0.1944em;"></span><span class="mord mathnormal" style="margin-right:0.10903em;">N</span><span class="mord mathnormal">o</span><span class="mord mathnormal">d</span><span class="mord mathnormal">e</span><span class="mord cjk_fallback">，</span><span class="mord mathnormal" style="margin-right:0.08125em;">H</span><span class="mord mathnormal">a</span><span class="mord mathnormal">s</span><span class="mord mathnormal">h</span><span class="mord mathnormal" style="margin-right:0.10903em;">M</span><span class="mord mathnormal">a</span><span class="mord mathnormal">p</span></span></span></span>Node实现了Map.Entry，而Map.Entry有<code v-pre>getKey()</code>和<code v-pre>getValue()</code>
<ul>
<li>使用EntrySet的增强for循环：
<ul>
<li>前提条件：使用向上转型，转为Map.Entry。<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654559890117-e448fef2-212f-494a-add9-8a349003e22d.png#clientId=u429de258-15ff-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=139&amp;id=u37f4962e&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=344&amp;originWidth=1019&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=217416&amp;status=done&amp;style=stroke&amp;taskId=ua0b0f676-a893-4db9-9e8c-9f8a997a031&amp;title=&amp;width=413.20001220703125" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>使用迭代器：
<ul>
<li>迭代器的<code v-pre>next()</code>取出的是entry，entry类型为HashMap<span class="katex"><span class="katex-mathml"><math xmlns="http://www.w3.org/1998/Math/MathML"><semantics><mrow><mi>N</mi><mi>o</mi><mi>d</mi><mi>e</mi><mtext>，</mtext><mi>H</mi><mi>a</mi><mi>s</mi><mi>h</mi><mi>M</mi><mi>a</mi><mi>p</mi></mrow><annotation encoding="application/x-tex">Node，HashMap</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height:0.8889em;vertical-align:-0.1944em;"></span><span class="mord mathnormal" style="margin-right:0.10903em;">N</span><span class="mord mathnormal">o</span><span class="mord mathnormal">d</span><span class="mord mathnormal">e</span><span class="mord cjk_fallback">，</span><span class="mord mathnormal" style="margin-right:0.08125em;">H</span><span class="mord mathnormal">a</span><span class="mord mathnormal">s</span><span class="mord mathnormal">h</span><span class="mord mathnormal" style="margin-right:0.10903em;">M</span><span class="mord mathnormal">a</span><span class="mord mathnormal">p</span></span></span></span>Node实现了Map.Entry。</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654560074202-dcfa90d2-5c89-4ace-aa11-c4bcc12d1f09.png#clientId=u429de258-15ff-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=141&amp;id=u2f60e4cb&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=225&amp;originWidth=1052&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=50431&amp;status=done&amp;style=stroke&amp;taskId=u39e255c7-86c8-4934-8eb4-cfcb9961bf4&amp;title=&amp;width=659.6000366210938" alt="image.png" loading="lazy"></li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_9-6-4-hashmap" tabindex="-1"><a class="header-anchor" href="#_9-6-4-hashmap" aria-hidden="true">#</a> 9.6.4 HashMap</h4>
<ol>
<li>特点：
<ul>
<li>使用率最高</li>
<li>key不能重复，但value可以重复，允许使用null的key和null的value</li>
<li>如果添加相同的key，则会覆盖原来的key-val，等同于修改（替换）</li>
<li>线程不安全</li>
</ul>
</li>
<li>底层：
<ul>
<li>底层以key-val的方式来存储数据（数组及数据均为HashMap$Node类型）</li>
<li>与HashSet一样，不保证映射顺序，因为底层是以hash表的方式来存储（数组+链表+红黑树）</li>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654567630552-ccbc13d7-efc8-460b-a6ff-8dc14f58ff6f.png#clientId=uc2d66382-7a15-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=250&amp;id=u308ac114&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=361&amp;originWidth=1114&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=438626&amp;status=done&amp;style=stroke&amp;taskId=u53e38b79-a65d-4dfa-a7da-610067988f6&amp;title=&amp;width=772.2000122070312" alt="image.png" loading="lazy"></li>
<li>**扩容机制：同HashSet，**唯一区别在于HashSet计算哈希值是元素，HashMap计算时是key</li>
<li>初始化数据容量为0</li>
</ul>
</li>
</ol>
<h4 id="_9-6-5-linkedhashmap" tabindex="-1"><a class="header-anchor" href="#_9-6-5-linkedhashmap" aria-hidden="true">#</a> 9.6.5 LinkedHashMap</h4>
<ol>
<li>特点：
<ul>
<li>继承了HashMap，实现了Map。</li>
<li>线程不安全</li>
<li>如果有相同key，后者替换前者；value可以重复，允许使用null的key和null的value</li>
</ul>
</li>
<li>底层
<ul>
<li>底层使用数组+双向链表 转 红黑树</li>
<li>初始容量为0</li>
</ul>
</li>
</ol>
<h4 id="_9-6-6-hashtable" tabindex="-1"><a class="header-anchor" href="#_9-6-6-hashtable" aria-hidden="true">#</a> 9.6.6 Hashtable</h4>
<ol>
<li>特点：
<ul>
<li>键和值都不能为null，会抛出NullPointerException</li>
<li>线程安全的</li>
</ul>
</li>
<li>底层：
<ul>
<li>底层是一个数组，类型为<code v-pre>Hashtable$Entry</code>，实现了Map.Entry。元素类型也为<code v-pre>Hashtable$Entry</code><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654645438036-faf29723-f927-451a-9e44-c3ff890fcce8.png#clientId=uc2d66382-7a15-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=127&amp;id=uc9759e34&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=131&amp;originWidth=310&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=4690&amp;status=done&amp;style=stroke&amp;taskId=u12bd0f03-9e22-4ed9-81b0-4a0aab395a9&amp;title=&amp;width=300" alt="image.png" loading="lazy"></li>
<li>初始化大小为11，临界值为8（11*0.75）</li>
<li>当添加数据数量到达8时，对数组进行扩容，扩容为当前容量 * 2 + 1，新的临界值变为当前容量 * 0.75</li>
</ul>
</li>
</ol>
<h4 id="_9-6-7-properties" tabindex="-1"><a class="header-anchor" href="#_9-6-7-properties" aria-hidden="true">#</a> 9.6.7 Properties</h4>
<ol>
<li>特点：
<ul>
<li>继承了Hashtable：不能添加null的key或value，会发生NullPointerException</li>
<li>线程安全</li>
<li>如果有相同key，后者替换前者</li>
<li>可以用与<code v-pre>xxx.properties</code>文件中，加载数据到<code v-pre>Properties</code>类中进行读取和修改</li>
</ul>
</li>
<li>底层
<ul>
<li>初始容量为0，底层使用数组，元素类型、扩容机制同Hashtab</li>
</ul>
</li>
</ol>
<h4 id="_9-6-8-treemap" tabindex="-1"><a class="header-anchor" href="#_9-6-8-treemap" aria-hidden="true">#</a> 9.6.8 TreeMap</h4>
<ol>
<li>特点：
<ul>
<li>使用无参构造器时，仍然是无序的（输出顺序与输入顺序不一致）。</li>
<li>使用带比较器的构造器<code v-pre>TreeMap(Comparator&lt;? super E&gt; comparator)</code>：可以设定指定的添加规则及顺序。
<ul>
<li>添加规则：取决于比较器中比较的属性，比较器返回0时则不能加入</li>
<li>顺序：根据比较器指定的顺序或者逆序确定。</li>
<li>匿名内部类的比较器规则会被创建时内部的compare()调用</li>
</ul>
</li>
</ul>
</li>
<li>底层：
<ul>
<li>底层就是Entry</li>
<li>存放的数据类型是<code v-pre>TreeMap$Entry</code><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654645499802-e1281d29-6c52-4555-83c3-67ee43a5e8ca.png#clientId=uc2d66382-7a15-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=137&amp;id=TABT7&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=137&amp;originWidth=203&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=4560&amp;status=done&amp;style=stroke&amp;taskId=u68474272-0362-4a2c-8a23-9964424ead9&amp;title=&amp;width=203" alt="image.png" loading="lazy"></li>
<li>初始化大小是0，添加一个容量+1</li>
</ul>
</li>
</ol>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<p><strong>比较（个人总结）：</strong>
<strong>注意：容量和</strong><code v-pre>**size()**</code><strong>不同。</strong><code v-pre>**size()**</code><strong>指的是有多少实际的数据。</strong>
<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654785573729-e5b5c179-38ad-4910-9ebf-3b6365ff31dd.png#clientId=uefe9bfec-13b2-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=246&amp;id=u508949b8&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=497&amp;originWidth=1514&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=319210&amp;status=done&amp;style=stroke&amp;taskId=uf58bcb7b-5800-4b77-b82c-c22184ecd58&amp;title=&amp;width=748" alt="image.png" loading="lazy"></p>
</div>
<h3 id="_9-7-collections工具类" tabindex="-1"><a class="header-anchor" href="#_9-7-collections工具类" aria-hidden="true">#</a> 9.7 Collections工具类</h3>
<h4 id="_9-7-1-介绍" tabindex="-1"><a class="header-anchor" href="#_9-7-1-介绍" aria-hidden="true">#</a> 9.7.1 介绍</h4>
<ol>
<li>操作Set、List、Map等集合的工具类。</li>
<li>能够对集合进行排序、查找、修改等工作。</li>
</ol>
<h4 id="_9-7-2-排序操作" tabindex="-1"><a class="header-anchor" href="#_9-7-2-排序操作" aria-hidden="true">#</a> 9.7.2 排序操作：</h4>
<ol>
<li><code v-pre>reverse(List)</code>：反转List中的元素顺序</li>
<li><code v-pre>shuffle(List)</code>：对List集合进行随机排序，每次调用都进行一次随机</li>
<li><code v-pre>sort(List)</code>：对List结合的元素进行自然排序（从小到大）</li>
<li><code v-pre>sort(List, Comparator)</code>：根据比较器的规则对List集合的元素进行排序</li>
<li><code v-pre>swap(List, int i, int j)</code>：交换List和i和j位置的元素
<ul>
<li>i或j超范围时抛出索引越界异常
| <strong>变量和类型</strong> | <strong>方法</strong> | <strong>描述</strong> |
| --- | --- | --- |
| static void | <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#reverse(java.util.List)" target="_blank" rel="noopener noreferrer">reverse<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">List<ExternalLinkIcon/></a><?> list) | 反转指定列表中元素的顺序。 |
| static void | [shuffle](https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#shuffle(java.util.List))([List](https://www.runoob.com/manual/jdk1.6/java.base/java/util/List.html)<?> list) | 使用默认的随机源随机置换指定的列表。 |
| static &lt;T extends <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Comparable.html" target="_blank" rel="noopener noreferrer">Comparable<ExternalLinkIcon/></a><? super T>> void | [sort](https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#sort(java.util.List))([List](https://www.runoob.com/manual/jdk1.6/java.base/java/util/List.html)<T> list) | 根据其元素的[natural   ordering](https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Comparable.html) ，将指定列表按升序排序。 |
| static <T> void | [sort](https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#sort(java.util.List,java.util.Comparator))([List](https://www.runoob.com/manual/jdk1.6/java.base/java/util/List.html)<T> list, [Comparator](https://www.runoob.com/manual/jdk1.6/java.base/java/util/Comparator.html)<? super T> c) | 根据指定比较器引发的顺序对指定列表进行排序。 |
| static void | [swap](https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#swap(java.util.List,int,int))([List](https://www.runoob.com/manual/jdk1.6/java.base/java/util/List.html)<?> list, int i, int j) | 交换指定列表中指定位置的元素。 |</li>
</ul>
</li>
</ol>
<h4 id="_9-7-3-查找、替换" tabindex="-1"><a class="header-anchor" href="#_9-7-3-查找、替换" aria-hidden="true">#</a> 9.7.3 查找、替换</h4>
<table>
<thead>
<tr>
<th><strong>变量和类型</strong></th>
<th><strong>方法</strong></th>
<th><strong>描述</strong></th>
</tr>
</thead>
<tbody>
<tr>
<td>static &lt;T extends <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> &amp; <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Comparable.html" target="_blank" rel="noopener noreferrer">Comparable<ExternalLinkIcon/></a>&lt;? super T&gt;&gt; T</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#max(java.util.Collection)" target="_blank" rel="noopener noreferrer">max<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;? extends T&gt; coll)</td>
<td>根据元素的 _自然顺序_返回给定集合的最大元素。</td>
</tr>
<tr>
<td>static <T> T</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#max(java.util.Collection,java.util.Comparator)" target="_blank" rel="noopener noreferrer">max<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;? extends T&gt; coll, <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Comparator.html" target="_blank" rel="noopener noreferrer">Comparator<ExternalLinkIcon/></a>&lt;? super T&gt; comp)</td>
<td>根据指定比较器引发的顺序返回给定集合的最大元素。</td>
</tr>
<tr>
<td>static &lt;T extends <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> &amp; <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Comparable.html" target="_blank" rel="noopener noreferrer">Comparable<ExternalLinkIcon/></a>&lt;? super T&gt;&gt; T</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#min(java.util.Collection)" target="_blank" rel="noopener noreferrer">min<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;? extends T&gt; coll)</td>
<td>根据元素的 _自然顺序_返回给定集合的最小元素。</td>
</tr>
<tr>
<td>static <T> T</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#min(java.util.Collection,java.util.Comparator)" target="_blank" rel="noopener noreferrer">min<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;? extends T&gt; coll, <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Comparator.html" target="_blank" rel="noopener noreferrer">Comparator<ExternalLinkIcon/></a>&lt;? super T&gt; comp)</td>
<td>根据指定比较器引发的顺序返回给定集合的最小元素。</td>
</tr>
<tr>
<td>static int</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#frequency(java.util.Collection,java.lang.Object)" target="_blank" rel="noopener noreferrer">frequency<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collection.html" target="_blank" rel="noopener noreferrer">Collection<ExternalLinkIcon/></a>&lt;?&gt; c, <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/lang/Object.html" target="_blank" rel="noopener noreferrer">Object<ExternalLinkIcon/></a> o)</td>
<td>返回指定集合中等于指定对象的元素数。</td>
</tr>
<tr>
<td>static <T> boolean</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#replaceAll(java.util.List,T,T)" target="_blank" rel="noopener noreferrer">replaceAll<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">List<ExternalLinkIcon/></a><T> list, T oldVal, T newVal)</td>
<td>用列表替换列表中所有出现的指定值。</td>
</tr>
<tr>
<td>static <T> void</td>
<td><a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/Collections.html#copy(java.util.List,java.util.List)" target="_blank" rel="noopener noreferrer">copy<ExternalLinkIcon/></a>(<a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">List<ExternalLinkIcon/></a>&lt;? super T&gt; dest, <a href="https://www.runoob.com/manual/jdk1.6/java.base/java/util/List.html" target="_blank" rel="noopener noreferrer">List<ExternalLinkIcon/></a>&lt;? extends T&gt; src)</td>
<td>将一个列表中的所有元素复制到另一个列表中。</td>
</tr>
</tbody>
</table>
<ul>
<li>使用<code v-pre>copy()</code>方法前必须确认目标集合与源集合有同样的size（注意size不是容量），否则会发生数组越界异常。</li>
</ul>
<h2 id="第10章-泛型" tabindex="-1"><a class="header-anchor" href="#第10章-泛型" aria-hidden="true">#</a> 第10章 泛型</h2>
<h3 id="_10-1-泛型的引出" tabindex="-1"><a class="header-anchor" href="#_10-1-泛型的引出" aria-hidden="true">#</a> 10.1 泛型的引出</h3>
<h4 id="_10-1-1-个人理解" tabindex="-1"><a class="header-anchor" href="#_10-1-1-个人理解" aria-hidden="true">#</a> 10.1.1 个人理解</h4>
<ul>
<li>集合中的添加的元素可以是任意类型，但某些特定需求下，需要将添加的类型限定在某一种类型，以保证开发效率、代码规范等目的。</li>
<li>这种情况下靠人为去控制添加的元素类型不具有显示意义，编译器也不会在编译程序的时候指出这种失误。</li>
<li>为了<strong>保证添加的元素类型一致、编译器能够在编译阶段（程序书写阶段）就发现错误、后续的代码中简化代码</strong>，java在JDK5.0时引入了泛型，它在集合、接口等有确定传入类型需求的类、接口声明时添加了占位元素，使得在使用时，用指定的元素类型替换占位元素，以达到上述目的。</li>
</ul>
<h4 id="_10-1-2-官方理解" tabindex="-1"><a class="header-anchor" href="#_10-1-2-官方理解" aria-hidden="true">#</a> 10.1.2 官方理解</h4>
<ul>
<li>泛型又称参数化类型，用于解决数据类型的安全性问题</li>
<li>需要在类声明或实例化时指定具体类型。</li>
<li>java泛型可以保证程序在编译时不出现警告，运行时也就不会产生ClassCastException，同时能够使diamagnetic更简洁、健壮。</li>
<li>泛型的作用是：可以在类声明时，通过一个标识，表示类中某个属性、某个方法的返回值、某个方法的参数是指定类型。</li>
</ul>
<h3 id="_10-2-使用泛型" tabindex="-1"><a class="header-anchor" href="#_10-2-使用泛型" aria-hidden="true">#</a> 10.2 使用泛型</h3>
<h4 id="_10-2-1-泛型的实例化" tabindex="-1"><a class="header-anchor" href="#_10-2-1-泛型的实例化" aria-hidden="true">#</a> 10.2.1 泛型的实例化</h4>
<ol>
<li>在创建对象时，<code v-pre>&lt;&gt;</code>中写上具体的参数类型。
<ul>
<li>例子：<code v-pre>List&lt;String&gt; list = new ArrayList&lt;String&gt;();</code></li>
<li>简写：<code v-pre>List&lt;String&gt; list = new ArrayList&lt;&gt;();</code>
<ul>
<li>好处：由编译器去自动推断数据类型，进一步保证数据安全。</li>
</ul>
</li>
</ul>
</li>
<li>细节：
<ul>
<li>写入的数据类型只能是引用类型，传入基本数据类型会报错</li>
<li>可以写入声明时指定的类型，或指定类型的子类型</li>
<li><code v-pre>&lt;&gt;</code>内不传入时，默认的泛型是Object</li>
</ul>
</li>
</ol>
<h4 id="_10-2-2-获取泛型的方法" tabindex="-1"><a class="header-anchor" href="#_10-2-2-获取泛型的方法" aria-hidden="true">#</a> 10.2.2 获取泛型的方法</h4>
<ol>
<li><code v-pre>getGenericSuperclass()</code>：与<code v-pre>getSuperclass()</code>方法类似，获取带泛型的父类类型。返回类型为<code v-pre>Type</code>。</li>
<li></li>
</ol>
<h3 id="_10-3-自定义泛型" tabindex="-1"><a class="header-anchor" href="#_10-3-自定义泛型" aria-hidden="true">#</a> 10.3 自定义泛型</h3>
<h4 id="_10-3-1-自定义泛型类" tabindex="-1"><a class="header-anchor" href="#_10-3-1-自定义泛型类" aria-hidden="true">#</a> 10.3.1 自定义泛型类</h4>
<ol>
<li>泛型的声明
<ul>
<li><code v-pre>class 类名&lt;K, V&gt;{}</code></li>
<li>K、V、T都不表示具体值或具体的类型，而是一个占位标记符，可以是任意标识符。
<ul>
<li>一般E使用在集合中</li>
<li>T使用在类中</li>
<li>K表示键</li>
<li>V表示值</li>
<li>N表示数值类型</li>
<li>?表示不确定的java类型</li>
</ul>
</li>
<li><code v-pre>&lt;&gt;</code>内可以写入多个，表示多个泛型</li>
</ul>
</li>
<li>声明细节：
<ul>
<li>泛型可以是属性、方法参数、方法返回值、构造器参数</li>
<li>泛型是数组时，不能在声明时初始化。
<ul>
<li>数组在<code v-pre>new</code>时，不确定泛型类型就不能在内存中开辟空间</li>
</ul>
</li>
<li>静态属性、静态方法（参数、返回值）不能是泛型
<ul>
<li>静态属性和静态方法随类的加载而加载，此时对象还没有创建，JVM无法初始化泛型</li>
</ul>
</li>
<li>泛型的类型在创建对象时确定
<ul>
<li>如果没有指定类型，则默认为Object</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_10-3-2-自定义泛型接口" tabindex="-1"><a class="header-anchor" href="#_10-3-2-自定义泛型接口" aria-hidden="true">#</a> 10.3.2 自定义泛型接口</h4>
<ol>
<li>泛型的声明
<ul>
<li><code v-pre>interface 接口名&lt;T&gt;{}</code></li>
<li>K、V、T都不表示具体值或具体的类型，而是一个占位标记符，可以是任意标识符。
<ul>
<li>一般E使用在集合中</li>
<li>T使用在类中</li>
<li>K表示键</li>
<li>V表示值</li>
<li>N表示数值类型</li>
<li>?表示不确定的java类型</li>
</ul>
</li>
<li><code v-pre>&lt;&gt;</code>内可以写入多个，表示多个泛型</li>
</ul>
</li>
<li>声明细节：
<ul>
<li>泛型可以是方法参数、方法返回值
<ul>
<li>不可以是属性，接口的属性是<code v-pre>public static final</code></li>
</ul>
</li>
<li>静态方法（参数及返回值）不能是泛型</li>
<li>泛型的类型在继承接口或实现接口时确定
<ul>
<li>如果没有指定类型，则默认为Object，且实现类默认使用Object</li>
<li>继承接口时确定：子接口的实现类会自动使用子接口确定的类型</li>
<li>实现接口时确定：实现类会自动使用实现类确定的类型</li>
</ul>
</li>
</ul>
</li>
</ol>
<h4 id="_10-3-3-自定义泛型方法" tabindex="-1"><a class="header-anchor" href="#_10-3-3-自定义泛型方法" aria-hidden="true">#</a> 10.3.3 自定义泛型方法</h4>
<ol>
<li>泛型的声明：<code v-pre>修饰符 &lt;参数类型列表&gt; 返回类型 方法名(参数列表){}</code></li>
<li>声明细节：
<ul>
<li>可以定义在普通类、普通接口中，也可以定义在泛型类、泛型接口中。</li>
<li>泛型方法被调用时类型会确定</li>
<li><code v-pre>public void eat(E e){}</code>修饰符后没有泛型标识，表示这个方法不是泛型方法，而是方法使用了（类声明的）泛型</li>
<li>泛型方法可以使用类声明的泛型，也可以使用自己声明的泛型</li>
</ul>
</li>
</ol>
<h3 id="_10-4-泛型的继承和通配符" tabindex="-1"><a class="header-anchor" href="#_10-4-泛型的继承和通配符" aria-hidden="true">#</a> 10.4 泛型的继承和通配符</h3>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654686345435-9a815001-8cc3-4755-87b8-34a50c036598.png#clientId=u92bfe641-6edf-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=117&amp;id=u18a969fb&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=117&amp;originWidth=633&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=142667&amp;status=done&amp;style=stroke&amp;taskId=u5c3e2321-8790-45e5-afc8-4c78df1f378&amp;title=&amp;width=633" alt="image.png" loading="lazy"></p>
<blockquote>
<ul>
<li>不对，泛型没有继承性</li>
</ul>
</blockquote>
<p>通配符注意点：
<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1654828938131-31da8281-89a2-4780-8714-3476af7b8401.png#clientId=uefe9bfec-13b2-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=253&amp;id=u62ddab7c&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=359&amp;originWidth=773&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=88457&amp;status=done&amp;style=stroke&amp;taskId=uca3f5a09-1612-45d2-a41b-80cd48770c0&amp;title=&amp;width=545" alt="image.png" loading="lazy"></p>
<h2 id="第11章-io流" tabindex="-1"><a class="header-anchor" href="#第11章-io流" aria-hidden="true">#</a> 第11章 IO流</h2>
<h3 id="_11-1-文件" tabindex="-1"><a class="header-anchor" href="#_11-1-文件" aria-hidden="true">#</a> 11.1 文件</h3>
<h4 id="_11-1-1-文件流" tabindex="-1"><a class="header-anchor" href="#_11-1-1-文件流" aria-hidden="true">#</a> 11.1.1 文件流</h4>
<ol>
<li>流：数据在数据源（文件）和程序（内存）之间经历的路径</li>
<li>输入流：数据从数据源（文件）到程序（内存）的路径</li>
<li>输出流：数据从程序（内存）到数据源（文件）的路径</li>
</ol>
<h4 id="_11-1-2-常用操作" tabindex="-1"><a class="header-anchor" href="#_11-1-2-常用操作" aria-hidden="true">#</a> 11.1.2 常用操作</h4>
<ol>
<li>创建文件对象
<ul>
<li><code v-pre>new File(String str)</code>：通过指定路径创建File实例</li>
<li><code v-pre>File(File parent, String child)</code>：通过父目录文件和子路径搭配创建File实例</li>
<li><code v-pre>File(String parent, String child)</code>：通过父目录和子路径搭配创建File实例</li>
</ul>
</li>
<li>获取文件相关信息
<ul>
<li><code v-pre>createNewFile()</code>：在指定路径生成目标文件，并保存在磁盘里
<ul>
<li>该方法有异常问题</li>
</ul>
</li>
<li><code v-pre>getName()</code>：获取文件名</li>
<li><code v-pre>getAbsolutePath()</code>：获取文件的绝对路径（带文件名）</li>
<li><code v-pre>getParent()</code>：获取父级目录</li>
<li><code v-pre>length()</code>获取文件内容有多少字节，根据文件的编码获取
<ul>
<li>UTF-8编码中，汉字3个字节</li>
</ul>
</li>
<li><code v-pre>exists()</code>：文件是否存在</li>
<li><code v-pre>isFile()</code>：是不是一个文件</li>
<li><code v-pre>isDirectory()</code>：是不是一个目录</li>
</ul>
</li>
<li>目录操作和文件删除：
<ul>
<li><code v-pre>delete()</code>：删除文件或空文件夹</li>
<li><code v-pre>mkdir()</code>：创建一级目录</li>
<li><code v-pre>mkdirs()</code>：创建多级目录</li>
</ul>
</li>
</ol>
<h3 id="_11-2-io流原理及分类" tabindex="-1"><a class="header-anchor" href="#_11-2-io流原理及分类" aria-hidden="true">#</a> 11.2 IO流原理及分类</h3>
<h4 id="_11-2-1-i-o流原理" tabindex="-1"><a class="header-anchor" href="#_11-2-1-i-o流原理" aria-hidden="true">#</a> 11.2.1 I/O流原理</h4>
<ol>
<li>用于数据传输，如读写文件，网络通讯。</li>
<li>java.io包下提供了各种流（stream）类和接口，用以获取不同类的数据，并通过方法输入或输出数据。</li>
<li>输入input：读取外部数据到内存（程序）中</li>
<li>输出output：将程序（内存）中的数据输出到存储设备中。</li>
</ol>
<h4 id="_11-2-2-流的分类-写、out-自身→外部-读、input-外部→自身" tabindex="-1"><a class="header-anchor" href="#_11-2-2-流的分类-写、out-自身→外部-读、input-外部→自身" aria-hidden="true">#</a> 11.2.2 流的分类：写、out：自身→外部，读、input：外部→自身</h4>
<ol>
<li>按照操作数据单位分：字节流（8字节）二进制文件、字符流（按字符）文本文件</li>
<li>按数据流向：输入流、输出流</li>
<li>按流的角色：节点流、处理流/包装流
<ul>
<li>节点流：从一个特定的数据源读写数据
<ul>
<li>数据源：存放数据的地方，可以是文件、字符串、数组、管道</li>
</ul>
</li>
<li>处理流/包装流：建立在已有的流之上，为程序提供更强大、更灵活的读写功能
<ul>
<li>如BufferedReader、BufferedWriter</li>
<li>处理流类的底层封装了节点流的Wrtie或Reader对象，根据多态，可以使用各种Writer和Reader的子类对象</li>
</ul>
</li>
</ul>
</li>
</ol>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<p>节点流和处理流的区别和联系：</p>
<ul>
<li>节点流是底层流，直接更数据源相接</li>
<li>处理流包装节点流，可以消除不同节点流的实现差异，也可以提供更方便的方法完成输入输出</li>
<li>处理流对节点流的包装，使用了修饰器涉及模式，不会直接与数据源相连</li>
<li>处理流提高了性能：主要以增加缓冲的方式提高输入输出的效率</li>
<li>处理流提供了操作的便捷：处理流可能提供了一系列编辑的方法来一次输入输出大批量的数据，使用更加灵活方便。</li>
</ul>
</div>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655076701795-2a45f660-af0e-4a01-bb69-fc6b1cfba311.png#clientId=u7843e38b-d936-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;id=uc2fff44d&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=674&amp;originWidth=1332&amp;originalType=url&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=458599&amp;status=done&amp;style=none&amp;taskId=u340c5d7b-b83b-4a12-93e9-46c31c154c5&amp;title=" alt="image.png" loading="lazy"></p>
<table>
<thead>
<tr>
<th>抽象基类</th>
<th>字节流</th>
<th>字符流</th>
</tr>
</thead>
<tbody>
<tr>
<td>输入流</td>
<td>InputStream</td>
<td>Reader</td>
</tr>
<tr>
<td>输出流</td>
<td>OutputStream</td>
<td>Writer</td>
</tr>
</tbody>
</table>
<ul>
<li>java的io流涉及40多个类，都是从上述4个抽象基类派生而来</li>
<li>这4个基类派生出来的子类名称都是以基类名作为子类名的后缀</li>
</ul>
<ol start="4">
<li>IO流体系图</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655109862091-af2dabfe-e36a-4c82-9ab6-748068363394.png#clientId=ud90fe092-97d3-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=ui&amp;id=u7a56f0c0&amp;margin=[object Object]&amp;name=java.io.png&amp;originHeight=8506&amp;originWidth=10250&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=2680163&amp;status=done&amp;style=none&amp;taskId=ue3e13abb-c019-4845-a488-3c8ad2c0010&amp;title=" alt="java.io.png" loading="lazy"></p>
<h3 id="_11-3-节点流-文件流" tabindex="-1"><a class="header-anchor" href="#_11-3-节点流-文件流" aria-hidden="true">#</a> 11.3 节点流/文件流</h3>
<h4 id="_11-3-1-fileinputstream" tabindex="-1"><a class="header-anchor" href="#_11-3-1-fileinputstream" aria-hidden="true">#</a> 11.3.1 FileInputStream</h4>
<ol>
<li>创建文件输入流对象：<code v-pre>new FileInputStream(filePath)</code>：
<ul>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>read()</code>：从输入流中读取一个字节的数据，
<ul>
<li>到达文件末尾时，返回-1（读取完毕）</li>
<li>有异常问题</li>
<li>读入的字节数据是ASCII编码，使用字符强转可得到原文</li>
</ul>
</li>
<li><code v-pre>read(byte[] b)</code>：一次读取b.length()个字节存入到b中，返回实际读取的字节数量
<ul>
<li>到达文件末尾时，返回-1（读取完毕）</li>
<li>有异常问题</li>
<li>读入的字节数据是ASCII编码组成的数组，转换为字符串时可使用<code v-pre>String(byte[] bytes, int offset, int length)</code>构造器
<ul>
<li>offset：byte[]数组起点下标</li>
<li>length：读入byte[]字节长度</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>read(byte[] b, int off, int len)</code>：开发中使用这个
<ul>
<li>到达文件末尾时，返回-1（读取完毕）</li>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>close()</code>：关闭文件输入流，并释放与该流相关的所有系统资源
<ul>
<li>由于创建输入流对象有异常问题，该方法须在finally块中调用，以保证确实执行。</li>
</ul>
</li>
</ol>
<h4 id="_11-3-2-fileoutputstream" tabindex="-1"><a class="header-anchor" href="#_11-3-2-fileoutputstream" aria-hidden="true">#</a> 11.3.2 FileOutputStream</h4>
<ol>
<li>创建文件输出流对象：
<ul>
<li><code v-pre>new FileOutputStream(filePath)</code>：覆盖模式</li>
<li><code v-pre>new FileOutputStream(filePath, true)</code>：追加模式：第二个参数设置为true时，输出的字节流是追加的方式</li>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>write(int b)</code>：将单个字节数据输出到输出流，传入的是一个ASCII整数，或者一个字符（会自动类型转换为整型）
<ul>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>write(byte[] b)</code>：将b.length()个字节输出到输出流
<ul>
<li>有异常问题</li>
<li>可搭配String的<code v-pre>getBytes(str)</code>使用，将字符串转换为字符数组</li>
</ul>
</li>
<li><code v-pre>write(byte[] b, int off, int len)</code>：将字节数组b，从下标off开始的len个字节数据输出到输出流。开发中使用这个
<ul>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>close()</code>：关闭文件输出流，并释放与该流相关的所有系统资源
<ul>
<li>由于创建输出流对象有异常问题，该方法须在finally块中调用，以保证确实执行。</li>
</ul>
</li>
</ol>
<h4 id="_11-3-3-文件拷贝" tabindex="-1"><a class="header-anchor" href="#_11-3-3-文件拷贝" aria-hidden="true">#</a> 11.3.3 文件拷贝</h4>
<ol>
<li>搭配输入输出流使用</li>
</ol>
<h4 id="_11-3-4-filereader" tabindex="-1"><a class="header-anchor" href="#_11-3-4-filereader" aria-hidden="true">#</a> 11.3.4 FileReader</h4>
<ol>
<li>创建文件读取对象：<code v-pre>new FileReader(filePath)</code>：
<ul>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>reader()</code>：读取单个字符，读入的是个整数
<ul>
<li>到达文件末尾时，返回-1（读取完毕）</li>
<li>有异常问题</li>
<li>读入的字符数据是ASCII编码，使用字符强转可得到原文</li>
</ul>
</li>
<li><code v-pre>read(byte[] b)</code>：一次读取b.length()个字符存入到b中，返回实际读取的字符数量
<ul>
<li>到达文件末尾时，返回-1（读取完毕）</li>
<li>有异常问题</li>
<li>读入的字符数据是ASCII编码组成的数组，转换为字符串时可使用<code v-pre>String(char[] chars, int offset, int length)</code>构造器
<ul>
<li>offset：char[]数组起点下标</li>
<li>length：读入char[]字节长度</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>read(char[] b, int off, int len)</code>：开发中使用这个
<ul>
<li>到达文件末尾时，返回-1（读取完毕）</li>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>close()</code>：关闭文件读取对象，并释放与该流相关的所有系统资源
<ul>
<li>由于创建文件读取对象有异常问题，该方法须在finally块中调用，以保证确实执行。</li>
</ul>
</li>
</ol>
<h4 id="_11-3-5-filewrite" tabindex="-1"><a class="header-anchor" href="#_11-3-5-filewrite" aria-hidden="true">#</a> 11.3.5 FileWrite</h4>
<ol>
<li>创建文件写入流对象：
<ul>
<li><code v-pre>new FileWriter(filePath)</code>：覆盖模式</li>
<li><code v-pre>new FileWriter(filePath, true)</code>：追加模式：第二个参数设置为true</li>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>write(int b)</code>：将单个字符数据输出到输出流，传入的是一个ASCII整数，或者一个字符（会自动类型转换为整型）
<ul>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>write(char[] b)</code>：将b.length()个字符输出到输出流
<ul>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>write(char[] b, int off, int len)</code>：将字符数组b，从下标off开始的len个字符数据输出到输出流。开发中使用这个
<ul>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>write(String str)</code>：写入整个字符串</li>
<li><code v-pre>write(String str, int off, int len)</code>：写入字符串指定部分</li>
<li><code v-pre>close()</code>：关闭文件输出流，并释放与该流相关的所有系统资源
<ul>
<li>由于创建输出流对象有异常问题，该方法须在finally块中调用，以保证确实执行。</li>
<li>FileWtrie必须关闭流(close())或(flush()，否则不能真正保存到文件</li>
<li>等价于flush()和关闭</li>
</ul>
</li>
</ol>
<h3 id="_11-4-处理流" tabindex="-1"><a class="header-anchor" href="#_11-4-处理流" aria-hidden="true">#</a> 11.4 处理流</h3>
<ul>
<li><strong>BufferedReader和BufferedWriter</strong>
<ul>
<li><strong>属于字符流，一般用于处理文本文件</strong>，处理声音、视频、doc、pdf等二进制文件时有数据丢失的风险。</li>
<li>关闭流时，只需要关闭外层的BufferedReader或BufferedWriter即可，而不是传入的Reader、Writer对象，底层会自动关闭对应的传入Reader、Writer对象</li>
</ul>
</li>
<li>BufferedInputStream和BufferedOutputStream
<ul>
<li>属于字节流，既可处理文本文件，也可处理二进制文件</li>
</ul>
</li>
</ul>
<h4 id="_11-4-1-bufferedreader" tabindex="-1"><a class="header-anchor" href="#_11-4-1-bufferedreader" aria-hidden="true">#</a> 11.4.1 BufferedReader</h4>
<ol>
<li>创建对象：<code v-pre>new BufferedReader(Reader in)</code>：
<ul>
<li>有异常问题。</li>
<li>异常存在于传入的Reader in对象</li>
</ul>
</li>
<li><code v-pre>readLine()</code>：按行读取，读取完毕返回null
<ul>
<li>不读入换行</li>
</ul>
</li>
</ol>
<h4 id="_11-5-2-bufferedwriter" tabindex="-1"><a class="header-anchor" href="#_11-5-2-bufferedwriter" aria-hidden="true">#</a> 11.5.2 BufferedWriter</h4>
<ol>
<li>创建对象：<code v-pre>new BufferedWriter(Writer out)</code>
<ul>
<li>有异常问题。</li>
<li>异常存在于传入的Writer out对象</li>
</ul>
</li>
<li><code v-pre>write(String s, int off, int len)</code>：写入字符串的一部分
<ul>
<li>好像不要off和len的时候是传入整个字符串？</li>
</ul>
</li>
<li><code v-pre>newLine()</code>：插入一个和系统相关的换行符</li>
</ol>
<h4 id="_11-4-3-bufferedinputstream" tabindex="-1"><a class="header-anchor" href="#_11-4-3-bufferedinputstream" aria-hidden="true">#</a> 11.4.3 BufferedInputStream</h4>
<ul>
<li><code v-pre>new BufferedInputStream(InputStream in)</code></li>
<li>类似BufferedReader</li>
<li>使用的方法是：<code v-pre>read(byte[] b, int off, int len)</code></li>
</ul>
<h4 id="_11-4-4-bufferedoutputstream" tabindex="-1"><a class="header-anchor" href="#_11-4-4-bufferedoutputstream" aria-hidden="true">#</a> 11.4.4 BufferedOutputStream</h4>
<ul>
<li><code v-pre>new BufferedOutputStream(OutputStream out)</code></li>
<li>类似于BufferedWriter</li>
<li>使用的方法是：<code v-pre>write(byte[] b, int off, int len)</code></li>
</ul>
<h4 id="_11-4-5-序列化和反序列化" tabindex="-1"><a class="header-anchor" href="#_11-4-5-序列化和反序列化" aria-hidden="true">#</a> 11.4.5 序列化和反序列化</h4>
<ol>
<li>序列化：保存值和数据类型到文件</li>
<li>反序列化：将保存到文件的数据值和数据类型进行恢复</li>
<li>对象要可序列化，则要求该对象实现<code v-pre>Serializable</code>或<code v-pre>Externalizable</code>接口。
<ul>
<li>一般使用<code v-pre>Serializable</code>，该接口为标记接口——没有任何属性和方法</li>
<li><code v-pre>Externalizable</code>，继承自<code v-pre>Serializable</code>，需要重写两个方法</li>
</ul>
</li>
<li>注意事项
<ul>
<li>读写顺序要一致</li>
<li>序列化或反序列化的对象必须实现<code v-pre>Serializable</code>或<code v-pre>Externalizable</code>接口。</li>
<li>序列化的对象建议添加<code v-pre>private static final long serialVersionUID</code>，提高兼容性</li>
<li>序列化的对象，会默认初始化除static和transient修饰的成员</li>
<li>序列化的对象，其属性类型也需要实现序列化接口，有异常问题</li>
<li>序列化具有继承性，其子类自动可序列化</li>
</ul>
</li>
</ol>
<h4 id="_11-4-6-objectoutputstream" tabindex="-1"><a class="header-anchor" href="#_11-4-6-objectoutputstream" aria-hidden="true">#</a> 11.4.6 ObjectOutputStream</h4>
<ol>
<li>特征：字节流、处理流、对象流、提供序列化功能</li>
<li>创建对象：<code v-pre>new ObjectOutputStream(OutputStream out)</code></li>
<li><code v-pre>writeInt(int)</code>：自动装箱，写一个32位的整形数</li>
<li><code v-pre>writeBoolean(boolean)</code>：自动装箱</li>
<li><code v-pre>writeChar(int)</code>：自动装箱，写一个16位字符，可传入字符，会自动转换为int</li>
<li><code v-pre>writeDouble(double)</code>：自动装箱，写一个64位双精度浮点数</li>
<li><code v-pre>writeUTF(String)</code>：以UTF-8模式写入字符串</li>
<li><code v-pre>writeObject(Object)</code>：将指定对象写入</li>
<li><code v-pre>close()</code></li>
<li>上述均有异常问题。</li>
</ol>
<h4 id="_11-4-7-objectinputstream" tabindex="-1"><a class="header-anchor" href="#_11-4-7-objectinputstream" aria-hidden="true">#</a> 11.4.7 ObjectInputStream</h4>
<ol>
<li>特征：字节流、处理流、对象流、提供反序列化功能，<strong>反序列化顺序必须与序列化顺序一致。</strong></li>
<li>创建对象：<code v-pre>new ObjectInputStream(InputStream input)</code></li>
<li><code v-pre>readInt()</code></li>
<li><code v-pre>readBoolean()</code></li>
<li><code v-pre>readChar()</code></li>
<li><code v-pre>readDouble()</code></li>
<li><code v-pre>readUTF()</code></li>
<li><code v-pre>readObject()</code>：底层表现多塔的特征，编译类型是Object，运行类型是实际的类型，底层会进行造型和强转。但如果使用运行类型的方法，需要进行显式强转。</li>
<li><code v-pre>close()</code></li>
<li>上述均有异常问题</li>
</ol>
<h3 id="_11-5-标准输入流和输出流-java-lang-object" tabindex="-1"><a class="header-anchor" href="#_11-5-标准输入流和输出流-java-lang-object" aria-hidden="true">#</a> 11.5 标准输入流和输出流（java.lang.Object）</h3>
<ol>
<li><code v-pre>System.in</code>类：编译类型为<code v-pre>InputStream</code>、运行类型为<code v-pre>BufferedInputStream</code>
<ul>
<li>标准输入</li>
<li>输入源键盘</li>
<li>返回<code v-pre>InputStream</code></li>
</ul>
</li>
<li><code v-pre>System.out</code>类：编译类型为<code v-pre>PrintStream</code>、运行类型为<code v-pre>PrintStream</code>
<ul>
<li>标准输出</li>
<li>输出源显示器</li>
<li>返回<code v-pre>OutputStream</code></li>
</ul>
</li>
</ol>
<h3 id="_11-6-转换流" tabindex="-1"><a class="header-anchor" href="#_11-6-转换流" aria-hidden="true">#</a> 11.6 转换流</h3>
<ul>
<li><code v-pre>InputStreamReader</code>（字符流）：
<ul>
<li>默认情况下，读取文件时按照utf-8的形式，</li>
<li><code v-pre>Reader</code>的子类</li>
<li>可以将<code v-pre>InputStream</code>（字节流）包装成/转换成<code v-pre>Reader</code>（字符流）</li>
<li><code v-pre>InputStreamReader(InputStream in, Charset cs)</code>：按照读取文件的cs编码格式进行读入</li>
</ul>
</li>
<li><code v-pre>OutputStreamWriter</code>（字符流）：
<ul>
<li>指定处理编码</li>
<li><code v-pre>Writer</code>的子类</li>
<li>可以将<code v-pre>OutputStream</code>（字节流）转换成<code v-pre>Writer</code>（字符流）</li>
<li><code v-pre>OutputStreamReader(OutputStream in, Charset cs)</code></li>
</ul>
</li>
<li>主要用于解决中文文本数据
<ul>
<li>中文文本数据有乱码问题</li>
<li>中文文本按照字符流处理（读取和写入）效率更高</li>
</ul>
</li>
</ul>
<h3 id="_11-7-打印流" tabindex="-1"><a class="header-anchor" href="#_11-7-打印流" aria-hidden="true">#</a> 11.7 打印流</h3>
<ul>
<li>只有输出流没有输入流</li>
</ul>
<h4 id="_11-7-1-printstream" tabindex="-1"><a class="header-anchor" href="#_11-7-1-printstream" aria-hidden="true">#</a> 11.7.1 PrintStream</h4>
<ol>
<li>构造器（常用）：
<ul>
<li><code v-pre>PrintStream(OutputStream out)</code>：
<ul>
<li><code v-pre>PrintStream(System.out)</code>：默认屏幕输出</li>
</ul>
</li>
<li><code v-pre>PrintStream(File file)</code>：可指定编码</li>
<li><code v-pre>PrintStream(String fileName)</code>：可指定编码</li>
<li><code v-pre>PrintStream(Writer out)</code>：可指定编码</li>
</ul>
</li>
<li>使用：<code v-pre>PrintStream out = System.out</code>
<ul>
<li><code v-pre>out.print()</code>：默认情况下，输出位置是标准输出——显示器</li>
<li><code v-pre>print()</code>底层使用的是<code v-pre>write()</code>，故可以使用字节流的<code v-pre>write()</code>方法进行时输出</li>
<li>修改输出位置：<code v-pre>System.setOut(PrintStream ps)</code>，然后调用<code v-pre>out.print()</code>
<ul>
<li>根据创建的<code v-pre>ps</code>对象，可以输出到指定文件</li>
</ul>
</li>
</ul>
</li>
<li>需要关闭。</li>
</ol>
<h4 id="_11-7-2-printwriter" tabindex="-1"><a class="header-anchor" href="#_11-7-2-printwriter" aria-hidden="true">#</a> 11.7.2 PrintWriter</h4>
<ol>
<li>构造器：
<ul>
<li><code v-pre>PrintWriter(OutputStream out)</code>：
<ul>
<li><code v-pre>PrintWriter(System.out)</code>：默认屏幕输出</li>
</ul>
</li>
<li><code v-pre>PrintWriter(File file)</code>：可指定编码</li>
<li><code v-pre>PrintWriter(String fileName)</code>：可指定编码</li>
<li><code v-pre>PrintWriter(Writer out)</code>：可指定编码</li>
</ul>
</li>
<li>使用：
<ul>
<li>调用<code v-pre>print()</code>方法</li>
</ul>
</li>
<li>需要关闭。</li>
</ol>
<h3 id="_11-8-properties" tabindex="-1"><a class="header-anchor" href="#_11-8-properties" aria-hidden="true">#</a> 11.8 Properties</h3>
<ol>
<li>作用：专门用于读写配置文件的集合类
<ul>
<li>配置文件格式：<code v-pre>键=值</code></li>
<li>键值对不需要有空格</li>
<li>值不需要使用引号</li>
<li>默认类型为String</li>
</ul>
</li>
<li>创建对象：<code v-pre>new Properties()</code></li>
<li>常见方法：
<ul>
<li><code v-pre>load(Reader reader)</code></li>
<li><code v-pre>loaad(InputStream instream)</code>：加载配置文件</li>
<li><code v-pre>list(PrintWriter out)</code>：将此属性列表打印到指定的输出流（键值对的形式）
<ul>
<li><code v-pre>list(System.out)</code>：屏幕输出</li>
</ul>
</li>
<li><code v-pre>list(PrintStream out)</code></li>
<li><code v-pre>getProperty(String key)</code>：根据key获取value</li>
<li><code v-pre>setProperty(String key, String value)</code>：修改、添加键值对到Properties类的对象（此时还没添加到文件里）</li>
<li><code v-pre>store(OutputStream out, String comments)</code>：将k-v存储到文件中
<ul>
<li>comments会添加文件的开头，以#注释，一般可置为null</li>
</ul>
</li>
<li><code v-pre>store(Writer writer, String comments)</code></li>
</ul>
</li>
<li>IDEA中使用路径：
<ul>
<li>绝对路径</li>
<li>工程路径：<code v-pre>src/io.properties</code></li>
<li>模块路径：<code v-pre>模块名/src/io.properties</code></li>
</ul>
</li>
</ol>
<h2 id="第12章-网络编程" tabindex="-1"><a class="header-anchor" href="#第12章-网络编程" aria-hidden="true">#</a> 第12章 网络编程</h2>
<h3 id="_12-1-网络相关概念" tabindex="-1"><a class="header-anchor" href="#_12-1-网络相关概念" aria-hidden="true">#</a> 12.1 网络相关概念</h3>
<h4 id="_12-1-1-网络通信" tabindex="-1"><a class="header-anchor" href="#_12-1-1-网络通信" aria-hidden="true">#</a> 12.1.1 网络通信</h4>
<ol>
<li>概念：两台设备之间通过网络实现数据传输</li>
<li>网络通信：将数据通过网络从一台设备传输到另一台设备。</li>
<li>java.net包提供了一系列接口，供编程使用，往后曾网络通信。</li>
</ol>
<div class="custom-container warning"><p class="custom-container-title">注意</p>
<p>推荐课程：</p>
</div>
<h4 id="_12-1-2-网络" tabindex="-1"><a class="header-anchor" href="#_12-1-2-网络" aria-hidden="true">#</a> 12.1.2 网络</h4>
<ol>
<li>概念：两台或多态设备通过一定物理设备连接起来就构成了网络。</li>
<li>分类：根据覆盖范围分
<ul>
<li>局域网：</li>
<li>城域网</li>
<li>广域网：万维网时广域网的代表</li>
</ul>
</li>
</ol>
<h4 id="_12-1-3-ip地址" tabindex="-1"><a class="header-anchor" href="#_12-1-3-ip地址" aria-hidden="true">#</a> 12.1.3 IP地址</h4>
<ol>
<li>概念：用于唯一标识网络中的每台计算机/主机</li>
<li><code v-pre>ipconfig</code>：查看本机ip地址</li>
<li>IPV4地址表示形式：点分十进制，<code v-pre>xxx.xxx.xxx.xxx</code></li>
<li>组成：网络地址 + 主机地址</li>
<li>IPV4分类：</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655196319657-c3511922-834e-41a0-9bfc-1288ae4b9eaf.png#clientId=u5f211634-2e28-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=253&amp;id=u8036f0fd&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=597&amp;originWidth=983&amp;originalType=url&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=102963&amp;status=done&amp;style=none&amp;taskId=uc757b0cb-e7f8-444d-baf2-5c6acd9fc74&amp;title=&amp;width=416" alt="image.png" loading="lazy"><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655196331701-bad6704c-ba0d-4ef0-b998-38e33729806c.png#clientId=u5f211634-2e28-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=180&amp;id=u86679a39&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=348&amp;originWidth=514&amp;originalType=url&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=63307&amp;status=done&amp;style=none&amp;taskId=ub4976e59-d7b9-43d8-bc48-60680d0796b&amp;title=&amp;width=266" alt="image.png" loading="lazy"></p>
<ol start="6">
<li>本地主机地址：127.0.0.1</li>
</ol>
<h4 id="_12-1-4-域名" tabindex="-1"><a class="header-anchor" href="#_12-1-4-域名" aria-hidden="true">#</a> 12.1.4 域名</h4>
<ol>
<li>概念：将ip地址根据http协议，映射成域名，便于记忆</li>
<li>端口号：
<ul>
<li>概念：用于标识计算机上某个特定的网络程序（服务）</li>
<li>表示形式：以整数表示，端口范围0~65535（216-1）</li>
<li>0~1024一般系统预留（已被占用）
<ul>
<li>22：ssh</li>
<li>21：ftp</li>
<li>25：smtp</li>
<li>80：http</li>
</ul>
</li>
<li>常见网络程序端口号：
<ul>
<li>8080：tomcat</li>
<li>3306：mysql</li>
<li>1521：oracle</li>
<li>1433：sqlserver</li>
</ul>
</li>
</ul>
</li>
<li>netstat指令：
<ul>
<li>netstat -an：查看当前主机网络情况，包括端口监听和网络连接状态
<ul>
<li>Listenning表示端口正在监听</li>
</ul>
</li>
<li>netstat -an | more：分页显示网络情况，按空格显示下一页</li>
</ul>
</li>
</ol>
<h4 id="_12-1-5-网络通信协议-tcp-ip" tabindex="-1"><a class="header-anchor" href="#_12-1-5-网络通信协议-tcp-ip" aria-hidden="true">#</a> 12.1.5 网络通信协议（TCP/IP）</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655198010580-06518ee4-38a1-4ad3-815c-1a48ac7e491a.png#clientId=u5f211634-2e28-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=577&amp;id=u5becdb1a&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=718&amp;originWidth=989&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=260001&amp;status=done&amp;style=none&amp;taskId=ud27290a6-8141-4735-a738-a1d63125144&amp;title=&amp;width=795" alt="image.png" loading="lazy"></p>
<ol>
<li>TCP：Transmission Control Protocol，传输控制协议
<ul>
<li>使用TCP协议前，须建立TCP连接，形成数据传输通道</li>
<li>传输前，采用“三次握手”确保连接可靠</li>
<li>“三次握手”可靠后，可进行大数据量传输</li>
<li>传输完毕后，需要释放已经建立的连接，效率低。</li>
<li>TCP协议通信时用到的两个应用进程：客户端、服务端</li>
</ul>
</li>
<li>IP：Internet Protocol，网络通讯协议</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655198125786-44f95ed5-83cc-494a-bed4-5bf44a838dbe.png#clientId=u5f211634-2e28-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=213&amp;id=uc0880cea&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=462&amp;originWidth=1225&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=480882&amp;status=done&amp;style=none&amp;taskId=uc1aed2ef-f361-44c4-9323-ef01cac430d&amp;title=&amp;width=566" alt="image.png" loading="lazy"></p>
<ol start="3">
<li>UDP协议（用户数据协议）
<ul>
<li>将数据、源、目的封装成数据包，不需要建立连接
<ul>
<li>不可靠</li>
</ul>
</li>
<li>每个数据包大小现在在64k内，不适合大数据量传输</li>
<li>传输完毕不需要释放资源，速度快</li>
</ul>
</li>
</ol>
<h3 id="_12-2-inetaddress类" tabindex="-1"><a class="header-anchor" href="#_12-2-inetaddress类" aria-hidden="true">#</a> 12.2 InetAddress类</h3>
<ol>
<li><code v-pre>getLocalHost()</code>：静态方法，获取本机InetAddress对象
<ul>
<li>返回：域名/ip地址</li>
</ul>
</li>
<li><code v-pre>getByName(String host)</code>：根据指定主机名/域名，获取其ip地址对象</li>
<li><code v-pre>getHostAddress</code>：通过InetAddress对象，获取其ip地址（主机名）</li>
<li><code v-pre>getHostName()</code>：通过InetAddress对象，获取其主机名或域名</li>
</ol>
<h3 id="_12-3-socket-套接字" tabindex="-1"><a class="header-anchor" href="#_12-3-socket-套接字" aria-hidden="true">#</a> 12.3 Socket（套接字）</h3>
<ol>
<li>组成：端口号+ip地址</li>
<li>作用：Socket允许程序把网络当成一个流，数据在两个Socket间通过IO传输</li>
<li>分类：一般将主动发起通信的应用程序成为客户端，等待通信请求的为服务端</li>
</ol>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655207997000-df82d2cd-5f4a-4da3-b5e2-aa25cf5f2c61.png#clientId=u8f3528d2-5dfb-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=296&amp;id=u02d99550&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=552&amp;originWidth=1280&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=826058&amp;status=done&amp;style=none&amp;taskId=u6167c93e-daae-4fcf-afde-5ab635d2c13&amp;title=&amp;width=686" alt="image.png" loading="lazy"></p>
<h4 id="_12-3-1-tcp网络通信编程" tabindex="-1"><a class="header-anchor" href="#_12-3-1-tcp网络通信编程" aria-hidden="true">#</a> 12.3.1 TCP网络通信编程</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655208023659-2eb99be6-1e13-4343-8476-b27720e2f8c4.png#clientId=u8f3528d2-5dfb-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=240&amp;id=u1397b7ce&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=374&amp;originWidth=881&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=192876&amp;status=done&amp;style=none&amp;taskId=u3b988a32-f9cc-41f9-9c6c-346023c7816&amp;title=&amp;width=566" alt="image.png" loading="lazy"></p>
<ul>
<li>必须关闭Socket，否则会造成服务器占用，导致无法连接</li>
<li>ServerSocket每调用一次accept()，就会开启一个Socket，所以也必须关闭ServerSocket</li>
<li>单向数据传输（客户端单向数据流，服务器单向数据流），可不设置结束标志，可以正常通信。</li>
<li>双向数据传输，必须设置结束标志，且关闭位置必须紧邻输出流。否则服务器会阻塞，处于等待状态，无正常输出。
<ul>
<li>结束标志：<code v-pre>socket.shutdownOutput()</code></li>
<li>字符流输出中，可利用<code v-pre>newLine()</code>和<code v-pre>readLine()</code>作为结束标志，而不使用<code v-pre>socket.shutdownOutput()</code></li>
</ul>
</li>
<li>当客户端连接到服务端后，客户端也会通过一个端口与服务端通讯，该端口由TCP/IP随机分配</li>
</ul>
<h4 id="_12-3-2-udp网络编程" tabindex="-1"><a class="header-anchor" href="#_12-3-2-udp网络编程" aria-hidden="true">#</a> 12.3.2 UDP网络编程</h4>
<ol>
<li><code v-pre>DatagramSocket</code>类和<code v-pre>DatagramPacket</code>类【数据包/数据报】实现了基于UDP协议的网络程序</li>
<li>UDP协议发送的数据不一定能够安全到达目的地，也不确定何时到达。</li>
<li><code v-pre>DatagramSocket</code>类和<code v-pre>DatagramPacket</code>类的对象封装了UDP数据报，包含了发送端的IP地址和端口号，以及接收端IP地址和端口号</li>
<li>UDP协议的每个数据报都包含了完整的地址信息，因此无需建立发送方和接收放的连接</li>
<li>基本流程：
<ul>
<li>通过<code v-pre>DatagramSocket</code>建立发送端和接收端
<ul>
<li>没有服务端、客户端的概念</li>
</ul>
</li>
<li>将数据封装到<code v-pre>DatagramPocket</code>对象</li>
<li>调用<code v-pre>DatagramSocket</code>的方法接收、发送数据</li>
<li>调用<code v-pre>DatagramPocket</code>的<code v-pre>getData()</code>方法解析数据</li>
<li>关闭<code v-pre>DatagramSocket</code></li>
</ul>
</li>
<li>注意：必须先启动先接收到数据的端，不然服务会一直阻塞。</li>
</ol>
<h2 id="第13章-反射-reflection" tabindex="-1"><a class="header-anchor" href="#第13章-反射-reflection" aria-hidden="true">#</a> 第13章 反射(Reflection)</h2>
<h3 id="_13-1-反射概述" tabindex="-1"><a class="header-anchor" href="#_13-1-反射概述" aria-hidden="true">#</a> 13.1 反射概述</h3>
<h4 id="_13-1-1-反射机制" tabindex="-1"><a class="header-anchor" href="#_13-1-1-反射机制" aria-hidden="true">#</a> 13.1.1 反射机制</h4>
<ol>
<li>基本认识：反射机制允许程序在执行期间，借助Reflection API取得任何类的内部信息，如成员变量，构造器，成员方法等，并能操作对象的属性和方法，而不会对操作的类代码产生修改。</li>
<li>大概解释：类加载完后，JVM堆内存中就产生一个Class类型的对象（一个类只有一个Class对象），这个对象包含了类的完整结构信息，通过该对象可以得到类的结构。对象相当于镜子。
<ul>
<li>类加载器使用了同步代码块，保证了即使时多线程情况下，一个类的Class类对象只有一个</li>
</ul>
</li>
</ol>
<h4 id="_13-1-2-反射机制原理示意图-后期再理解-暂时不解" tabindex="-1"><a class="header-anchor" href="#_13-1-2-反射机制原理示意图-后期再理解-暂时不解" aria-hidden="true">#</a> 13.1.2 反射机制原理示意图（后期再理解，暂时不解）</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655378886918-6ebaaef8-1178-4db1-9f6e-5ca1b5c4ebe8.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=400&amp;id=uadeaa695&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=729&amp;originWidth=1611&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=795278&amp;status=done&amp;style=none&amp;taskId=u394b5757-1215-467b-b741-fc96d8437c9&amp;title=&amp;width=884" alt="image.png" loading="lazy"></p>
<h4 id="_13-1-3-作用" tabindex="-1"><a class="header-anchor" href="#_13-1-3-作用" aria-hidden="true">#</a> 13.1.3 作用</h4>
<ol>
<li>在运行时判断任意一个对象所属的类</li>
<li>在运行时构造任意一个类的对象</li>
<li>在运行时得到任意一个类所具有的成员变量和方法</li>
<li>在运行时调用任意一个对象的成员变量和方法</li>
<li>生成动态代理</li>
</ol>
<h4 id="_13-1-4-反射相关的主要类" tabindex="-1"><a class="header-anchor" href="#_13-1-4-反射相关的主要类" aria-hidden="true">#</a> 13.1.4 反射相关的主要类</h4>
<ol>
<li><code v-pre>java.lang.Class</code>：代表一个类，Class类对象表示某个类加载后在堆中的对象</li>
<li><code v-pre>java.lang.reflect.Method</code>：代表类的方法，Method对象表示某个类的方法</li>
<li><code v-pre>java.lang.reflect.Field</code>：代表类的成员变量，Field对象表示某个类的成员变量</li>
<li><code v-pre>java.lang.reflect.Constructor</code>：代表类的构造方法，Constructor对象表示构造器</li>
</ol>
<h4 id="_13-1-5-反射的优缺点" tabindex="-1"><a class="header-anchor" href="#_13-1-5-反射的优缺点" aria-hidden="true">#</a> 13.1.5 反射的优缺点</h4>
<ol>
<li>优点：可以动态的创建和使用对象（框架底层核心），使用灵活，没有反射机制，框架技术就失去底层支撑。</li>
<li>缺点：反射是解释执行，对执行速度有影响。</li>
</ol>
<h4 id="_13-1-6-反射调用优化——关闭访问检查" tabindex="-1"><a class="header-anchor" href="#_13-1-6-反射调用优化——关闭访问检查" aria-hidden="true">#</a> 13.1.6 反射调用优化——关闭访问检查</h4>
<ol>
<li>Method、Field和Constructor的对象都有<code v-pre>setAccessible()</code>方法</li>
<li><code v-pre>setAccessible()</code>作用是启动和禁用访问安全检查的开关</li>
<li>传入true表示反射的对象在使用时取消访问检查，提高反射效率。</li>
<li>传入false表示反射的对象在使用是执行访问检查，默认为false。</li>
</ol>
<h3 id="_13-2-class类" tabindex="-1"><a class="header-anchor" href="#_13-2-class类" aria-hidden="true">#</a> 13.2 Class类</h3>
<h4 id="_13-2-1-基本介绍" tabindex="-1"><a class="header-anchor" href="#_13-2-1-基本介绍" aria-hidden="true">#</a> 13.2.1 基本介绍</h4>
<ol>
<li>Class是类的一种，继承自Object类
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655382426321-cadcd57f-1e97-4ee9-9a12-9754047b46e8.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=199&amp;id=u1470fa61&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=199&amp;originWidth=456&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=8021&amp;status=done&amp;style=none&amp;taskId=u2b184e35-4af2-4ba7-8fc1-e3b9f2ac128&amp;title=&amp;width=456" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>Class类对不是new出来的，是系统通过类加载器（ClassLoader）的loadClass()方法创建的。</li>
<li>对于某个类的Class类对象在内存中只有一份，因为类只加载一次。
<ul>
<li>同一个类的Class类对象，hashcode相同</li>
</ul>
</li>
<li>每个类的实例都会记得自己是由哪个Class实例所生成。</li>
<li>利用Class类的一系列API可以完整得到该Class类对象所对应的那个类的完整结构。</li>
<li>Class类的对象存放在堆空间中。</li>
<li>类的字节码二进制数据存放在方法区，称为元数据（包括方法代码、变量名、方法名、访问权限等）</li>
</ol>
<h4 id="_13-2-2-class类的常用方法" tabindex="-1"><a class="header-anchor" href="#_13-2-2-class类的常用方法" aria-hidden="true">#</a> 13.2.2 Class类的常用方法</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655437219934-72cbfa79-2758-4c08-ae26-978e865c47a8.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=336&amp;id=u52373190&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=336&amp;originWidth=787&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=112011&amp;status=done&amp;style=none&amp;taskId=u18648f40-3e0e-418e-85d2-5cd49f5f534&amp;title=&amp;width=787" alt="image.png" loading="lazy"></p>
<ul>
<li><code v-pre>Class&lt;?&gt; cls = Class.forName(classPath)</code>：
<ul>
<li>classPath是从src路径开始的全类名</li>
<li><code v-pre>&lt;?&gt;</code>表示不确定的java类型，也可以省略。</li>
<li>输出<code v-pre>cls</code>时，显示的是<code v-pre>class classPaht</code></li>
<li>forName有异常问题</li>
</ul>
</li>
<li><code v-pre>cls.getClass()</code>：输出cls的运行类型——class java.lang.Class</li>
<li><code v-pre>cls.getName()</code>：得到全类名——classPath</li>
<li><code v-pre>cls.getPackage().getName()</code>：从src路径开始的全包名</li>
<li><code v-pre>cls.newInstance</code>：创建实例对象，与new出来的实例对象是两个不同对象
<ul>
<li>与classPath的类一致（强转后一致）</li>
<li>有异常问题</li>
</ul>
</li>
<li><code v-pre>cls.getField(&quot;属性名&quot;)</code>：通过反射获取类的属性对象
<ul>
<li>通过此方式访问设置为private的属性会报错</li>
<li><code v-pre>cls.getField(&quot;属性名&quot;).getName()</code>：获取属性名</li>
<li><code v-pre>cls.getField(&quot;属性名&quot;).get(对象名)</code>：获取该对象中该属性的值
<ul>
<li>这里的对象可以是new出来的，也可以是newInstace出来的</li>
</ul>
</li>
<li><code v-pre>cls.getField(&quot;属性名&quot;).set(对象名, 新值）</code>：通过反射给属性赋值
<ul>
<li>这里的对象可以是new出来的，也可以是newInstace出来的</li>
</ul>
</li>
</ul>
</li>
<li><code v-pre>cls.getFields()</code>：获取所有属性的对象数组</li>
</ul>
<div class="language-java ext-java line-numbers-mode"><pre v-pre class="language-java"><code><span class="token keyword">package</span> <span class="token namespace">reflect_</span><span class="token punctuation">;</span>

<span class="token keyword">import</span> <span class="token import"><span class="token namespace">java<span class="token punctuation">.</span>lang<span class="token punctuation">.</span>reflect<span class="token punctuation">.</span></span><span class="token class-name">Field</span></span><span class="token punctuation">;</span>

<span class="token keyword">public</span> <span class="token keyword">class</span> <span class="token class-name">Test</span> <span class="token punctuation">{</span>
    <span class="token keyword">public</span> <span class="token keyword">static</span> <span class="token keyword">void</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token class-name">String</span><span class="token punctuation">[</span><span class="token punctuation">]</span> args<span class="token punctuation">)</span> <span class="token keyword">throws</span> <span class="token class-name">ClassNotFoundException</span><span class="token punctuation">,</span> <span class="token class-name">InstantiationException</span><span class="token punctuation">,</span> <span class="token class-name">IllegalAccessException</span><span class="token punctuation">,</span> <span class="token class-name">NoSuchFieldException</span> <span class="token punctuation">{</span>
        <span class="token class-name">Car</span> car1 <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Car</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        car1<span class="token punctuation">.</span>brand <span class="token operator">=</span> <span class="token string">"奔驰"</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>car1<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//Car{brand='奔驰', price='50000', color='red'}</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>car1<span class="token punctuation">.</span><span class="token function">getClass</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//class reflect_.Car</span>

        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>car1<span class="token punctuation">.</span><span class="token function">getClass</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getClassLoader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//sun.misc.Launcher$AppClassLoader@18b4aac2</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token class-name">Test</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">.</span><span class="token function">getClassLoader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//sun.misc.Launcher$AppClassLoader@18b4aac2</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>car1<span class="token punctuation">.</span><span class="token function">getClass</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getClassLoader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token operator">==</span><span class="token class-name">Test</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">.</span><span class="token function">getClassLoader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//true</span>

        <span class="token class-name">Person</span> person <span class="token operator">=</span> <span class="token keyword">new</span> <span class="token class-name">Person</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token class-name">Person</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">.</span><span class="token function">getClassLoader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token operator">==</span>person<span class="token punctuation">.</span><span class="token function">getClass</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getClassLoader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//true</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token class-name">Person</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">.</span><span class="token function">getClassLoader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token operator">==</span>car1<span class="token punctuation">.</span><span class="token function">getClass</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getClassLoader</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//true</span>

        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token class-name">Test</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//class reflect_.Test</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span><span class="token class-name">Test</span><span class="token punctuation">.</span><span class="token keyword">class</span><span class="token punctuation">.</span><span class="token function">getClass</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//class java.lang.Class</span>

        <span class="token class-name">String</span> classPath <span class="token operator">=</span> <span class="token string">"reflect_.Car"</span><span class="token punctuation">;</span>
        <span class="token class-name">Class</span><span class="token generics"><span class="token punctuation">&lt;</span><span class="token operator">?</span><span class="token punctuation">></span></span> cls <span class="token operator">=</span> <span class="token class-name">Class</span><span class="token punctuation">.</span><span class="token function">forName</span><span class="token punctuation">(</span>classPath<span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>cls<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//class reflect_.Car</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>cls<span class="token punctuation">.</span><span class="token function">getClass</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//class java.lang.Class</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>cls<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//reflect_.Car</span>

        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>cls<span class="token punctuation">.</span><span class="token function">getPackage</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//package reflect_</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>cls<span class="token punctuation">.</span><span class="token function">getPackage</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//reflect_</span>

        <span class="token class-name">Field</span> brand <span class="token operator">=</span> cls<span class="token punctuation">.</span><span class="token function">getField</span><span class="token punctuation">(</span><span class="token string">"brand"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>brand<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//public java.lang.String reflect_.Car.brand</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>brand<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//brand</span>

        <span class="token class-name">Car</span> car <span class="token operator">=</span> <span class="token punctuation">(</span><span class="token class-name">Car</span><span class="token punctuation">)</span>cls<span class="token punctuation">.</span><span class="token function">newInstance</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>car<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//Car{brand='宝马', price='50000', color='red'}</span>

        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>brand<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span>car<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//宝马</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>brand<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span>car1<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//奔驰</span>

        brand<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span>car<span class="token punctuation">,</span> <span class="token string">"华晨宝马"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        brand<span class="token punctuation">.</span><span class="token function">set</span><span class="token punctuation">(</span>car1<span class="token punctuation">,</span> <span class="token string">"梅赛德斯奔驰"</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>brand<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span>car<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//华晨宝马</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>brand<span class="token punctuation">.</span><span class="token function">get</span><span class="token punctuation">(</span>car1<span class="token punctuation">)</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//梅赛德斯奔驰</span>

        <span class="token class-name">Field</span><span class="token punctuation">[</span><span class="token punctuation">]</span> fields <span class="token operator">=</span> cls<span class="token punctuation">.</span><span class="token function">getFields</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">;</span>
        <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">println</span><span class="token punctuation">(</span>fields<span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//[Ljava.lang.reflect.Field;@74a14482</span>
        <span class="token keyword">for</span><span class="token punctuation">(</span><span class="token class-name">Field</span> field <span class="token operator">:</span> fields<span class="token punctuation">)</span><span class="token punctuation">{</span>
            <span class="token class-name">System</span><span class="token punctuation">.</span>out<span class="token punctuation">.</span><span class="token function">print</span><span class="token punctuation">(</span>field<span class="token punctuation">.</span><span class="token function">getName</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">+</span> <span class="token string">"\t"</span><span class="token punctuation">)</span><span class="token punctuation">;</span><span class="token comment">//brand	price	color</span>
        <span class="token punctuation">}</span>
    <span class="token punctuation">}</span>
<span class="token punctuation">}</span>

</code></pre><div class="line-numbers" aria-hidden="true"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><h4 id="_13-2-3-获取class类对象-实例" tabindex="-1"><a class="header-anchor" href="#_13-2-3-获取class类对象-实例" aria-hidden="true">#</a> 13.2.3 获取Class类对象（实例）</h4>
<blockquote>
<ul>
<li>根据类加载的不同阶段，可以在不同阶段使用不同方式获取Class类。
<ul>
<li>不同方式获取到的Class类对象是同一个，原因为堆内存中一个类只有一个Class对象（反射机制）</li>
</ul>
</li>
</ul>
</blockquote>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655427465287-09f030db-0e27-416d-a909-159c28a79df2.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=430&amp;id=u85d0d7cd&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=779&amp;originWidth=1608&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=759416&amp;status=done&amp;style=none&amp;taskId=u75c05082-12c6-4171-923f-35109bf63f3&amp;title=&amp;width=888" alt="image.png" loading="lazy"></p>
<ol>
<li><code v-pre>Class.forName(classPath)</code>：调用<code v-pre>Class</code>的静态方法
<ul>
<li>前提：已知一个类的全类名，且该类在类路径下？</li>
<li>应用场景：加载配置文件，读取类全路径，加载类</li>
<li>注意点：有ClassNotFoundEception</li>
<li>阶段：程序编写阶段</li>
</ul>
</li>
<li><code v-pre>类名.class</code>：调用运行时类的属性
<ul>
<li>前提：已知一个具体的类</li>
<li>应用场景：多用于参数传递（当作参数传进去），比如通过反射得到对应构造器的对象</li>
<li>注意点：最安全可靠，性能最高</li>
<li>阶段：类的加载阶段</li>
</ul>
</li>
<li><code v-pre>对象.getClass()</code>：调用运行时类的<code v-pre>getClass()</code>方法
<ul>
<li>前提：已知某个类的对象实例</li>
<li>应用场景：有对象实例</li>
<li>注意点：获取到的是运行类型</li>
<li>阶段：程序运行阶段</li>
</ul>
</li>
<li>类加载器【4种】
<ul>
<li><code v-pre>对象.getClass().getClassLoader()</code>得到<code v-pre>ClassLoader</code>（类加载器）。</li>
<li>或者使用<code v-pre>类.class.getClassLoader()</code>得到，二者返回的classLoader()是同一个。一个类一个类加载器吗？还是许多类一个加载器？测试好像是所有类一个类加载器。
<ul>
<li><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1656548640656-9acc3927-06a1-480b-bc9d-0756c421b7e6.png#clientId=u377d090f-b49f-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=269&amp;id=u0f3efa67&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=336&amp;originWidth=1028&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=77951&amp;status=done&amp;style=none&amp;taskId=u084abb0c-4110-4a8a-b453-e6269ebb300&amp;title=&amp;width=822.4" alt="image.png" loading="lazy"></li>
</ul>
</li>
<li>通过类加载器得到Class类对象：<code v-pre>类加载器的对象.loadClass(classPath)</code></li>
</ul>
</li>
<li><code v-pre>Class&lt;包装类&gt; cls = 基本数据类型.class</code>
<ul>
<li>基本数据类型按照上述方式获得</li>
<li>输出时会自动拆箱，得到基本数据类型</li>
</ul>
</li>
<li><code v-pre>Class&lt;包装类&gt; cls = 包装类.TYPE</code>
<ul>
<li>基本数据类型的包装类可以按照上述方式获得</li>
<li>输出时会自动拆箱，得到基本数据类型</li>
<li>底层基本数据类型和其包装类是同一个Class类对象</li>
</ul>
</li>
</ol>
<h4 id="_13-2-4-具有class对象的类" tabindex="-1"><a class="header-anchor" href="#_13-2-4-具有class对象的类" aria-hidden="true">#</a> 13.2.4 具有Class对象的类</h4>
<ol>
<li>外部类、成员内部类、静态内部类、局部内部类、匿名内部类
<ul>
<li>Class也有，因为Class类是外部类的一种</li>
</ul>
</li>
<li>interface</li>
<li>enum</li>
<li>数组</li>
<li>annotation</li>
<li>void</li>
<li>基本数据类型</li>
</ol>
<h3 id="_13-3-类加载" tabindex="-1"><a class="header-anchor" href="#_13-3-类加载" aria-hidden="true">#</a> 13.3 类加载</h3>
<h4 id="_13-3-1-基本说明" tabindex="-1"><a class="header-anchor" href="#_13-3-1-基本说明" aria-hidden="true">#</a> 13.3.1 基本说明</h4>
<ol>
<li>静态加载：编译时加载相关的类，如果类不存在则报错，具有高依赖性</li>
<li>动态加载：运行时加载需要得类，如果运行时不用该类，即使不存在该类，也不报错，降低了依赖性</li>
<li>java通过反射机制实现了动态语言的动态加载，让原本在编译时加载的类到运行时才加载</li>
</ol>
<h4 id="_13-3-2-类的加载时机" tabindex="-1"><a class="header-anchor" href="#_13-3-2-类的加载时机" aria-hidden="true">#</a> 13.3.2 类的加载时机</h4>
<ol>
<li>new创建对象时——静态加载</li>
<li>子类被加载时，父类也被加载——静态加载</li>
<li>调用类中的静态成员时——静态加载</li>
<li>通过反射——动态加载</li>
</ol>
<h4 id="_13-3-3-类的加载过程" tabindex="-1"><a class="header-anchor" href="#_13-3-3-类的加载过程" aria-hidden="true">#</a> 13.3.3 类的加载过程</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655437193792-1f03bf13-a511-4f87-88e9-4d8f273be747.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=256&amp;id=u92356403&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=256&amp;originWidth=536&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=142109&amp;status=done&amp;style=none&amp;taskId=u19e81d77-628b-410c-8189-ef4f2fb4c32&amp;title=&amp;width=536" alt="image.png" loading="lazy">
<img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655437178713-458880e8-8c58-402c-8272-3d92802bde84.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=259&amp;id=u7f9663aa&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=259&amp;originWidth=498&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=176928&amp;status=done&amp;style=none&amp;taskId=u569a6a24-fd9b-4449-b733-6f3e858ed51&amp;title=&amp;width=498" alt="image.png" loading="lazy"></p>
<ul>
<li>加载阶段：JVM将来自不同数据源（class文件、jar包、网络等）的字节码文件，转化为二进制字节流加载到内存中，并生成一个代表该类的java.lang.Class对象</li>
<li>连接阶段：
<ul>
<li>验证：jvm检查字节流信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全
<ul>
<li>包括文件格式验证（是否以魔数oxcafebabe开头）、元数据验证、字节码验证和符号引用验证</li>
<li>可以使用<code v-pre>-Xverify:none</code>参数关闭大部分类的验证措施，缩短虚拟机类加载的时间</li>
</ul>
</li>
<li>准备：JVM对静态变量进行默认初始化并分配内存，这些变量所使用的内存在方法区进行分配
<ul>
<li>无修饰的变量不会分配内存，那会默认初始化吗？</li>
<li>static修饰变量会默认初始化，会分配内存</li>
<li>static 和 final修饰的变量会默认初始化，也会分配内存</li>
</ul>
</li>
<li>解析：虚拟机将常来给你吃内的符号引用替换为直接引用</li>
</ul>
</li>
<li>初始化阶段：初始化阶段时执行<code v-pre>&lt;clint&gt;()</code>方法的过程
<ul>
<li><code v-pre>&lt;clint&gt;()</code>方法时由编译器按语句在源文件中出现的顺序，依次自动收集类中所有的静态变量赋值动作和静态代码块中的语句，并进行合并</li>
<li>虚拟机会保证一个类的<code v-pre>&lt;clint&gt;()</code>方法在多线程环境中被正确的加锁、同步，如果多个线程同时初始化一个类，哪个只有一个线程去执行类的<code v-pre>&lt;clint&gt;()</code>方法，其他线程都会阻塞等待，直到活动线程执行<code v-pre>&lt;clint&gt;()</code>方法完毕。</li>
</ul>
</li>
</ul>
<h3 id="_13-4-通过反射获取类的结构信息" tabindex="-1"><a class="header-anchor" href="#_13-4-通过反射获取类的结构信息" aria-hidden="true">#</a> 13.4 通过反射获取类的结构信息</h3>
<h4 id="_13-4-1-java-lang-class类及其方法" tabindex="-1"><a class="header-anchor" href="#_13-4-1-java-lang-class类及其方法" aria-hidden="true">#</a> 13.4.1 java.lang.Class类及其方法</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655437143808-153e1a87-90c3-4886-bbd9-960fc9335e2c.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=196&amp;id=u7141156f&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=196&amp;originWidth=419&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=170346&amp;status=done&amp;style=none&amp;taskId=ua36f75c6-4ded-4d5e-9747-0bb55e80bcb&amp;title=&amp;width=419" alt="image.png" loading="lazy"></p>
<h4 id="_13-4-2-java-lang-reflect-field类" tabindex="-1"><a class="header-anchor" href="#_13-4-2-java-lang-reflect-field类" aria-hidden="true">#</a> 13.4.2 java.lang.reflect.Field类</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655437274892-22c1ff9d-65a1-47a0-af05-9c78e5dc458c.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=88&amp;id=u7ffcf092&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=88&amp;originWidth=461&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=68762&amp;status=done&amp;style=none&amp;taskId=ua824b4b6-b219-4693-96b0-a12e38c64cd&amp;title=&amp;width=461" alt="image.png" loading="lazy"></p>
<ul>
<li><code v-pre>getType()</code>返回的是属性的类型</li>
</ul>
<h4 id="_13-4-3-java-lang-reflect-method类" tabindex="-1"><a class="header-anchor" href="#_13-4-3-java-lang-reflect-method类" aria-hidden="true">#</a> 13.4.3 java.lang.reflect.Method类</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655437302993-530cafda-c1cb-4475-8e08-f3ff56f7a0ac.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=107&amp;id=uff44035e&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=107&amp;originWidth=471&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=86085&amp;status=done&amp;style=none&amp;taskId=u669ca468-7669-47be-bdb5-6ed8238365b&amp;title=&amp;width=471" alt="image.png" loading="lazy"></p>
<ul>
<li><code v-pre>getReturnType()</code>返回的是返回类型的类型</li>
</ul>
<h4 id="_13-4-4-java-lang-reflect-constructor类" tabindex="-1"><a class="header-anchor" href="#_13-4-4-java-lang-reflect-constructor类" aria-hidden="true">#</a> 13.4.4 java.lang.reflect.Constructor类</h4>
<p><img src="https://cdn.nlark.com/yuque/0/2022/png/1604140/1655437795837-b9caf0a9-ae2c-4f7d-a033-6d34c2ce2ea3.png#clientId=ud1220326-adda-4&amp;crop=0&amp;crop=0&amp;crop=1&amp;crop=1&amp;from=paste&amp;height=66&amp;id=ufb9b3c39&amp;margin=[object Object]&amp;name=image.png&amp;originHeight=66&amp;originWidth=373&amp;originalType=binary&amp;ratio=1&amp;rotation=0&amp;showTitle=false&amp;size=49626&amp;status=done&amp;style=none&amp;taskId=u9f2cf018-6ac9-4c3b-b3f6-52e258ecb3e&amp;title=&amp;width=373" alt="image.png" loading="lazy"></p>
<h3 id="_13-5-通过反射创建对象" tabindex="-1"><a class="header-anchor" href="#_13-5-通过反射创建对象" aria-hidden="true">#</a> 13.5 通过反射创建对象</h3>
<p>在13.2.3的基础上：</p>
<ol>
<li>方式一：
<ul>
<li><code v-pre>Class.forName(classPath)</code>：得到Class类对象</li>
<li><code v-pre>Class类对象.newInstance()</code>：得到实例对象</li>
</ul>
</li>
<li>方式二：
<ul>
<li><code v-pre>Class.forName(classPath)</code>：得到Class类对象</li>
<li><code v-pre>Class类对象.getConstructor(已知参数类名.class)</code>：得到带参构造器对象
<ul>
<li>得到的只是public修饰的构造器</li>
</ul>
</li>
<li><code v-pre>带参构造器对象.newInstance(实参)</code>：得到对象实例</li>
</ul>
</li>
<li>方式三（私有构造器流程）：
<ul>
<li><code v-pre>Class.forName(classPath)</code>：得到Class类对象</li>
<li><code v-pre>Class类对象.getDeclaredConstructor(已知参数类名.class)</code>：得到带参构造器对象
<ul>
<li>得到的是各种权限修饰符修饰的构造器（上面只是获得了私有构造器，还不能使用，使用会报错）</li>
</ul>
</li>
<li><code v-pre>构造器对象.setAccessible(true)</code>：<strong>爆破</strong>，使得私有的构造器可以使用</li>
<li><code v-pre>构造器对象.newInstance(实参)</code>：得到对象实例</li>
</ul>
</li>
</ol>
<ul>
<li>以上方式创建的实例对象都是Object类型，但是可以向下转型为指定类型（体现多态）</li>
</ul>
<h3 id="_13-6-通过反射访问类中的成员" tabindex="-1"><a class="header-anchor" href="#_13-6-通过反射访问类中的成员" aria-hidden="true">#</a> 13.6 通过反射访问类中的成员</h3>
<h4 id="_13-6-1-访问属性" tabindex="-1"><a class="header-anchor" href="#_13-6-1-访问属性" aria-hidden="true">#</a> 13.6.1 访问属性</h4>
<ol>
<li>得到类对应的Class类对象：<code v-pre>Class.forName(classPath)</code></li>
<li>通过13.5的方式创建Class类对象的实例对象</li>
<li>方式一（访问公开属性）：
<ul>
<li>通过Class类对象的<code v-pre>getField(已知属性名)</code>得到本类及父类中public修饰的属性对象
<ul>
<li><code v-pre>属性对象.get(实例对象名)</code>可以获得实例对象中的属性值</li>
<li><code v-pre>属性对象.set(实例对象名)</code>可以修改实例对象中的属性值</li>
</ul>
</li>
</ul>
</li>
<li>方式二（访问非公开属性）：
<ul>
<li>通过Class类对象的<code v-pre>getDeclaredField(已知属性名)</code>得到本类中各类修饰符修饰的属性对象</li>
<li><code v-pre>属性对象.setAccessible(true)</code>：<strong>爆破</strong>，使得私有的构造器可以使用
<ul>
<li><code v-pre>属性对象.get(实例对象名)</code>可以获得实例对象中的属性值</li>
<li><code v-pre>属性对象.set(实例对象名,value)</code>可以修改实例对象中的属性值</li>
</ul>
</li>
</ul>
</li>
</ol>
<ul>
<li>如果是静态属性，则set和get中的实例对象名，也可以写成null</li>
</ul>
<h4 id="_13-6-2-访问方法" tabindex="-1"><a class="header-anchor" href="#_13-6-2-访问方法" aria-hidden="true">#</a> 13.6.2 访问方法</h4>
<ol>
<li>得到类对应的Class类对象：<code v-pre>Class.forName(classPath)</code></li>
<li>通过13.5的方式创建Class类对象的实例对象</li>
<li>方式一（访问公开方法）：
<ul>
<li>通过Class类对象的<code v-pre>getMethod(已知方法名, 形参对象类.class)</code>得到本类及父类中public修饰的方法对象
<ul>
<li>能不能写成<code v-pre>getMethod(已知方法名, 形参对象实例.getClass())</code>？不能，会报找不到这样方法的异常【2022.07.06】【可以，2022.07.12研究，那是因为那个例子中，对类有改造。但还是不明白具体情况下该用哪个】</li>
<li><code v-pre>方法对象.invoke(实例对象名, 实参)</code>可以调用实例对象中的方法</li>
</ul>
</li>
</ul>
</li>
<li>方式二（访问非公开方法）：
<ul>
<li>通过Class类对象的<code v-pre>getDeclaredMethod(已知方法名, 形参对象类.class)</code>得到本类中各类修饰符修饰的方法对象</li>
<li><code v-pre>属性对象.setAccessible(true)</code>：<strong>爆破</strong>，使得私有的构造器可以使用
<ul>
<li><code v-pre>方法对象.invoke(实例对象名, 实参)</code>可以调用实例对象中的方法</li>
</ul>
</li>
</ul>
</li>
</ol>
<ul>
<li>如果是静态属性，则invoke中的实例对象名，也可以写成null</li>
<li>反射中，方法如果有返回值，统一返回Object（编译类型），运行类型按照方法实际的类型执行。</li>
</ul>
</div></template>
