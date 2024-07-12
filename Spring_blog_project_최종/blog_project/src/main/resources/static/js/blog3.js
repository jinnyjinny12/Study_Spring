// document.addEventListener("Dom~", function () {....});
// 웹페이지의 DOM 이 완전히 로드되고 파싱된 후에  실행될 javaScript 코드를 정의한다.
// DOM 은 웹페이지의 구조를 나타내느 일종의 지도이다.  -> 지도 페이지에 있ㄱ는 모든 요소들인 (텍스트, 이미지, 버튼 등) 이 표시되어 있다.
// DOMcontentLoad 는 페이지가 준비되었다고 신호를 보내는 이벤트 : javaScript 코드를 실행해도 안전하다. 는 걸 의미하며

// EventListener 는 document 에서  "DOMContentLoaded"  이벤트가 발생할 때 실행할 작업을 의정
// function 은 DomContentLoaded 이벤트가 발생했을 때 실행될 작업을 담고 있는 코드

document.addEventListener("DOMContentLoaded", function () {
    var likeButtons = document.querySelectorAll(".like-button");
    // querySelectorAll 을 통해 클래스에 가진 모든 요소를 선택해서 "likeButtons" 변수에 저장
    // 페이지 내에 모든 좋아요 버튼을 찾아라!


    likeButtons.forEach(function (likeButton) { // for each 를 사용해서 이벤트 리스너 추가
        likeButton.addEventListener("click", function () {
            var blogId = likeButton.getAttribute("data-id");
            var likeCountElement = document.getElementById("likeCount-" + blogId);


            console.log(`Blog ID: ${blogId}`);  // 디버깅 로그
            console.log(`likeCountElement:`, likeCountElement);  // 디버깅 로그

            // 오류처리
            if (!blogId) {
                console.error("Blog ID is missing!");
                return; // blog  id 가 없으면 함수를 중지해.
            }


            if (!likeCountElement) {
                console.error("LikeCountElement is missing for blog ID:", blogId);
                return;  // likeCountElement 없으면 함수르 중지해
            }


            //fetch 는 javaScript 에서 네트워크 요청을 보내느 방법이다
            // fetch는 HTTP 요청을 보내고 응답을 받을 수 있게 해준다.
            // fetch (url, options) : url 은 요청을 보낼 서버의 주소이고  options 는 요청의 설정을 포함하는 객체이다.
            // fetch 함수는 네트워크 요청을 보내기 위해 구조가 다음과 같다
            // fetch (url , {
            //      method: 'GET'
            //      headers: {
            //          'Content-Type' : 'application/json' 본문 데이터 형식
            //      },
            //      body: JSON.stringify({ key: 'value'})  요청 본문
            //  ** Content-Type : 서버에게 요청 본문에 포함된 데이터 형식을 알려준다
            //      "application/json": 요청 본문이 JSON 형식임을 의미합니다.
            //      "application/x-www-form-urlencoded": 폼 데이터 형식을 의미합니다.
            //      "text/plain": 텍스트 형식을 의미합니다.



            fetch("/posts/" + blogId + "/like", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    if (data && data.likes !== undefined) {
                        console.log(data.likes)
                        likeCountElement.textContent = data.likes;
                    } else {
                        console.error("Invalid response data:", data);
                    }
                })
                .catch(error => {
                    console.error("Failed to like the blog", error);
                });
        });
    });
});

function count(type) {
    const resultElement = document.getElementById('result');
    let number = resultElement.innerText;

    // 더하기/빼기
    if(type === 'plus') {
        number = parseInt(number) + 1;
    }else if(type === 'minus')  {
        number = parseInt(number) - 1;
    }


}