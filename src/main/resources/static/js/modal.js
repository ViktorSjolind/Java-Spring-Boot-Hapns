/**
 * 
 */

var loginModal = document.getElementById("login-modal");
var createPostModal = document.getElementById("create-post-modal");
var closeLogin = document.getElementById("close-login");
var closeCreatePost = document.getElementById("close-create-post");

function showLoginModal(){
	loginModal.style.display = "block";
}

function showCreatePostModal(){
	createPostModal.style.display = "block";
}


closeLogin.onclick = function(){
	loginModal.style.display = "none";
	
}

closeCreatePost.onclick = function(){
	createPostModal.style.display = "none";
}

window.onclick = function(event){
	if(event.target == loginModal){
		loginModal.style.display = "none";
	}
	
	if(event.target == createPostModal){
		createPostModal.style.display = "none";
	}
}









