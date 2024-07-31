// ClassComponent, FunctionComponent 2개 하위 컴포넌트 사용
import ClassComponent from "../components/ClassComponent";
import FunctionComponent from "../components/FunctionComponent";

function ComponentTwoWay(){
    return (
        <>
            <ClassComponent />
            <FunctionComponent />
        </>
    )
}

export default ComponentTwoWay;