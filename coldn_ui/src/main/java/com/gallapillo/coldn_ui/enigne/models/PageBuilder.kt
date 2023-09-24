package com.gallapillo.coldn_ui.enigne.models

@ArticleDSL
class PageBuilder {
    var number: Int = -1
    var pageBlocks: MutableList<PageBlock> = mutableListOf()

    fun pageBlocks(block: PageBlockContainer.() -> Unit) {
        val pageBlockContainer = PageBlockContainer().apply(block)
        pageBlocks.addAll(pageBlockContainer.content)
    }

    fun build(): Page = Page(number, pageBlocks)
}

class PageBlockContainer {
    val content: MutableList<PageBlock> = mutableListOf<PageBlock>()

    @ArticleDSL
    inline fun pageBlock(block: PageBlockBuilder.() -> Unit) =
        PageBlockBuilder().apply(block).build().also {
            content.add(it)
        }
}