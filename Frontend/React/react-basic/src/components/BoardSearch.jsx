import {useState} from "react";

export default function BoardSearch() {

    const [searchWord, setSearchWord] = useState('');

    const handleChange = ((e) => {
        setSearchWord(e.target.value);
    })

    const search = (() => {
        alert(searchWord);
    })

    return (
        <>
            <input type="text" onChange={handleChange} />
            <button onClick={search}>검색</button>
        </>
    )
}