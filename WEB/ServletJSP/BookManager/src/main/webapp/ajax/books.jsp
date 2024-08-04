<%@ page import="dto.BookDto" %><%--
  Created by IntelliJ IDEA.
  User: greta
  Date: 8/2/24
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    하나의 jsp에서 CRUD를 한꺼번에 처리
    비동기요청(ajax)는 fetch 함수가 나오기 전까지 매우 복잡한 구조를 가져서 불편
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>도서 목록</h1>
    <%-- list --%>
    <table>
        <thead>
        <tr><th>bookId</th><th>bookName</th><th>publisher</th><th>price</th></tr>
        </thead>
        <tbody id="bookTbody">

        </tbody>
    </table>
    <hr>
    <%-- form --%>
    <form>
        <input type="text" name="bookId" id="bookId" /><br>
        <input type="text" name="bookName" id="bookName" /><br>
        <input type="text" name="publisher" id="publisher" /><br>
        <input type="text" name="price" id="price" /><br>
    </form>
    <hr>
    <button type="button" id="btnInsert">등록</button>
    <button type="button" id="btnUpdate">수정</button>
    <button type="button" id="btnDelete">삭제</button>

    <script>
        window.onload = function () {
            listBook();

            document.querySelector("#btnInsert").onclick = insertBook;
            document.querySelector("#btnUpdate").onclick = updateBook;
            document.querySelector("#btnDelete").onclick = deleteBook;
        }

        async function listBook() {
            // back-end에 도서 목록 요청 (ajax, json)
            let url = '/BookManager/books-ajax/list';
            let response = await fetch(url); // fetch는 비동기이므로, fetch() 종료될 때까지 대기하도록 await
            let data = await response.json(); // 비동기, response에 담긴 json 문자열을 javascript object로 변환

            makeListHtml(data);
        }

        function makeListHtml(list) {
            let listHTML = ``;
            list.forEach(el => {
                listHTML +=
                    `<tr data-bookId="\${el.bookId}"> <!-- 사용자 정의 Attr -->
                        <td>\${el.bookId}</td>
                        <td>\${el.bookName}</td>
                        <td>\${el.publisher}</td>
                        <td>\${el.price}</td>
                    </tr>`
            });
            document.querySelector("#bookTbody").innerHTML = listHTML;

            document.querySelectorAll("#bookTbody tr").forEach(el => {
                el.onclick = function () {
                    let bookId = this.getAttribute("data-bookId");
                    detailBook(bookId);
                }
            })
        }

        async function detailBook(bookId) {
            let url = '/BookManager/books-ajax/detail?bookId=' + bookId;
            let response = await fetch(url);
            let data = await response.json();

            document.querySelector("#bookId").value = data.bookId;
            document.querySelector("#bookName").value = data.bookName;
            document.querySelector("#publisher").value = data.publisher;
            document.querySelector("#price").value = data.price;
        }

        // post - body에 파라미터 넣어 전달
        async function insertBook() {
            let urlParams = new URLSearchParams({
                bookId: document.querySelector("#bookId").value,
                bookName: document.querySelector("#bookName").value,
                publisher: document.querySelector("#publisher").value,
                price: document.querySelector("#price").value
            });

            let fetchOptions = {
                method: "POST",
                body: urlParams
            }

            let url = '/BookManager/books-ajax/insert';
            let response = await fetch(url, fetchOptions);
            let data = await response.json();
            // console.log(data)

            if (data.result == "success") {
                alert("도서 등록 성공");
            } else if (data.result == "fail") {
                alert("도서 등록 실패");
            }

            listBook();
        }

        async function updateBook() {
            let urlParams = new URLSearchParams({
                bookId: document.querySelector("#bookId").value,
                bookName: document.querySelector("#bookName").value,
                publisher: document.querySelector("#publisher").value,
                price: document.querySelector("#price").value
            });

            let fetchOptions = {
                method: "POST",
                body: urlParams
            }

            let url = '/BookManager/books-ajax/update';
            let response = await fetch(url, fetchOptions);
            let data = await response.json();

            if (data.result == "success") {
                alert("도서 수정 성공");
            } else if (data.result == "fail") {
                alert("도서 수정 실패");
            }

            listBook();
        }

        // get
        async function deleteBook() {
            let bookId = document.querySelector("#bookId").value;
            let url = '/BookManager/books-ajax/delete?bookId=' + bookId;
            let response = await fetch(url);
            let data = await response.json();

            if (data.result == "success") {
                alert("도서 삭제 성공");
            } else if (data.result == "fail") {
                alert("도서 삭제 실패");
            }

            listBook();
        }

    </script>
</body>
</html>
