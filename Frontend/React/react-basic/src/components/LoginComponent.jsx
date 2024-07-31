export default function LoginComponent({fromChild}){
    return (
        <>
            <button onClick={() => fromChild(true)}>Login</button>
        </>
    )
}