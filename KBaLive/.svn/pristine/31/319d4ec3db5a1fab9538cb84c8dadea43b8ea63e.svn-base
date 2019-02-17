//function init(){
//	var left_button2=document.getElementById("left_button2");
//	left_button2.onclick=ChangeLeft;
//	var left_model_button2=document.getElementById("left_model_button2");
//	left_model_button2.onclick=ChangeLeft;
//	
//	ChangeColor();
//}

var num=true;

//收缩导航栏
function ChangeLeft(){
	var left_button2=document.getElementById("left_button2");
	var left_model_button2=document.getElementById("left_model_button2");
	var left=document.getElementById("left");
	var left_model=document.getElementById("left_model");
	//左移
	var dazhudiv=document.getElementById("dazhudiv");
	
	if(num){
		left.style.display="none";
		left_model.style.display="block";
		dazhudiv.style.marginLeft="200px";
		num=false;
	}
	else{
		left.style.display="block";
		left_model.style.display="none";
		dazhudiv.style.marginLeft="300px";
		num=true;
	}
}

//颜色
function ChangeColor(){
	var liquanbu=document.getElementsByClassName("liquanbu");
	for(var i=0;i<liquanbu.length;i++){
		liquanbu[i].onmouseover=function(){
			this.style.color="#fff";
		}
		liquanbu[i].onmouseleave=function(){
			this.style.color="#f60";
		}
	}
}

window.onload=init;