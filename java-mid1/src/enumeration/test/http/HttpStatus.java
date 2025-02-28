package enumeration.test.http;

/**
 * 문제 4
 *
 *  enumeration.test.http 패키지를 사용하자.
 *  HttpStatus 열거형을 만들어라.
 *
 *  HTTP 상태 코드 정의
 *  OK
 *   - code : 200
 *   - message : "OK"
 *  BAD_REQUEST
 *   - code : 400
 *   - message : "Bad Request"
 *  NOT_FOUND
 *   - code : 401
 *   - message : "Not Found"
 *  INTERNAL_SERVER_ERROR
 *   - code : 500
 *   - message : "Internal Server Error"
 */
public enum HttpStatus {
    OK(200, "OK"),
    BAD_REQUEST(400, "Bad Request"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String message;
    private
    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static HttpStatus findByCode(int inputCode) {
        for (HttpStatus status : HttpStatus.values()) {
            if (status.getCode() == inputCode) {
                return status;
            }
        }
        return null;
    }

    public boolean isSuccess() {
        if ( code >= 200 && code <= 299 ) {
            return true;
        } else {
            return false;
        }
    }
}