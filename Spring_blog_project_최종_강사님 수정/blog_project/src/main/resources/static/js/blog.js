// document.addEventListener("Dom~", function () {....});
// 웹페이지의 DOM 이 완전히 로드되고 파싱된 후에  실행될 javaScript 코드를 정의한다.
// DOM 은 웹페이지의 구조를 나타내느 일종의 지도이다.  -> 지도 페이지에 있ㄱ는 모든 요소들인 (텍스트, 이미지, 버튼 등) 이 표시되어 있다.
// DOMcontentLoad 는 페이지가 준비되었다고 신호를 보내는 이벤트 : javaScript 코드를 실행해도 안전하다. 는 걸 의미하며

// EventListener 는 document 에서  "DOMContentLoaded"  이벤트가 발생할 때 실행할 작업을 의정
// function 은 DomContentLoaded 이벤트가 발생했을 때 실행될 작업을 담고 있는 코드

document.addEventListener("DOMContentLoaded", function () {
    // DOMContentLoad  이벤트가 발생하면 함수(function) 안의 코드가 실행된다.

    var likeButton = document.getElementById("likeButton");
    // likeButton 변수에 id 가 likeButton 인 요소를 저장
    var likeCountElement = document.getElementById("likeCounts");
    // LikeCountElement  변수에 id 가 likeButton 인 요소를 저장
        if(likeButton && likeCountElement) {
            // likebutton 과 likeCountElement 가 모두존재하는지 확인한다. 둘 중 하나라도 존재하지 않으면 오류 메세지!

            likeButton.addEventListener("click",function (){
                // Like 버튼이 존재하면 click 이벤트리스너를 추가하고 클릭할 때마다 함수를 실행해라

                var blogId = likeButton.getAttribute("data-id");
                // likeButton 이라는 요소에 "data-id" 라는 속성값을 가져와서
                // blogId라는 변수에 저장한다.

                if(!blogId) {
                    console.error("Blod Id is missing!");
                    return;
                }
                // blogId 가 없으면  "Blod Id is missing!" 를 출력하고 함수를 중지해라
                //  blogId 가 있으면 Fetch  요청이 실행된다


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
                //

                fetch("posts/" + blogId +"/like", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    }

                    //method: POST (서버에 데이터를 전송한다) POST방식으로 실행된다/
                    //header : 요청의 헤더이다. 요청 본문의 데이터 형식이  JSON 이다.


                })
                    .then(response => { // fetch 요청이 완료되면 then 메서드의 콜백함수가 실행된다/
                        if(!response.ok){  // 응답상태가 200 ~ 299 범위인 경우 'true' 를 반환한다
                            throw new Error("Failed to like the blog.");
                        }
                        console.log("Blog liked successfully")
                        // response 가 성공적으로 완료되면 현재 좋아요 수를 문자열에서 정수로 변환한다.
                        var currentLikeCount = parseInt(likeCountElement.textContent);

                        // 좋아요 수를 1 증가시키고 liekCountElement 텍스트에 설정한다.
                        likeCountElement.textContent = currentLikeCount + 1;
                    })
                    .catch(error => {
                        console.error("Failed to like the blog.", error);
                    });
            });
        }else {
            console.error("Like button or like count element not found");
        }
    });