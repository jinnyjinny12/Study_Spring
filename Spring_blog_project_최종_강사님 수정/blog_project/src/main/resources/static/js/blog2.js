document.addEventListener("DOMContentLoaded", function () {
    var likeButtons = document.querySelectorAll(".like-button");

    likeButtons.forEach(function (likeButton){
        likeButton.addEventListener("click", function () {
            var blogId = likeButton.getAttribute("data-id");

            if(!blogId){
                console.error("Blog Id is mssing!");
                return;
            }
            fetch(`/posts/${blogId}/like` , {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                }
            })
            .then(response => {
                if(!response.ok) {
                    throw new Error("Failed to like the blog");

                }
                return response.json();
            })
            .then(data => {
                console.log("Blog Liked Successfully")
                var likeCountElement = likeButton.nextElementSibling;
                likeCountElement.textContent = data.likes;

            })
            .catch(errer => {
                console.error("Failed to like the blog", error);
            });
        });
    });
});
