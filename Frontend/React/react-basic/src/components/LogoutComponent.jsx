export default function LogoutComponent({fromChild}){
    return (
        <>
            <button onClick={() => fromChild(false)}>Logout</button>
        </>
    )
}