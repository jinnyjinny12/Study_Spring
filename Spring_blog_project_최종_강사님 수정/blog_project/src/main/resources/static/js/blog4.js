

// DOMContentLoaded 이벤트가 발생하면 실행될 코드를 정의합니다.
document.addEventListener("DOMContentLoaded", function () {
    // "like-button" 클래스를 가진 모든 요소를 선택합니다.
    var likeButtons = document.querySelectorAll(".like-button");

    // 선택된 "like-button" 요소 각각에 대해 클릭 이벤트 리스너를 추가합니다.
    likeButtons.forEach(function (likeButton) {
        likeButton.addEventListener("click", function () {
            var blogId = likeButton.getAttribute("data-id");
            var likeCountElement = document.getElementById("likeCount-" + blogId);

            console.log(`Blog ID: ${blogId}`); // 디버깅1
            console.log(`likeCountElement:`, likeCountElement); // 디버깅2

            // blogId가 없으면 오류를 출력하고 함수 실행을 중지합니다.
            if (!blogId) {
                console.error("Blog ID is missing!");
                return;
            }

            // likeCountElement가 없으면 오류를 출력하고 함수 실행을 중지합니다.
            if (!likeCountElement) {
                console.error("LikeCountElement is missing for blog ID:", blogId);
                return;
            }

            // axios를 사용하여 비동기 POST 요청을 보냄.
            axios.post(`/posts/${blogId}/like`)
                .then(response => {
                    // 요청이 성공하면 응답 데이터에서 좋아요 수를 가져와서 페이지의 좋아요 수를 업데이트.
                    // 좋아요 서비스 레이어에서 보낸 response 를 통해 좋아요를 가져옴
                    const likeCount = response.data.likes;
                    if (likeCount !== undefined) {
                        console.log(likeCount); // 서버에서 받은 데이터 처리
                        likeCountElement.textContent = likeCount;
                    } else {
                        console.error("Invalid response data:", response.data);
                    }
                })
                .catch(error => {
                    // 요청이 실패하면 오류를 출력합니다.
                    console.error("Failed to like the blog", error);
                });
        });
    });
});
