package com.causa_arcana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainWebView: WebView = findViewById(R.id.mainWebView)

        val htmlGenerator = HtmlGenerator(contentHtml)
        val fullHtml = htmlGenerator.fullHtml()
        val encodedFullHtml = Base64.encodeToString(fullHtml.toByteArray(), Base64.NO_PADDING)

        mainWebView.loadData(encodedFullHtml, "text/html", "base64")
    }

    companion object {
        private const val contentHtml = """
            <p>Однажды мы выпустили статью
            &ldquo;<a href="../../../2020/06/04/decentralized-vs-distributed.html">Децентрализованные сервисы против распределённых</a>&rdquo;,
            где предприняли попытку подтолкнуть читателей к более обдуманному отношению к
            терминам, таким как &ldquo;централизованный&rdquo;, &ldquo;децентрализованный&rdquo; и &ldquo;распределённый&rdquo;.
            Это имеет значение не только с точки зрения теоретической информатики и удобства
            практической деятельности по написанию программного обеспечения. Часто такие
            термины используются спекулятивно с целью рекламного продвижения продуктов
            сомнительного качества, таких как некоторые реализации децентрализованных
            финансов (DeFi; от англ. <em>decentralized finance</em>), а то и вовсе мошеннических
            предложений.</p>

            <p>Мы не собирались развивать эту тему, так как любая попытка составления подробной
            классификации обречена на провал. Технологии развиваются быстрее, чем успевают
            осмысляться, а их сложность не даёт шансов охватить все тонкости. Единственное,
            что можно сделать &ndash; это посоветовать подробнее изучать то, что собираетесь
            использовать.</p>

            <p>Закономерно, что отвечать на критику представленного нами наброска классификации
            мы тоже не хотели, потому что она с большой вероятностью была бы справедлива.
            Любой выбор терминологии имеет как преимущества, позволяя удобнее передавать
            мысли, так и недостатки, заковывая сознание в слишком строгие рамки. В начале
            нашей статьи так и было сказано, что мы не ставим целью создание идеальной
            классификации.</p>

            <p>Однако мы столкнулись, помимо прочего, с обвинениями в невежестве. Это может
            означать, что мы слишком плохо объяснили нашу мотивацию. Мы хотим исправить эту
            ошибку, потому что проблемы эпистемологии и языка довольно важны для нас, они
            касаются мышления о мире вообще, а не только о технологиях.</p>

            <div class="d-flex justify-content-center">
                <figure class="nice-figure">
                    <img src="../../../../assets/images/blog/decentralized-vs-distributed-wrong.png"
                         alt='Та самая "неправильная" картинка.'/>
                    <figcaption>
                        Та самая &ldquo;неправильная&rdquo; картинка.
                    </figcaption>
                </figure>
            </div>

            <p>Что же не так с распространёнными вариантами использования упомянутых терминов?
            Начнём с рассмотрения представленной выше картинки, альтернатива которой была
            показана в нашей статье. Она часто используется для иллюстрации соответствующих
            терминов, причём не только в популярных статьях, но и в научных публикациях.
            Так, в
            <a href="https://www.researchgate.net/publication/316042146_A_Survey_on_Trust_Computation_in_the_Internet_of_Things">одной</a>
            из рассмотренных нами публикаций децентрализованная система определяется в том
            числе как система без единой точки отказа, и тут же приводится эта картинка.
            Если присмотреться к ней, то в примере децентрализованной системы есть один
            узел, при удалении которого части системы больше не будут связаны. Возможно, это
            не является противоречием при каком-то экзотическом определении требований к
            системе, смысла узлов и связей между ними, но рассматриваемая публикация не
            содержит ничего подобного.</p>

            <p>Рассматриваемая выше картинка ведёт своё происхождение из
            <a href="https://www.rand.org/content/dam/rand/pubs/research_memoranda/2006/RM3420.pdf">книги</a>
            1964 года &ldquo;On Distributed Communications Networks&rdquo; (автор Paul Baran). Там
            даётся определение децентрализованной сети как такой, где отказ центрального
            узла не приводит к полной потере связности между всеми узлами, а лишь
            некоторыми. Это было довольно актуально в то время, поскольку количество
            информации, передаваемой между отдалёнными узлами больших сетей было невелико, а
            связность внутри организаций могла быть гораздо важнее, чем между ними. Чего
            нельзя сказать про наше время. Кроме того, автор рассматривает довольно узкий
            вопрос сетевых топологий, то есть физической связности. У современных же систем
            есть множество других свойств, таких как доверие между узлами или хранение
            данных на разных узлах.</p>

            <div class="d-flex justify-content-center">
                <figure class="nice-figure">
                    <img src="../../../../assets/images/blog/network-topologies.png"
                         alt="Классификация сетевых топологий. Возможно, тоже неправильная или неполная."/>
                    <figcaption>
                        Классификация сетевых топологий. Возможно, тоже неправильная или неполная.
                    </figcaption>
                </figure>
            </div>

            <p>Попытка создать современную классификацию была предпринята, например, в
            <a href="https://journals.sagepub.com/doi/full/10.1177/2631787720977052">работе</a> 2020
            года &ldquo;Decentralized vs. Distributed Organization: Blockchain, Machine Learning
            and the Future of the Digital Platform&rdquo;. Там предлагается воспринимать
            децентрализацию как рассеивание коммуникации, а распределённость как рассеивание
            принятия решений. Это интересная работа с историческим обзором, собственным
            теоретическим аппаратом и масштабными выводами, в том числе
            социально-политического характера. Однако её результаты противоречат устоявшейся
            терминологии, а также являются слишком сложными, чтобы их можно было корректно
            применять. Так, в добавок к существующим трём терминам там вводится ещё один &ndash;
            концентрированные системы. Авторы текстов с тремя-то не справляются.</p>

            <p>Похожий подход предлагает и создатель криптовалюты Ethereum Виталик Бутерин в
            <a href="https://medium.com/@VitalikButerin/the-meaning-of-decentralization-a0c92b76a274">статье</a>
            &ldquo;The Meaning of Decentralization&rdquo;. Он особенно подчёркивает, что каждая система
            может классифицироваться тем или иным образом по каждому из трёх различных
            критериев:</p>

            <ul>
                <li>Архитектурная децентрализованность &ndash; как много узлов в системе? Как много из
                них могут выйти из строя, не вызывая отказа всей системы?</li>
                <li>Политическая децентрализованность &ndash; как много людей или организаций
                контролируют систему?</li>
                <li>Логическая децентрализованность &ndash; являются ли интерфейсы и структуры данных
                системы единым монолитным объектом (как в блокчейне) или нет (как в федеративных
                социальных сетях)?</li>
            </ul>

            <p>Мы согласны, что соответствие системы каким-то критериям зависит от целей,
            которые ставятся теми, кто её обсуждает, но явное введение таких критериев,
            опять же, слишком усложняет классификацию, оставляя её потенциально неполной.</p>

            <p>Главным возражением на нашу статью было противоречие (только кажущееся) нашего
            определения распределённой системы наиболее распространённому, согласно которому
            это коллекция узлов, которая выглядит для пользователей как единая когерентная
            система. Это определение даёт сам Эндрю Таненбаум в книге &ldquo;Distributed Systems:
            Principles and Paradigms&rdquo;. Наше определение, возможно, более широкое, но оно
            точно полностью включает указанное. Есть, например, распределённые базы данных,
            управление которыми осуществляет одна инстанция, принимающие некоторые
            административные решения. Однако необходимость наличия администратора в случае
            баз данных не вызывает никаких сомнений и при обсуждении может не упоминаться.
            Большую же часть времени они работают автономно, без какого-либо единого центра
            принятия решений, и принятие решений действительно осуществляется всей сетью с
            помощью алгоритмов распределённого консенсуса, таких как Paxos или Raft.</p>

            <p>Таким образом, удобство классификаций и определений сильно зависит от того,
            какие задачи необходимо решать. Как мы уже писали в статье
            &ldquo;<a href="../../07/19/capitalization-of-internet.html">Почему слово Интернет пишется с прописной буквы?</a>&rdquo;,
            мы не указываем вам, как и что говорить, лишь помогаем думать эффективнее и не
            попадаться в ментальные ловушки, расставленные теми, кто на самом деле хочет вас
            контролировать. Это непростая задача в столь быстро меняющеся мире, но благодаря
            вашей поддержке и обратной связи мы сможем выполнять её более эффективно.</p>
        """
    }
}
