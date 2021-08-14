package com.causa_arcana

class HtmlGenerator(private val contentHtml: String) {
    fun fullHtml(): String {
        return """
        <!DOCTYPE html>
        <html>
            <head>${headInnerHtml()}</head>
            <body>$contentHtml</body>
        </html>
        """
    }

    private fun headInnerHtml(): String {
        return """
        <meta charset="utf-8"/>
        <style>${fullCss()}</style>
        """
    }

    private fun fullCss(): String {
        return """
        body {
            background-color: #FFFF00;
        }
        """
    }
}
