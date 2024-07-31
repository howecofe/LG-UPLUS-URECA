// 2개 하위 컴포넌트: 로그인, 로그아웃 버튼
// isLogin 상태를 관리 <= useState() 리액트 제공 함수(api)
import {useState} from "react";
import LoginComponent from "../components/LoginComponent"
import LogoutComponent from "../components/LogoutComponent"

export default function LoginLogout() {

    // const [isLogin] = useState(true);
    const [isLogin, setIsLogin] = useState(false); // getter, setter

    const changeLoginout  = ((flag) => {
        // console.log(flag);
        setIsLogin(flag);
    })

    return (
        <>
            {
                isLogin === true ? <LogoutComponent fromChild={changeLoginout} /> : <LoginComponent fromChild={changeLoginout} />
            }
        </>
    )
}