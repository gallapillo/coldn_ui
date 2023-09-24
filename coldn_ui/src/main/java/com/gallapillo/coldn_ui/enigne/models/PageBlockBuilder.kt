package com.gallapillo.coldn_ui.enigne.models

@ArticleDSL
class PageBlockBuilder {
    var content = ""
    var type = "UNDEFINED"
    var innerBlock: PageBlock? = null
    fun build(): PageBlock = PageBlock(content, type, innerBlock)
}