export default function BoardPagination({movePage}) {
    return (
        <>
            <button onClick={() => movePage(1)}>1</button>
            <button onClick={() => movePage(2)}>2</button>
        </>
    )
}