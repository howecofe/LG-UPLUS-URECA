export default function BoardItem(props) {
    return (
        <tr>
            <td>{props.item.boardId}</td>
            <td>{props.item.userId}</td>
            <td>{props.item.title}</td>
            <td>{props.item.content}</td>
        </tr>
    )
}