import { useState, useEffect } from "react";

import BoardSearch from "../components/BoardSearch";
import BoardList from "../components/BoardList";
import BoardPagination from "../components/BoardPagination";

export default function BoardView() {
    // 게시판 목록을 관리하는 상태
    const [boardList, setBoardList] = useState([]);

    // 백엔드로부터 받은 게시판 목록 1, 2
    const data1 = [
        {
            boardId: 1,
            userId: "gildong",
            title: "길동이 쓴 글 1",
            content: "길동이 쓴 글 1 내용.....",
        },
        {
            boardId: 2,
            userId: "gildong",
            title: "길동이 쓴 글 2",
            content: "길동이 쓴 글 2 내용.....",
        },
        {
            boardId: 3,
            userId: "gildong",
            title: "길동이 쓴 글 3",
            content: "길동이 쓴 글 3 내용.....",
        },
        {
            boardId: 4,
            userId: "gildong",
            title: "길동이 쓴 글 4",
            content: "길동이 쓴 글 4 내용.....",
        },
        {
            boardId: 5,
            userId: "gildong",
            title: "길동이 쓴 글 5",
            content: "길동이 쓴 글 5 내용.....",
        },
    ];

    const data2 = [
        {
            boardId: 6,
            userId: "gildong",
            title: "길동이 쓴 글 6",
            content: "길동이 쓴 글 6 내용.....",
        },
        {
            boardId: 7,
            userId: "gildong",
            title: "길동이 쓴 글 7",
            content: "길동이 쓴 글 7 내용.....",
        },
        {
            boardId: 8,
            userId: "gildong",
            title: "길동이 쓴 글 8",
            content: "길동이 쓴 글 8 내용.....",
        },
        {
            boardId: 9,
            userId: "gildong",
            title: "길동이 쓴 글 9",
            content: "길동이 쓴 글 9 내용.....",
        },
        {
            boardId: 10,
            userId: "gildong",
            title: "길동이 쓴 글 10",
            content: "길동이 쓴 글 10 내용.....",
        },
    ];

    // 최초로 렌더링될 때, setBoardList 호출
    useEffect(() => {
        setBoardList(data1)
    }, []);

    const movePage = ((no) => {
        if (no == 1) {
            setBoardList(data1);
        } else if (no == 2) {
            setBoardList(data2);
        }
    })

    return (
        <>
            <BoardSearch />
            <BoardList boardList={boardList} />
            <BoardPagination movePage={movePage} />
        </>
    );
}
