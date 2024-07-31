function ComponentWithProps(props) {
    return (
        <>
            <h2>이름: {props.person.name}</h2>
            <h2>연락처: {props.person.phone}</h2>
            <h2>취미: {props.person.hobby.map((el, index) => <span key={index}>{el}</span>)}</h2>
        </>
    )
}

export default ComponentWithProps;

// [1,2,3] 배열 각 요소 접근 방식 2가지
// 1. forEach(el => ) : 원본 배열에 접근
// 2, map(el => ) : 새로운 배열