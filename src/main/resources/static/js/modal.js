/**
 * 
 */

var loginModal = document.getElementById("login-modal");
var createPostModal = document.getElementById("create-post-modal");
var closeButton = document.getElementById("close-modal");

function displayLoginModal(){
	loginModal.style.display = "block";
}

function displayCreatePostModal(){
	createPostModal.style.display = "block";
}


closeButton.onclick = function(){
	hideModal();
}

window.onclick = function(event){
	if(event.target == loginModal){
		hideModal();
	}
}


function hideModal(){
	loginModal.style.display = "none";
}







