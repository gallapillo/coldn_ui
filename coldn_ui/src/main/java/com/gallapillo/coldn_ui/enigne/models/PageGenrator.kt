package com.gallapillo.coldn_ui.enigne.models

fun page(block: PageBuilder.() -> Unit): Page = PageBuilder().apply(block).build()
fun pageBlock(block: PageBlockBuilder.() -> Unit): PageBlock = PageBlockBuilder().apply(block).build()


class PageGenerator {
    private fun generatePage() = page {
        number = 1
        pageBlocks {
            headerBlock
            pageBlock {
                content = "This is bottom content"
            }
            pageBlock {
                content = "This is bottom content"
            }
            compositeBlock(
                imageBlock(url = "imageUrl")
            )
        }
    }

    fun testPage() {
        val fistPage = generatePage()
    }
}

val headerBlock = pageBlock {
    type = "HEADER"
    content = "This is header block"
}

fun PageBlockContainer.imageBlock(url: String) = pageBlock {
    type = "Image"
    content = url
}

fun PageBlockContainer.textBlock(text: String) = pageBlock {
    type = "Plain"
    content = text
}

fun PageBlockContainer.compositeBlock(pageBlock: PageBlock) = pageBlock {
    type = "Composite"
    innerBlock = pageBlock
}