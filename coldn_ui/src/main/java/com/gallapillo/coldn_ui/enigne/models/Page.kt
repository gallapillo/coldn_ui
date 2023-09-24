package com.gallapillo.coldn_ui.enigne.models

data class Page(val number: Int? = null, val pageBlocks: List<PageBlock>? = null)

data class PageBlock(val content: String? = null, val type: String, val pageBlock: PageBlock? = null)