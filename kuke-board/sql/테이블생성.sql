/* 테이블 생성 */
CREATE TABLE TB_ARTICLE (
      ARTICLE_ID     NUMBER(19)        PRIMARY KEY
    , TITLE          VARCHAR2(100)     NOT NULL
    , CONTENT        VARCHAR2(3000)
    , BOARD_ID       NUMBER(19)        NOT NULL
    , WRITER_ID      NUMBER(19)        NOT NULL
    , CREATED_AT     DATE              DEFAULT SYSDATE
    , MODIFIED_AT    DATE
);

COMMENT ON TABLE TB_ARTICLE IS '게시글';

COMMENT ON COLUMN TB_ARTICLE.ARTICLE_ID   IS '게시글ID';
COMMENT ON COLUMN TB_ARTICLE.TITLE        IS '제목';
COMMENT ON COLUMN TB_ARTICLE.CONTENT      IS '내용';
COMMENT ON COLUMN TB_ARTICLE.BOARD_ID     IS '게시판ID (Shard Key)';
COMMENT ON COLUMN TB_ARTICLE.WRITER_ID    IS '작성자ID';
COMMENT ON COLUMN TB_ARTICLE.CREATED_AT   IS '생성시간';
COMMENT ON COLUMN TB_ARTICLE.MODIFIED_AT  IS '수정시간';

CREATE TABLE TB_COMMENT (
      COMMENT_ID         NUMBER(19)        PRIMARY KEY
    , CONTENT            VARCHAR2(3000)    NOT NULL
    , ARTICLE_ID         NUMBER(19)        NOT NULL
    , PARENT_COMMENT_ID  NUMBER(19)        NOT NULL
    , WRITER_ID          NUMBER(19)        NOT NULL
    , DEL_YN             VARCHAR2(1)       DEFAULT 'N' NOT NULL
    , CREATED_AT         DATE              DEFAULT SYSDATE NOT NULL
    , MODIFIED_AT    DATE
);


COMMENT ON TABLE TB_COMMENT IS '댓글';

COMMENT ON COLUMN TB_COMMENT.COMMENT_ID   IS '댓글ID';
COMMENT ON COLUMN TB_COMMENT.CONTENT      IS '내용';
COMMENT ON COLUMN TB_COMMENT.ARTICLE_ID   IS '게시판ID (Shard Key)';
COMMENT ON COLUMN TB_COMMENT.PARENT_COMMENT_ID IS '상위댓글ID';
COMMENT ON COLUMN TB_COMMENT.WRITER_ID    IS '작성자ID';
COMMENT ON COLUMN TB_COMMENT.DEL_YN       IS '삭제여부';
COMMENT ON COLUMN TB_COMMENT.CREATED_AT   IS '생성시간';
COMMENT ON COLUMN TB_COMMENT.MODIFIED_AT  IS '수정시간';