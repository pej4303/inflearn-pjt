package com.pej.portfolio_pej.admin.data

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ApiRespone<T>(status: HttpStatus): ResponseEntity<T>(status) {
}