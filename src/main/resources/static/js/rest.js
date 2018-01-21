var buttonOptionAll = document.getElementById("option-all");
var buttonOptionToday = document.getElementById("option-today");
var buttonOptionThisWeek = document.getElementById("option-this-week");
var xmlhttp = new XMLHttpRequest();

window.onload = function(){
	
}


buttonOptionAll.onclick = function(){
	xmlhttp.open("GET", "http://localhost:8080/public_api/get_all");
	xmlhttp.send();			
}

buttonOptionToday.onclick = function(){
	xmlhttp.open("GET", "http://localhost:8080/public_api/get_today");
	xmlhttp.send();	
}

buttonOptionThisWeek.onclick = function(){
	xmlhttp.open("GET", "http://localhost:8080/public_api/get_this_week");
	xmlhttp.send();	
}



xmlhttp.onreadystatechange = function(){
	if(this.readyState == 4 && this.status == 200){
		responseArray = JSON.parse(this.responseText);		
		var anchorElement = document.getElementsByTagName("main")[0];	
		anchorElement.innerHTML = "";
		
		for(var index = 0; index < responseArray.length; index++){
			anchorElement.appendChild(createLayout(responseArray[index]));
		}		
	}
}


function createLayout(responseContent){
	var article = document.createElement("article");
	
	var header = document.createElement("header"), h4 = document.createElement("h4");
	h4.textContent = responseContent.title;
	header.appendChild(h4);	
		
	var pTime = document.createElement("p");
	pTime.textContent = responseContent.date + " " + responseContent.time;
	
	var pText = document.createElement("p");
	pText.textContent = responseContent.text;
	
	var pGoing = document.createElement("p");
	pGoing.textContent = responseContent.going;
	
	var buttonGoing = document.createElement("BUTTON");
	buttonGoing.innerHTML = "Going";
			
	article.appendChild(header);
	article.appendChild(pTime);
    article.appendChild(pText);
    article.appendChild(pGoing);
    article.appendChild(buttonGoing);	
	
    return article;
	
}
