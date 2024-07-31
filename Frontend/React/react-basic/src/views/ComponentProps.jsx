// data를 가지고 있고 이 data를 하위 컴포넌트에게 전달
// props: 부모(상위 컴포넌트)가 자식(하위 컴포넌트)한테 전달하는 데이터
import ComponentWithProps from "../components/ComponentWithProps";

const obj = {
    name: '홍길동',
    phone: '010-1111-1111',
    hobby: ['축구', '음주', '가무']
}

function ComponentProps() {
    return (
        <ComponentWithProps person={obj} />
    )
}

export default ComponentProps;