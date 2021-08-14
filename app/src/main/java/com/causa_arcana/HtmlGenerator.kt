package com.causa_arcana

class HtmlGenerator(private val title: String, private val contentHtml: String) {
    fun fullHtml(): String {
        return """
        <!DOCTYPE html>
        <html>
            <head>${headInnerHtml()}</head>
            <body>${bodyInnerHtml()}</body>
        </html>
        """
    }

    private fun headInnerHtml(): String {
        return """
        <meta charset="utf-8"/>
        <style>${fullCss()}</style>
        """
    }

    private fun bodyInnerHtml(): String {
        return """
            <main>
                <article>
                    <header>
                        <h1>$title</h1>
                    </header>
                    <div>$contentHtml</div>
                </article>
            </main>
        """
    }

    private fun fullCss(): String {
        return """
        img {
            max-width: 100%;
        }
        """
    }
}
