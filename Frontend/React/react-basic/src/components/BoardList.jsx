import BoardItem from "./BoardItem"

export default function BoardList(props) {
    return (
        <table>
            <tbody>
                {
                    props.boardList.map(boardItem => <BoardItem key={boardItem.boardId} item={boardItem} />)
                }
            </tbody>
        </table>
    )
}