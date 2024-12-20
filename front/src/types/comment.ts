export interface CommentProps {
    commentId: number;
    boardId: number;
    nickname: string;
    content: string;
    replyCommentCnt: number;
    like: number;
    createdAt: string;
}
