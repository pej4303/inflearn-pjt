package com.pej.portfolio_pej.admin.data

class TableDTO(
    val name: String,
    val columns: List<String>,
    val records: List<List<String>>
) {
    // 어드민 페이지이에서 그리드에서 뿌려줄 데이터를 담는 DTO
}